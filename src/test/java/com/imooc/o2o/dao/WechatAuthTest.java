package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.WechatAuth;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class WechatAuthTest extends BaseTest {
    @Autowired
    private WechatAuthDao wechatAuthDao;

    @Test
    public void testInsertWechatAuth() {
        WechatAuth wechatAuth = new WechatAuth();
        wechatAuth.setOpenId("lalala");
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(3L);
        wechatAuth.setPersonInfo(personInfo);
        int effectNum = wechatAuthDao.insertWechatAuth(wechatAuth);
        assertEquals(effectNum, 1);
    }

    @Test
    public void testQueryWechatAuthById() {
        WechatAuth wechatAuth = wechatAuthDao.queryWechatAuthById("lalala");
        System.out.println(wechatAuth.getPersonInfo().getName());
    }
}
