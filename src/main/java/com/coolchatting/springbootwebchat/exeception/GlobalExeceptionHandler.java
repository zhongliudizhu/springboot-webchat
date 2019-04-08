package com.coolchatting.springbootwebchat.exeception;

import com.coolchatting.springbootwebchat.domain.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public JsonData Handler(Exception e){

        if(e instanceof BuinessExeception){
            BuinessExeception buinessExeception =  (BuinessExeception) e;
            return JsonData.buildFailure(buinessExeception.getCode(),buinessExeception.getMsg());
        }else{
            return JsonData.buildFailure("未知异常，请重试");
        }
    }
}
