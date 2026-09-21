package com.foodordering.exceptions;

public class FoodNotFoundException extends Exception {

    public FoodNotFoundException(String message) {
        super(message);
    }
}