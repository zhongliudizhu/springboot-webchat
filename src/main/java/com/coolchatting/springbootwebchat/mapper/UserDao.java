package com.coolchatting.springbootwebchat.mapper;

import com.coolchatting.springbootwebchat.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface UserDao {
     @Select(" select * from user where openid=#{openID}")
     User getUserInfo(String openID);

     int insertUserInfo(User user);

     @Update("update user set create_time=#{create_time} where openid=#{openid}")
     int updateUserLoginTime(@Param("create_time") Date time, @Param("openid") String openid);
     @Select("select * from user where id=#{userId} ")
      User  getUserInfoByUserId(Integer userId);

}
