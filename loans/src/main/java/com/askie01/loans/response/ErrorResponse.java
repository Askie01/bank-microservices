package com.askie01.loans.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String path;
    private HttpStatus code;
    private String message;
    private LocalDateTime timestamp;
}
