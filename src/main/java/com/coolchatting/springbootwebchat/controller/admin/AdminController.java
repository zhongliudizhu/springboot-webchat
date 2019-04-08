package com.coolchatting.springbootwebchat.controller.admin;

import com.coolchatting.springbootwebchat.domain.JsonData;
import com.coolchatting.springbootwebchat.domain.VideoOrder;
import com.coolchatting.springbootwebchat.service.VideoOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/videoOrder")
public class AdminController {
        private static  final Logger logger= LoggerFactory.getLogger(AdminController.class);
        @Autowired
        private VideoOrderService videoOrderService;

      @PutMapping("/update")
      public JsonData  updateVideoOrder(@RequestBody VideoOrder videoOrder){
         try {
              boolean b = videoOrderService.updateOrderVideo(videoOrder);
              if(b){
                 return  JsonData.buildSucess("更新成功");
              }
             }catch (Exception e){
                logger.error(e.getMessage());
            }
               return null;
    }

}
