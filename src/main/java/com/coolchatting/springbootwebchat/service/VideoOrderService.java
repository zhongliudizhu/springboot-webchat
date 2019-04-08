package com.coolchatting.springbootwebchat.service;

import com.coolchatting.springbootwebchat.domain.VideoOrder;

import java.util.List;

public interface VideoOrderService {

    List<VideoOrder> getAllInfo();

    boolean updateOrderVideo(VideoOrder videoOrder);

    String createOrderInfo(Integer userId,String ip,Integer videoId)throws Exception;

}
