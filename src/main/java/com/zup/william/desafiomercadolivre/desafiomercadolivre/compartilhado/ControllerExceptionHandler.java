package com.zup.william.desafiomercadolivre.desafiomercadolivre.compartilhado;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public  ErrorMessage resourceNotFoundException(MethodArgumentNotValidException request) {

        String field = request.getFieldError().getField();
        String rejectedValue = request.getFieldError().getRejectedValue().toString();
        String message = request.getFieldError().getDefaultMessage();
         ErrorMessage dtoErro = new ErrorMessage(field, rejectedValue, message);


        return dtoErro;
    }
}
