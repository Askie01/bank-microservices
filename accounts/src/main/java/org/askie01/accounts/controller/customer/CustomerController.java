package org.askie01.accounts.controller.customer;

import jakarta.validation.Valid;
import lombok.Data;
import org.askie01.accounts.constant.ResponseCode;
import org.askie01.accounts.constant.ResponseMessage;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.request.customer.create.CustomerCreateRequest;
import org.askie01.accounts.request.customer.delete.CustomerDeleteRequest;
import org.askie01.accounts.request.customer.get.CustomerGetRequest;
import org.askie01.accounts.request.customer.update.CustomerUpdateRequest;
import org.askie01.accounts.response.Response;
import org.askie01.accounts.service.customer.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@Validated
@RestController
@RequestMapping(path = "customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(path = "create")
    public ResponseEntity<Response> createCustomer(@Valid @RequestBody CustomerCreateRequest request) {
        customerService.createCustomer(request);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CUSTOMER_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "get")
    public ResponseEntity<Customer> getCustomer(@Valid @RequestBody CustomerGetRequest request) {
        final Customer customer = customerService.getCustomer(request);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateCustomer(@Valid @RequestBody CustomerUpdateRequest request) {
        customerService.updateCustomer(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteCustomer(@Valid @RequestBody CustomerDeleteRequest request) {
        customerService.deleteCustomer(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
