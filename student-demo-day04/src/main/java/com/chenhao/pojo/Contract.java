package com.chenhao.pojo;

import java.sql.Date;

public class Contract {
    private int id;
    private String con_num;
    private String con_name;
    private String con_type;
    private String con_peo;
    private Date start_time;
    private Date end_time;

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", con_num='" + con_num + '\'' +
                ", con_name='" + con_name + '\'' +
                ", con_type='" + con_type + '\'' +
                ", con_peo='" + con_peo + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCon_num() {
        return con_num;
    }

    public void setCon_num(String con_num) {
        this.con_num = con_num;
    }

    public String getCon_name() {
        return con_name;
    }

    public void setCon_name(String con_name) {
        this.con_name = con_name;
    }

    public String getCon_type() {
        return con_type;
    }

    public void setCon_type(String con_type) {
        this.con_type = con_type;
    }

    public String getCon_peo() {
        return con_peo;
    }

    public void setCon_peo(String con_peo) {
        this.con_peo = con_peo;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Contract() {
    }

    public Contract(int id, String con_num, String con_name, String con_type, String con_peo, Date start_time, Date end_time) {
        this.id = id;
        this.con_num = con_num;
        this.con_name = con_name;
        this.con_type = con_type;
        this.con_peo = con_peo;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
