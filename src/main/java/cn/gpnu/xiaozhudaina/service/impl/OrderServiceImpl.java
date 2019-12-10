package cn.gpnu.xiaozhudaina.service.impl;

import cn.gpnu.xiaozhudaina.dao.OrderDao;
import cn.gpnu.xiaozhudaina.entity.Order;
import cn.gpnu.xiaozhudaina.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public boolean isExistOrder(Integer orderNo) {
        Order order = orderDao.findOrderByOrderNo(orderNo);
        if (order != null){
            return true;
        }
        return false;
    }
}