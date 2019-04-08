package com.coolchatting.springbootwebchat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
@MapperScan(basePackages = "com.coolchatting.springbootwebchat.mapper")
//@EnableSwagger2
@SpringBootApplication
public class SpringbootWebchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebchatApplication.class, args);
    }

    @Bean(name = "restTemplate")
    public RestTemplate gtRestTemplate(){
        return new RestTemplate();
    }

}
