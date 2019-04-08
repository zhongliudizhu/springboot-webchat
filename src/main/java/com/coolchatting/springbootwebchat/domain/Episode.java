package com.coolchatting.springbootwebchat.domain;


import lombok.Data;

import java.util.Date;
@Data
public class Episode {

  private Integer id;
  private String title;
  private Integer num;
  private String duration;
  private String coverImg;
  private Integer videoId;
  private String summary;
  private Date createTime;
  private Integer chapterId;



}
