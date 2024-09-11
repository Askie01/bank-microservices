package com.askie01.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    @NotEmpty(message = "Mobile number cannot be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card number must be 12 digits")
    private String cardNumber;

    @NotEmpty(message = "Card type cannot be null or empty")
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;
}
