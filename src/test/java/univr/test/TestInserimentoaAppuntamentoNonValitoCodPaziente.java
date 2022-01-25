package univr.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import univr.utils.BaseTest;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
public class TestInserimentoaAppuntamentoNonValitoCodPaziente extends BaseTest {

    @Test
    public void testInserimentoaAppuntamentoNonValitoCodPaziente() throws ParseException {
        setUpRepository();


        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("receptionist");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("password");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();


        WebElement title2 = driver.findElement(By.tagName("h1"));
        String titleMessage2 = title2.getText();
        assertEquals("Receptionist", titleMessage2);

        WebElement newCodFiscale = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]"));
        assertEquals("ACRTTE98L61B256R", newCodFiscale.getText());

        WebElement codiceFiscalePaziente = driver.findElement(By.xpath("/html/body/form[2]/input[1]"));
        codiceFiscalePaziente.sendKeys("ABRTTE98L61B256P");
        WebElement codiceFiscaleMedico = driver.findElement(By.xpath("/html/body/form[2]/input[2]"));
        codiceFiscaleMedico.sendKeys("ACRTTE98L61B256M");

        WebElement inserisciAppuntamentoButton = driver.findElement(By.xpath("/html/body/form[2]/input[3]"));
        inserisciAppuntamentoButton.click();

        WebElement title3 = driver.findElement(By.tagName("h1"));
        String titleMessage3 = title3.getText();
        assertEquals("Account non presente.", titleMessage3);

        resetRepository();

    }
}
