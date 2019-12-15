package cn.gpnu.xiaozhudaina.service;


import cn.gpnu.xiaozhudaina.entity.Order;

import cn.gpnu.xiaozhudaina.entity.Order;

import java.util.List;

public interface OrderService {
    boolean isExistOrder(String orderNo);

    int submitOrder(Order order);

    List<Order> queryOrderList(Integer userId);
}
