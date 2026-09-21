package com.foodordering.food;

public class Food {

    private int foodId;
    private String foodName;
    private double price;
    private int restaurantId;

    public Food(int foodId, String foodName, double price, int restaurantId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food ID: " + foodId
                + ", Name: " + foodName
                + ", Price: ₹" + price
                + ", Restaurant ID: " + restaurantId;
    }
}