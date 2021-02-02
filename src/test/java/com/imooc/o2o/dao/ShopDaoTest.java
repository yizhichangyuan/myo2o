package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

//@Transactional //该注释会对测试进行默认回滚，如果不想回滚，可以在方法前添加@Rollback(false)注解
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺lala");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setPhone("test");
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        shop.setCreateTime(new Date());
        int id = shopDao.insertShop(shop);
        assertEquals(id, 1);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(8L);
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("测试地址");
        shop.setShopAddr("测试描述");
        shop.setPhone("test");
        shop.setPhone("test");
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        shop.setLastEditTime(new Date());
        int id = shopDao.updateShop(shop);
        assertEquals(id, 1);
    }

    @Test
    public void testQueryShopById() {
        long shopId = 8;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaName:" + shop.getArea().getAreaName());
    }

    @Test
    public void testQueryShopList() {
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        shopCondition.setShopName("测试");
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        System.out.println("查询到的分页大小：" + shopList.size());
    }

    @Test
    public void testQueryShopCount() {
        Shop shopCondition = new Shop();
        Area area = new Area();
        area.setAreaId(3);
        shopCondition.setArea(area);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("查询到的符合查询条件总数：" + count);
    }


}
