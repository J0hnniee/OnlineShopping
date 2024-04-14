/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;
import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class SignupPage {
    
    // Method to display signup screen and attempt user registration
    public static boolean SignUp(AccountManager userSignup){
        Scanner scan = new Scanner(System.in);
        boolean isSignedUp = false;
        
        // Call the registerNewUser method of AccountManager to attempt user registration
        if (userSignup.registerNewUser()) {
            System.out.println("Account created successfully!");
            isSignedUp = true; // Mark user as signed up
        }
        
        return isSignedUp; // Return the signup status
    }
}
