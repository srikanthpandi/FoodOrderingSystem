package com.foodordering.payment;

import java.util.ArrayList;
import java.util.List;

import com.foodordering.exceptions.PaymentFailedException;
import com.foodordering.order.Order;

public class PaymentService {

    private List<Payment> payments = new ArrayList<>();

    private int nextPaymentId = 5001;

    public Payment makePayment(Order order, String paymentMethod)
            throws PaymentFailedException {

        if (order == null) {
            throw new PaymentFailedException(
                    "Payment failed. Order not found."
            );
        }

        if (order.getTotalAmount() <= 0) {
            throw new PaymentFailedException(
                    "Payment failed. Invalid order amount."
            );
        }

        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new PaymentFailedException(
                    "Payment failed. Payment method is required."
            );
        }

        Payment payment = new Payment(
                nextPaymentId,
                order.getOrderId(),
                order.getTotalAmount(),
                paymentMethod
        );

        payments.add(payment);

        nextPaymentId++;

        System.out.println("\n========== PAYMENT ==========");
        System.out.println("Payment successful.");
        System.out.println("Payment ID: " + payment.getPaymentId());
        System.out.println("Order ID: " + payment.getOrderId());
        System.out.println("Amount: ₹" + payment.getAmount());
        System.out.println("Method: " + payment.getPaymentMethod());
        System.out.println("Status: " + payment.getPaymentStatus());

        return payment;
    }

    public Payment findPaymentById(int paymentId) {

        for (Payment payment : payments) {

            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }

        return null;
    }

    public void viewAllPayments() {

        if (payments.isEmpty()) {
            System.out.println("No payments available.");
            return;
        }

        System.out.println("\n========== PAYMENTS ==========");

        for (Payment payment : payments) {
            System.out.println(payment);
        }
    }

    public double getTotalPayments() {

        double total = 0;

        for (Payment payment : payments) {

            if (payment.getPaymentStatus().equals("SUCCESS")) {
                total += payment.getAmount();
            }
        }

        return total;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}