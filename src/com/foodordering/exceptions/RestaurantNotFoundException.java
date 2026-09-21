package com.foodordering.exceptions;

public class RestaurantNotFoundException extends Exception {

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}