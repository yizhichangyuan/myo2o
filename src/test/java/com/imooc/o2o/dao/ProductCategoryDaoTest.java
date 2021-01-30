package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //按照测试类的方法名的顺序依次执行
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testInsertProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setShopId(8L);
        productCategory.setProductCategoryName("测试分类");
        productCategory.setCreateTime(new Date());
        productCategory.setPriority(1);
        int id = productCategoryDao.insertProductCategory(productCategory);
        assertEquals(id, 1);
    }

    @Test
    @Ignore
    public void testQueryProductCategory() {
        ProductCategory productCategory = new ProductCategory();
//        productCategory.setProductCategoryName("试");
        productCategory.setShopId(8L);
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(productCategory, 0, 5);
        assertEquals(productCategoryList.size(), 1);
        System.out.println(productCategoryList.get(0).getProductCategoryName());
    }

    @Test
    @Ignore
    public void testQueryProductCategoryCount() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("试");
        int productCategoryCount = productCategoryDao.queryProductCategoryCount(productCategory);
        assertEquals(productCategoryCount, 1);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setShopId(8L);
        List<ProductCategory> list = productCategoryDao.queryProductCategoryList(productCategory, 0, 100);
        for (ProductCategory temp : list) {
            int productCategoryCount = productCategoryDao.deleteProductCategory(temp);
            assertEquals(productCategoryCount, 1);
        }
    }

    @Test
    public void insertBatchProductCategoryTest() {
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
        int result = productCategoryDao.insertBatchProductCategory(list);
        System.out.println("插入结果： " + result);
    }
}
