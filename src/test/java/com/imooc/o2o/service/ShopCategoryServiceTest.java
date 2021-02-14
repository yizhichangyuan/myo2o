package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private CacheService cacheService;

    @Test
    public void testQueryShopCategoryListTest() {
        ShopCategory shopCategoryCondition = new ShopCategory();
        List<ShopCategory> list = shopCategoryService.queryShopCategory(shopCategoryCondition);
//        List<ShopCategory> temp = shopCategoryService.queryShopCategory(null);
        ShopCategory parent = new ShopCategory();
        parent.setShopCategoryId(10L);
        shopCategoryCondition.setParent(parent);
        shopCategoryService.queryShopCategory(shopCategoryCondition);
        cacheService.removeKeys(shopCategoryService.SHOP_CATEGORY_KEY);
        shopCategoryService.queryShopCategory(shopCategoryCondition);
    }
}
