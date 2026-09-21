# 🍽️ Food Ordering System

> A powerful, console-based Food Ordering System built with **Core Java** | **OOP Principles** | **Collections** | **Exception Handling**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Console App](https://img.shields.io/badge/Console-Application-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-Academic-blue?style=for-the-badge)

---

## 📚 Table of Contents
- [✨ Overview](#-overview)
- [🎯 Features](#-features)
- [💻 Technologies](#-technologies)
- [📦 Project Structure](#-project-structure)
- [🚀 Quick Start](#-quick-start)
- [📋 Application Flow](#-application-flow)
- [💾 Data Storage](#-data-storage)
- [🔧 Architecture](#-architecture)
- [🌟 Future Enhancements](#-future-enhancements)

---

## ✨ Overview

The **Food Ordering System** is a feature-rich console application that demonstrates professional Java development practices. It enables customers to browse restaurants, manage their cart, place orders, and make payments—while admins manage restaurants, food items, and orders.

**Key Highlights:**
- ✅ 100% Java-based (No external frameworks)
- ✅ Service-oriented architecture
- ✅ Custom exception handling
- ✅ In-memory data management
- ✅ Beautiful console UI with ANSI colors

---

## 🎯 Features

### 👨‍💼 Customer Features
- 🏪 **Browse Restaurants** - View all available restaurants
- 🍜 **Browse Food Items** - Explore menu items with prices
- 🔍 **Search Functionality** - Find food by name
- 🛒 **Cart Management** - Add/remove items from cart
- 📦 **Order Placement** - Create orders from cart
- 💳 **Payment Processing** - Complete transactions
- 📄 **Order Details** - View order information

### 🔐 Admin Features
- 🏢 **Manage Restaurants** - Add, view, and update restaurants
- 🍽️ **Manage Food Items** - Add, view, and update menu items
- 📊 **View Orders** - Monitor all placed orders
- 💰 **Payment Analytics** - Track all payments
- 💵 **Revenue Reports** - View total successful payments

---

## 💻 Technologies

| Technology | Purpose |
|-----------|---------|
| **Java** | Core programming language |
| **Collections** | ArrayList for data storage |
| **OOP** | Classes, inheritance, encapsulation |
| **Exception Handling** | Custom exceptions for error management |
| **ANSI Colors** | Enhanced console UI |
| **Scanner** | User input handling |

---

## 📦 Project Structure

```
src/
└── com.foodordering/
    ├── Main.java                          # Application entry point
    ├── ConsoleUI.java                     # UI/UX formatting
    │
    ├── user/
    │   ├── User.java                      # User data model
    │   └── UserService.java               # User operations
    │
    ├── restaurant/
    │   ├── Restaurant.java                # Restaurant model
    │   └── RestaurantService.java         # Restaurant operations
    │
    ├── food/
    │   ├── Food.java                      # Food item model
    │   └── FoodService.java               # Food operations
    │
    ├── cart/
    │   ├── Cart.java                      # Shopping cart
    │   ├── CartItem.java                  # Individual cart item
    │   └── CartService.java               # Cart operations
    │
    ├── order/
    │   ├── Order.java                     # Order model
    │   └── OrderService.java              # Order operations
    │
    ├── payment/
    │   ├── Payment.java                   # Payment model
    │   └── PaymentService.java            # Payment operations
    │
    └── exceptions/
        ├── FoodNotFoundException.java
        ├── RestaurantNotFoundException.java
        ├── CartEmptyException.java
        ├── OrderNotFoundException.java
        └── PaymentFailedException.java
```

---

## 🚀 Quick Start

### Prerequisites
- ✅ Java Development Kit (JDK 8 or higher)
- ✅ IDE (Eclipse, IntelliJ, VS Code) OR Command Line

### Option 1️⃣ : Using Eclipse

1. **Open Eclipse** and import the project
2. **Navigate** to `com.foodordering.Main.java`
3. **Right-click** → `Run As` → `Java Application`
4. **Interact** using the console menu

### Option 2️⃣ : Using Command Line

```bash
# Compile
javac -d bin src/com/foodordering/**/*.java

# Run
java -cp bin com.foodordering.Main
```

---

## 📋 Application Flow

### 🏠 System Architecture

```
         🍽️ FOOD ORDERING SYSTEM 🍽️
                    │
         ┌──────────┴──────────┐
         │                     │
      👤 Customer          👨‍💼 Admin
         │                     │
    ┌────┼─────┐          ┌────┼─────┐
    │    │     │          │    │     │
  🍜 Food 🛒 Cart 📦 Order 🏢 Restaurant 🍽️ Food 💰 Payments
    │    │     │          │    │     │
    └────┼─────┘          └────┼─────┘
         │                     │
         └─────────┬───────────┘
                   │
              💳 Payment
```

### 📊 Customer Journey

```
Main Menu
   ↓
Select User (ID: 101 or 102)
   ↓
Customer Dashboard
   ├─ 🏪 Browse Restaurants
   ├─ 🍜 View Food Items
   ├─ 🔍 Search Food by Name
   ├─ 🛒 Add to Cart
   ├─ 📋 View Cart
   ├─ ✂️  Remove from Cart
   ├─ 📦 Place Order
   ├─ 💳 Make Payment
   └─ 📄 View Order Details
```

### 🔐 Admin Journey

```
Main Menu
   ↓
Select Admin
   ↓
Admin Dashboard
   ├─ ➕ Add Restaurant
   ├─ 📍 View Restaurants
   ├─ ✏️  Update Restaurant
   ├─ ➕ Add Food Item
   ├─ 📜 View All Food
   ├─ ✏️  Update Food
   ├─ 📦 View All Orders
   ├─ 💰 View All Payments
   └─ 💵 View Total Revenue
```

---

## 💾 Data Storage

All data is stored in **memory** using Java Collections:

| Data Type | Storage |
|-----------|---------|
| 👤 Users | ArrayList\<User\> |
| 🏢 Restaurants | ArrayList\<Restaurant\> |
| 🍜 Food Items | ArrayList\<Food\> |
| 🛒 Shopping Carts | ArrayList\<Cart\> |
| 📦 Orders | ArrayList\<Order\> |
| 💳 Payments | ArrayList\<Payment\> |

> 📌 **Note:** Data persists only during the session. It resets when the application stops.

---

## 👥 Sample Data

### Pre-loaded Users
| ID | Name |
|----|------|
| 101 | Srikanth |
| 102 | Rahul |

### Sample Restaurants
| ID | Name | City |
|----|------|------|
| 1 | 🍛 Paradise | Hyderabad |
| 2 | 🍴 Mehfil | Secunderabad |

### Sample Food Menu
| ID | Item | Price |
|----|------|-------|
| 101 | 🍛 Chicken Biryani | ₹250 |
| 102 | 🥘 Veg Biryani | ₹180 |
| 103 | 🔥 Chicken 65 | ₹220 |
| 104 | 🧀 Paneer Biryani | ₹200 |

---

## 🎓 Core Concepts Demonstrated

- ✅ **OOP Principles**
  - Encapsulation (Private fields, getters/setters)
  - Abstraction (Service layer design)
  - Inheritance-ready package structure
  
- ✅ **Collections Framework**
  - ArrayList for dynamic data storage
  - Iteration with enhanced for loops
  
- ✅ **Exception Handling**
  - Custom exception classes
  - Try-catch blocks for error management
  
- ✅ **Control Flow**
  - Switch statements for menu navigation
  - Conditional logic for business operations
  
- ✅ **Architecture Patterns**
  - Service-layer design pattern
  - Separation of concerns (Models vs Services)

---

## 🔧 Architecture

### Layered Architecture Pattern

```
┌─────────────────────────────────┐
│      Main & ConsoleUI          │  ← User Interface Layer
├─────────────────────────────────┤
│    Service Classes              │  ← Business Logic Layer
│ (FoodService, CartService, ...) │
├─────────────────────────────────┤
│    Model Classes                │  ← Data Model Layer
│ (Food, Cart, User, ...)         │
├─────────────────────────────────┤
│   ArrayList Collections         │  ← Data Storage Layer
└─────────────────────────────────┘
```

### Example: Food Management

```
Food (Model)
    ↓
FoodService (Business Logic)
    ↓
Main/ConsoleUI (Presentation)
    ↓
ArrayList Storage
```

**Benefits:**
- 🎯 Clear separation of concerns
- 🔄 Easy to test and maintain
- 📈 Scalable architecture
- 🔌 Easy to add persistence layer later

---

## 🌟 Future Enhancements

### Phase 1: Database Integration
- 🗄️ MySQL database integration
- 🔗 JDBC for database operations

### Phase 2: Security & User Management
- 🔐 User authentication
- 🔑 Password-based admin login
- 👤 Secure session management

### Phase 3: Enhanced Features
- 📂 Food categories
- 🏪 Restaurant-based food filtering
- ❌ Order cancellation
- 📊 Order status tracking (Pending → Preparing → Ready → Delivered)
- 🔢 Quantity management in cart
- 📍 Delivery address tracking

### Phase 4: Analytics & Reporting
- 📈 Customer order history
- 📄 Bill/Invoice generation
- 💰 Payment analytics and reports
- ⏰ Payment date/time tracking

### Phase 5: UI Enhancement
- 🖥️ GUI using Swing/JavaFX
- 🌐 Web version using Spring Boot
- 📱 REST API development

---

## 🏆 Learning Outcomes

By studying this project, you'll master:

✅ Core Java fundamentals  
✅ Object-Oriented Programming principles  
✅ Design patterns (Service Layer)  
✅ Exception handling best practices  
✅ Collections Framework  
✅ Professional code organization  
✅ Console UI development  
✅ Multi-component application design  

---

## 👨‍💻 Author

**Srikanth Pandi**  
*Computer Science Engineering*

---

## 📄 License

This project is created for **learning, academic, and portfolio purposes**.

---

## 🤝 Contributing

Feel free to fork this project, create feature branches, and submit pull requests for:
- Bug fixes
- Feature enhancements
- Code optimizations
- Documentation improvements

---

## 💡 Getting Help

- 📖 Refer to the code comments
- 🔍 Check the project structure for examples
- 📝 Review custom exception classes for error handling

---

<div align="center">

**Made with ❤️ for learning Java**

⭐ If you found this project helpful, please consider giving it a star!

</div>
