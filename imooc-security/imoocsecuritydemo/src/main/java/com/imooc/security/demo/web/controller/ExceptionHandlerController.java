package com.imooc.security.demo.web.controller;

import com.imooc.security.demo.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * zhshl  2018/9/16
 */
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotExistException(UserNotExistException ex){
        Map<String,Object> result = new HashMap<>();
        result.put("id",ex.getId());
        result.put("messge",ex.getMessage());
        return result;
    }
}
