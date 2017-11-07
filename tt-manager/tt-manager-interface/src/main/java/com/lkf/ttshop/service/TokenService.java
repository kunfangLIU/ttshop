package com.lkf.ttshop.service;

import com.lkf.common.dto.MessageResult;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 22:11
 * Version:V1.0
 */
public interface TokenService {
    MessageResult getUserByToken(String token);
}
