package org.askie01.customers.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.askie01.customers.entity.Country;
import org.askie01.customers.entity.Customer;
import org.askie01.customers.response.Response;

/**
 * Utility class that defines common {@link Response} messages used throughout the application.
 * <p>
 * This class contain constants for standard {@link Response} messages, such as {@link #CUSTOMER_CREATED},  {@link #EXPECTATION_FAILED}.
 * It is designed as a static utility class and should not be instantiated.
 * </p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {

    /**
     * {@code message} indicating that the request was processed successfully.
     */
    public static final String OK = "Request processed successfully.";

    /**
     * {@code message} indicating that the {@link Customer} was created successfully.
     */
    public static final String CUSTOMER_CREATED = "Customer created successfully.";

    /**
     * {@code message} indicating that the {@link Country} was created successfully.
     */
    public static final String COUNTRY_CREATED = "Country created successfully.";

    /**
     * {@code message} indicating that a delete operation failed.
     */
    public static final String EXPECTATION_FAILED = "Delete operation failed.";

    /**
     * {@code message} indicating that a server error occurred.
     */
    public static final String SERVER_ERROR = "Server error occurred.";
}
