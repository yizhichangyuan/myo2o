package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductImg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductImgDaoTest extends BaseTest {
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testInsertBatchProductImg() {
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("test");
        productImg1.setImgDesc("测试描述");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(13L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("test");
        productImg2.setImgDesc("测试描述");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(13L);
        List<ProductImg> list = new ArrayList<>();
        list.add(productImg1);
        list.add(productImg2);
        int effectNum = productImgDao.insertBatchProductImg(list);
        System.out.println("插入成功：" + effectNum);
    }

    @Test
    public void testBDeleteBatchProductImg() {
        List<ProductImg> list = new ArrayList<>();
        ProductImg productImg1 = new ProductImg();
        productImg1.setProductImgId(15L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setProductImgId(16L);
        list.add(productImg1);
        list.add(productImg2);
        int effectNum = productImgDao.deleteBatchProductImg(list);
        assertEquals(effectNum, list.size());
    }

    @Test
    public void testCQueryProductImgList() {
        ProductImg productImg1 = new ProductImg();
        productImg1.setProductId(25L);
        List<ProductImg> list = productImgDao.queryProductImgList(productImg1);
        System.out.println(list.size());
    }
}
