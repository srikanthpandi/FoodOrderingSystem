package com.foodordering.cart;

import com.foodordering.food.Food;

public class CartItem {

    private Food food;
    private int quantity;

    public CartItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return food.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Food: " + food.getFoodName()
                + ", Price: ₹" + food.getPrice()
                + ", Quantity: " + quantity
                + ", Total: ₹" + getTotalPrice();
    }
}