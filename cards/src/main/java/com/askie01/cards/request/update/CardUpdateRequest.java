package com.askie01.cards.request.update;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardUpdateRequest implements UpdateRequest {

    @Min(value = 1000_0000_0000_0000L, message = "Card number must be at least 1000 0000 0000 0000")
    @Max(value = 9999_9999_9999_9999L, message = "Card number must be at most 9999 9999 9999 9999")
    private Long cardNumber;

    @Pattern(regexp = "^\\+\\d{2,3} \\d{8,15}$",
            message = "Mobile number must start with '+' followed by 2-3 digits, a space, and 8-15 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card type name cannot be null/empty")
    private String cardTypeName;

    @DecimalMin(value = "0.01", message = "Money limit must be at least 0.01")
    @DecimalMax(value = "99999999.99", message = "Money limit must be below 99 999 999.99")
    private BigDecimal moneyLimit;

    @PositiveOrZero(message = "Money used must be at least 0")
    @DecimalMax(value = "99999999.99", message = "Money used must be below 99 999 999.99")
    private BigDecimal moneyUsed;
}
