package io.github.LuizHenriqueMaronezi.pedidosapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException exception, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(
                Instant.now(),
                status.value(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }
}
