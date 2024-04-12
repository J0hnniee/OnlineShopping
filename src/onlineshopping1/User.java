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
public class User {
    private String name;
    private String username;
    private String password;
    private boolean isSignedUp;
    private boolean isSignedIn;
    private ArrayList<PurchaseHistory> purchaseHistory;
    
    public User(String name, String username, String password, boolean isSignedUp, boolean isSignedIn){
        this.name = name;
        this.username = username;
        this.password = password;
        this.isSignedUp = false;
        this.isSignedIn = false;
        this.purchaseHistory = new ArrayList();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    // Set user's login status
    public void setUserSignedin(boolean isSignedIn) {
        this.setIsSignedIn(isSignedIn);
    }
    
    // Check if user is signed in
    public boolean userSignedIn() {
        return isIsSignedIn();
    }
    
    // Check if user is signed up
    public boolean userSignedUp() {
        return isSignedUp;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the isSignedIn
     */
    public boolean isIsSignedIn() {
        return isSignedIn;
    }

    /**
     * @param isSignedIn the isSignedIn to set
     */
    public void setIsSignedIn(boolean isSignedIn) {
        this.isSignedIn = isSignedIn;
    }
    
}
