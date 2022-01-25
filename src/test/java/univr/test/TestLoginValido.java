package univr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import univr.PersonaleMedico;
import univr.PersonaleMedicoRepository;
import univr.utils.BaseTest;


import java.text.ParseException;

import static org.junit.Assert.assertEquals;
public class TestLoginValido extends BaseTest {
    @Test
    public void testLoginValido() throws ParseException {
        setUpRepository();

        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("medico");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("password");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement newCodFiscale = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]"));
        assertEquals("ACRTTE98L61B256M", newCodFiscale.getText());

        resetRepository();
    }


}
