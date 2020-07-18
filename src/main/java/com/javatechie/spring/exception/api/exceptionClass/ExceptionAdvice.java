package com.javatechie.spring.exception.api.exceptionClass;

import com.javatechie.spring.exception.api.model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice
{

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<OrderError> mapExp(OrderServiceException exp)
    {
        OrderError orderError = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(), exp.getMessage());
        return new ResponseEntity<>(orderError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
