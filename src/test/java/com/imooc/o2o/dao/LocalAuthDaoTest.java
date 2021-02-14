package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthDaoTest extends BaseTest {
    @Autowired
    private LocalAuthDao localAuthDao;
    @Autowired
    private PersonInfoDao personInfoDao;

    private static final String userName = "testName";
    private static final String password = "123456";

    @Test
    public void testAInsertLocalAuth() {
        PersonInfo personInfo = personInfoDao.queryPersonInfoById(1L);
        LocalAuth localAuth = new LocalAuth();
        localAuth.setUserName(userName);
        localAuth.setPassword(password);
        localAuth.setCreateTime(new Date());
        localAuth.setLastEditTime(new Date());
        localAuth.setPersonInfo(personInfo);
        int effectNum = localAuthDao.insertLocalAuth(localAuth);
        assertEquals(effectNum, 1);
    }

    @Test
    public void testBQueryLocalAuthByUserId() {
        LocalAuth localAuth = localAuthDao.queryLocalAuthByUserId(1L);
        System.out.println(localAuth.getPersonInfo().getName());
    }

    @Test
    public void testCQueryLocalAuthByUserNameAndPASD() {
        LocalAuth localAuth = localAuthDao.queryLocalAuthByUserNameAndPASD(userName, password);
        System.out.println(localAuth.getPersonInfo().getName());
    }

    @Test
    public void testDUpdateLocalAuth() {
        long userId = 1L;
        String newPassword = "1234";
        Date lastEditTime = new Date();
        int effectNum = localAuthDao.updateLocalAuth(userName, password, newPassword, userId, lastEditTime);
        assertEquals(1, effectNum);
    }
}
