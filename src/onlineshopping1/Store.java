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

    private ArrayList<Product> products;
    private CategoryDisplay categoryDisplay;
    private int uniqueProductNumber; 

    public Store() {
        products = new ArrayList<>();
        uniqueProductNumber = 1; // Initialize the unique product number

        Category perfumeCategory = new Category("Perfumes", "Products related to perfume.");
        Category hairProductsCategory = new Category("Hair Products", "Hair products");
     
        

        // Add products to the catalog with unique numbers
        products.add(new Perfumes(uniqueProductNumber++, "Dior Sauvage 100mL", 259, "An intense and smooth trail, mysteriously powerful in its precise freshness.", perfumeCategory));
        products.add(new Perfumes(uniqueProductNumber++, "Sweet like Candy by Ariana Grande 100mL", 74.99, "Indulge your sweet tooth with the Ariana Grande Sweet Like Candy Eau de Parfum, a fragrance for women with fruity gourmand facets.", perfumeCategory));
        products.add(new Perfumes(uniqueProductNumber++, "Chanel de bleu 100mL", 260, "A timeless Scent Housed in a bottle of a deep and mysterious shade of blue", perfumeCategory));
        
        products.add(new HairProducts(uniqueProductNumber++, "Head & Shoulders Shampoo 100mL", 14.99, "Anti dandruff shampoo", hairProductsCategory));
        products.add(new HairProducts(uniqueProductNumber++, "Pantene Shampoo", 9.99, "Smooth shampoo that help give your hair silky smoothness and frizz control", hairProductsCategory));
        products.add(new HairProducts(uniqueProductNumber++, "Palmolive Shampoo", 8.49, "Suitable for dry/coarse hair", hairProductsCategory));

        
        
        // Initialize the display manager with the products
        categoryDisplay = new CategoryDisplay(products);
    }

    // Display all available products in the catalog //NOT BEING USED CURRENTLY
    public void displayAllProducts() {
        categoryDisplay.displayAllProducts();
    }

    // Display products in a specific category
    public void displayCategory(String categoryName) {
        categoryDisplay.displayProductsOfCategory(categoryName);
    }

    // Get the total number of products in the catalog
    public int getProductCount() {
        return products.size();
    }

    // Get a product from the catalog based on its number
    public Product getProductNumber(int productNumber) {
        if (productNumber >= 1 && productNumber <= getProductCount()) {
            return products.get(productNumber - 1);
        }
        return null;
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
                Product selectedProduct = categoryDisplay.getSelectedProduct(productNumber);

                if (selectedProduct != null) {
                    cart.addItem(selectedProduct);
                    System.out.println(selectedProduct.getProductName() + " added to cart.");
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