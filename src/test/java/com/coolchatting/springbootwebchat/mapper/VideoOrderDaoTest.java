package com.coolchatting.springbootwebchat.mapper;

import com.coolchatting.springbootwebchat.domain.VideoOrder;
import com.coolchatting.springbootwebchat.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class VideoOrderDaoTest {
    @Autowired
    private VideoOrderDao videoOrderDao;
    @Test
    public void insertVideoOrder() {
        VideoOrder videoOrder=new VideoOrder();
        videoOrder.setUser_id(4);
        videoOrder.setOut_trade_no(CommonUtils.generateUUID());
        videoOrder.setState(0);
        videoOrder.setNotify_time(new Date());
        videoOrder.setNickname("wewewewe");
        videoOrder.setState(3);
        videoOrder.setNotify_time(new Date());
        videoOrderDao.insertVideoOrder(videoOrder);
        log.info("============插入成功========");
    }
}