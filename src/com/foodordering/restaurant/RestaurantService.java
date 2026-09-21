package com.foodordering.restaurant;

import java.util.ArrayList;
import java.util.List;

import com.foodordering.exceptions.RestaurantNotFoundException;

public class RestaurantService {

    private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println("Restaurant added successfully.");
    }

    public void viewRestaurants() {

        if (restaurants.isEmpty()) {
            System.out.println("No restaurants available.");
            return;
        }

        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }

    public Restaurant findRestaurantById(int restaurantId)
            throws RestaurantNotFoundException {

        for (Restaurant restaurant : restaurants) {

            if (restaurant.getRestaurantId() == restaurantId) {
                return restaurant;
            }
        }

        throw new RestaurantNotFoundException(
                "Restaurant with ID " + restaurantId + " not found."
        );
    }

    public void updateRestaurant(int restaurantId, String name, String location)
            throws RestaurantNotFoundException {

        Restaurant restaurant = findRestaurantById(restaurantId);

        restaurant.setRestaurantName(name);
        restaurant.setLocation(location);

        System.out.println("Restaurant updated successfully.");
    }
}