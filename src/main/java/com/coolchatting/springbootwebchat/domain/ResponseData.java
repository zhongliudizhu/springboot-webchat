package com.coolchatting.springbootwebchat.domain;


import org.springframework.http.ResponseEntity;

public class ResponseData<T> {

     private static String code;
     private static String msg;

    public ResponseData(String code, String msg, ResponseEntity<T> responseEntity) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData() {
    }


}
