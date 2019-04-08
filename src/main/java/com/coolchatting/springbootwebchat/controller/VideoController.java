package com.coolchatting.springbootwebchat.controller;

import com.coolchatting.springbootwebchat.domain.JsonData;
import com.coolchatting.springbootwebchat.domain.Video;
import com.coolchatting.springbootwebchat.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/video")
public class VideoController implements ApplicationContextAware {
    @Autowired
    private VideoService videoService;
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        System.out.println(applicationContext.getClass().getName());
    }

    @RequestMapping("getAllVideoInfo")
    public JsonData getAllVideoInfo(){
        List<Video> allVideos = videoService.getAllVideos();
        if(allVideos==null){
            return JsonData.buildFailure("请求错误");
        }
        return JsonData.buildSucess(allVideos);
    }

}
