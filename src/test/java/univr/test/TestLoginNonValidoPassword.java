package univr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import univr.PersonaleMedico;
import univr.PersonaleMedicoRepository;
import univr.utils.BaseTest;


import java.text.ParseException;

import static org.junit.Assert.assertEquals;
public class TestLoginNonValidoPassword extends BaseTest {

    @Test
    public void testNotValidLoginPassword() throws ParseException {
        setUpRepository();

        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("medico");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("Password");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();


        WebElement titleErrore = driver.findElement(By.tagName("h1"));
        String titleMessageErrore = titleErrore.getText();
        assertEquals("Account non presente.", titleMessageErrore);

        resetRepository();
    }

}
