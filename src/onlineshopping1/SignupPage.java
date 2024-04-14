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
    public static boolean SignUp(AccountManager userSignup){
        Scanner scan = new Scanner(System.in);
        boolean isSignedUp = false;
        if (userSignup.registerNewUser()) {
            System.out.println("Account created successfully!");
            isSignedUp = true; // Mark user as signed up
        }
        
        return isSignedUp;
    }
}
