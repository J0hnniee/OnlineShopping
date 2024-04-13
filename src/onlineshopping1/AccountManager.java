/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class AccountManager {

    private ArrayList<User> users = new ArrayList<>();  // List to store user objects

    public void loadUserData() {
        UserData usersData = new UserData();
        users = new ArrayList<>(usersData.loadUserData());
    }

    public boolean registerNewUser() {
        Scanner scan = new Scanner(System.in);
        boolean isValidUsername = false;
        String username = "";

        while (!isValidUsername) {
            System.out.println("Enter your desired username: ");
            username = scan.nextLine().trim();

            boolean usernameExists = false;
            for (User u : users) {
                if (u.getUsername().equalsIgnoreCase(username)) {
                    usernameExists = true;
                    break;
                }
            }
            if (usernameExists) {
                System.out.println("Username already taken. Please choose a different username.");
            } else {
                isValidUsername = true;
            }
        }

        System.out.println("Enter your desired password: ");
        String password = scan.nextLine();
        System.out.println("Enter your first name: ");
        String firstName = scan.nextLine().trim();
        System.out.println("Enter your last name: ");
        String lastName = scan.nextLine().trim();

        String fullName = firstName + " " + lastName;

        boolean isValidName = false;

        while (!isValidName) {
            if (fullName.matches("[A-Za-z]+\\s+[A-Za-z]+")) {
                isValidName = true;

            } else {
                System.out.println("Invalid input. Please enter your first and last name");
                System.out.println("Enter your first name: ");
                firstName = scan.nextLine().trim();
                System.out.println("Enter your last name: ");
                lastName = scan.nextLine().trim();
                fullName = firstName + " " + lastName;
            }
        }

        System.out.println("\nAccount Created!");
        User newUser = new User(firstName + " " + lastName, username, password, true, false);

        // Add the new user to the list and save their data
        users.add(newUser);
        UserData userData = new UserData();
        userData.savedUserData(newUser);

        return true;
    }

    public User signIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().trim().equals(username) && user.getPassword().equals(password)) {
                // Set the user's login status and provide feedback
                user.setUserSignedin(true);
                System.out.println("Login successful. Welcome " + user.getUsername() + "!");
                return user;  // Return the logged-in user object
            }
        }
        System.out.println("Login failed. Invalid username or password.");
        return null;  // Return null if login attempt is unsuccessful
    }

    public void signOut(User user) {
        if (user != null && users.contains(user) && user.isIsSignedIn()) {
            user.setIsSignedIn(false);  // Update the user's sign-in status
            System.out.println("Logout successful.");
        } else {
            System.out.println("Logout failed. User not found or not signed in.");
        }
    }
}
