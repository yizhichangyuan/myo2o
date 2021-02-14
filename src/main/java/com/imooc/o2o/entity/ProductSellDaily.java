package com.imooc.o2o.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbProductSellDaily)实体类，统计店铺每日某件商品统计  unique key（productId,shopId,create_time)
 *
 * @author makejava
 * @since 2021-02-14 16:01:19
 */
public class ProductSellDaily implements Serializable {
    private static final long serialVersionUID = -16561799001498426L;

    private Integer productSellDailyId;

    private Integer productId;

    private Integer shopId;

    /**
     * 该商品的日销量
     */
    private Integer total;

    /**
     * 统计日期，每天统计一次
     */
    private Date createTime;


    public Integer getProductSellDailyId() {
        return productSellDailyId;
    }

    public void setProductSellDailyId(Integer productSellDailyId) {
        this.productSellDailyId = productSellDailyId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}