package com.coolchatting.springbootwebchat;

import com.coolchatting.springbootwebchat.utils.RestTemplateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootWebchatApplicationTests {
    private static final Logger logger= LoggerFactory.getLogger(SpringbootWebchatApplicationTests.class);
    @Autowired
    private RestTemplateUtils utils;
    @Autowired
    private RestTemplate template;
    private  String url="http://t.weather.sojson.com/api/weather/city/%s";
    @Test
    public void contextLoads() {
        String tempUrl = String.format(url, "101030100");


    }

}
