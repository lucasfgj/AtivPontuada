package com.example.AtvPontSpringBoot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> hadleRuntimeException(RuntimeException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem", erro.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> hadleMethodArgumentNotValidException(MethodArgumentNotValidException erro){
        // O método recebe o erro (do tipo RuntimeException) como parâmetro.

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
        // Retorna uma resposta HTTP com o status 400 (BAD_REQUEST) e um corpo contendo a mensagem do erro.
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> hadleRequestMethodNotSuportedExcepition(HttpRequestMethodNotSupportedException erro){
        // O método recebe o erro (do tipo RuntimeException) como parâmetro.

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Recurso não encontrado"));
        // Retorna uma resposta HTTP com o status 400 (BAD_REQUEST) e um corpo contendo a mensagem do erro.
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> hadleNoResourceFoundException(NoResourceFoundException erro){
        // O método recebe o erro (do tipo RuntimeException) como parâmetro.

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Recurso não encontrado"));
        // Retorna uma resposta HTTP com o status 400 (BAD_REQUEST) e um corpo contendo a mensagem do erro.
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpMessageNotReadableException(HttpMessageNotReadableException erro){
        // O método recebe o erro (do tipo RuntimeException) como parâmetro.

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Corpo da requisição ausente ou mal formatado"));
        // Retorna uma resposta HTTP com o status 400 (BAD_REQUEST) e um corpo contendo a mensagem do erro.
    }
}
