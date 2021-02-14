package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HeadLineServiceTest extends BaseTest {
    @Autowired
    private HeadLineService headLineService;
    @Autowired
    private CacheService cacheService;

    @Test
    public void testQueryHeadline() {
        HeadLine headLine = new HeadLine();
        List<HeadLine> list = headLineService.queryHeadLineList(headLine);
        cacheService.removeKeys(headLineService.HEADLINE_KEY);
        List<HeadLine> temp = headLineService.queryHeadLineList(headLine);
        System.out.println(list.size());
    }
}
