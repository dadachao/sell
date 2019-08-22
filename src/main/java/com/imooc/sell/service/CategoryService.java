package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Kelvin
 */
public interface CategoryService {
    /**
     * 返回查询的结果，若未查询到，则报[PRODUCT_CATEGORY_NOT_EXIST 商品种类不存在]异常
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 返回查询结果,若未查询到，则返回 Null
     * @param categoryId
     * @return
     */
    ProductCategory findOneOrNull(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

    ProductCategory save(ProductCategory productCategory);

}
