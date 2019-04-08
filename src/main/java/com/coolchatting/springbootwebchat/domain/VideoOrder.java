package com.coolchatting.springbootwebchat.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class VideoOrder implements Serializable {

  private Integer id;
  private String openid;
  private String out_trade_no;
  private Integer state;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy:MM:dd")
  private Date create_time;
  @DateTimeFormat(pattern = "yyyy:MM:dd")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
  private Date notify_time;
  private Integer total_fee;
  private String nickname;
  private String head_img;
  private Integer video_id;
  private String video_title;
  private String video_img;
  private Integer user_id;
  private String ip;
  private Integer del;



}
