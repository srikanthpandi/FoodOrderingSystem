package com.foodordering.restaurant;

public class Restaurant {

    private int restaurantId;
    private String restaurantName;
    private String location;

    public Restaurant(int restaurantId, String restaurantName, String location) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant ID: " + restaurantId
                + ", Name: " + restaurantName
                + ", Location: " + location;
    }
}