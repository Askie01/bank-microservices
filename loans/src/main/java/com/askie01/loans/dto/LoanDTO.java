package com.askie01.loans.dto;

import lombok.Data;

@Data
public class LoanDTO {
    private Long number;
    private String type;
    private Integer mobileNumber;
    private Integer moneyLoaned;
    private Integer moneyPaid;
    private Integer moneyRemaining;
}
