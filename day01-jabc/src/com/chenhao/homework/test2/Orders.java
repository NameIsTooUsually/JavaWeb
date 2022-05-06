package com.chenhao.homework.test2;

import java.util.Date;

public class Orders {
private long id;
private String number;
private int status;
private Date orderTime;
private int payMethod;
private double amount;
private String phone;
private String address;

    public Orders(long id, String number, int status, Date orderTime, int payMethod, double amount, String phone, String address) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.orderTime = orderTime;
        this.payMethod = payMethod;
        this.amount = amount;
        this.phone = phone;
        this.address = address;
    }

    public Orders() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", payMethod=" + payMethod +
                ", amount=" + amount +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
