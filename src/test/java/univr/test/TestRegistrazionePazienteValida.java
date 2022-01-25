package univr.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import univr.PersonaleMedico;
import univr.PersonaleMedicoRepository;
import univr.utils.BaseTest;


import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class TestRegistrazionePazienteValida extends BaseTest {

    @Test
    public void testRegistrationePazienteValida() throws ParseException {
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

        WebElement codiceFiscaleMedico = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]"));
        assertEquals("ACRTTE98L61B256M", codiceFiscaleMedico.getText());

        WebElement nuovoPazienteButton = driver.findElement(By.xpath("/html/body/a[1]"));
        nuovoPazienteButton.click();


        String codFiscale = "CFRTTE98L61B256G";
        String nome = "Giulio";
        String cognome = "Cappelletti";
        String username= "giulio";
        String password = "password";
        String indirizzo = "Frazione tervenano";
        String comune = "Boh";
        String cap = "12345";
        String provincia = "San marino";
        String telefono1 = "1234567890";
        String telefono2 = "1234567890";
        String patologia = "psss";
        String descrizione = "si dimentica le cose";
        String autosufficiente = "false";

        WebElement newCodFiscale = driver.findElement(By.xpath("/html/body/form/input[1]"));
        WebElement newNome = driver.findElement(By.xpath("/html/body/form/input[2]"));
        WebElement newCognome = driver.findElement(By.xpath("/html/body/form/input[3]"));
        WebElement newUsername = driver.findElement(By.xpath("/html/body/form/input[4]"));
        WebElement newPassword = driver.findElement(By.xpath("/html/body/form/input[5]"));
        WebElement newIndirizzo = driver.findElement(By.xpath("/html/body/form/input[6]"));
        WebElement newComune = driver.findElement(By.xpath("/html/body/form/input[7]"));
        WebElement newCap = driver.findElement(By.xpath("/html/body/form/input[8]"));
        WebElement newProvincia = driver.findElement(By.xpath("/html/body/form/input[9]"));
        WebElement newTelefono1 = driver.findElement(By.xpath("/html/body/form/input[10]"));
        WebElement newTelefono2 = driver.findElement(By.xpath("//input[11]"));
        WebElement newPatologia = driver.findElement(By.xpath("//input[12]"));
        WebElement newDescrizione = driver.findElement(By.xpath("//input[13]"));
        WebElement newAutosufficiente = driver.findElement(By.xpath("//input[@value='false']"));
        WebElement createAccountButton = driver.findElement(By.xpath("//input[@type='submit']"));

        newCodFiscale.sendKeys(codFiscale);
        newNome.sendKeys(nome);
        newCognome.sendKeys(cognome);
        newUsername.sendKeys(username);
        newPassword.sendKeys(password);
        newIndirizzo.sendKeys(indirizzo);
        newComune.sendKeys(comune);
        newCap.sendKeys(cap);
        newProvincia.sendKeys(provincia);
        newTelefono1.sendKeys(telefono1);
        newTelefono2.sendKeys(telefono2);
        newPatologia.sendKeys(patologia);
        newDescrizione.sendKeys(descrizione);
        newAutosufficiente.sendKeys(autosufficiente);
        createAccountButton.click();

        WebElement titleSuccesso = driver.findElement(By.tagName("h1"));
        String titleMessageSuccesso = titleSuccesso.getText();
        assertEquals("Account creato con successo!", titleMessageSuccesso);

        /*
        newCodFiscale = driver.findElement(By.xpath("//input[1]"));
        newNome = driver.findElement(By.xpath("//input[2]"));
        newCognome = driver.findElement(By.xpath("//input[3]"));
        newUsername = driver.findElement(By.xpath("//input[4]"));
        newPassword = driver.findElement(By.xpath("//input[5]"));
        newIndirizzo = driver.findElement(By.xpath("//input[6]"));
        newComune = driver.findElement(By.xpath("//input[7]"));
        newProvincia = driver.findElement(By.xpath("//input[8]"));
        newTelefono1 = driver.findElement(By.xpath("/html/body/form/input[10]"));
        newTelefono2 = driver.findElement(By.xpath("//input[11]"));
        newPatologia = driver.findElement(By.xpath("//input[12]"));
        newDescrizione = driver.findElement(By.xpath("//input[13]"));
        newAutosufficiente = driver.findElement(By.xpath("//input[@value='false']"));
        createAccountButton = driver.findElement(By.xpath("//input[@type='submit']"));

        assertEquals(codFiscale, newCodFiscale.getText());
        assertEquals(nome, newNome.getText());
        assertEquals(cognome, newCognome.getText());
        assertEquals(username, newUsername.getText());
        assertEquals(username, newUsername.getText());
        assertEquals(password, newPassword.getText());
        assertEquals(indirizzo, newIndirizzo.getText());
        assertEquals(comune, newComune.getText());
        assertEquals(provincia, newProvincia.getText());*/
    }
}
