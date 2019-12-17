package cn.gpnu.xiaozhudaina.service;

import cn.gpnu.xiaozhudaina.dto.UserOrder;

import java.util.List;

public interface UserOrderService {
    List<UserOrder> getAllList();

    int getAllListCount();
}
