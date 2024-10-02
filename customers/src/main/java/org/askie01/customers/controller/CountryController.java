package org.askie01.customers.controller;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.constant.ResponseCode;
import org.askie01.customers.constant.ResponseMessage;
import org.askie01.customers.dto.CountryDTO;
import org.askie01.customers.entity.Country;
import org.askie01.customers.response.Response;
import org.askie01.customers.service.CountryService;
import org.askie01.customers.validation.ValidId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * This controller manages operations related to {@link Country} management.
 * It provides REST endpoints to {@code create}, {@code get}, {@code update}, and {@code delete} countries.
 * <p>
 * All requests and responses are in JSON format, and this controller is validated with {@link Validated} annotation
 * for input validation.
 * </p>
 * <p>
 * Path: {@code /country}.
 * </p>
 * <p>
 * Produces: {@link MediaType#APPLICATION_JSON_VALUE}.
 * </p>
 * <p>
 * Dependencies: {@link CountryService}.
 * </p>
 * <p>
 * Response structure: {@link Response}.
 * </p>
 * <p>
 * DTO: {@link CountryDTO}.
 * </p>
 * <p>
 * Validation:
 *     <ul>
 *         <li>{@link Valid} is used to validate request bodies for creating and updating {@link Country}</li>
 *         <li>{@link ValidId} is a custom annotation to validate the format of {@link Country#id} in {@link PathVariable}.</li>
 *     </ul>
 * </p>
 */
@Data
@Slf4j
@Validated
@RestController
@RequestMapping(path = "country", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryService countryService;

    /**
     * Creates a new {@link Country}.
     *
     * @param countryDTO the data transfer object containing the {@link Country} information.
     * @return {@link ResponseEntity} with {@link Response} indicating successful {@link Country} creation
     * along with {@link HttpStatus#CREATED} (201).
     */
    @PostMapping
    public ResponseEntity<Response> createCountry(@Valid @RequestBody CountryDTO countryDTO) {
        log.atDebug().log("Attempting to create a new Country from: '{}'", countryDTO);
        countryService.createCountry(countryDTO);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.COUNTRY_CREATED);
        log.atInfo().log("Created Country from: '{}'", countryDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Retrieves the {@link Country} information by {@code id}.
     *
     * @param id the unique ID of the {@link Country}.
     * @return {@link ResponseEntity} with {@link CountryDTO} containing the {@link Country} details
     * along with {@link HttpStatus#OK} (200).
     */
    @GetMapping(path = "{id}")
    public ResponseEntity<CountryDTO> getCountryDTO(@ValidId @PathVariable Long id) {
        log.atDebug().log("Attempting to retrieve CountryDTO with ID: '{}'", id);
        final CountryDTO countryDTO = countryService.getCountryDTO(id);
        log.atInfo().log("Retrieved: '{}'", countryDTO);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    /**
     * Updates an existing {@link Country}.
     *
     * @param countryDTO the data transfer object containing updated {@link Country} information.
     * @return {@link ResponseEntity} with {@link Response} indicating successful {@link Country} update operation
     * along with {@link HttpStatus#OK} (201).
     */
    @PutMapping
    public ResponseEntity<Response> updateCountryDTO(@Valid @RequestBody CountryDTO countryDTO) {
        log.atDebug().log("Attempting to update Country from: '{}'", countryDTO);
        countryService.updateCountry(countryDTO);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        log.atInfo().log("Updated Country with: '{}'", countryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Deletes a {@link Country} by {@code id}.
     *
     * @param id the unique ID of {@link Country} to be deleted.
     * @return {@link ResponseEntity} with {@link Response} indicating a successful {@link Country} delete operation
     * along with {@link HttpStatus#OK} (201).
     */
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Response> deleteCountry(@ValidId @PathVariable Long id) {
        log.atDebug().log("Attempting to delete Country with ID: '{}'", id);
        countryService.deleteCountry(id);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        log.atInfo().log("Deleted Country with ID: '{}'", id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
