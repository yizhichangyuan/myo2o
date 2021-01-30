package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ProductCategoryExecution;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.enums.ProductCategoryStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductCategoryServiceTest extends BaseTest {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void testGetProductCategoryList() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setShopId(8L);
        ProductCategoryExecution pce = productCategoryService.getProductCategoryList(productCategory, 1, 5);
        assertEquals(pce.getState(), 1);
        System.out.println(pce.getProductCategoryList().size());
    }

    @Test
    public void testAddBatchProductCategory() {
        List<ProductCategory> list = new ArrayList<>();
        ProductCategory pc1 = new ProductCategory();
        pc1.setShopId(8L);
        pc1.setCreateTime(new Date());
        pc1.setProductCategoryName("第一个分类");
        ProductCategory pc2 = new ProductCategory();
        pc2.setShopId(8L);
        pc2.setCreateTime(new Date());
        pc2.setProductCategoryName("第二个分类");
        list.add(pc1);
        list.add(pc2);
        ProductCategoryExecution execution = productCategoryService.addBatchProductCategory(list);
        assertEquals(execution.getState(), ProductCategoryStateEnum.SUCCESS.getState());
    }

}
