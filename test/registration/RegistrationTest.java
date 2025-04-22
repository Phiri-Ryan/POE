/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registration;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationTest {
    @Test
    public void testGoodUsername() {
        Registration reg = new Registration();
        reg.Username = "kyl_1";
        assertEquals("Username successfully captured.", reg.getUsernameMessage());
    }
    
    @Test
    public void testBadUsername() {
        Registration reg = new Registration();
        reg.Username = "kyle!!!!!!!";
        assertEquals("Username is not correctly formatted...", reg.getUsernameMessage());
    }
    
    @Test
    public void testGoodPassword() {
        Registration reg = new Registration();
        reg.Password = "Ch&&sec@ke99!";
        assertEquals("Password successfully captured.", reg.getPasswordMessage());
    }
    
    @Test
    public void testBadPassword() {
        Registration reg = new Registration();
        reg.Password = "password";
        assertEquals("Password is not correctly formatted...", reg.getPasswordMessage());
    }
    
    @Test
    public void testGoodCellphone() {
        Registration reg = new Registration();
        reg.Cellphone = "+27831234567";
        assertEquals("Cell phone number successfully added.", reg.getCellphoneMessage());
    }
    
    @Test
    public void testBadCellphone() {
        Registration reg = new Registration();
        reg.Cellphone = "0831234567";
        assertEquals("Cell phone number incorrectly formatted...", reg.getCellphoneMessage());
    }
}
