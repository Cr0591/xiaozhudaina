package cn.gpnu.xiaozhudaina.dao;

import cn.gpnu.xiaozhudaina.entity.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 通过订单号查询订单
     *
     * @param orderNo
     * @return
     */
    Order findOrderByOrderNo(String orderNo);


    /**
     * 查询这个用户的所有订单
     * @param userId
     * @return
     */
    List<Order> queryOrderList(Integer userId);


}
