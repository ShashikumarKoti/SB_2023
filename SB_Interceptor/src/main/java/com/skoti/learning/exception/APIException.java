package com.skoti.learning.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIException extends RuntimeException {

    private Set<APIErrors> errors;
    private HttpStatus httpStatusCode;

    public APIException(HttpStatus httpStatusCode, Set<APIErrors> errors) {
        this.httpStatusCode = httpStatusCode;
        this.errors = errors;
    }

}
