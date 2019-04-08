package com.coolchatting.springbootwebchat.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:WebChat.properties"})
@Data
public class WebChatConfig {

    /**
     * 微信开放平台二维码连接
     */
    private  String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?" +
             "appid=%s&redirect_uri=%s&response_type=code&" +
              "scope=snsapi_login&state=%s#wechat_redirect";

    private  final String OPEN_ACCESSTOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s" +
            "&grant_type=authorization_code";

    private  final String OPEN_USERINFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    @Value("${wxopen.appid}")
    private String openAppid;
    @Value("${wxopen.appsecret}")
    private String openAppsecret;
    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;


     /**
      * 对接支付相关配置
      * */
     @Value("${wxpay.appid}")
     private  String wxPayAppid;
     @Value("${wxpay.key}")
     private  String wxPaykey;
    @Value("${wxpay.callback}")
     private  String wxPayCallback;
    @Value("${wxpay.mer_id}")
     private  String wxMerId;
      @Value("${wxpay.appsecret}")
      private  String wxPayAppSecret;


    /**
     * 统一下单url
     */
    private  final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

}
