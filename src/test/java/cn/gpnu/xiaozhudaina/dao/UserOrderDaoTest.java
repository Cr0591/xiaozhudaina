package cn.gpnu.xiaozhudaina.dao;

import cn.gpnu.xiaozhudaina.BaseTest;
import cn.gpnu.xiaozhudaina.dto.UserOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserOrderDaoTest extends BaseTest {

    @Autowired
    public UserOrderDao userOrderDao;
    @Test
    public void testGetAllOrder(){
        List<UserOrder> allOrder = userOrderDao.queryAllOrder();
        System.out.println(allOrder.size());
    }

    @Test
    public void testCountAllList(){
        int i = userOrderDao.countAllList();
        System.out.println(i);
    }
}
