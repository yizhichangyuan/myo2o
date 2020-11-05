package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService; //spring会自动将实现AreaService接口的类注入

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.queryArea();
        assertEquals("西苑", areaList.get(0).getAreaName());
    }

}
