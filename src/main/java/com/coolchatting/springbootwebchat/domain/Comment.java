package com.coolchatting.springbootwebchat.domain;


import lombok.Data;

import java.util.Date;
@Data
public class Comment {

  private Integer id;
  private String content;
  private Integer userId;
  private String headImg;
  private String name;
  private Double point;
  private Integer up;
  private Date createTime;
  private Integer orderId;
  private Integer videoId;




}
