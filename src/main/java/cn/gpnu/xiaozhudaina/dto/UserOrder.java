package cn.gpnu.xiaozhudaina.dto;

import cn.gpnu.xiaozhudaina.entity.Order;
import cn.gpnu.xiaozhudaina.entity.User;

public class UserOrder {
    User user;
    Order order;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
