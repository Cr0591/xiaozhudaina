package cn.gpnu.xiaozhudaina.dao;

import cn.gpnu.xiaozhudaina.entity.Order;

public interface OrderDao {
    Order findOrderByOrderNo(String orderNo);
}
