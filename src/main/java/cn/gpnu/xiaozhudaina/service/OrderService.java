package cn.gpnu.xiaozhudaina.service;


import cn.gpnu.xiaozhudaina.entity.Order;

public interface OrderService {
    boolean isExistOrder(String orderNo);

    int submitOrder(Order order);
}
