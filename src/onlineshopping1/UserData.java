/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlineshopping1;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnn
 */
public class UserData {

    public static final String USERS_DATA = "./userdata/users_data.txt";

    public void savedUserData(User user) {
        try {
            // Open a BufferedWriter to append to the user data file
            BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_DATA, true));

            // Write the user information in a formatted manner
            writer.write("Name: " + user.getName() + ", Username: " + user.getUsername() + ", Password: " + user.getPassword());
            writer.newLine();  // Move to the next line for the next user
            writer.close();    // Close the writer to finalize the write operation
        } catch (IOException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> loadUserData() {
        List<User> loadedUsers = new ArrayList<>();

        try ( BufferedReader reader = new BufferedReader(new FileReader(USERS_DATA))) {
            String textLine;
            while ((textLine = reader.readLine()) != null) {
                String[] userData = textLine.split(", ");
                if (userData.length == 3) { // Ensure there are 3 parts in the userData array
                    String name = userData[0].split(": ")[1];
                    String username = userData[1].split(": ")[1];
                    String password = userData[2].split(": ")[1];

                    User user = new User(name, username, password, true, true);
                    loadedUsers.add(user);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return loadedUsers;
    }
}
