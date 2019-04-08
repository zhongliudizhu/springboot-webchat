package com.coolchatting.springbootwebchat.intercept;

import com.alibaba.fastjson.JSON;
import com.coolchatting.springbootwebchat.domain.JsonData;
import com.coolchatting.springbootwebchat.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginHandleInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token==null){
             token = request.getParameter("token");
        }
        if(token!=null){
            Claims claims = JwtUtils.checkJWT(token);
             if(claims!=null){
                 Integer id = (Integer) claims.get("id");
                 String name = (String) claims.get("name");
                 request.setAttribute("user_id",id);
                 request.setAttribute("userName",name);
                 return  true;
             }
        }

          sendErrorMsg(response);
          return false;
    }

    private void sendErrorMsg(HttpServletResponse response) throws IOException {
        response.setContentType("application/json,charset=UTF-8");
        PrintWriter writer = response.getWriter();
        JsonData jsonData = JsonData.buildFailure("you do not have auth ,please do login");
        writer.print(JSON.toJSONString(jsonData));
        writer.close();
        response.flushBuffer();
    }
}
