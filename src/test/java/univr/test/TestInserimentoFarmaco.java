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
;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class TestInserimentoFarmaco extends BaseTest {

    @Test
    public void testInserimentoFarmaco() throws ParseException {

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

        WebElement codFiscalePazienteInput = driver.findElement(By.xpath("/html/body/form[1]/input[1]"));
        codFiscalePazienteInput.sendKeys("ACRTTE98L61B256A");

        WebElement visualizzaPazienteButton = driver.findElement(By.xpath("/html/body/form[1]/input[3]"));
        visualizzaPazienteButton.click();

        WebElement inserisciFarmacoButton = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[16]/a"));
        inserisciFarmacoButton.click();


        String idFarmaco = "TCP";
        String nomeFarmaco = "Tachipirina";
        String doseAlGiorno = "1";
        String numeroGiorni = "20";
        String costo = "12";


        WebElement newIdFarmaco = driver.findElement(By.xpath("//input[@name='idFarmaco']"));
        WebElement newNome = driver.findElement(By.xpath("//input[@name='nome_farmaco']"));
        WebElement newDose = driver.findElement(By.xpath("//input[@name='dose']"));
        WebElement newGiorni = driver.findElement(By.xpath("//input[@name='numGiorni']"));
        WebElement newCosto = driver.findElement(By.xpath("//input[@name='costo']"));
        WebElement createFarmacoButton = driver.findElement(By.xpath("//input[@type='submit']"));


        newIdFarmaco.sendKeys(idFarmaco);
        newNome.sendKeys(nomeFarmaco);
        newDose.sendKeys(doseAlGiorno);
        newGiorni.sendKeys(numeroGiorni);
        newCosto.sendKeys(costo);
        createFarmacoButton.click();

        WebElement titleSuccesso = driver.findElement(By.tagName("h1"));
        String titleMessageSuccesso = titleSuccesso.getText();
        assertEquals("Farmaco inserito correttamente!", titleMessageSuccesso);

        resetRepository();
    }
}
