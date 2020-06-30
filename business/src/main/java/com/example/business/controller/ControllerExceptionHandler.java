package com.example.business.controller;


import com.example.server.dto.ResponseDto;
import com.example.server.exception.ValidatorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ValidatorException.class)
    public ResponseDto validatorExceptionHandler(ValidatorException e) {
        log.warn(e.getMessage());
        return new ResponseDto(false, "404","后端校验: 请求参数异常", null);
    }
}
