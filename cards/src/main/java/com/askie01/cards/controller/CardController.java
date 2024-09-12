package com.askie01.cards.controller;

import com.askie01.cards.constant.ResponseCode;
import com.askie01.cards.constant.ResponseMessage;
import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.dto.ContactInformationDTO;
import com.askie01.cards.requests.CardCreationRequest;
import com.askie01.cards.requests.CardUpdateRequest;
import com.askie01.cards.response.Response;
import com.askie01.cards.service.CardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@Validated
@RestController
@RequestMapping(value = "card", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {

    @Value("${build.version}")
    private String buildVersion;

    private final CardService cardService;
    private final Environment environment;
    private final ContactInformationDTO contactInformationDTO;

    @PostMapping("create")
    public ResponseEntity<Response> createCard(@Valid @RequestBody CardCreationRequest request) {
        cardService.createCard(request);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<CardDTO> getCardDetails(@Min(value = 100_000_000, message = "Mobile number must be at least 9 digits")
                                                  @Max(value = 999_999_999, message = "Mobile number must be at most 9 digits")
                                                  @RequestParam Integer mobileNumber) {
        final CardDTO cardDTO = cardService.getCardDTO(mobileNumber);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Response> updateCardDetails(@Valid @RequestBody CardUpdateRequest request) {
        cardService.updateCard(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Response> deleteCardDetails(@Min(value = 100_000_000, message = "Mobile number must be at least 9 digits")
                                                      @Max(value = 999_999_999, message = "Mobile number must be at most 9 digits")
                                                      @RequestParam Integer mobileNumber) {
        cardService.deleteCard(mobileNumber);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "build-version")
    public ResponseEntity<String> getBuildVersion() {
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @GetMapping(path = "java-version")
    public ResponseEntity<String> getJavaVersion() {
        final String javaVersion = environment.getProperty("JAVA_HOME");
        return new ResponseEntity<>(javaVersion, HttpStatus.OK);
    }

    @GetMapping(path = "maven-version")
    public ResponseEntity<String> getMavenVersion() {
        final String mavenVersion = environment.getProperty("MAVEN_HOME");
        return new ResponseEntity<>(mavenVersion, HttpStatus.OK);
    }

    @GetMapping(path = "contact-information")
    public ResponseEntity<ContactInformationDTO> getContactInformationDTO() {
        return new ResponseEntity<>(contactInformationDTO, HttpStatus.OK);
    }
}
