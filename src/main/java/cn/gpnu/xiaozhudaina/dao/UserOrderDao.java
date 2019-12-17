package cn.gpnu.xiaozhudaina.dao;

import cn.gpnu.xiaozhudaina.dto.UserOrder;

import java.util.List;

public interface UserOrderDao {
    List<UserOrder> queryAllOrder();

    /**
     * 所有订单的长度
     * @return
     */
    int countAllList();
}
