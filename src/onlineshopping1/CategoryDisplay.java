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
public class CategoryDisplay {
    private ArrayList<Product> products;
    private int totalProductCount;

    public CategoryDisplay(ArrayList<Product> products) {
        this.products = products;
        this.totalProductCount = products.size();
    }

    // Choose a shopping category and display products within that category
    public void displayProductsSelection(Scanner scanner) {
        while (true) {
            System.out.println("Choose a shopping category:");
            System.out.println("1) Perfume");
            System.out.println("2) Hair Products");

            int categoryChoice;
            try {
                categoryChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            if (categoryChoice == 1) {
                displayProductsOfCategory("Perfumes");
                break;
            } else if (categoryChoice == 2) {
                displayProductsOfCategory("Hair Products");
                break;
            } else {
                System.out.println("Invalid category choice. Please enter 1 for Perfumes or 2 for Hair Products.");
            }
        }
    }

    // Display products within a specific category
    public void displayProductsOfCategory(String categoryName) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getProductCategory().getCategoryName().equalsIgnoreCase(categoryName)) {
                System.out.println((i + 1) + ") " + product.getProductName() + " - $" + product.getProductPrice() + " " + product.getProductDescription());
            }
        }
    }

    // Display all products
    public void displayAllProducts() {
        System.out.println("Product List:");
        int productNumber = 1;
        for (Product product : products) {
            System.out.println(productNumber + ") " + product.getProductCategory().getCategoryName() + " - " + product.getProductName() + " - $" + product.getProductPrice() + " " + product.getProductDescription());
            productNumber++;
        }
    }

    // Get the selected product based on its position in the list
    public Product getSelectedProduct(int productNumber) {
        if (productNumber >= 1 && productNumber <= totalProductCount) { // Use totalProductCount
            return products.get(productNumber - 1);
        }
        return null;
    }
}
