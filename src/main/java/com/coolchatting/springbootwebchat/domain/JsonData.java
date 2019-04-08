package com.coolchatting.springbootwebchat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JsonData {
    /**
     * 1,成功，0，处理中，-1，失败
     */
    private int code;
    private String msg;
    private Object data;

    public JsonData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static JsonData buildSucess() {
        return new JsonData(1, null, null);
    }

    public static JsonData buildSucess(Object data) {
        return new JsonData(1, null, data);
    }

    public static JsonData buildSucess(String msg) {
        return new JsonData(1, null, msg);
    }

    public static JsonData buildFailure(String msg) {
        return new JsonData(-1, msg, null);
    }
    public static JsonData buildFailure( Integer code,String msg) {
        return new JsonData(code, msg, null);
    }
}
