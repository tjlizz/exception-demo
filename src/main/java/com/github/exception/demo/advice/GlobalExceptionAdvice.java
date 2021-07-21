package com.github.exception.demo.advice;

import com.github.exception.demo.exception.http.ForbiddenException;
import com.github.exception.demo.exception.http.NotFoundException;
import com.github.exception.demo.exception.http.ParameterException;
import com.github.exception.demo.exception.http.UnAuthenticatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    @ExceptionHandler(UnAuthenticatedException.class)
    public ResponseEntity unAuthenticatedException(UnAuthenticatedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getCode());
    }


    @ExceptionHandler(ParameterException.class)
    public ResponseEntity handleParameterException(ParameterException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCode());
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity handleForbiddenException(ForbiddenException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getCode());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCode());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRunTimeException(RuntimeException e) {
        log.error(getExceptionDetail(e));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(500);
    }


    public String getExceptionDetail(Exception e) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getClass() + System.getProperty("line.separator"));
        stringBuilder.append(e.getLocalizedMessage() + System.getProperty("line.separator"));
        StackTraceElement[] arr = e.getStackTrace();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i].toString() + System.getProperty("line.separator"));

        }
        return stringBuilder.toString();
    }
}
