package com.example.ex080910.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomExceptionHander {
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<?> handleException(Exception e) {
        if(passwordAbsent(e)) return requiredFieldMissing("password");
        if(usernameAbsent(e)) return requiredFieldMissing("username");

        return ResponseEntity.badRequest().body("Outro.");
    }

    private ResponseEntity<?> requiredFieldMissing(String field) {
        return ResponseEntity.badRequest().body("Propriedade obrigatória '" + field + "' não encontrada no objeto enviado");
    }

    private boolean passwordAbsent(Exception e){
        return e instanceof MethodArgumentNotValidException
                && ((MethodArgumentNotValidException) e).getFieldError().getField().equals("password");
    }

    private boolean usernameAbsent(Exception e){
        return e instanceof MethodArgumentNotValidException
                && ((MethodArgumentNotValidException) e).getFieldError().getField().equals("username");
    }
}
