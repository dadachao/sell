package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * @author Kelvin
 */
public interface ProductService {

    /**
     * 若查询到则返回对象，否则报[商品不存在 PRODUCT_NOT_EXIST]异常
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 若查询到则返回对象，否则返回null
     * @param productId
     * @return
     */
    ProductInfo findOneOrNull(String productId);

    /**
     * 查询所有上架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存接口
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 增加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
