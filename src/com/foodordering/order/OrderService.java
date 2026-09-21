package com.foodordering.order;

import java.util.ArrayList;
import java.util.List;

import com.foodordering.cart.Cart;
import com.foodordering.cart.CartItem;
import com.foodordering.cart.CartService;
import com.foodordering.exceptions.CartEmptyException;
import com.foodordering.exceptions.OrderNotFoundException;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    private int nextOrderId = 1001;

    private CartService cartService;

    public OrderService(CartService cartService) {
        this.cartService = cartService;
    }

    public Order placeOrder(int userId)
            throws CartEmptyException {

        Cart cart = cartService.findCartByUserId(userId);

        if (cart == null || cart.isEmpty()) {
            throw new CartEmptyException(
                    "Cannot place order. Cart is empty."
            );
        }

        List<CartItem> items = new ArrayList<>(cart.getItems());

        double totalAmount = cart.getTotalAmount();

        Order order = new Order(
                nextOrderId,
                userId,
                items,
                totalAmount
        );

        orders.add(order);

        nextOrderId++;

        cart.clearCart();

        System.out.println("Order placed successfully.");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Total Amount: ₹" + order.getTotalAmount());

        return order;
    }

    public Order findOrderById(int orderId)
            throws OrderNotFoundException {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        throw new OrderNotFoundException(
                "Order with ID " + orderId + " not found."
        );
    }

    public void viewOrder(int orderId)
            throws OrderNotFoundException {

        Order order = findOrderById(orderId);

        System.out.println("\n========== ORDER ==========");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("User ID: " + order.getUserId());

        System.out.println("\nItems:");

        for (CartItem item : order.getItems()) {
            System.out.println(item);
        }

        System.out.println("---------------------------");
        System.out.println("Total Amount: ₹" + order.getTotalAmount());
        System.out.println("Order Status: " + order.getOrderStatus());
    }

    public void viewAllOrders() {

        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        System.out.println("\n========== ALL ORDERS ==========");

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public double getTotalOrderAmount() {

        double total = 0;

        for (Order order : orders) {
            total += order.getTotalAmount();
        }

        return total;
    }

    public List<Order> getOrders() {
        return orders;
    }
}