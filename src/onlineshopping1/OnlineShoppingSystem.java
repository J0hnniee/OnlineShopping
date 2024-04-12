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

        while (true) {
            System.out.println("Online Shopping System");
            System.out.println("1) Register");
            System.out.println("2) Login");
            System.out.println("3) Logout");
            System.out.println("4) Product list");
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
                    isSignedIn = SignInPage.loginScreen(accountManager);
                    break;
                case 3:
                    // Implement logout functionality
                    break;
                case 4:
                    // Implement product list functionality
                    break;
                case 5:
                    // Implement view cart functionality
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

    
   
