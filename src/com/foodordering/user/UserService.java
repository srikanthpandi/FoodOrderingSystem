package com.foodordering.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully.");
    }

    public void viewUsers() {

        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

    public User findUserById(int userId) {

        for (User user : users) {

            if (user.getUserId() == userId) {
                return user;
            }
        }

        return null;
    }
}