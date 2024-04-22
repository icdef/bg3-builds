package org.freetime.me.bg3builds.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(value = {BuildItemNotFoundException.class,
            NameUniqueConstraintException.class, BuildNotFoundException.class, LootItemNotFoundException.class,
            BuildLootItemUniqueConstraintException.class, BuildLootItemNotFoundException.class})
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        return handleExceptionWithStatus(ex, request, HttpStatus.BAD_REQUEST);
    }


    /**
     * Override methods from ResponseEntityExceptionHandler to send a customized HTTP response for a
     * know exception from e.g. Spring
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // Get all errors
        List<String> errors =
                ex.getBindingResult().getFieldErrors().stream()
                        .map(err -> "Field: " + err.getField() + " " + err.getDefaultMessage())
                        .toList();

        String response = generateErrorObject(new RuntimeException(String.join("\n", errors)), status);

        return new ResponseEntity<>(response, headers, status);
    }

    private ResponseEntity<Object> handleExceptionWithStatus(
            RuntimeException ex, WebRequest request, HttpStatusCode responseStatus) {
        log.error("Exception with status {} occurred: {}", responseStatus, ex.getMessage());
        String jsonResponse = generateErrorObject(ex, responseStatus);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, jsonResponse, headers, responseStatus, request);
    }

    /**
     * Generate a json object with the error message
     *
     * @param ex             the exception holding the error
     * @param responseStatus the status
     * @return the json object
     */
    private String generateErrorObject(RuntimeException ex, HttpStatusCode responseStatus) {
        ApiError value = ApiError.from(ex, responseStatus);
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return "";
    }
}

