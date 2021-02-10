package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.PersonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PersonInfoDaoTest extends BaseTest {
    @Autowired
    private PersonInfoDao personInfoDao;

    @Test
    public void testInsertPersonInfo() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("测试名");
        personInfo.setProfileImg("XXXX");
        personInfo.setEmail("695999620@qq.com");
        personInfo.setGender("女");
        personInfo.setEnableStatus(1);
        personInfo.setUserType(2);
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        int effectNum = personInfoDao.insertPersonInfo(personInfo);
        assertEquals(effectNum, 1);
    }

    @Test
    public void testQueryPersonInfoById() {
        PersonInfo personInfo = personInfoDao.queryPersonInfoById(3);
        System.out.println(personInfo.getName());
    }
}
