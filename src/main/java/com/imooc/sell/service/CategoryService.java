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

    /***
     * 查询所有种类
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 查询指定范围内的种类
     * @param list
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

    /**
     * 保存
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);

}
