package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ProductStateEnum;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAAddProduct() throws FileNotFoundException {
        Product product = new Product();
        product.setProductName("测试产品");
        product.setProductDesc("测试内容");
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
        File thumbnailImg = new File("/Users/yizhichangyuan/Desktop/截屏:录屏.nosync/截屏2021-01-01 22.14.44.png");
        InputStream is = new FileInputStream(thumbnailImg);
        ImageHolder thumbnail = new ImageHolder(is, thumbnailImg.getName());

        List<ImageHolder> detailImgList = new ArrayList<>();
        File detailImg1 = new File("/Users/yizhichangyuan/Downloads/IMG_5023.jpeg");
        InputStream is1 = new FileInputStream(detailImg1);
        ImageHolder imageHolder1 = new ImageHolder(is1, detailImg1.getName());
        File detailImg2 = new File("/Users/yizhichangyuan/Downloads/IMG_20170930_164953.jpg");
        InputStream is2 = new FileInputStream(detailImg2);
        ImageHolder imageHolder2 = new ImageHolder(is2, detailImg2.getName());
        detailImgList.add(imageHolder1);
        detailImgList.add(imageHolder2);

        ProductExecution productExecution = productService.addProduct(product, thumbnail, detailImgList);
        assertEquals(productExecution.getState(), ProductStateEnum.SUCCESS.getState());
    }

    @Test
    public void testBModifyProduct() throws FileNotFoundException {
        Product product = new Product();
        product.setProductId(22L);
        product.setProductName("修改产品");
        product.setProductDesc("修改内容");
        product.setNormalPrice("10");
        product.setPromotionPrice("1");
        product.setPriority(0);
        Shop shop = new Shop();
        shop.setShopId(8L);
        product.setShop(shop);

        File thumbnailImg = new File("/Users/yizhichangyuan/Desktop/截屏:录屏.nosync/截屏2020-12-21 00.02.29.png");
        InputStream is = new FileInputStream(thumbnailImg);
        ImageHolder thumbnail = new ImageHolder(is, thumbnailImg.getName());

        List<ImageHolder> detailImgList = new ArrayList<>();
        File detailImg1 = new File("/Users/yizhichangyuan/Desktop/截屏:录屏.nosync/Photo2.jpeg");
        InputStream is1 = new FileInputStream(detailImg1);
        ImageHolder imageHolder1 = new ImageHolder(is1, detailImg1.getName());
        File detailImg2 = new File("/Users/yizhichangyuan/Desktop/截屏:录屏.nosync/6576D2BC-03F8-4C72-B99A-FB5CD68F5269_1_105_c.jpeg");
        InputStream is2 = new FileInputStream(detailImg2);
        ImageHolder imageHolder2 = new ImageHolder(is2, detailImg2.getName());
        detailImgList.add(imageHolder1);
        detailImgList.add(imageHolder2);

        ProductExecution productExecution = productService.modifyProduct(product, thumbnail, detailImgList);
        assertEquals(productExecution.getState(), ProductStateEnum.SUCCESS.getState());
    }
}
