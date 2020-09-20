package com.intercop.challengeclientapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DateTimeParseException.class})
    public Map<String, String> handleBadRequest(Exception ex, WebRequest request)  {
        Map<String, String> errors = new HashMap<>();
        errors.put("Fecha invalida:"," Utiliza un formato  dd/mm/yyyy");
        return errors;
    }

}
