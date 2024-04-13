/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

/**
 *
 * @author johnn
 */
public class Category {

    private String name;        // The name of the category
    private String description; // A description of the category

    // Constructor to create a new Category with the given name and description.
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Get the name of the category.
    public String getCategoryName() {
        return name;
    }

    // Get the description of the category.
    public String getCategoryDescription() {
        return description;
    }
}