/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class Store {

    private HashMap<Integer, Product> productsMap;  // Use a HashMap to store products with unique identifiers
    private CategoryDisplay categoryDisplay;
    private int uniqueProductNumber; // Add this field

    public Store() {
        productsMap = new HashMap<>();
        uniqueProductNumber = 1; // Initialize the unique product number

        Category technologyCategory = new Category("Technology", "Products related to technology.");
        Category accessoryCategory = new Category("Accessories", "Various accessories for different purposes.");

        // Add products to the catalog with unique numbers
        addProduct(new TechProducts(uniqueProductNumber++, "Gaming Monitor", 300, "Ultra Gaming monitor.", technologyCategory, "Full HD, 144Hz"));
        addProduct(new TechProducts(uniqueProductNumber++, "Gaming Mouse", 250, "Light weight gaming mouse.", technologyCategory, "RGB lighting"));
        addProduct(new TechProducts(uniqueProductNumber++, "Gaming Keyboard", 300, "Mechanical gaming keyboard.", technologyCategory, "Mechanical switches"));

        addProduct(new AccessoryProducts(uniqueProductNumber++, "Mouse Pad", 50, "Smooth Mouse pad.", accessoryCategory));
        addProduct(new AccessoryProducts(uniqueProductNumber++, "Universal Remote", 28.95, "Uses AA Batteries", accessoryCategory));
        addProduct(new AccessoryProducts(uniqueProductNumber++, "USD 3.0 Flash", 14.99, "36GB", accessoryCategory));

        // Initialize the display manager with the products
        categoryDisplay = new ProductCatalogueDisplay(new ArrayList<>(productsMap.values()));
    }

    // Add a product to the HashMap
    private void addProduct(Product product) {
        productsMap.put(product.getProductNumber(), product);
    }

    // Get a product from the catalog based on its number
    public Product getProductNumber(int productNumber) {
        return productsMap.get(productNumber);
    }

    // Allow the user to select and add products to the shopping cart
    public void productSelection(Scanner scanner, Basket cart) {
        while (true) {
            // Display available categories and products
            categoryDisplay.displayProductsSelection(scanner);

            // Prompt the user to choose a product or go back
            System.out.println("\nEnter the product number to add to cart or");
            System.out.println("Enter C for category selection or enter 0 to go back to the main menu:");
            String userInput = scanner.nextLine();

            if (userInput.equals("0")) {
                // Back to the main menu
                return;
            } else if (userInput.equalsIgnoreCase("C")) {
                // Back to the category selection
                continue;
            }

            try {
                int productNumber = Integer.parseInt(userInput);
                Product selectedProduct = getProductNumber(productNumber);

                if (selectedProduct != null) {
                    cart.addItem(selectedProduct);
                    System.out.println(selectedProduct.getName() + " added to cart.");
                    while (true) {
                        System.out.println("Do you want to add another item? (Y/N): ");
                        String choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            break;
                        } else if (choice.equalsIgnoreCase("N")) {
                            return;
                        } else {
                            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                        }
                    }
                } else {
                    System.out.println("Invalid product number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number, 'C' for category, or 0 to go back.");
            }
        }
    }
}