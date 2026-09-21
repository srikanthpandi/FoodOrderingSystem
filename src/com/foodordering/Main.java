package com.foodordering;

import java.util.Scanner;

import com.foodordering.user.User;
import com.foodordering.user.UserService;

import com.foodordering.restaurant.Restaurant;
import com.foodordering.restaurant.RestaurantService;

import com.foodordering.food.Food;
import com.foodordering.food.FoodService;

import com.foodordering.cart.CartService;

import com.foodordering.order.Order;
import com.foodordering.order.OrderService;

import com.foodordering.payment.PaymentService;

import com.foodordering.exceptions.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // =========================================
    // SERVICES
    // =========================================

    static UserService userService = new UserService();

    static RestaurantService restaurantService =
            new RestaurantService();

    static FoodService foodService =
            new FoodService();

    static CartService cartService =
            new CartService();

    static OrderService orderService =
            new OrderService(cartService);

    static PaymentService paymentService =
            new PaymentService();


    // =========================================
    // MAIN METHOD
    // =========================================

    public static void main(String[] args) {

        loadSampleData();

        while (true) {

            ConsoleUI.mainHeader();

            ConsoleUI.mainMenu();

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    customerMenu();
                    break;

                case 2:
                    adminMenu();
                    break;

                case 3:

                    ConsoleUI.success(
                            "Thank you for using Foodie Express!"
                    );

                    System.out.println(
                            "\nApplication closed."
                    );

                    scanner.close();

                    return;

                default:

                    ConsoleUI.error(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }


    // =========================================
    // SAMPLE DATA
    // =========================================

    static void loadSampleData() {

        // USERS

        userService.addUser(
                new User(
                        101,
                        "Srikanth",
                        "9876543210"
                )
        );

        userService.addUser(
                new User(
                        102,
                        "Rahul",
                        "9876543211"
                )
        );


        // RESTAURANTS

        restaurantService.addRestaurant(
                new Restaurant(
                        1,
                        "Paradise",
                        "Hyderabad"
                )
        );

        restaurantService.addRestaurant(
                new Restaurant(
                        2,
                        "Mehfil",
                        "Secunderabad"
                )
        );


        // FOOD

        foodService.addFood(
                new Food(
                        101,
                        "Chicken Biryani",
                        250,
                        1
                )
        );

        foodService.addFood(
                new Food(
                        102,
                        "Veg Biryani",
                        180,
                        1
                )
        );

        foodService.addFood(
                new Food(
                        103,
                        "Chicken 65",
                        220,
                        2
                )
        );

        foodService.addFood(
                new Food(
                        104,
                        "Paneer Biryani",
                        200,
                        2
                )
        );
    }


    // =========================================
    // CUSTOMER MENU
    // =========================================

    static void customerMenu() {

        ConsoleUI.sectionHeader(
                "👤 CUSTOMER LOGIN"
        );

        System.out.print(
                "Enter User ID: "
        );

        int userId = scanner.nextInt();

        User user =
                userService.findUserById(userId);

        if (user == null) {

            ConsoleUI.error(
                    "User not found!"
            );

            return;
        }

        while (true) {

            ConsoleUI.customerMenu(
                    user.getUserName()
            );

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    viewRestaurants();
                    break;

                case 2:
                    viewFood();
                    break;

                case 3:
                    searchFood();
                    break;

                case 4:
                    addFoodToCart(userId);
                    break;

                case 5:
                    viewCart(userId);
                    break;

                case 6:
                    removeFoodFromCart(userId);
                    break;

                case 7:
                    placeOrder(userId);
                    break;

                case 8:
                    makePayment();
                    break;

                case 9:
                    viewOrder();
                    break;

                case 0:

                    ConsoleUI.info(
                            "Returning to Main Menu..."
                    );

                    return;

                default:

                    ConsoleUI.error(
                            "Invalid choice!"
                    );
            }
        }
    }


    // =========================================
    // VIEW RESTAURANTS
    // =========================================

    static void viewRestaurants() {

        ConsoleUI.sectionHeader(
                "🍽️ AVAILABLE RESTAURANTS"
        );

        restaurantService.viewRestaurants();

        pause();
    }


    // =========================================
    // VIEW FOOD
    // =========================================

    static void viewFood() {

        ConsoleUI.sectionHeader(
                "🍔 AVAILABLE FOOD"
        );

        foodService.viewFoods();

        pause();
    }


    // =========================================
    // SEARCH FOOD
    // =========================================

    static void searchFood() {

        ConsoleUI.sectionHeader(
                "🔍 SEARCH FOOD"
        );

        scanner.nextLine();

        System.out.print(
                "Enter food name: "
        );

        String foodName =
                scanner.nextLine();

        try {

            foodService.searchFood(
                    foodName
            );

        } catch (FoodNotFoundException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // ADD FOOD TO CART
    // =========================================

    static void addFoodToCart(int userId) {

        ConsoleUI.sectionHeader(
                "🛒 ADD FOOD TO CART"
        );

        System.out.print(
                "Enter Food ID: "
        );

        int foodId = scanner.nextInt();

        try {

            Food food =
                    foodService.findFoodById(
                            foodId
                    );

            System.out.println(
                    "\nSelected Food: "
                    + food.getFoodName()
            );

            System.out.println(
                    "Price: ₹"
                    + food.getPrice()
            );

            System.out.print(
                    "Enter Quantity: "
            );

            int quantity =
                    scanner.nextInt();

            if (quantity <= 0) {

                ConsoleUI.error(
                        "Quantity must be greater than 0."
                );

                return;
            }

            cartService.addToCart(
                    userId,
                    food,
                    quantity
            );

            ConsoleUI.success(
                    "Food added to cart successfully!"
            );

        } catch (FoodNotFoundException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // VIEW CART
    // =========================================

    static void viewCart(int userId) {

        ConsoleUI.sectionHeader(
                "🛒 MY CART"
        );

        try {

            cartService.viewCart(
                    userId
            );

        } catch (CartEmptyException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // REMOVE FROM CART
    // =========================================

    static void removeFoodFromCart(int userId) {

        ConsoleUI.sectionHeader(
                "❌ REMOVE FROM CART"
        );

        System.out.print(
                "Enter Food ID: "
        );

        int foodId =
                scanner.nextInt();

        try {

            cartService.removeFromCart(
                    userId,
                    foodId
            );

            ConsoleUI.success(
                    "Food removed from cart."
            );

        } catch (CartEmptyException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // PLACE ORDER
    // =========================================

    static void placeOrder(int userId) {

        ConsoleUI.sectionHeader(
                "📦 PLACE ORDER"
        );

        try {

            Order order =
                    orderService.placeOrder(
                            userId
                    );

            ConsoleUI.success(
                    "Order placed successfully!"
            );

            System.out.println(
                    "\nOrder ID    : "
                    + order.getOrderId()
            );

            System.out.println(
                    "Total Amount: ₹"
                    + order.getTotalAmount()
            );

        } catch (CartEmptyException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // MAKE PAYMENT
    // =========================================

    static void makePayment() {

        ConsoleUI.sectionHeader(
                "💳 MAKE PAYMENT"
        );

        System.out.print(
                "Enter Order ID: "
        );

        int orderId =
                scanner.nextInt();

        try {

            Order order =
                    orderService.findOrderById(
                            orderId
                    );

            System.out.println(
                    "\nOrder Amount: ₹"
                    + order.getTotalAmount()
            );

            System.out.println(
                    "\nSelect Payment Method:"
            );

            System.out.println(
                    "1. 📱 UPI"
            );

            System.out.println(
                    "2. 💳 Card"
            );

            System.out.println(
                    "3. 💵 Cash"
            );

            ConsoleUI.separator();

            System.out.print(
                    "➜ Select: "
            );

            int paymentChoice =
                    scanner.nextInt();

            String paymentMethod;

            switch (paymentChoice) {

                case 1:
                    paymentMethod = "UPI";
                    break;

                case 2:
                    paymentMethod = "Card";
                    break;

                case 3:
                    paymentMethod = "Cash";
                    break;

                default:

                    ConsoleUI.error(
                            "Invalid payment method."
                    );

                    return;
            }

            paymentService.makePayment(
                    order,
                    paymentMethod
            );

            ConsoleUI.success(
                    "Payment completed successfully!"
            );

        } catch (OrderNotFoundException e) {

            ConsoleUI.error(
                    e.getMessage()
            );

        } catch (PaymentFailedException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // VIEW ORDER
    // =========================================

    static void viewOrder() {

        ConsoleUI.sectionHeader(
                "📋 VIEW ORDER"
        );

        System.out.print(
                "Enter Order ID: "
        );

        int orderId =
                scanner.nextInt();

        try {

            orderService.viewOrder(
                    orderId
            );

        } catch (OrderNotFoundException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // ADMIN MENU
    // =========================================

    static void adminMenu() {

        while (true) {

            ConsoleUI.adminMenu();

            int choice =
                    scanner.nextInt();

            switch (choice) {

                case 1:
                    addRestaurant();
                    break;

                case 2:
                    viewRestaurants();
                    break;

                case 3:
                    updateRestaurant();
                    break;

                case 4:
                    addFood();
                    break;

                case 5:
                    viewFood();
                    break;

                case 6:
                    updateFood();
                    break;

                case 7:
                    viewAllOrders();
                    break;

                case 8:
                    viewAllPayments();
                    break;

                case 9:
                    viewTotalPayments();
                    break;

                case 0:

                    ConsoleUI.info(
                            "Returning to Main Menu..."
                    );

                    return;

                default:

                    ConsoleUI.error(
                            "Invalid choice!"
                    );
            }
        }
    }


    // =========================================
    // ADD RESTAURANT
    // =========================================

    static void addRestaurant() {

        ConsoleUI.sectionHeader(
                "➕ ADD RESTAURANT"
        );

        System.out.print(
                "Restaurant ID: "
        );

        int id =
                scanner.nextInt();

        scanner.nextLine();

        System.out.print(
                "Restaurant Name: "
        );

        String name =
                scanner.nextLine();

        System.out.print(
                "Location: "
        );

        String location =
                scanner.nextLine();

        Restaurant restaurant =
                new Restaurant(
                        id,
                        name,
                        location
                );

        restaurantService.addRestaurant(
                restaurant
        );

        ConsoleUI.success(
                "Restaurant added successfully!"
        );

        pause();
    }


    // =========================================
    // UPDATE RESTAURANT
    // =========================================

    static void updateRestaurant() {

        ConsoleUI.sectionHeader(
                "✏️ UPDATE RESTAURANT"
        );

        System.out.print(
                "Restaurant ID: "
        );

        int id =
                scanner.nextInt();

        scanner.nextLine();

        System.out.print(
                "New Restaurant Name: "
        );

        String name =
                scanner.nextLine();

        System.out.print(
                "New Location: "
        );

        String location =
                scanner.nextLine();

        try {

            restaurantService.updateRestaurant(
                    id,
                    name,
                    location
            );

            ConsoleUI.success(
                    "Restaurant updated successfully!"
            );

        } catch (RestaurantNotFoundException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // ADD FOOD
    // =========================================

    static void addFood() {

        ConsoleUI.sectionHeader(
                "➕ ADD FOOD"
        );

        System.out.print(
                "Food ID: "
        );

        int id =
                scanner.nextInt();

        scanner.nextLine();

        System.out.print(
                "Food Name: "
        );

        String name =
                scanner.nextLine();

        System.out.print(
                "Price: ₹"
        );

        double price =
                scanner.nextDouble();

        System.out.print(
                "Restaurant ID: "
        );

        int restaurantId =
                scanner.nextInt();

        Food food =
                new Food(
                        id,
                        name,
                        price,
                        restaurantId
                );

        foodService.addFood(
                food
        );

        ConsoleUI.success(
                "Food added successfully!"
        );

        pause();
    }


    // =========================================
    // UPDATE FOOD
    // =========================================

    static void updateFood() {

        ConsoleUI.sectionHeader(
                "✏️ UPDATE FOOD"
        );

        System.out.print(
                "Food ID: "
        );

        int id =
                scanner.nextInt();

        scanner.nextLine();

        System.out.print(
                "New Food Name: "
        );

        String name =
                scanner.nextLine();

        System.out.print(
                "New Price: ₹"
        );

        double price =
                scanner.nextDouble();

        try {

            foodService.updateFood(
                    id,
                    name,
                    price
            );

            ConsoleUI.success(
                    "Food updated successfully!"
            );

        } catch (FoodNotFoundException e) {

            ConsoleUI.error(
                    e.getMessage()
            );
        }

        pause();
    }


    // =========================================
    // VIEW ALL ORDERS
    // =========================================

    static void viewAllOrders() {

        ConsoleUI.sectionHeader(
                "📦 ALL ORDERS"
        );

        orderService.viewAllOrders();

        pause();
    }


    // =========================================
    // VIEW ALL PAYMENTS
    // =========================================

    static void viewAllPayments() {

        ConsoleUI.sectionHeader(
                "💳 ALL PAYMENTS"
        );

        paymentService.viewAllPayments();

        pause();
    }


    // =========================================
    // TOTAL PAYMENTS
    // =========================================

    static void viewTotalPayments() {

        ConsoleUI.sectionHeader(
                "💰 TOTAL PAYMENTS"
        );

        double total =
                paymentService.getTotalPayments();

        System.out.println(
                ConsoleUI.GREEN
                + "Total Successful Payments: ₹"
                + total
                + ConsoleUI.RESET
      
        );

        pause();
    }


    // =========================================
    // PAUSE
    // =========================================

    static void pause() {

        System.out.println();

        System.out.println(
                ConsoleUI.YELLOW
                + "Press ENTER to continue..."
                + ConsoleUI.RESET
        );

        scanner.nextLine();
        scanner.nextLine();
    }
}