package com.jRafael.ControleGastos.Controller.handlers;

import com.jRafael.ControleGastos.Dto.CustomErrorDto;
import com.jRafael.ControleGastos.Dto.ValidationErroDto;
import com.jRafael.ControleGastos.Service.exceptions.CategoryNotFoundException;
import com.jRafael.ControleGastos.Service.exceptions.UserNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<CustomErrorDto> userNotFound(UserNotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDto err = new CustomErrorDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CategoryNotFoundException .class)
    public ResponseEntity<CustomErrorDto> categoryNotFoundException (CategoryNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDto err = new CustomErrorDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
         ValidationErroDto err = new ValidationErroDto(Instant.now(), status.value(), "Dados invalidos", request.getRequestURI());
            for(FieldError x :e.getBindingResult().getFieldErrors()){
                err.addError(x.getField(),x.getDefaultMessage());
            }

         return ResponseEntity.status(status).body(err);
    }



}


