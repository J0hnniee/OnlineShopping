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
public class AccountManager {

    private ArrayList<User> users = new ArrayList<>();  // List to store user objects

    public void loadUserData() {
        UserData usersData = new UserData();
        users = new ArrayList<>(usersData.loadUserData());
    }

    public boolean registerNewUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your desired username: ");
        String username = scan.nextLine();
        System.out.println("Enter your desired password: ");
        String password = scan.nextLine();

        String firstName = "";
        String lastName = "";

        boolean isValidName = false;

        while (!isValidName) {
            System.out.println("Please enter your First and Last name (separated by a space):");
            String fullName = scan.nextLine().trim();

            String[] names = fullName.split("\\s+");
            if (names.length >= 2 && names[0].matches("[A-Za-z]+") && names[1].matches("[A-Za-z]+")) {
                isValidName = true;
                System.out.println("Name accepted.");
            } else {
                System.out.println("Invalid input. Please enter your first and last name correctly.");
            }
        }

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
                System.out.println("User " + user.getUsername() + " logged in.");
                return user;  // Return the logged-in user object
            }
        }
        return null;  // Return null if login attempt is unsuccessful
    }

    public void signOut(User user) {
        if (user != null) {
            user.setUserSignedin(false);
            System.out.println("Logout successful.");
        } else {
            System.out.println("Logout failed, please try again");
        }
    }
}
