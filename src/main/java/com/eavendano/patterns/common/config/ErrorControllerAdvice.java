package com.eavendano.patterns.common.config;

import com.eavendano.patterns.common.exceptions.NotFoundException;
import com.eavendano.patterns.common.models.ExceptionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.exception.ExceptionUtils.getRootCauseStackTrace;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionModel> handleNotFoundException(final NotFoundException nfe) {
        var exceptionModel = new ExceptionModel().setMessage(nfe.getMessage());
        if (null != nfe.getCause()) {
            exceptionModel.setDevMessages(traverseExceptions(nfe));
        }
        return new ResponseEntity<>(exceptionModel, NOT_FOUND);
    }

    private List<String> traverseExceptions(final RuntimeException runtimeException) {
        return asList(getRootCauseStackTrace(runtimeException));
    }
}
