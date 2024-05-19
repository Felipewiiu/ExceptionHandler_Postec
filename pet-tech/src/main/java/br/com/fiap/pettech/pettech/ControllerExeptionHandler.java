package br.com.fiap.pettech.pettech;

import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExeptionHandler {
    private StandardError err = new StandardError();

    @ExceptionHandler(ControllerNotFoundExeption.class)
    public ResponseEntity<StandardError> EntityNotFound(ControllerNotFoundExeption e, HttpServletRequest request){
        HttpStatus status = HttpStatus.MULTI_STATUS;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Entity not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(this.err);

    }
}
