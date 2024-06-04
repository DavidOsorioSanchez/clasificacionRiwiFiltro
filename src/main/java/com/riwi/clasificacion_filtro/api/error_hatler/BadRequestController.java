package com.riwi.clasificacion_filtro.api.error_hatler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.clasificacion_filtro.api.dto.error.BaseErrorResponse;
import com.riwi.clasificacion_filtro.api.dto.error.ErrorsResp;
import com.riwi.clasificacion_filtro.util.exception.BadRequestException;


@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public BaseErrorResponse handleBadRequest(
      MethodArgumentNotValidException exception) {

    List<String> errors = new ArrayList<>();

    exception.getAllErrors()
        .forEach(error -> errors.add(error.getDefaultMessage()));

    return ErrorsResp.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .status(HttpStatus.BAD_REQUEST.name())
        .errors(errors)
        .build();
  }

  @ExceptionHandler(BadRequestException.class)
  public BaseErrorResponse badRequest(BadRequestException exception) {
    List<String> errors = new ArrayList<>();

    errors.add(exception.getMessage());

    return ErrorsResp.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .status(HttpStatus.BAD_REQUEST.name())
        .errors(errors)
        .build();
  }
}
