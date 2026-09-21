package com.foodordering;

public class ConsoleUI {

    // =========================================
    // ANSI COLORS
    // =========================================

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";


    // =========================================
    // MAIN APPLICATION HEADER
    // =========================================

    public static void mainHeader() {

        System.out.println();

        System.out.println(CYAN
                + "╔══════════════════════════════════════════════════════╗"
                + RESET);

        System.out.println(CYAN
                + "║                                                      ║"
                + RESET);

        System.out.println(CYAN + BOLD
                + "║              🍔  FOODIE EXPRESS  🍕                  ║"
                + RESET);

        System.out.println(CYAN
                + "║                                                      ║"
                + RESET);

        System.out.println(CYAN
                + "║          Your Favorite Food, Delivered!              ║"
                + RESET);

        System.out.println(CYAN
                + "║                                                      ║"
                + RESET);

        System.out.println(CYAN
                + "╚══════════════════════════════════════════════════════╝"
                + RESET);

        System.out.println();
    }


    // =========================================
    // SECTION HEADER
    // =========================================

    public static void sectionHeader(String title) {

        System.out.println();

        System.out.println(RED
                + "╔══════════════════════════════════════════════════════╗"
                + RESET);

        System.out.println(RED + BOLD
                + "║"
                + centerText(title, 52)
                + "║"
                + RESET);

        System.out.println(RED
                + "╚══════════════════════════════════════════════════════╝"
                + RESET);

        System.out.println();
    }


    // =========================================
    // MAIN MENU
    // =========================================

    public static void mainMenu() {

        sectionHeader("🏠 MAIN MENU");

        System.out.println("        " + CYAN + "1." + RESET + " 👤 Customer");
        System.out.println("        " + CYAN + "2." + RESET + " 🛠️  Admin");
        System.out.println("        " + CYAN + "3." + RESET + " 🚪 Exit");

        separator();

        System.out.print(YELLOW + "➜ Enter your choice: " + RESET);
    }


    // =========================================
    // CUSTOMER MENU
    // =========================================

    public static void customerMenu(String userName) {

        sectionHeader("CUSTOMER DASHBOARD");

        System.out.println(
                GREEN + "  Welcome, " + userName + "!" + RESET
        );

        System.out.println();

        System.out.println("  " + CYAN + "1." + RESET + " Browse Restaurants");
        System.out.println("  " + CYAN + "2." + RESET + " Browse Food");
        System.out.println("  " + CYAN + "3." + RESET + " Search Food");
        System.out.println("  " + CYAN + "4." + RESET + " Add Food to Cart");
        System.out.println("  " + CYAN + "5." + RESET + " View Cart");
        System.out.println("  " + CYAN + "6." + RESET + " Remove from Cart");
        System.out.println("  " + CYAN + "7." + RESET + " Place Order");
        System.out.println("  " + CYAN + "8." + RESET + " Make Payment");
        System.out.println("  " + CYAN + "9." + RESET + " View Order");
        System.out.println("  " + CYAN + "10." + RESET + " Back");

        separator();

        System.out.print(YELLOW + "Choose an option: " + RESET);
    }
    // =========================================
    // ADMIN MENU
    // =========================================
    public static void adminMenu() {

        sectionHeader("ADMIN DASHBOARD");

        System.out.println("  " + CYAN + "1." + RESET + " Add Restaurant");
        System.out.println("  " + CYAN + "2." + RESET + " View Restaurants");
        System.out.println("  " + CYAN + "3." + RESET + " Update Restaurant");
        System.out.println("  " + CYAN + "4." + RESET + " Add Food");
        System.out.println("  " + CYAN + "5." + RESET + " View Food");
        System.out.println("  " + CYAN + "6." + RESET + " Update Food");
        System.out.println("  " + CYAN + "7." + RESET + " View All Orders");
        System.out.println("  " + CYAN + "8." + RESET + " View All Payments");
        System.out.println("  " + CYAN + "9." + RESET + " View Total Payments");
        System.out.println("  " + CYAN + "10." + RESET + " Back");

        separator();

        System.out.print(
                YELLOW + "Choose an option: " + RESET
        );
    }

    // =========================================
    // SUCCESS MESSAGE
    // =========================================

    public static void success(String message) {

        System.out.println();

        System.out.println(
                GREEN + "╔══════════════════════════════════════════════════════╗"
                + RESET
        );

        System.out.println(
                GREEN + BOLD + "║  ✅ " + message
                + RESET
        );

        System.out.println(
                GREEN + "╚══════════════════════════════════════════════════════╝"
                + RESET
        );
    }


    // =========================================
    // ERROR MESSAGE
    // =========================================

    public static void error(String message) {

        System.out.println();

        System.out.println(
                RED + "╔══════════════════════════════════════════════════════╗"
                + RESET
        );

        System.out.println(
                RED + BOLD + "║  ❌ " + message
                + RESET
        );

        System.out.println(
                RED + "╚══════════════════════════════════════════════════════╝"
                + RESET
        );
    }


    // =========================================
    // INFO MESSAGE
    // =========================================

    public static void info(String message) {

        System.out.println(
                CYAN + "ℹ️  " + message + RESET
        );
    }


    // =========================================
    // SEPARATOR
    // =========================================

    public static void separator() {

        System.out.println(
                WHITE + "------------------------------------------------------"
                + RESET
        );
    }


    // =========================================
    // CENTER TEXT
    // =========================================

    private static String centerText(String text, int width) {

        int padding = width - text.length();

        if (padding <= 0) {
            return text;
        }

        int left = padding / 2;
        int right = padding - left;

        return " ".repeat(left)
                + text
                + " ".repeat(right);
    }
}