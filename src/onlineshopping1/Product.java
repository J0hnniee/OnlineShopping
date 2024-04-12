/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

/**
 *
 * @author johnn
 */
public class Product {
    
    private String productName;
    private double productPrice;
    private String productDescription;
    private Category productCategory;
    
    public Product(String productName, double productPrice, String productDescription, Category productCategory){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @return the productPrice
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }
    
    
}
