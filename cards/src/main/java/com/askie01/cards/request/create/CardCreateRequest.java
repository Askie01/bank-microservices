package com.askie01.cards.request.create;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardCreateRequest implements CreateRequest {

    @Pattern(regexp = "^\\+\\d{2,3} \\d{8,15}$",
            message = "Mobile number must start with '+' followed by 2-3 digits, a space, and 8-15 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card type name cannot be null/empty")
    private String cardTypeName;

    @DecimalMin(value = "0.01", message = "Money limit must be at least 0.01")
    @DecimalMax(value = "99999999.99", message = "Money limit must be below 99 999 999.99")
    private BigDecimal moneyLimit;
}
