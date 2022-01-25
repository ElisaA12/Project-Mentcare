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

public class TestRegistrazionePersonaleNonValidaUsername extends BaseTest {

    @Test
    public void testRegistrazionePersonaleNonValidaUsername() throws ParseException {
        setUpRepository();
        WebElement title = driver.findElement(By.tagName("h1"));
        String titleMessage = title.getText();
        assertEquals("Login", titleMessage);
        WebElement nuovoPazienteButton = driver.findElement(By.xpath("/html/body/center/a"));
        nuovoPazienteButton.click();

        WebElement title2 = driver.findElement(By.tagName("h1"));
        String titleMessage2 = title2.getText();
        assertEquals("Login", titleMessage2);

        WebElement chiave = driver.findElement(By.xpath("//input[@name='chiave']"));
        chiave.sendKeys("key");
        WebElement loginManagerButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginManagerButton.click();

        WebElement title3 = driver.findElement(By.tagName("h1"));
        String titleMessage3 = title3.getText();
        assertEquals("Manager", titleMessage3);

        WebElement aggiungiNuovoPersonaleButton = driver.findElement(By.xpath("/html/body/a[1]"));
        aggiungiNuovoPersonaleButton.click();


        String codFiscale = "ACRTTE98L61B256A";
        String nome = "Elisa";
        String cognome = "Acciari";
        String username= "medico";
        String password = "password";
        String indirizzo = "Via s. polenta";
        String comune = "Boh";
        String cap = "12345";
        String provincia = "San marino";
        String telefono1 = "1234567890";
        String telefono2 = "1234567890";
        String clinica = "psss";
        String idClinica = "2";

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
        WebElement newClinica = driver.findElement(By.xpath("//input[12]"));
        WebElement newIdClinica = driver.findElement(By.xpath("//input[13]"));
        WebElement newRuolo = driver.findElement(By.xpath("//input[@value='Medico']"));
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
        newClinica.sendKeys(clinica);
        newIdClinica.sendKeys(idClinica);
        newRuolo.click();
        createAccountButton.click();

        WebElement titleSuccesso = driver.findElement(By.tagName("h1"));
        String titleMessageSuccesso = titleSuccesso.getText();
        assertEquals("Username già presente.", titleMessageSuccesso);
        resetRepository();
    }

}
