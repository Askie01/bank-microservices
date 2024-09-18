package com.askie01.cards.controller;

import com.askie01.cards.constant.ResponseCode;
import com.askie01.cards.constant.ResponseMessage;
import com.askie01.cards.entity.CardType;
import com.askie01.cards.response.Response;
import com.askie01.cards.service.CardTypeService;
import com.askie01.cards.validation.ValidCardTypeName;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@Validated
@RestController
@RequestMapping(path = "card/type", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardTypeController {

    private final CardTypeService cardTypeService;

    @PostMapping(path = "create")
    public ResponseEntity<Response> createCardType(@ValidCardTypeName @RequestParam String name) {
        cardTypeService.createCardType(name);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CARD_TYPE_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "get")
    public ResponseEntity<CardType> getCardType(@ValidCardTypeName @RequestParam String name) {
        final CardType cardType = cardTypeService.getCardType(name);
        return new ResponseEntity<>(cardType, HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateCardType(@ValidCardTypeName @RequestParam String oldName,
                                                   @ValidCardTypeName @RequestParam String newName) {
        cardTypeService.updateCardType(oldName, newName);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteCardType(@ValidCardTypeName @RequestParam String name) {
        cardTypeService.deleteCardType(name);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
