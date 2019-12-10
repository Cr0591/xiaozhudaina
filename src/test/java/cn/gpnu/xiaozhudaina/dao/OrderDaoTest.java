package cn.gpnu.xiaozhudaina.dao;

import cn.gpnu.xiaozhudaina.BaseTest;
import cn.gpnu.xiaozhudaina.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class OrderDaoTest extends BaseTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testFindOrderByOrderNo(){
        int orderNo = 2;
        Order order = orderDao.findOrderByOrderNo(orderNo);
//        assertEquals("13192700591",order.consigneePhone);
        assertEquals(null,order);
    }
}
