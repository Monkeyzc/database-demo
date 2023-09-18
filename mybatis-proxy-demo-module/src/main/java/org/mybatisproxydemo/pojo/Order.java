package org.mybatisproxydemo.pojo;

// 订单
public class Order {
    public int id;
    public double payment;
    public int paymentType;
    public int status;

    public Order() {
    }

    public Order(int id, double payment, int paymentType, int status) {
        this.id = id;
        this.payment = payment;
        this.paymentType = paymentType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", status=" + status +
                '}';
    }
}
