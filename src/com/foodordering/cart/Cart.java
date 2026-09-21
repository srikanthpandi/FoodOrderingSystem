package com.foodordering.cart;

import java.util.ArrayList;
import java.util.List;

import com.foodordering.food.Food;

public class Cart {

    private int userId;
    private List<CartItem> items = new ArrayList<>();

    public Cart(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void addItem(Food food, int quantity) {

        for (CartItem item : items) {

            if (item.getFood().getFoodId() == food.getFoodId()) {

                item.setQuantity(item.getQuantity() + quantity);

                System.out.println("Food quantity updated in cart.");
                return;
            }
        }

        items.add(new CartItem(food, quantity));

        System.out.println("Food added to cart.");
    }

    public void removeItem(int foodId) {

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getFood().getFoodId() == foodId) {

                items.remove(i);

                System.out.println("Food removed from cart.");
                return;
            }
        }

        System.out.println("Food not found in cart.");
    }

    public void viewCart() {

        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n========== CART ==========");

        for (CartItem item : items) {
            System.out.println(item);
        }

        System.out.println("--------------------------");
        System.out.println("Cart Total: ₹" + getTotalAmount());
    }

    public double getTotalAmount() {

        double total = 0;

        for (CartItem item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }
}