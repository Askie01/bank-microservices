package com.askie01.cards.request.delete;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CardDeleteRequest implements DeleteRequest {

    @Min(value = 1000_0000_0000_0000L, message = "Card number must be at least 1000 0000 0000 0000")
    @Max(value = 9999_9999_9999_9999L, message = "Card number must be at most 9999 9999 9999 9999")
    private Long cardNumber;

    @Pattern(regexp = "^\\+\\d{2,3} \\d{8,15}$",
            message = "Mobile number must start with '+' followed by 2-3 digits, a space, and 8-15 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card type name cannot be null/empty")
    private String cardTypeName;
}
