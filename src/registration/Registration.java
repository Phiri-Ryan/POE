/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration;
import java.util.Scanner;
import java.util.regex.Pattern;

//Registration class
public class Registration {
    // Class variables to store user information
    String Username, Password, Cellphone, FirstName, LastName;
    
    // Constructor initializes empty user information
    public Registration(){
        Username = "";
        Password = "";
        Cellphone = "";
        FirstName = "";
        LastName = "";
    }
   //collects and validates username
    public void Username(){
        Scanner Input = new Scanner(System.in);   
        boolean use=true;
        
        while (use){
            System.out.print("Enter username: ");
            this.Username = Input.nextLine(); 
            if (Username.contains("_") && Username.length() <= 5){
                System.out.println("Username successfully captured.");
                System.out.println("");
                use=false;
             } else { 
                 System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
                 System.out.println("");
             }       
         } 
    }
     
    //Collects and validates password
    public void Password(){
        Scanner Input = new Scanner(System.in);   
        boolean pas=true;
        
        String line="!@#$%^&*()-_=+[{]}|;:'\",<.>/?`~";
        boolean Capital=false;
        boolean Lower = false;
        boolean Special = false;
        boolean Digit = false;
        
        while (pas){
            System.out.print("Enter password: ");
            this.Password = Input.nextLine(); 
            char[] charArray = Password.toCharArray();
            char[] charSpecial = line.toCharArray();
            
            for (char c : charArray){
                if (Character.isUpperCase(c)) {
                    Capital = true;
                } else if (Character.isLowerCase(c)) { 
                     Lower = true;
                } else if (Character.isDigit(c)) {
                    Digit = true;
                }
                for (char k : charSpecial){
                    if (k==c){ 
                        Special = true;
                    }
                }
            }
            
            if ((Capital==true) && (Lower == true) && (Special==true) && (Digit==true) && (Password.length() >= 8)){
                System.out.println("Password successfully captured.");
                System.out.println("");
                pas=false;
             } else { 
                 System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
                 System.out.println("");
             }       
        } 
    }
    //Collects and validates cellphone number 
    public void Number(){
        Scanner Input = new Scanner(System.in);    
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
         
        while (true) {
            System.out.print("Enter your cell phone number (e.g., +27831234569): ");
            Cellphone = Input.nextLine();

            if (Cellphone.matches(regex) && Cellphone.length() > 10) {
                System.out.println("Cell phone number successfully added.");
                System.out.println("");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
                System.out.println("");
            }
        }
    }

    //Returns username validation message for testing
    public String getUsernameMessage() {
        if (Username.contains("_") && Username.length() <= 5) {
            return "Username successfully captured.";
        }
        return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
    }
    //Returns password validation message for testing
    public String getPasswordMessage() {
        String special = "!@#$%^&*()-_=+[{]}|;:'\",<.>/?`~";
        boolean Cap=false, Low=false, Spec=false, Dig=false;
        
        for (char c : Password.toCharArray()){
            if (Character.isUpperCase(c)) Cap=true;
            if (Character.isLowerCase(c)) Low=true;
            if (Character.isDigit(c)) Dig=true;
            if (special.contains(String.valueOf(c))) Spec=true;
        }
        
        if (Password.length()>=8 && Cap && Low && Spec && Dig) {
            return "Password successfully captured.";
        }
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }
    //Returns cellphone validation message for testing
    public String getCellphoneMessage() {
        if (Cellphone.matches("^\\+\\d{1,3}\\d{1,10}$") && Cellphone.length()>10) {
            return "Cell phone number successfully added.";
        }
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    /**
     * Main program flow:
     * 1. Registration process
     * 2. Login verification
     */
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        Registration userReg = new Registration();
        
        System.out.println("=== REGISTRATION ===");
        userReg.Username();
        userReg.Password();
        userReg.Number();
        
        System.out.print("First name: ");
        String firstName = Input.nextLine();
        System.out.print("Last name: ");
        String lastName = Input.nextLine();
        
        Login userLogin = new Login(
            userReg.Username, 
            userReg.Password, 
            firstName, 
            lastName
        );
        
        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String loginUser = Input.nextLine();
        System.out.print("Password: ");
        String loginPass = Input.nextLine();
        
        boolean status = userLogin.loginUser(loginUser, loginPass);
        System.out.println(userLogin.returnLoginStatus(status));
        
        Input.close();
    }
}