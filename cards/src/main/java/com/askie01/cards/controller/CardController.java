package com.askie01.cards.controller;

import com.askie01.cards.constant.ResponseCode;
import com.askie01.cards.constant.ResponseMessage;
import com.askie01.cards.dto.ContactInformationDTO;
import com.askie01.cards.entity.Card;
import com.askie01.cards.request.create.CardCreateRequest;
import com.askie01.cards.request.delete.CardDeleteRequest;
import com.askie01.cards.request.get.CardGetRequest;
import com.askie01.cards.request.update.CardUpdateRequest;
import com.askie01.cards.response.Response;
import com.askie01.cards.service.DefaultCardService;
import jakarta.validation.Valid;
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

    private final DefaultCardService defaultCardService;
    private final Environment environment;
    private final ContactInformationDTO contactInformationDTO;

    @PostMapping("create")
    public ResponseEntity<Response> createCard(@Valid @RequestBody CardCreateRequest request) {
        defaultCardService.createCard(request);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CARD_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<Card> getCard(@Valid @RequestBody CardGetRequest request) {
        final Card card = defaultCardService.getCard(request);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Response> updateCard(@Valid @RequestBody CardUpdateRequest request) {
        defaultCardService.updateCard(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Response> deleteCard(@Valid @RequestBody CardDeleteRequest request) {
        defaultCardService.deleteCard(request);
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
