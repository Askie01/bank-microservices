package org.askie01.accounts.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private String code;
    private String message;
}
