package org.askie01.customers.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.askie01.customers.constant.ResponseCode;
import org.askie01.customers.constant.ResponseMessage;

/**
 * Represents a standard response structure for API responses.
 * <p>
 * This class encapsulates the response {@code code} and {@code message}, which can be used
 * to communicate the outcome of an operation performed by the API.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /**
     * The response code indicating the status of the operation.
     * <p>
     * Commonly used HTTP status codes can be represented, such as {@link ResponseCode#OK} (200) for success,
     * {@link ResponseCode#BAD_REQUEST} (400), etc.
     * </p>
     */
    private Integer code;

    /**
     * A message providing additional information about the operation result.
     * <p>
     * This can be used to convey success messages, error details, or other
     * relevant information for the client, such as {@link ResponseMessage#OK},
     * {@link ResponseMessage#SERVER_ERROR}, etc.
     * </p>
     */
    private String message;
}
