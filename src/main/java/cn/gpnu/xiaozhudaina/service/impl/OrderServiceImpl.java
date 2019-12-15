package cn.gpnu.xiaozhudaina.service.impl;

import cn.gpnu.xiaozhudaina.dao.OrderDao;
import cn.gpnu.xiaozhudaina.entity.Order;
import cn.gpnu.xiaozhudaina.service.OrderService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public boolean isExistOrder(String orderNo) {
        Order order = orderDao.findOrderByOrderNo(orderNo);
        if (order != null){
            return true;
        }
        return false;
    }

    @Override
    public int submitOrder(Order order) {
        order.setCreateTime(new Date());
        order.setOrderStatus(0);
        try {
            int res = orderDao.submitOrder(order);
            return res;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Order> queryOrderList(Integer userId) {
        return orderDao.queryOrderList(userId);
    }
}
