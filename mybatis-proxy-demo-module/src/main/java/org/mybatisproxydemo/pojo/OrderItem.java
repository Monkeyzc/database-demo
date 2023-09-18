package org.mybatisproxydemo.pojo;

// 订单项
public class OrderItem {
    public int id;
    public String goodsName;
    public double goodsPrice;
    public String count;
    public int orderId;

    public OrderItem() {
    }

    public OrderItem(int id, String goodsName, double goodsPrice, String count, int orderId) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.count = count;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", count='" + count + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
