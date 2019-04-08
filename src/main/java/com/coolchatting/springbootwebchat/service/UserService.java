package com.coolchatting.springbootwebchat.service;

import com.coolchatting.springbootwebchat.domain.User;

public interface UserService {
    User saveUserInfo(String code)throws Exception;

}
