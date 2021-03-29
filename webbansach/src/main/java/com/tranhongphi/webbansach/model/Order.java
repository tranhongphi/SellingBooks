package com.tranhongphi.webbansach.model;

import java.util.List;

public class Order {
    private int id;
    private User user;
    private List<Item> items;
    private int totalPrice;
    private int status;

    public Order() {
    }

    public Order(int id, User user, List<Item> items, int status) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
