package com.askie01.cards.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CardCreationRequest {

    @Min(value = 100_000_000, message = "Card's mobile number must be at least 9 digits")
    @Max(value = 999_999_999, message = "Card's mobile number must be at most 9 digits")
    private Integer mobileNumber;

    @NotEmpty(message = "Card type cannot be null or empty")
    private String type;

    @Positive(message = "Money limit should be greater than zero")
    private Integer moneyLimit;
}
