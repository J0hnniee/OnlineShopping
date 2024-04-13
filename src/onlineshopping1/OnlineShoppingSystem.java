/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package onlineshopping1;

import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class OnlineShoppingSystem {

    /*public static void main(String[] args) {
        System.out.println("Im eating bollos for Iftaarrr!\n");
        System.out.println("Welcome to our Online Shopping System!");

        AccountManager accountManager = new AccountManager();
        boolean isSignedIn = false;
        boolean isSignedUp = false;

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        while (true) {
            System.out.println("1) Login");
            System.out.println("2) Logout");
            System.out.println("3) Signup");
            System.out.println("4) Store");
            System.out.println("5) View cart");
            System.out.println("6) Exit store");

            try {
                int option = Integer.parseInt(s.trim());
                switch (option) {
                    case 1:
                        if (isSignedUp) {
                            accountManager.registerNewUser();
                        }

                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }

        }
    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AccountManager accountManager = new AccountManager();
        boolean isSignedIn = false;
        boolean isSignedUp = false;

        accountManager.loadUserData();
        Basket cart = new Basket();
        Store store = new Store();
        
        User currentUser = null;

        while (true) {
            System.out.println("Online Shopping System\n");
            System.out.println("1) Register");
            System.out.println("2) Login");
            System.out.println("3) Logout");
            System.out.println("4) Store");
            System.out.println("5) View Cart");
            System.out.println("6) Exit program");
            System.out.println();

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                continue;
            }

            switch (choice) {
                case 1:
                    isSignedUp = accountManager.registerNewUser();
                    break;
                case 2:
                    if (!isSignedIn) {
                        System.out.println("Enter your username: ");
                        String username = scanner.nextLine().trim();
                        System.out.println("Enter your password: ");
                        String password = scanner.nextLine();
                        currentUser = accountManager.signIn(username, password);
                        if (currentUser != null) {
                            isSignedIn = true;
                        }
                    } else {
                        System.out.println("You are already logged in.");
                    }
                    break;
                case 3:
                    if (isSignedIn) {
                        accountManager.signOut(currentUser);
                        isSignedIn = false;
                        currentUser = null;
                    } else {
                        System.out.println("You are not logged in.");
                    }
                    break;
                case 4:
                    if (isSignedIn) {
                        store.productSelection(scanner, cart);
                    } else {
                        System.out.println("You must log in to view products.");
                    }
                    break;
                case 5:
                    cart.viewBasket();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
            System.out.println();
        }
    }
}
