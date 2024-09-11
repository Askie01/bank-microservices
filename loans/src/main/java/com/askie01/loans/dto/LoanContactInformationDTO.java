package com.askie01.loans.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "loans")
public class LoanContactInformationDTO {
    private String message;
    private Map<String, String> contactDetails;
    private List<Integer> onCallSupport;
}
