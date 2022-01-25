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
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class TestVisualizzaAppuntamentoNonPresente extends BaseTest {

    @Test
    public void testAppuntamentoNonPresente() throws ParseException {
        setUpRepository();
        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);

        String userRecep = "receptionist";
        String passwordRecep = "password";

        WebElement user = driver.findElement(By.xpath("/html/body/form/input[1]"));
        WebElement password = driver.findElement(By.xpath("/html/body/form/input[2]"));
        user.sendKeys(userRecep);
        password.sendKeys(passwordRecep);

        WebElement inviaButton = driver.findElement(By.xpath("/html/body/form/center/input"));
        inviaButton.click();

        WebElement title3 = driver.findElement(By.tagName("h1"));
        String titleMessage3 = title3.getText();
        assertEquals("Receptionist", titleMessage3);
        WebElement visualizzaAppuntamentoButton = driver.findElement(By.xpath("/html/body/form[1]/input[3]"));
        String codFiscalePaziente = "ACRTTE98L61B256A";
        String codFiscalePersonale = "ACRTTE98L61B256M";

        WebElement newCodFiscalePaziente = driver.findElement(By.xpath("/html/body/form[1]/input[1]"));
        WebElement newCodFiscalePersonale = driver.findElement(By.xpath("/html/body/form[1]/input[2]"));
        newCodFiscalePaziente.sendKeys(codFiscalePaziente);
        newCodFiscalePersonale.sendKeys(codFiscalePersonale);
        visualizzaAppuntamentoButton.click();
        WebElement titleSuccesso = driver.findElement(By.tagName("h1"));
        String titleMessageSuccesso = titleSuccesso.getText();
        assertEquals("Appuntamenti non presenti.", titleMessageSuccesso);
        resetRepository();
    }
}
