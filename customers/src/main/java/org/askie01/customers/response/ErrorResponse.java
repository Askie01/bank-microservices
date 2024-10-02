package org.askie01.customers.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents an error response structure for API error handling.
 * <p>
 * This class encapsulates the details of an error that occurred during an API
 * operation, providing information such as the request {@code path}, error {@code code}, {@code message},
 * and {@code timestamp} of the error.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    /**
     * The path of the request that resulted in the error.
     */
    private String path;

    /**
     * The error code indicating the status of the error.
     */
    private Integer code;

    /**
     * A message providing additional details about the error.
     */
    private String message;

    /**
     * The timestamp indicating when the error occurred.
     */
    private LocalDateTime timestamp;
}
