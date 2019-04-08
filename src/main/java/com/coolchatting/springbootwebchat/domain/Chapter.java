package com.coolchatting.springbootwebchat.domain;


import lombok.Data;

import java.util.Date;
@Data
public class Chapter {

  private Integer id;
  private Integer videoId;
  private String title;
  private Integer ordered;
  private Date createTime;


}