package univr.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import univr.*;
import univr.utils.BaseTest;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class TestVisualizzaPazientiCF extends BaseTest {

    @Test
    public void testValidaPazienteConCF() throws ParseException {
        setUpRepository();
        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);

        String user = "medico";
        String password = "password";

        WebElement userM = driver.findElement(By.xpath("/html/body/form/input[1]"));
        WebElement passwordM = driver.findElement(By.xpath("/html/body/form/input[2]"));
        userM.sendKeys(user);
        passwordM.sendKeys(password);
        WebElement inviaButton = driver.findElement(By.xpath("/html/body/form/center/input"));
        inviaButton.click();

        WebElement title3 = driver.findElement(By.tagName("h1"));
        String titleMessage3 = title3.getText();
        assertEquals("Medico", titleMessage3);
        WebElement visualizzaPazientiButton = driver.findElement(By.xpath("/html/body/form[1]/input[3]"));
        String codFiscalePaziente = "ACRTTE98L61B256A";

        WebElement newCodFiscalePaziente = driver.findElement(By.xpath("/html/body/form[1]/input[1]"));
        newCodFiscalePaziente.sendKeys(codFiscalePaziente);
        visualizzaPazientiButton.click();
        WebElement titleSuccesso = driver.findElement(By.tagName("h1"));
        String titleMessageSuccesso = titleSuccesso.getText();
        assertEquals("Lista pazienti", titleMessageSuccesso);
        WebElement codPaziente = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]"));
        assertEquals("ACRTTE98L61B256A", codPaziente.getText());

        resetRepository();
    }
}
