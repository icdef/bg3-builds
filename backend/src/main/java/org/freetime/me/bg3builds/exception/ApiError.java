package org.freetime.me.bg3builds.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private Integer status;

    private String description;

    private String time;

    /**
     * Generates a ApiError object from the given exception and the response status
     *
     * @param e              the exception to wrap
     * @param responseStatus the status
     * @return the newly created ApiError object
     */
    public static ApiError from(Exception e, HttpStatusCode responseStatus) {
        return ApiError.from(e.getMessage(), responseStatus);
    }

    /**
     * Generates a ApiError object from the given message and the response status
     *
     * @param msg            the message to wrap
     * @param responseStatus the status
     * @return the newly created ApiError object
     */
    public static ApiError from(String msg, HttpStatusCode responseStatus) {
        return new ApiError(responseStatus.value(), msg, LocalDateTime.now().toString());
    }
}

