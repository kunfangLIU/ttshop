package com.lkf.ttshop.dao;


import com.lkf.ttshop.pojo.po.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: DHC
 * Date: 2017/10/16
 * Time: 15:36
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class TbUserMapperTest {

    @Autowired
    private TbUserMapper userDao;

    @Test
    public void selectByPrimaryKey() throws Exception {
      TbUser user = userDao.selectByPrimaryKey(5L);
        System.out.println(user);
    }

}