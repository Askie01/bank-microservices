package org.askie01.customers.controller;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.constant.ResponseCode;
import org.askie01.customers.constant.ResponseMessage;
import org.askie01.customers.dto.CustomerDTO;
import org.askie01.customers.entity.Customer;
import org.askie01.customers.response.Response;
import org.askie01.customers.service.CustomerService;
import org.askie01.customers.validation.ValidId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles operations related to {@link Customer} management.
 * It provides REST endpoints to {@code create}, {@code get}, {@code update},
 * and {@code delete} customers.
 * <p>
 * All requests and responses are in JSON format, and this controller is validated
 * with the {@link Validated} annotation for input validation.
 * </p>
 * <p>
 * Path: {@code /customer}
 * </p>
 * <p>
 * Produces {@link MediaType#APPLICATION_JSON_VALUE}.
 * </p>
 * <p>
 * Dependencies {@link CustomerService}.
 * </p>
 * <p>
 * Response structure: {@link Response}.
 * </p>
 * <p>
 * DTO: {@link CustomerDTO}.
 * </p>
 * <p>
 * Validation:
 * <ul>
 *     <li>{@link Valid} is used to validate request bodies for creating and updating {@link Customer}.</li>
 *     <li>{@link ValidId} is a custom annotation to validate the format of {@link Customer#id} in {@link PathVariable}.</li>
 * </ul>
 * </p>
 */
@Data
@Slf4j
@Validated
@RestController
@RequestMapping(path = "customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Creates a new {@link Customer}.
     *
     * @param customerDTO the customer data transfer object containing {@link Customer} information.
     * @return {@link ResponseEntity} with {@link Response} indicating {@link Customer} creation success
     * along with {@link HttpStatus#CREATED} (201).
     */
    @PostMapping
    public ResponseEntity<Response> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        log.atDebug().log("Attempting to create a new Customer from: '{}'", customerDTO);
        customerService.createCustomer(customerDTO);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CUSTOMER_CREATED);
        log.atInfo().log("Created Customer from: '{}'", customerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Retrieves {@link Customer} information by {@code id}.
     *
     * @param id the unique ID of the {@link Customer}.
     * @return {@link ResponseEntity} with {@link CustomerDTO} containing the {@link Customer} details
     * along with {@link HttpStatus#OK} (200).
     */
    @GetMapping(path = "{id}")
    public ResponseEntity<CustomerDTO> getCustomerDTO(@ValidId @PathVariable Long id) {
        log.atDebug().log("Attempting to retrieve CustomerDTO with ID: '{}'", id);
        final CustomerDTO customerDTO = customerService.getCustomerDTO(id);
        log.atInfo().log("Retrieved: '{}'", customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    /**
     * Updates an existing {@link Customer} information.
     *
     * @param customerDTO the customer data transfer object containing updated {@link Customer} information.
     * @return {@link ResponseEntity} with {@link Response} indicating successful {@link Customer} update operation along with {@link HttpStatus#OK} (200).
     */
    @PutMapping
    public ResponseEntity<Response> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        log.atDebug().log("Attempting to update Customer from: '{}'", customerDTO);
        customerService.updateCustomer(customerDTO);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        log.atInfo().log("Updated Customer with: '{}'", customerDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Deletes a {@link Customer} by {@code id}.
     *
     * @param id the unique ID of {@link Customer} to be deleted.
     * @return {@link ResponseEntity} with {@link Response} indicating successful {@link Customer} delete operation
     * along with {@link HttpStatus#OK} (200).
     */
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Response> deleteCustomer(@ValidId @PathVariable Long id) {
        log.atDebug().log("Attempting to delete Customer with ID: '{}'", id);
        customerService.deleteCustomer(id);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        log.atInfo().log("Deleted Customer with ID: '{}'", id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
