package cn.gpnu.xiaozhudaina.service.impl;

import cn.gpnu.xiaozhudaina.dao.UserOrderDao;
import cn.gpnu.xiaozhudaina.dto.UserOrder;
import cn.gpnu.xiaozhudaina.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    public UserOrderDao userOrderDao;

    @Override
    public List<UserOrder> getAllList() {
        return userOrderDao.queryAllOrder();
    }

    @Override
    public int getAllListCount() {
        return userOrderDao.countAllList();
    }


}
