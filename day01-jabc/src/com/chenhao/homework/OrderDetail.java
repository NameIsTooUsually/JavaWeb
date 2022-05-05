package com.chenhao.homework;

public class OrderDetail {
    private long id;
    private String name;
    private long order_id;
    private int number;
    private double amount;

    public OrderDetail(long id, String name, long order_id, int number, double amount) {
        this.id = id;
        this.name = name;
        this.order_id = order_id;
        this.number = number;
        this.amount = amount;
    }

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order_id=" + order_id +
                ", number=" + number +
                ", amount=" + amount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
