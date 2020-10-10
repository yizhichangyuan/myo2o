package com.imooc.o2o.entity;

import java.util.Date;

//商品类别，用户点击某个商品类别，展现所有符合的商家以及该商家是该类别的商品id
public class ProductCategory {
    private Long productCategoryId;
    private Long shopId;
    private String produceCategoryName;
    private Integer priority;

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProduceCategoryName() {
        return produceCategoryName;
    }

    public void setProduceCategoryName(String produceCategoryName) {
        this.produceCategoryName = produceCategoryName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;
}
