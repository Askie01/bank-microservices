package org.askie01.accounts.mapper;

import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO map(Customer source, CustomerDTO target) {
        mapName(source, target);
        mapEmail(source, target);
        mapMobileNumber(source, target);
        return target;
    }

    private static void mapName(Customer customer, CustomerDTO customerDTO) {
        final String name = customer.getName();
        customerDTO.setName(name);
    }

    private static void mapEmail(Customer customer, CustomerDTO customerDTO) {
        final String email = customer.getEmail();
        customerDTO.setEmail(email);
    }

    private static void mapMobileNumber(Customer customer, CustomerDTO customerDTO) {
        final String mobileNumber = customer.getMobileNumber();
        customerDTO.setMobileNumber(mobileNumber);
    }

    public static Customer map(CustomerDTO source, Customer target) {
        mapName(source, target);
        mapEmail(source, target);
        mapMobileNumber(source, target);
        return target;
    }

    private static void mapName(CustomerDTO customerDTO, Customer customer) {
        final String name = customerDTO.getName();
        customer.setName(name);
    }

    private static void mapEmail(CustomerDTO customerDTO, Customer customer) {
        final String email = customerDTO.getEmail();
        customer.setEmail(email);
    }

    private static void mapMobileNumber(CustomerDTO customerDTO, Customer customer) {
        final String mobileNumber = customerDTO.getMobileNumber();
        customer.setMobileNumber(mobileNumber);
    }
}
