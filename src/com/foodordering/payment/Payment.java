package com.foodordering.payment;

public class Payment {

    private int paymentId;
    private int orderId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int paymentId, int orderId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "SUCCESS";
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentId
                + ", Order ID: " + orderId
                + ", Amount: ₹" + amount
                + ", Method: " + paymentMethod
                + ", Status: " + paymentStatus;
    }
}