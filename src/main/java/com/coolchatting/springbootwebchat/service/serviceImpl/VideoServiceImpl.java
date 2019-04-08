package com.coolchatting.springbootwebchat.service.serviceImpl;

import com.coolchatting.springbootwebchat.domain.Video;
import com.coolchatting.springbootwebchat.mapper.VideoMapper;
import com.coolchatting.springbootwebchat.service.VideoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService , ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        System.out.println(applicationContext.getClass().getName());

    }

    @Override
    public List<Video> getAllVideos() {
        return videoMapper.getAllVideos();
    }
}
