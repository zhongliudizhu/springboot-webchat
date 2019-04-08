package com.coolchatting.springbootwebchat.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coolchatting.springbootwebchat.config.WebChatConfig;
import com.coolchatting.springbootwebchat.domain.User;
import com.coolchatting.springbootwebchat.mapper.UserDao;
import com.coolchatting.springbootwebchat.service.UserService;
import com.coolchatting.springbootwebchat.utils.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private Logger dataLogger = LoggerFactory.getLogger("dataLogger");
    @Autowired
      private RestTemplate restTemplate;
     @Autowired
     private WebChatConfig webChatConfig;
     @Autowired
     private UserDao userDao;
    @Override
     public User saveUserInfo(String code) throws Exception {
        //通过code获取Access_token
         String tempUrl=String.format(webChatConfig.getOPEN_ACCESSTOKEN_URL(),
                 webChatConfig.getOpenAppid(),webChatConfig.getOpenAppsecret(),code);
         String responseMap = restTemplate.getForObject(tempUrl, String.class);
         if(responseMap==null||responseMap.trim().length()==0){return null;}
         JSONObject jsonObject = JSON.parseObject(responseMap);
         String access_token = jsonObject.getString("access_token");
         String openid = jsonObject.getString("openid");
         User user = userDao.getUserInfo(openid);
         if(user!=null){
             userDao.updateUserLoginTime(new Date(),openid);
             return  user;
         }
        //通过access_token 获取用户信息
        String s = restTemplate.getForObject(String.format(webChatConfig.getOPEN_USERINFO_URL(), access_token, openid), String.class);
        if(s==null||s.trim().length()==0){return null;}
        //得到用户的详细信息
        JSONObject userInfo = JSON.parseObject(s);
        String nickname = new String(userInfo.getString("nickname").getBytes("ISO-8859-1"),"UTF-8");
        Integer sex = Integer.parseInt(userInfo.getString("sex"));
        String headimgurl = userInfo.getString("headimgurl");
        //处理乱码
        String province = new String(userInfo.getString("province").getBytes("ISO-8859-1"),"UTF-8");
        String city = new String(userInfo.getString("city").getBytes("ISO-8859-1"),"UTF-8");
        String country = new String(userInfo.getString("country").getBytes("ISO-8859-1"),"UTF-8");
        StringBuffer str=new StringBuffer();
        str.append(country).append("||").append(province).append("||").append(city);
         User user1=new User(headimgurl,sex,str.toString());
         user1.setOpenid(openid);
         user1.setName(nickname);
         user1.setCity(str.toString());
         user1.setCreate_time(new Date());
         userDao.insertUserInfo(user1);
         return user1;
    }
}
