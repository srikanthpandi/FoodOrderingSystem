package com.foodordering.food;

import java.util.ArrayList;
import java.util.List;

import com.foodordering.exceptions.FoodNotFoundException;

public class FoodService {

    private List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
        System.out.println("Food added successfully.");
    }

    public void viewFoods() {

        if (foods.isEmpty()) {
            System.out.println("No food available.");
            return;
        }

        for (Food food : foods) {
            System.out.println(food);
        }
    }

    public Food findFoodById(int foodId)
            throws FoodNotFoundException {

        for (Food food : foods) {

            if (food.getFoodId() == foodId) {
                return food;
            }
        }

        throw new FoodNotFoundException(
                "Food with ID " + foodId + " not found."
        );
    }

    public void searchFood(String foodName)
            throws FoodNotFoundException {

        boolean found = false;

        for (Food food : foods) {

            if (food.getFoodName().equalsIgnoreCase(foodName)) {
                System.out.println(food);
                found = true;
            }
        }

        if (!found) {
            throw new FoodNotFoundException(
                    "Food with name '" + foodName + "' not found."
            );
        }
    }

    public void updateFood(int foodId, String foodName, double price)
            throws FoodNotFoundException {

        Food food = findFoodById(foodId);

        food.setFoodName(foodName);
        food.setPrice(price);

        System.out.println("Food updated successfully.");
    }
}