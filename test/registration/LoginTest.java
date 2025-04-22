/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registration;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    @Test
    public void testLoginSuccess() {
        Login login = new Login("user_1", "Pass123!", "John", "Doe");
        assertTrue(login.loginUser("user_1", "Pass123!"));
    }
    
    @Test
    public void testLoginFail() {
        Login login = new Login("user_1", "Pass123!", "John", "Doe");
        assertFalse(login.loginUser("wrong", "wrong"));
    }
    
    @Test
    public void testLoginMessage() {
        Login login = new Login("user_1", "Pass123!", "John", "Doe");
        assertEquals("Welcome John,Doe It is great to see you again.", 
                   login.returnLoginStatus(true));
        assertEquals("Username or password incorrect, please try again.",
                   login.returnLoginStatus(false));
    }
}
