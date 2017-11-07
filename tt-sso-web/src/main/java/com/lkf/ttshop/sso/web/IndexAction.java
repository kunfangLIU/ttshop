package com.lkf.ttshop.sso.web;


import com.lkf.common.dto.MessageResult;
import com.lkf.common.util.CookieUtils;
import com.lkf.ttshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: DHC
 * Date: 2017/11/7
 * Time: 16:40
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class IndexAction {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String index(){
        return "login";
    }

    @RequestMapping(value="/user/login", method= RequestMethod.POST)
    @ResponseBody
    public MessageResult login(String username, String password,
                               HttpServletRequest request, HttpServletResponse response) {

        //接收两个参数。
        //调用Service进行登录。
        MessageResult result = loginService.userLogin(username, password);
        //判断是否登录成功
        if(result.isSuccess()) {
            //从返回结果中取token，写入cookie。Cookie要跨域。
            String token = result.getData().toString();
            System.out.println(token);
            CookieUtils.setCookie(request, response, "tt_token", token);
        }
        //响应数据。Json数据。MessageResult，其中包含Token。
        return result;
    }

}
