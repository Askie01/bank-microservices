package org.askie01.accounts.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.entity.Customer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerMapper {
    public static CustomerDTO map(Customer source, CustomerDTO target) {
        mapName(source, target);
        mapEmail(source, target);
        mapMobileNumber(source, target);
        return target;
    }

    private static void mapName(Customer source, CustomerDTO target) {
        final String name = source.getName();
        target.setName(name);
    }

    private static void mapEmail(Customer source, CustomerDTO target) {
        final String email = source.getEmail();
        target.setEmail(email);
    }

    private static void mapMobileNumber(Customer source, CustomerDTO target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    public static Customer map(CustomerDTO source, Customer target) {
        mapName(source, target);
        mapEmail(source, target);
        mapMobileNumber(source, target);
        return target;
    }

    private static void mapName(CustomerDTO source, Customer target) {
        final String name = source.getName();
        target.setName(name);
    }

    private static void mapEmail(CustomerDTO source, Customer target) {
        final String email = source.getEmail();
        target.setEmail(email);
    }

    private static void mapMobileNumber(CustomerDTO source, Customer target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }
}
