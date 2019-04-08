package com.coolchatting.springbootwebchat.mapper;

import com.coolchatting.springbootwebchat.domain.VideoOrder;
import com.coolchatting.springbootwebchat.provider.DynamicSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;



public interface VideoOrderDao {

    List<VideoOrder> getAllInfo();
    @UpdateProvider(type = DynamicSqlProvider.class,method = "updateVideoOrder")
    int  updateVideoOrder(VideoOrder videoOrder);
    @InsertProvider(type = DynamicSqlProvider.class,method = "insertVideoOrder")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int  insertVideoOrder(VideoOrder videoOrder);
}
