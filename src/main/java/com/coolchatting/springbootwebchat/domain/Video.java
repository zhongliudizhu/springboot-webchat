package com.coolchatting.springbootwebchat.domain;


import lombok.Data;

import java.util.Date;
@Data
public class Video {

  private Integer id;
  private String title;
  private String summary;
  private String cover_img;
  private Integer view_num;
  private Integer price;
  private Date createTime;
  private Integer online;
  private Double point;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getCover_img() {
    return cover_img;
  }

  public void setCover_img(String cover_img) {
    this.cover_img = cover_img;
  }

  public Integer getView_num() {
    return view_num;
  }

  public void setView_num(Integer view_num) {
    this.view_num = view_num;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getOnline() {
    return online;
  }

  public void setOnline(Integer online) {
    this.online = online;
  }

  public Double getPoint() {
    return point;
  }

  public void setPoint(Double point) {
    this.point = point;
  }
}
