package com.event.eventapp.infrastructure.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ErrorMessage {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
