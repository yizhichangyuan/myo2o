package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void testAInsertProduct() {
        Product product = new Product();
        product.setProductName("测试产品");
        product.setProductDesc("测试内容");
        product.setImgAddr("test");
        product.setNormalPrice("100");
        product.setPromotionPrice("10");
        product.setPriority(1);
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());
        product.setEnableStatus(1);
        Shop shop = new Shop();
        shop.setShopId(8L);
        product.setShop(shop);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(32L);
        product.setProductCategory(productCategory);
        int effectNum = productDao.insertProduct(product);
        assertEquals(effectNum, 1);
    }
}
