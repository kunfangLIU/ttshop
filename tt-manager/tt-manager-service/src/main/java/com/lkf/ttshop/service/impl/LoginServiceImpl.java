package com.lkf.ttshop.service.impl;
import com.lkf.ttshop.pojo.po.TbUserExample.Criteria;
import com.lkf.common.dto.MessageResult;
import com.lkf.common.jedis.JedisClient;
import com.lkf.common.util.JsonUtils;
import com.lkf.ttshop.dao.TbUserMapper;
import com.lkf.ttshop.pojo.po.TbUser;
import com.lkf.ttshop.pojo.po.TbUserExample;
import com.lkf.ttshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 22:05
 * Version:V1.0
 * 用户登录处理
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private TbUserMapper userMapper;
    @Autowired
    private JedisClient jedisClient;


    @Override
    public MessageResult userLogin(String username, String password) {

        MessageResult result = new MessageResult();

        //判断用户和密码是否正确
        //根据用户名查询用户信息
        TbUserExample example = new TbUserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        //执行查询
        List<TbUser> list = userMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            //返回登录失败
            result.setSuccess(false);
            result.setMessage("用户名不存在");
            return result;
        }

        //取用户信息
        TbUser user = list.get(0);
        //判断密码是否正确
        String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5Pass.equals(user.getPassword())) {
            //返回登录失败
            result.setSuccess(false);
            result.setMessage("密码错误");
            return result;
        }

        //如果正确生成token。
        String token = UUID.randomUUID().toString();
        //把用户信息写入redis，key：token value：用户信息
        user.setPassword(null);
        jedisClient.set("TT_TOKEN:" + token, JsonUtils.objectToJson(user));
        //设置Session的过期时间
        jedisClient.expire("TT_TOKEN:" + token, 1800);
        //把token返回
        result.setSuccess(true);
        result.setMessage("登录成功");
        result.setData(token);
        return result;
    }
}
