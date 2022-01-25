package univr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import univr.Paziente;
import univr.PazienteRepository;
import univr.PersonaleMedico;
import univr.PersonaleMedicoRepository;
import univr.utils.BaseTest;

import javax.swing.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
public class TestInserimentoAppuntamentoValido extends BaseTest {

    @Test
    public void testInserimentoAppuntamentoValido () throws ParseException {
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
        codiceFiscalePaziente.sendKeys("ACRTTE98L61B256A");
        WebElement codiceFiscaleMedico = driver.findElement(By.xpath("/html/body/form[2]/input[2]"));
        codiceFiscaleMedico.sendKeys("ACRTTE98L61B256M");

        WebElement inserisciAppuntamentoButton = driver.findElement(By.xpath("/html/body/form[2]/input[3]"));
        inserisciAppuntamentoButton.click();

        WebElement title3 = driver.findElement(By.tagName("h1"));
        String titleMessage3 = title3.getText();
        assertEquals("Inserisci appuntamento", titleMessage3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        String date = dateTime.format(formatter);
        String indirizzo = "Via G. Leopardi";
        String descrizione = "Visita cardiologica. Clinica 5. Ambulatorio 1.";


        WebElement newData = driver.findElement(By.xpath("//input[1]"));
        WebElement newIndirizzo = driver.findElement(By.xpath("//input[2]"));
        WebElement newDescrizione = driver.findElement(By.xpath("//input[3]"));

        newData.sendKeys(date);
        newIndirizzo.sendKeys(indirizzo);
        newDescrizione.sendKeys(descrizione);

        WebElement inserisciAppuntamentoButton2 = driver.findElement(By.xpath("//input[@type='submit']"));
        inserisciAppuntamentoButton2.click();


        WebElement titleSuccesso = driver.findElement(By.tagName("h1"));
        String titleMessageSuccesso = titleSuccesso.getText();
        assertEquals("Appuntamento inserito correttamente!", titleMessageSuccesso);

        resetRepository();
    }
}
