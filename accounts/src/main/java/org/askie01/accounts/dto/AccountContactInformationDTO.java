package org.askie01.accounts.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "accounts")
public class AccountContactInformationDTO {
    private String message;
    private Map<String, String> contactDetails;
    private List<Integer> onCallSupport;
}