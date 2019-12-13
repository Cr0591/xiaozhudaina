package cn.gpnu.xiaozhudaina.service;


import cn.gpnu.xiaozhudaina.entity.Order;

import java.util.List;

public interface OrderService {
    boolean isExistOrder(String orderNo);

    List<Order> queryOrderList(Integer userId);
}
