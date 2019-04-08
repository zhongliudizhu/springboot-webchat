package com.coolchatting.springbootwebchat.provider;

import com.coolchatting.springbootwebchat.domain.User;
import com.coolchatting.springbootwebchat.domain.VideoOrder;
import org.apache.ibatis.jdbc.SQL;
import sun.awt.SunHints;

public class DynamicSqlProvider {


    public String updateVideoOrder(final VideoOrder videoOrder) {
        return new SQL() {{
            UPDATE("video_order");
            //条件写法.
            if (videoOrder.getOpenid() != null) {
                SET("openid=#{openid}");
            }
            if (videoOrder.getCreate_time() != null) {
                SET("create_time=#{create_time}");
            }
            if (videoOrder.getOut_trade_no() != null) {
                SET("out_trade_no=#{out_trade_no}");
            }
            if (videoOrder.getDel() != null) {
                SET("del=#{del}");
            }
            if (videoOrder.getState() != null) {
                SET("state=#{state}");
            }
            if (videoOrder.getNotify_time() != null) {
                SET("notify_time=#{notify_time}");
            }
            if (videoOrder.getTotal_fee() != null) {
                SET("total_fee=#{total_fee}");
            }
            if (videoOrder.getNickname() != null) {
                SET("nickname=#{nickname}");
            }
            if (videoOrder.getHead_img() != null) {
                SET("head_img=#{head_img}");
            }
            if (videoOrder.getVideo_id() != null) {
                SET("video_id=#{video_id}");
            }
            if (videoOrder.getVideo_img() != null) {
                SET("video_img()=#{video_img}");
            }
            if (videoOrder.getVideo_title() != null) {
                SET("video_title=#{video_title}");
            }
            if (videoOrder.getIp() != null) {
                SET("ip=#{ip}");
            }
            if (videoOrder.getUser_id() != null) {
                SET("user_id=#{user_id}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }


    public String insertVideoOrder(final VideoOrder videoOrder) {
        SQL sql = new SQL();
        sql.INSERT_INTO("video_order");
            {{
                //条件写法.
                if (videoOrder.getOpenid() != null) {
                    sql.VALUES("openid", "#{openid}");
                }
                if (videoOrder.getCreate_time() != null) {
                    sql.VALUES("create_time", "#{create_time}");
                }
                if (videoOrder.getOut_trade_no() != null) {
                    sql.VALUES("out_trade_no", "#{out_trade_no}");
                }
                if (videoOrder.getDel() != null) {
                    sql.VALUES("del", "#{del}");
                }
                if (videoOrder.getState() != null) {
                    sql.VALUES("state", "#{state}");
                }
                if (videoOrder.getNotify_time() != null) {
                    sql.VALUES("notify_time", "#{notify_time}");
                }
                if (videoOrder.getTotal_fee() != null) {
                    sql.VALUES("total_fee", "#{total_fee}");
                }
                if (videoOrder.getNickname() != null) {
                    sql.VALUES("nickname", "#{nickname}");
                }
                if (videoOrder.getHead_img() != null) {
                    sql.VALUES("head_img", "#{head_img}");
                }
                if (videoOrder.getVideo_id() != null) {
                    sql.VALUES("video_id", "#{video_id}");
                }
                if (videoOrder.getVideo_img() != null) {
                    sql.VALUES("video_img", "#{video_img}");
                }
                if (videoOrder.getVideo_title() != null) {
                    sql.VALUES("video_title", "#{video_title}");
                }
                if (videoOrder.getIp() != null) {
                    sql.VALUES("ip", "#{ip}");
                }
                if (videoOrder.getUser_id() != null) {
                    sql.VALUES("user_id", "#{user_id}");
                }
            }}

               return sql.toString();


    }
}