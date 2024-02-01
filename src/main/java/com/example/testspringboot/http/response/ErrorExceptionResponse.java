package com.example.testspringboot.http.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorExceptionResponse {
    private HttpStatus httpStatus;
    private String message;
    private Date date;
}
