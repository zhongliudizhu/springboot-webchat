package com.coolchatting.springbootwebchat.controller;

import com.coolchatting.springbootwebchat.domain.JsonData;
import com.coolchatting.springbootwebchat.domain.VideoOrder;
import com.coolchatting.springbootwebchat.service.VideoOrderService;
import com.coolchatting.springbootwebchat.utils.IpUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user/api/videoOrder")
public class VideoOrderInfoController {
    @Autowired
    private VideoOrderService service;

    @RequestMapping("page")
    public JsonData getVideoInfo(@RequestParam(value = "page_num",defaultValue = "1") int pageNum,
                                 @RequestParam(value = "page_size",defaultValue = "3") int pageSize){
        List<VideoOrder> allInfo = service.getAllInfo();
        PageInfo<VideoOrder> pageInfo = new PageInfo<>(allInfo);
        return JsonData.buildSucess(pageInfo);
    }

        /**
         * 生成订单信息，进行统一下单
         * 获取二维码
         * */

     @RequestMapping("saveOrderInfo")
     public  void saveOrderInfo(@RequestParam(value = "video_id",required = true)
                                           Integer id,
                                  HttpServletRequest request, HttpServletResponse response){

            String ipAddr = IpUtils.getIpAddr(request);
            Integer userId = (Integer) request.getAttribute("user_id");

         try {
             String info = service.createOrderInfo(userId, ipAddr, id);
             if(info==null){
                 return;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }


     }




}
