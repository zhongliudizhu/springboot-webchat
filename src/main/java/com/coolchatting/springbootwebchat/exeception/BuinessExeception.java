package com.coolchatting.springbootwebchat.exeception;

import lombok.Data;

@Data
public class BuinessExeception extends RuntimeException {

        private Integer code;
        private String msg;


}
