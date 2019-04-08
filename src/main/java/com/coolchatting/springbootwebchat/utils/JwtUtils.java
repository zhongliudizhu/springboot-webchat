package com.coolchatting.springbootwebchat.utils;

import com.coolchatting.springbootwebchat.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {

    private static final Logger logger= LoggerFactory.getLogger(JwtUtils.class);
    public static final String SUBJECT = "xdclass";

    public static final long EXPIRE = 1000*60;  //过期时间，毫秒，一周

    //秘钥
    public static final  String APPSECRET = "xd666";

    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        if(user == null || user.getId() == null || user.getName() == null
                || user.getHead_img()==null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getName())
                .claim("img",user.getHead_img())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){ }
        return null;
    }

    public static void main(String[] args) {
//        User user=new User();
//        user.setId(12);
//        user.setName("EWEW");
//        user.setHead_img("https://ewewe/ffdf");
//        String token = geneJsonWebToken(user);
//        logger.info("===="+token+"====");
            String  token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjEyLCJuYW1lIjoiRVdFVyIsImltZyI6Imh0dHBzOi8vZXdld2UvZmZkZiIsImlhdCI6MTUzOTg1MTI4OSwiZXhwIjoxNTM5ODU0ODg5fQ.iC9aKw6LNGrSwCBGDw8-gv5axKaSnudrZBjdCgffPWw";
        Claims claims = checkJWT(token);
        Object name = claims.get("name");
        logger.info("==="+name+"===="+claims.get("head_img")+ claims.get("id"));


    }

}
