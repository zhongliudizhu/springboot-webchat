package com.coolchatting.springbootwebchat.domain;


import lombok.Data;

import java.util.Date;
@Data
public class User {

  private Integer id;
  private String openid;
  private String name;
  private String head_img;
  private String phone;
  private String sign;
  private Integer sex;
  private String city;
  private Date create_time;

  public User(String headImg, Integer sex, String city) {
    this.head_img = headImg;
    this.sex = sex;
    this.city = city;

  }




}
