package com.lkf.ttshop.service.impl;


import com.lkf.common.dto.MessageResult;
import com.lkf.common.jedis.JedisClient;
import com.lkf.common.util.JsonUtils;
import com.lkf.ttshop.pojo.po.TbUser;
import com.lkf.ttshop.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 根据token取用户信息
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public MessageResult getUserByToken(String token) {
		
		MessageResult result = new MessageResult();
		
		//根据token到redis中取用户信息
		String json = jedisClient.get("TT_TOKEN:" + token);
		//取不到用户信息，登录已经过期，返回登录过期
		if (StringUtils.isBlank(json)) {
			result.setSuccess(false);
			result.setMessage("用户登录已经过期");
			return result;
		}
		//取到用户信息更新token的过期时间
		jedisClient.expire("TT_TOKEN:" + token, 1800);
		//返回结果
		TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
		
		result.setSuccess(true);
		result.setMessage("登录成功");
		result.setData(user);
		return result;
	}

}
