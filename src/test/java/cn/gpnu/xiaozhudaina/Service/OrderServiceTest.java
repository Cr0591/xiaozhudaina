package cn.gpnu.xiaozhudaina.Service;

import cn.gpnu.xiaozhudaina.BaseTest;
import cn.gpnu.xiaozhudaina.entity.Order;
import cn.gpnu.xiaozhudaina.service.OrderService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class OrderServiceTest extends BaseTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void tset(){
        Order order = new Order();
        order.setUserId(1);
        order.setConsigneePhone("123");
        order.setOrderNo("123123");
        order.setCreateTime(new Date());
        int i = orderService.submitOrder(order);
        System.out.println(i);
    }


}
