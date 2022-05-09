package com.chenhao.pojo;

import java.time.LocalDateTime;

public class Store {
    private Integer id;
    private String shopOwner;
    private String idNumber;
    private String name;
    private String industry;
    private String area;
    private String phone;
    private Integer status;
    private LocalDateTime auditTime;

    public Store(Integer id, String shopOwner, String idNumber, String name, String industry, String area, String phone, Integer status, LocalDateTime auditTime) {
        this.id = id;
        this.shopOwner = shopOwner;
        this.idNumber = idNumber;
        this.name = name;
        this.industry = industry;
        this.area = area;
        this.phone = phone;
        this.status = status;
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", shopOwner='" + shopOwner + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                ", area='" + area + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", auditTime=" + auditTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(LocalDateTime auditTime) {
        this.auditTime = auditTime;
    }

    public Store() {
    }
}
