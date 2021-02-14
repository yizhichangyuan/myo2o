package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.LocalAuthExecution;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.enums.LocalAuthStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class LocalAuthServiceTest extends BaseTest {
    @Autowired
    private LocalAuthService localAuthService;

    @Test
    public void testAInsertLocalAuth() {
        LocalAuth localAuth = new LocalAuth();
        localAuth.setUserName("test");
        localAuth.setPassword("123456");
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        localAuth.setPersonInfo(personInfo);
        LocalAuthExecution localAuthExecution = localAuthService.bindLocalAuth(localAuth);
        assertEquals(localAuthExecution.getState(), LocalAuthStateEnum.SUCCESS.getState());
    }

    @Test
    public void testBModifyLocalAuth() {
        String userName = "test";
        String password = "123456";
        String newPassword = "make1234";
        long userId = 1L;
        LocalAuthExecution localAuthExecution = localAuthService.modifyPassword(userName, password, newPassword, userId);
        assertEquals(localAuthExecution.getState(), LocalAuthStateEnum.SUCCESS.getState());
    }
}
