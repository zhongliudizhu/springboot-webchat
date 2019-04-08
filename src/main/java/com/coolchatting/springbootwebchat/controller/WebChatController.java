package com.coolchatting.springbootwebchat.controller;

import com.coolchatting.springbootwebchat.config.WebChatConfig;
import com.coolchatting.springbootwebchat.domain.JsonData;
import com.coolchatting.springbootwebchat.domain.User;
import com.coolchatting.springbootwebchat.service.UserService;
import com.coolchatting.springbootwebchat.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api/webchat")
@Slf4j
public class WebChatController {

    @Autowired
    private WebChatConfig webChatConfig;

    @Autowired
    private UserService userService;
    /**
     * 获取微信二维码连接
     * */

    @RequestMapping("getWebChatUrl")
    public JsonData  getWebChatUrl(@RequestParam(value = "acess_page",required = true) String url) throws UnsupportedEncodingException {
        //获取重定向地址
        String redirectUrl=webChatConfig.getOpenRedirectUrl();
        String callback = URLEncoder.encode(redirectUrl, "GBK");
        String codeUrl = String.format(webChatConfig.getOPEN_QRCODE_URL(),webChatConfig.getOpenAppid(),callback,url);
        return  JsonData.buildSucess(codeUrl);
    }
    /**
     *
     * 获取用户信息,颁发token
     */
    @GetMapping("saveWebchatUserInfo")
    public  void   saveWebchatUserInfo(@RequestParam(value = "code") String code,
                                      @RequestParam(value = "state") String state, HttpServletResponse response){

        try {
            User user = userService.saveUserInfo(code);
             if(user!=null){
                 String  token = JwtUtils.geneJsonWebToken(user);
                 log.info(token);
                 response.sendRedirect(state+"?token="+token+"&head_img="+user.getHead_img()+"&name="+user.getName());
             }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
