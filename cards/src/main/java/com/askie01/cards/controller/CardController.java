package com.askie01.cards.controller;

import com.askie01.cards.constant.CardConstants;
import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.dto.ResponseDTO;
import com.askie01.cards.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@Data
@Validated
@RestController
@RequestMapping(value = "card", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(
        name = "CRUD REST APIs for Cards in bank-microservices",
        description = "CRUD REST APIs in bank-microservices to CREATE, UPDATE, GET and DELETE card details"
)
public class CardController {

    private final CardService cardService;

    @Operation(
            summary = "Create Card REST API",
            description = "REST API to create new Card inside bank-microservices"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PostMapping("create")
    public ResponseEntity<ResponseDTO> createCard(@Valid
                                                  @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                  @RequestParam String mobileNumber) {
        cardService.createCard(mobileNumber);
        return new ResponseEntity<>(
                new ResponseDTO(CardConstants.STATUS_201, CardConstants.MESSAGE_201),
                HttpStatus.CREATED
        );
    }

    @Operation(
            summary = "Get Card details REST API",
            description = "REST API to get card details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @GetMapping("get")
    public ResponseEntity<CardDTO> getCardDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                  @RequestParam String mobileNumber) {
        final CardDTO cardDTO = cardService.getCard(mobileNumber);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Card details REST API",
            description = "REST API to update card details based on a card number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PutMapping("update")
    public ResponseEntity<ResponseDTO> updateCardDetails(@Valid
                                                         @RequestBody CardDTO cardDTO) {
        final boolean isUpdated = cardService.updateCard(cardDTO);
        if (isUpdated) {
            return new ResponseEntity<>(
                    new ResponseDTO(CardConstants.STATUS_200, CardConstants.MESSAGE_200),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new ResponseDTO(CardConstants.STATUS_417, CardConstants.MESSAGE_417_UPDATE),
                    HttpStatus.EXPECTATION_FAILED
            );
        }
    }

    @Operation(
            summary = "Delete Card Details REST API",
            description = "REST API to delete Card details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @DeleteMapping("delete")
    public ResponseEntity<ResponseDTO> deleteCardDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                         @RequestParam String mobileNumber) {
        final boolean isDeleted = cardService.deleteCard(mobileNumber);
        if (isDeleted) {
            return new ResponseEntity<>(
                    new ResponseDTO(CardConstants.STATUS_200, CardConstants.MESSAGE_200),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new ResponseDTO(CardConstants.STATUS_417, CardConstants.MESSAGE_417_DELETE),
                    HttpStatus.EXPECTATION_FAILED
            );
        }
    }
}
