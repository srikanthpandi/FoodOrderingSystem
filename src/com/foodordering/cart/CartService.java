package com.foodordering.cart;

import java.util.ArrayList;
import java.util.List;

import com.foodordering.exceptions.CartEmptyException;
import com.foodordering.food.Food;

public class CartService {

    private List<Cart> carts = new ArrayList<>();

    public void addToCart(int userId, Food food, int quantity) {

        Cart cart = findCartByUserId(userId);

        if (cart == null) {
            cart = new Cart(userId);
            carts.add(cart);
        }

        cart.addItem(food, quantity);
    }

    public Cart findCartByUserId(int userId) {

        for (Cart cart : carts) {

            if (cart.getUserId() == userId) {
                return cart;
            }
        }

        return null;
    }

    public void viewCart(int userId)
            throws CartEmptyException {

        Cart cart = findCartByUserId(userId);

        if (cart == null || cart.isEmpty()) {
            throw new CartEmptyException(
                    "Cart is empty for user ID: " + userId
            );
        }

        cart.viewCart();
    }

    public void removeFromCart(int userId, int foodId)
            throws CartEmptyException {

        Cart cart = findCartByUserId(userId);

        if (cart == null || cart.isEmpty()) {
            throw new CartEmptyException(
                    "Cannot remove item. Cart is empty."
            );
        }

        cart.removeItem(foodId);
    }

    public double getCartTotal(int userId)
            throws CartEmptyException {

        Cart cart = findCartByUserId(userId);

        if (cart == null || cart.isEmpty()) {
            throw new CartEmptyException(
                    "Cannot calculate total. Cart is empty."
            );
        }

        return cart.getTotalAmount();
    }

    public boolean isCartEmpty(int userId) {

        Cart cart = findCartByUserId(userId);

        return cart == null || cart.isEmpty();
    }

    public void clearCart(int userId)
            throws CartEmptyException {

        Cart cart = findCartByUserId(userId);

        if (cart == null || cart.isEmpty()) {
            throw new CartEmptyException(
                    "Cannot clear cart. Cart is already empty."
            );
        }

        cart.clearCart();

        System.out.println("Cart cleared successfully.");
    }
}