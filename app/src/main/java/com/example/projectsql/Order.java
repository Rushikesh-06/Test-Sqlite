package com.example.projectsql;

public class Order {
    String id;
    String userid;
    String username;
    String orderitem;
    String orderdate;
    String orderprice;

    public Order() {
    }

    public Order(String userid, String username, String orderitem, String orderdate, String orderprice) {
        this.userid = userid;
        this.username = username;
        this.orderitem = orderitem;
        this.orderdate = orderdate;
        this.orderprice = orderprice;
    }

    public Order(String id, String userid, String username, String orderitem, String orderdate, String orderprice) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.orderitem = orderitem;
        this.orderdate = orderdate;
        this.orderprice = orderprice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(String orderitem) {
        this.orderitem = orderitem;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }
}
