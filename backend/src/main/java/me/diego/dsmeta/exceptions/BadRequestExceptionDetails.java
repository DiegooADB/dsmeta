package me.diego.dsmeta.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BadRequestExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private String timestamp;
}

