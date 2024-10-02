package org.askie01.customers.exception;

import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.constant.ResponseCode;
import org.askie01.customers.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global exception handler for the application.
 * <p>
 * This class extends {@link ResponseEntityExceptionHandler} and is annotated with
 * {@link ControllerAdvice} to handle exceptions across the whole application.
 * </p>
 * <p>
 * It provides specific handlers for all exceptions thrown in the application,
 * including a catch-all handler for {@link Exception}.
 * </p>
 * <p>
 * For each exception, it constructs a proper {@link ErrorResponse} objects and returns a
 * {@link ResponseEntity} with the appropriate {@link HttpStatus} code.
 * </p>
 *
 * @see ResponseEntityExceptionHandler
 * @see ControllerAdvice
 * @see ExceptionHandler
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Customized handling of {@link MethodArgumentNotValidException}.
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the exception to handle.
     * @param headers the headers to be written to the response.
     * @param status  the selected response status.
     * @param request the current request.
     * @return a {@link ResponseEntity} with validation error details and {@link HttpStatus#BAD_REQUEST} (400) code.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final Map<String, String> validationErrors = new HashMap<>();
        final List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            final String fieldName = ((FieldError) error).getField();
            final String validationMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMessage);
        });

        log.atError().log("Validation failed for request: '{}'.", request.getDescription(false));
        log.atError().log("Validations errors: '{}'.", validationErrors);
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method catches any unhandled {@link Exception}, constructs an {@link ErrorResponse} with
     * a {@link HttpStatus#INTERNAL_SERVER_ERROR} (500) code.
     *
     * @param exception  the exception to handle.
     * @param webRequest the current request.
     * @return a {@link ResponseEntity} with error details and {@link HttpStatus#INTERNAL_SERVER_ERROR} (500) code.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception, WebRequest webRequest) {
        log.atError().log(exception.getMessage());
        final ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                ResponseCode.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * This method catches {@link ResourceNotFoundException} and constructs an {@link ErrorResponse}
     * with {@link HttpStatus#NOT_FOUND} (404) code.
     *
     * @param exception  the exception to handle.
     * @param webRequest the current request.
     * @return a {@link ResponseEntity} with error details and {@link HttpStatus#NOT_FOUND} (404) code.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        log.atError().log(exception.getMessage());
        final ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                ResponseCode.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * This method catches {@link MobileNumberAlreadyExistsException} and constructs an {@link ErrorResponse}
     * with a {@link HttpStatus#BAD_REQUEST} (400) code.
     *
     * @param exception  the exception to handle.
     * @param webRequest the current request.
     * @return a {@link ResponseEntity} with error details and {@link HttpStatus#BAD_REQUEST} (400) code.
     */
    @ExceptionHandler(MobileNumberAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleMobileNumberAlreadyExistsException(MobileNumberAlreadyExistsException exception, WebRequest webRequest) {
        log.atError().log(exception.getMessage());
        final ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                ResponseCode.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method catches {@link EmailAlreadyExistsException} and constructs an {@link ErrorResponse}
     * with a {@link HttpStatus#BAD_REQUEST} (400) code.
     *
     * @param exception  the exception to handle.
     * @param webRequest the current request.
     * @return a {@link ResponseEntity} with error details and {@link HttpStatus#BAD_REQUEST}.
     */
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception, WebRequest webRequest) {
        log.atError().log(exception.getMessage());
        final ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                ResponseCode.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method catches {@link CountryNameAlreadyExistsException} and constructs an {@link ErrorResponse} with a
     * {@link HttpStatus#BAD_REQUEST} (400) code.
     *
     * @param exception  the exception to handle.
     * @param webRequest the current request.
     * @return {@link ResponseEntity} with error details and {@link HttpStatus#BAD_REQUEST} (400).
     */
    @ExceptionHandler(CountryNameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleCountryNameAlreadyExistsException(CountryNameAlreadyExistsException exception, WebRequest webRequest) {
        log.atError().log(exception.getMessage());
        final ErrorResponse errorResponse = new ErrorResponse(
                webRequest.getDescription(false),
                ResponseCode.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
