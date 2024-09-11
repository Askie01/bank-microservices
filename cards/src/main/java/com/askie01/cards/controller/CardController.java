package com.askie01.cards.controller;

import com.askie01.cards.constant.ResponseCode;
import com.askie01.cards.constant.ResponseMessage;
import com.askie01.cards.dto.CardContactInformationDTO;
import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.response.Response;
import com.askie01.cards.service.CardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
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
    private final CardContactInformationDTO cardContactInformationDTO;

    @PostMapping("create")
    public ResponseEntity<Response> createCard(@Valid
                                               @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                               @RequestParam String mobileNumber) {
        cardService.createCard(mobileNumber);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<CardDTO> getCardDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                  @RequestParam String mobileNumber) {
        final CardDTO cardDTO = cardService.getCard(mobileNumber);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Response> updateCardDetails(@Valid @RequestBody CardDTO cardDTO) {
        cardService.updateCard(cardDTO);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Response> deleteCardDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                      @RequestParam String mobileNumber) {
        cardService.deleteCard(mobileNumber);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "build-info")
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

    @GetMapping(path = "contact-info")
    public ResponseEntity<CardContactInformationDTO> getContactInfo() {
        return new ResponseEntity<>(cardContactInformationDTO, HttpStatus.OK);
    }
}
