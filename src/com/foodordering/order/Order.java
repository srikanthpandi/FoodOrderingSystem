package com.foodordering.order;

import java.util.ArrayList;
import java.util.List;

import com.foodordering.cart.CartItem;

public class Order {

    private int orderId;
    private int userId;
    private List<CartItem> items;
    private double totalAmount;
    private String orderStatus;

    public Order(int orderId, int userId, List<CartItem> items, double totalAmount) {

        this.orderId = orderId;
        this.userId = userId;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.orderStatus = "PLACED";
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {

        return "Order ID: " + orderId
                + ", User ID: " + userId
                + ", Total Amount: ₹" + totalAmount
                + ", Status: " + orderStatus;
    }
}