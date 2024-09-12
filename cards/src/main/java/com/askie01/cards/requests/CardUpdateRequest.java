package com.askie01.cards.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CardUpdateRequest {

    @Min(value = 1000_0000_0000_0000L, message = "Card's number must be at least 16 digits")
    @Max(value = 9999_9999_9999_9999L, message = "Card's number must be at most 16 digits")
    private Long number;

    @Min(value = 100_000_000, message = "Card's mobile number must be at least 9 digits")
    @Max(value = 999_999_999, message = "Card's mobile number must be at most 9 digits")
    private Integer mobileNumber;

    @NotEmpty(message = "Card type cannot be null nor empty")
    private String type;

    @Positive(message = "Card's money limit must be above zero")
    private Integer moneyLimit;

    @PositiveOrZero(message = "Card's money used must be positive/zero")
    private Integer moneyUsed;
}
