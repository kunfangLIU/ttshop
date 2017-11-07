package com.lkf.ttshop.sso.web;


import com.lkf.common.dto.MessageResult;
import com.lkf.common.util.JsonUtils;
import com.lkf.ttshop.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 根据token查询用户信息Controller
 */
@Controller
@Scope("prototype")
public class TokenAction {

	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value="/user/token1/{token}")
	@ResponseBody
	public MessageResult getUserByToken1(@PathVariable String token, String callback) {
		MessageResult result = tokenService.getUserByToken(token);
		return result;
	}
	
	@RequestMapping(value="/user/token2/{token}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getUserByToken2(@PathVariable String token, String callback) {
		MessageResult result = tokenService.getUserByToken(token);
		//响应结果之前，判断是否为jsonp请求
		if (StringUtils.isNotBlank(callback)) {
			//把结果封装成一个js语句响应
			return callback + "(" + JsonUtils.objectToJson(result)  + ");";
		}
		return JsonUtils.objectToJson(result);
	}
	
	@RequestMapping(value="/user/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback) {
		MessageResult result = tokenService.getUserByToken(token);
		//响应结果之前，判断是否为jsonp请求
		if (StringUtils.isNotBlank(callback)) {
			//把结果封装成一个js语句响应
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
		return result;
	}
}
