package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    List<Product> queryProductList(@Param("productCondition") Product productCondition);

    int insertProduct(@Param("product") Product product);
}
