package org.askie01.customers.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.askie01.customers.response.Response;
import org.springframework.http.HttpStatus;

/**
 * Utility class that defines common {@link Response} codes.
 * <p>
 * This class contains constants for {@link HttpStatus} codes such as {@link #OK} (200),
 * {@link #CREATED} (201), {@link #NOT_FOUND} (404), and others. It cannot be instantiated since
 * it only provides static values.
 * </p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseCode {

    /**
     * {@link HttpStatus#OK} code (200). The request was successful.
     */
    public static final Integer OK = 200;

    /**
     * {@link HttpStatus#CREATED} code (201). The request has resulted in a new resource being created.
     */
    public static final Integer CREATED = 201;

    /**
     * {@link HttpStatus#FOUND} code (302). The resource has been temporarily moved to a different URI.
     */
    public static final Integer FOUND = 302;

    /**
     * {@link HttpStatus#BAD_REQUEST} code (400). The request cannot be processed due to client error.
     */
    public static final Integer BAD_REQUEST = 400;

    /**
     * {@link HttpStatus#NOT_FOUND} code (404). The requested resource could not be found.
     */
    public static final Integer NOT_FOUND = 404;

    /**
     * {@link HttpStatus#EXPECTATION_FAILED} code (417). The server cannot meet the requirement of the expected header.
     */
    public static final Integer EXPECTATION_FAILED = 417;

    /**
     * {@link HttpStatus#INTERNAL_SERVER_ERROR} code (500). An error occurred on the server side.
     */
    public static final Integer INTERNAL_SERVER_ERROR = 500;
}
