package com.skecorp.studentsmaster.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


public record ApiException(String message, @JsonIgnore Throwable throwable, HttpStatus httpStatus, Integer status,
                           ZonedDateTime zonedDateTime) {
}
