package me.diego.dsmeta.handler;

import com.twilio.exception.RestException;
import me.diego.dsmeta.exceptions.BadRequestException;
import me.diego.dsmeta.exceptions.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                BadRequestExceptionDetails.builder()
                        .timestamp(String.valueOf(LocalDateTime.now()))
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, check the documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .build()
        );
    }
}
