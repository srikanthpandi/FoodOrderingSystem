::: {align="center"}

🍔 Foodie Express

A Console-Based Food Ordering System built with Core Java

<p>

<b>{=html}Java 21</b>{=html} • <b>{=html}OOP</b>{=html} •
<b>{=html}Collections</b>{=html} • <b>{=html}Exception
Handling</b>{=html} • <b>{=html}Service Architecture</b>{=html}

</p>

<p>

A clean, modular food ordering application designed to demonstrate
real-world Core Java concepts through a practical console project.

</p>

:::

📌 About the Project

Foodie Express is a Core Java console-based Food Ordering System
that simulates the basic workflow of a food delivery application.

Customers can browse restaurants and food, manage their cart, place
orders, and make payments. Administrators can manage restaurants and
food items and monitor orders and payments.

Note: This is intentionally a console application. It uses Java
ArrayList collections for in-memory storage and does not require a
database, Spring Boot, or external frameworks.

✨ Highlights

👤 Customer          🛠️ Admin

Browse restaurants   Add restaurants
Browse food          Update restaurants
Search food          Add food
Manage cart          Update food
Place orders         View all orders
Make payments        View payments
View order details   View total payments

🖥️ Console Experience

The project includes a custom ConsoleUI class to make the console
interface cleaner and easier to navigate.

╔══════════════════════════════════════════════════════╗
║                                                      ║
║              🍔  FOODIE EXPRESS  🍕                  ║
║                                                      ║
║          Your Favorite Food, Delivered!              ║
║                                                      ║
╚══════════════════════════════════════════════════════╝

                 MAIN MENU

        1. Customer
        2. Admin
        3. Exit

------------------------------------------------------
Choose an option:

Customer Dashboard

╔══════════════════════════════════════════════════════╗
║                  CUSTOMER DASHBOARD                   ║
╚══════════════════════════════════════════════════════╝

  Welcome, Srikanth!

  1. Browse Restaurants
  2. Browse Food
  3. Search Food
  4. Add Food to Cart
  5. View Cart
  6. Remove from Cart
  7. Place Order
  8. Make Payment
  9. View Order
  0. Back

------------------------------------------------------
Choose an option:

🧩 Features

👤 Customer Module

View available restaurants

View food items

Search food by name

Add food to cart

Increase quantity of existing cart items

View cart and total amount

Remove food from cart

Place an order

Make payment using UPI, Card, or Cash

View order details

🛠️ Admin Module

Add restaurant

View restaurants

Update restaurant details

Add food

View food

Update food details

View all orders

View all payments

View total successful payments

🛡️ Exception Handling

The project uses custom checked exceptions for common application
errors:

FoodNotFoundException
RestaurantNotFoundException
CartEmptyException
OrderNotFoundException
PaymentFailedException

🏗️ Project Architecture

The application follows a simple Model → Service → Main/UI
structure.

                    🍔 FOODIE EXPRESS
                           │
                    ┌──────┴──────┐
                    │             │
                Customer        Admin
                    │             │
                    └──────┬──────┘
                           │
                     Main.java
                           │
                    ConsoleUI.java
                           │
                 ┌─────────┴─────────┐
                 │                   │
             Services             Exceptions
                 │
        ┌────────┼────────┬──────────┐
        │        │        │          │
      User   Restaurant  Food      Cart
        │        │        │          │
        └────────┴────────┴──────────┘
                           │
                      OrderService
                           │
                     PaymentService
                           │
                    ArrayList Storage

📂 Project Structure

src
└── com.foodordering
    │
    ├── Main.java
    ├── ConsoleUI.java
    │
    ├── user
    │   ├── User.java
    │   └── UserService.java
    │
    ├── restaurant
    │   ├── Restaurant.java
    │   └── RestaurantService.java
    │
    ├── food
    │   ├── Food.java
    │   └── FoodService.java
    │
    ├── cart
    │   ├── Cart.java
    │   ├── CartItem.java
    │   └── CartService.java
    │
    ├── order
    │   ├── Order.java
    │   └── OrderService.java
    │
    ├── payment
    │   ├── Payment.java
    │   └── PaymentService.java
    │
    └── exceptions
        ├── FoodNotFoundException.java
        ├── RestaurantNotFoundException.java
        ├── CartEmptyException.java
        ├── OrderNotFoundException.java
        └── PaymentFailedException.java

🔄 Application Flow

Customer Flow

Main Menu
    │
    ▼
Customer
    │
    ▼
Enter User ID
    │
    ▼
Customer Dashboard
    │
    ├── Browse Restaurants
    ├── Browse Food
    ├── Search Food
    │
    ├── Add Food to Cart
    │          │
    │          ▼
    │       View Cart
    │          │
    │          ▼
    │       Place Order
    │          │
    │          ▼
    │       Make Payment
    │          │
    │          ▼
    │       View Order
    │
    └── Back

Admin Flow

Main Menu
    │
    ▼
Admin Dashboard
    │
    ├── Add Restaurant
    ├── View Restaurants
    ├── Update Restaurant
    │
    ├── Add Food
    ├── View Food
    ├── Update Food
    │
    ├── View All Orders
    ├── View All Payments
    └── View Total Payments

🧠 Core Java Concepts Demonstrated

This project was designed to demonstrate practical Java fundamentals:

Object-Oriented Programming

Classes and Objects

Encapsulation

Constructors

Getters and Setters

Object relationships

Separation of responsibilities

Collections

List<User>
List<Restaurant>
List<Food>
List<Cart>
List<Order>
List<Payment>

The project primarily uses:

ArrayList

Exception Handling

try {
    // operation
} catch (FoodNotFoundException e) {
    // handle error
}

Custom Exceptions

Application-specific exceptions are created instead of relying only on
generic exceptions.

Control Flow

if / else

switch

for

Enhanced for

while

Console Input

Scanner scanner = new Scanner(System.in);

💾 Data Storage

The current version uses in-memory collections.

Application starts
      ↓
Sample data loaded
      ↓
Data stored in ArrayList
      ↓
User interacts with application
      ↓
Application closes
      ↓
Data is cleared

There is currently:

❌ No MySQL

❌ No JDBC

❌ No external files

❌ No Spring Boot

❌ No external APIs

This keeps the project focused on Core Java.

🚀 Getting Started

Requirements

Java JDK 21 or compatible JDK

Eclipse IDE or any Java IDE

Git (optional, for version control)

Run in Eclipse

Open the project in Eclipse.

Make sure the src folder contains the com.foodordering package.

Open:

src/com/foodordering/Main.java

Right-click Main.java.

Select:

Run As → Java Application

Use the console menu to operate the application.

🧪 Sample Data

Users

 ID Name       Mobile

101 Srikanth   9876543210
102 Rahul      9876543211

Restaurants

ID Restaurant   Location

 1 Paradise     Hyderabad
 2 Mehfil       Secunderabad

Food

 ID Food                Price   Restaurant

101 Chicken Biryani      ₹250     Paradise
102 Veg Biryani          ₹180     Paradise
103 Chicken 65           ₹220       Mehfil
104 Paneer Biryani       ₹200       Mehfil

🧾 Example Order Flow

Customer
   ↓
Select Food
   ↓
Add to Cart
   ↓
View Cart
   ↓
Place Order
   ↓
Order ID Generated
   ↓
Select Payment Method
   ↓
Payment Successful
   ↓
Order Status → PAID

Example:

Order ID       : 1001
Total Amount   : ₹500
Payment Method : UPI
Payment Status : SUCCESS
Order Status   : PAID

🔮 Future Enhancements

The project can be extended with:

MySQL database using JDBC

User authentication

Admin authentication

Food categories

Restaurant-based food filtering

Order cancellation

Order status tracking

Delivery address

Customer order history

Payment date and time

Invoice generation

Quantity update from cart

GUI version using JavaFX/Swing

Web version using Spring Boot

REST APIs

🎯 Learning Objective

The main purpose of this project is to build a practical application
while strengthening Core Java and OOP fundamentals.

It demonstrates how individual Java concepts can be combined into a
small real-world system instead of being implemented as isolated
examples.

Core Java
    +
OOP
    +
Collections
    +
Exception Handling
    +
Service-Based Structure
    ↓
Food Ordering System

👨‍💻 Author

Srikanth Pandi

Computer Science Engineering

::: {align="center"}

🍔 Foodie Express

Built with Java • Designed for learning • Ready for enhancement
:::
