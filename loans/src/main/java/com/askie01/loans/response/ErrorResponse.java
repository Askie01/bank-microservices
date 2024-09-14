package com.askie01.loans.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String path;
    private Integer code;
    private String message;
    private LocalDateTime timestamp;
}
