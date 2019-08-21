package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Kelvin
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    /**
     * 根据orderId查询订单详情表
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
