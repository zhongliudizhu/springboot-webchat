package com.coolchatting.springbootwebchat.mapper;

import com.coolchatting.springbootwebchat.domain.Video;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoMapper {
     @Select("select * from video")
     List<Video> getAllVideos();
     @Select("select * from video where id=#{videoId}")
     Video getVideoInfo(Integer videoId);
}
