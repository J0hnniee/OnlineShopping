/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

/**
 *
 * @author johnn
 */
public class HairProducts extends Product{

    private int uniqueProductNumber; // Add this field
    private String description;

    public HairProducts(int uniqueProductNumber, String name, double price, String productInfo, Category category) {
        super(name, price, productInfo, category);
        this.uniqueProductNumber = uniqueProductNumber; // Set the unique product number
    }

    public String getProductInfo() {
        return super.getProductDescription() + " Description: " + description;
    }

}


