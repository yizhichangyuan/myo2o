package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    @Ignore
    public void testAddShop() throws IOException, ShopOperationException {
        Shop shop = new Shop();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        PersonInfo owner = new PersonInfo();
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        owner.setUserId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺1");
        shop.setShopDesc("test1");
        shop.setShopAddr("龙腾街道");
        shop.setPhone("1234");
        File shopImg = new File("/Users/yizhichangyuan/Downloads/IMG_20170930_164953.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.addShop(shop, is, shopImg.getName());
        assertEquals(shopExecution.getState(), ShopStateEnum.CHECK.getState());
    }

    @Test
    @Ignore
    public void testModifyShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(75L);
        shop.setShopName("修改后的店铺名称");
        File file = new File("/Users/yizhichangyuan/Desktop/截屏:录屏.nosync/截屏2020-12-21 00.02.29.png");
        ShopExecution shopExecution = shopService.modifyShop(shop, new FileInputStream(file), file.getName());
        System.out.println(shopExecution.getShop().getShopImg());
    }

    @Test
    public void testGetShopList() {
        Shop shop = new Shop();
        Area area = new Area();
        area.setAreaId(2);
        shop.setArea(area);
        ShopExecution shopExecution = shopService.getShopList(shop, 1, 5);
        System.out.println("店铺列表总数：" + shopExecution.getShopList().size());
        System.out.println("符合条件店铺总数：" + shopExecution.getCount());
    }

}
