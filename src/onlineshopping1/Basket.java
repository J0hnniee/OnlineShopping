/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class Basket {

    private ArrayList<Product> items; // List of items in the basket
    private ArrayList<PurchaseHistory> purchaseHistoryList; // List of purchase histories

    public Basket() {
        items = new ArrayList<>();
        purchaseHistoryList = new ArrayList<>();
    }
    
    // Adds an item to the basket
    public void addItem(Product product) {
        items.add(product);
        System.out.println("Item added to the basket: " + product.getProductName());
    }

    // Removes an item from the basket
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            Product removedProduct = items.remove(index);
            System.out.println("Item removed from the basket: " + removedProduct.getProductName());
        } else {
            System.out.println("Invalid item index.");
        }
    }

    // Displays the contents of the basket and allows the user to remove items or checkout
    public void viewBasket() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (items.isEmpty()) {
                System.out.println("Your basket is empty.");
                return;
            }

            System.out.println("Basket Contents:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ") " + items.get(i).getProductName());
            }

            double totalPrice = calculateTotalPrice();
            System.out.println("\nTotal Price: $" + totalPrice);

            System.out.println((items.size() + 1) + ") Checkout");

            System.out.println("Enter the item number to remove from the basket");
            System.out.println("Enter " + (items.size() + 1) + " to checkout (0 to Cancel)");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    System.out.println("No items removed.");
                    return;
                } else if (choice >= 1 && choice <= items.size()) {
                    removeItem(choice - 1);
                } else if (choice == items.size() + 1) {
                    System.out.print("Enter your full name: ");
                    String fullName = scanner.nextLine();

                    checkout(fullName);
                    return;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getProductPrice();
        }
        return totalPrice;
    }

    public void checkout(String fullName) {
        if (items.isEmpty()) {
            System.out.println("No items in the basket to checkout.");
            return;
        }

        double totalPrice = calculateTotalPrice();

        System.out.println("Total Price: $" + totalPrice);
        System.out.println("\nThank you for shopping, " + fullName + "!");


        PurchaseHistory purchaseHistory = new PurchaseHistory(totalPrice, new ArrayList<>(items), fullName);
        purchaseHistoryList.add(purchaseHistory);

        items.clear();

        System.out.println("\nReturning to the main menu...\n");
    }
}