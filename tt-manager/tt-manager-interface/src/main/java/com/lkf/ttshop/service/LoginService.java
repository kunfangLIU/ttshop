package com.lkf.ttshop.service;

import com.lkf.common.dto.MessageResult;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 22:04
 * Version:V1.0
 */
public interface LoginService {
    MessageResult userLogin(String username,String password);
}
