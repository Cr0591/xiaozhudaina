package cn.gpnu.xiaozhudaina.dao;

import cn.gpnu.xiaozhudaina.BaseTest;
import cn.gpnu.xiaozhudaina.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderDaoTest extends BaseTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testFindOrderByOrderNo(){
        Order order = orderDao.findOrderByOrderNo("123456789");
        String phone = order.getConsigneePhone();
        assertEquals("13192700591",phone);
    }

    @Test
    public void testQueryOrderList(){
        List<Order> orderList = orderDao.queryOrderList(1);
        assertEquals(1,orderList.size());
    }

    @Test
    public void tset(){
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setConsigneePhone("123123");
        order.setUserId(1);
        order.setOrderStatus(0);
        order.setMessage("wocao");
        order.setOrderNo("5555555555555555");
        int i = orderDao.submitOrder(order);
        System.out.println(i);
    }

}
