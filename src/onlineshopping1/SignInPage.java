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
public class SignInPage {
    public static boolean loginScreen(AccountManager userLogin) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Attempt to log in user
        User user = userLogin.signIn(username, password);
        if (user != null) {
            System.out.println("Login successful!");
            isLoggedIn = true; // Mark user as logged in
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
        
        return isLoggedIn;
    }
}
