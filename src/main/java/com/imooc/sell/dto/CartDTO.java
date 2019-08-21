package com.imooc.sell.dto;

import lombok.Data;

/**
 * @author Kelvin
 */
@Data
public class CartDTO {
    /** 商品信息Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
