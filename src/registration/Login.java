/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;
//Handles user login functionality
public class Login {
    // Stores login credentials and user details
    String storedUsername, storedPassword, firstName, lastName;
    //Initializes login handler with user credentials
    public Login(String username, String password, String firstName, String lastName){
        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Verifies login credentials
     * @return true if credentials match, false otherwise
     */
    public boolean loginUser(String username, String password){
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
    
    /**
     * Returns appropriate login status message
     */
    public String returnLoginStatus(boolean isLoggedIn){
        if (isLoggedIn) {
            return "Welcome " + firstName + "," + lastName + " It is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
