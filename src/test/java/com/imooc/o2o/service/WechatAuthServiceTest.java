package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.WechatExecution;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.WechatAuth;
import com.imooc.o2o.enums.WechatAuthStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class WechatAuthServiceTest extends BaseTest {
    @Autowired
    private WechatAuthService wechatAuthService;

    @Test
    public void testRegister() {
        WechatAuth wechatAuth = new WechatAuth();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("test名称");
        personInfo.setProfileImg("xxx");
        personInfo.setGender("男");
        personInfo.setEnableStatus(1);
        personInfo.setUserType(3);
        wechatAuth.setPersonInfo(personInfo);
        wechatAuth.setOpenId("*****");
        WechatExecution wechatExecution = wechatAuthService.register(wechatAuth);
        assertEquals(wechatExecution.getState(), WechatAuthStateEnum.SUCCESS.getState());
    }

    @Test
    public void testGetWechatAuthById() {
        String openId = "*****";
        WechatAuth wechatAuth = wechatAuthService.getWechatAuthById(openId);
        System.out.println(wechatAuth.getPersonInfo().getName());
    }


}
