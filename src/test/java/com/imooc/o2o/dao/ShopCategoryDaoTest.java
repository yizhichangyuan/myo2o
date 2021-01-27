package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void queryShopCategoryTest() {
        List<ShopCategory> list = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(1, list.size());

        ShopCategory testShopCategory = new ShopCategory();
        ShopCategory parent = new ShopCategory();
        parent.setShopCategoryId(1L);
        testShopCategory.setParent(parent);
        List<ShopCategory> temp = shopCategoryDao.queryShopCategory(testShopCategory);
        assertEquals(1, temp.size());
        System.out.println(temp.get(0).getShopCategoryName());
    }
}
