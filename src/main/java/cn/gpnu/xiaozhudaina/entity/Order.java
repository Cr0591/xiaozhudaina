package cn.gpnu.xiaozhudaina.entity;


import java.util.Date;

public class Order {
    //订单号
    public String orderNo;
    //收货人的电话
    public String consigneePhone;
    //订单创建或提交时间
    public Date createTime;
    //订单完成时间
    public Date completeTime;
    //订单状况 0为提交，1为完成
    public Integer orderStatus;
    //返利金额
    public Integer profit;
    //绑定这是谁的订单
    public Integer userId;

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", consigneePhone='" + consigneePhone + '\'' +
                ", createTime=" + createTime +
                ", completeTime=" + completeTime +
                ", orderStatus=" + orderStatus +
                ", profit=" + profit +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                '}';
    }
}
