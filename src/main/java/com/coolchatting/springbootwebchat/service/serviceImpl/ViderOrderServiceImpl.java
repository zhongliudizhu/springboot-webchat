package com.coolchatting.springbootwebchat.service.serviceImpl;

import com.coolchatting.springbootwebchat.config.WebChatConfig;
import com.coolchatting.springbootwebchat.domain.User;
import com.coolchatting.springbootwebchat.domain.Video;
import com.coolchatting.springbootwebchat.domain.VideoOrder;
import com.coolchatting.springbootwebchat.mapper.UserDao;
import com.coolchatting.springbootwebchat.mapper.VideoMapper;
import com.coolchatting.springbootwebchat.mapper.VideoOrderDao;
import com.coolchatting.springbootwebchat.service.VideoOrderService;
import com.coolchatting.springbootwebchat.utils.CommonUtils;
import com.coolchatting.springbootwebchat.utils.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Slf4j
@Service
public class ViderOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderDao dao;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private WebChatConfig webChatConfig;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<VideoOrder> getAllInfo() {
        return dao.getAllInfo();
    }

    @Override
    public boolean updateOrderVideo(VideoOrder videoOrder) {
        return  dao.updateVideoOrder(videoOrder)==1;
    }


    @Override
    public String createOrderInfo(Integer userId,String ip,Integer videoId)throws Exception {
        Video videoInfo = videoMapper.getVideoInfo(videoId);
        User userInfo = userDao.getUserInfoByUserId(userId);
        if(videoInfo==null){ log.info("====该商品已售空===="); return null;}
         VideoOrder order=new VideoOrder();
          order.setIp(ip);
          order.setVideo_id(videoId);
          //order.setUser_id(1);
          order.setCreate_time(new Date());
          order.setOut_trade_no(CommonUtils.generateUUID());
          dao.insertVideoOrder(order);
        //生成二维码
        //获取codeurl
        String codeUrl = unifiedOrder(order);
        return codeUrl;
    }

    private String unifiedOrder(VideoOrder order) throws Exception {
        SortedMap<String,String> params = new TreeMap<>();
        params.put("appid",webChatConfig.getWxPayAppid());
        params.put("mch_id", webChatConfig.getWxMerId());
        params.put("nonce_str", CommonUtils.generateUUID());
        params.put("body",order.getVideo_title());
        params.put("out_trade_no",order.getOut_trade_no());
        params.put("total_fee",order.getTotal_fee().toString());
        params.put("spbill_create_ip",order.getIp());
        params.put("notify_url",webChatConfig.getWxPayCallback());
        params.put("trade_type","NATIVE");
        //sign签名
        String sign = WXPayUtil.createSign(params, webChatConfig.getWxPaykey());
        params.put("sign",sign);
        //map转xml
        String payXml = WXPayUtil.mapToXml(params);
        System.out.println(payXml);
        //统一下单

        String orderStr =restTemplate.postForObject(webChatConfig.getUNIFIED_ORDER_URL(),payXml,String.class);
        if(null == orderStr) {
            return null;
        }
        Map<String, String> unifiedOrderMap =  WXPayUtil.xmlToMap(orderStr);
        System.out.println(unifiedOrderMap.toString());
        if(unifiedOrderMap != null) {
            return unifiedOrderMap.get("code_url");
        }
        return null;

    }
}
