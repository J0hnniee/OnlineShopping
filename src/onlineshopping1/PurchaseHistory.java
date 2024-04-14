/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

import java.util.ArrayList;

/**
 *
 * @author johnn
 */
public class PurchaseHistory {

    private double totalPrice;
    private ArrayList<Product> purchasedProducts;
    private String fullName;

    public PurchaseHistory(double totalPrice, ArrayList<Product> purchasedProducts, String fullName) {
        this.totalPrice = totalPrice;
        this.purchasedProducts = new ArrayList<Product>(purchasedProducts);
        this.fullName = fullName;
    }

    //Override the toString method to customize the string representation of PurchaseHistory objects
    @Override
    public String toString() {
        StringBuilder products = new StringBuilder();
        // Loop through the purchased products and append their names to their StringBuilder
        for (Product product: purchasedProducts) {
            products.append(product.getProductName()).append(", ");
        }
        // Create a string representation including total price, purchased items, and full name
        return "Total Price: $" + totalPrice + ", Items: " + products.toString()
                + "Full Name: " + fullName;
    }
}
