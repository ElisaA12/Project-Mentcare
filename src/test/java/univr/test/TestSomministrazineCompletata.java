package univr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import univr.*;
import univr.utils.BaseTest;


import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class TestSomministrazineCompletata extends BaseTest {

    @Test
    public void testSomministrazineCompletata() throws ParseException {
        setUpRepository();

        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("infermiere");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("password");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();


        WebElement title2 = driver.findElement(By.tagName("h1"));
        String titleMessage2 = title2.getText();
        assertEquals("Infermiere", titleMessage2);

        WebElement pazienteInput = driver.findElement(By.xpath("//input[@name='codPaziente']"));
        pazienteInput.sendKeys("ACRTTE98L61B256N");

        WebElement visualizzaPazienteButton = driver.findElement(By.xpath("/html/body/form[1]/input[3]"));
        visualizzaPazienteButton.click();

        WebElement visualizzaFarmaciButton = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[14]/a"));
        visualizzaFarmaciButton.click();


        WebElement somministraButton = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[7]/a"));
        somministraButton.click();

        WebElement title3 = driver.findElement(By.tagName("h1"));
        String titleMessage3 = title3.getText();
        assertEquals("Questo farmaco è stato somministrato per intero!", titleMessage3);

        resetRepository();

    }
}
