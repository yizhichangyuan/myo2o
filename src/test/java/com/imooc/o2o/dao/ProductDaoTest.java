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
import java.util.List;

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

    @Test
    public void testBGetProductById() {
        Product product = productDao.getProductById(22L);
        System.out.println(product.getProductImgList().size());
        System.out.println(product.getShop().getOwner().getUserId());
        System.out.println(product.getProductImgList().get(0).getImgAddr());
    }

    @Test
    public void testCQueryProductList() {
        Product productCondition1 = new Product();
        Shop shop = new Shop();
        shop.setShopId(8L);
        productCondition1.setShop(shop);
        List<Product> list1 = productDao.queryProductList(productCondition1, 0, 10);
        System.out.println(list1.size());
        Product productCondition2 = new Product();
        productCondition2.setProductName("修改");
        List<Product> list2 = productDao.queryProductList(productCondition2, 0, 10);
        System.out.println(list2.size());
        Product productCondition3 = new Product();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(32L);
        productCondition3.setProductCategory(productCategory);
        List<Product> list3 = productDao.queryProductList(productCondition3, 0, 10);
        System.out.println(list3.size());
        Product productCondition4 = new Product();
        Shop shop2 = new Shop();
        shop2.setShopId(8L);
        productCondition4.setShop(shop2);
        productCondition4.setProductName("修改");
        int count = productDao.queryProductCount(productCondition4);
        System.out.println(count);
    }

    @Test
    public void testDAlterProductCategoryToNull() {
        long productCategoryId = 32L;
        int effectNum = productDao.alterProductCategoryToNull(productCategoryId);
        System.out.println("将商品的商品类别置空的商品数量为：" + effectNum);
    }
}
