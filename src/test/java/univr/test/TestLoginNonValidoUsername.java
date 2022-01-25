package univr.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import univr.utils.BaseTest;


import static org.junit.Assert.assertEquals;

public class TestLoginNonValidoUsername  extends BaseTest {
    @Test
    public void testNotValidLoginUsername() {

        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("medico12");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("password");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();


        WebElement titleErrore = driver.findElement(By.tagName("h1"));
        String titleMessageErrore = titleErrore.getText();
        assertEquals("Account non presente.", titleMessageErrore);
    }

}
