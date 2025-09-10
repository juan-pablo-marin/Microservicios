package com.aplication.rest.SpringBootRest.advice;

import com.aplication.rest.SpringBootRest.wrapper.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
//@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            org.springframework.web.context.request.WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        ApiResponse<Object> errorResponse = new ApiResponse<>(
                "error",
                null,
                Map.of("errors", errors, "timestamp", LocalDateTime.now())
        );

        return ResponseEntity.status(statusCode.value()).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneric(Exception ex, HttpServletRequest req) {
        ApiResponse<Object> errorResponse = new ApiResponse<>(
                "error",
                null,
                Map.of("message", ex.getMessage(), "path", req.getRequestURI())
        );
        return ResponseEntity.status(500).body(errorResponse);
    }
}