package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.HeadLineDao;
import com.imooc.o2o.entity.HeadLine;
import com.imooc.o2o.exceptions.HeadLineException;
import com.imooc.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> queryHeadLineList(HeadLine headLineCondition) {
        try {
            List<HeadLine> headLineList = headLineDao.queryHeadLineList(headLineCondition);
            return headLineList;
        } catch (Exception e) {
            throw new HeadLineException("queryHeadLineList error:" + e.getMessage());
        }
    }
}
