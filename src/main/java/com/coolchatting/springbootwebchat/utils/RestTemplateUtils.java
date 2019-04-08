package com.coolchatting.springbootwebchat.utils;

import com.coolchatting.springbootwebchat.domain.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestTemplateUtils {
        @Autowired
        private RestTemplate restTemplate;

        public<T>  ResponseData<T> doGetRequest(String url, Map<String ,Object> params,Class<T> clazz){
            return   doRealRequest(url,params, HttpMethod.GET,clazz);
        }
         public<T> ResponseData<T>  doGetRequest(String url, Class<T> clazz){
           return   doRealRequest(url,null, HttpMethod.GET,clazz);
      }
        public<T>  ResponseData<T> doPostRequest(String url, Map<String ,Object> params,Class<T> clazz){
            return   doRealRequest(url,params, HttpMethod.POST,clazz);
       }

         public<T>  ResponseData<T> doPutRequest(String url, Map<String ,Object> params,Class<T> clazz){
           return   doRealRequest(url,params, HttpMethod.PUT,clazz);
         }
         public<T> ResponseData<T> doDeleteRequest(String url, Map<String ,Object> params,Class<T> clazz){
            return   doRealRequest(url,params, HttpMethod.DELETE,clazz);
        }
     private <T> ResponseData<T> doRealRequest(String url, Map<String, Object> params, HttpMethod method, Class<T> clazz) {
            ResponseEntity<T> response=null;
            HttpHeaders headers=new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept",MediaType.APPLICATION_JSON.toString());
            HttpEntity request=new HttpEntity(headers);
             if(params==null){
                  response=restTemplate.exchange(url,method,request,clazz);
              }else{
                  response=restTemplate.exchange(url,method,request,clazz,params);
             }
            HttpStatus statusCode = response.getStatusCode();
             if(statusCode.is2xxSuccessful()){

             }


         return  null;
       }


}
