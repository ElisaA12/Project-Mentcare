package univr.utils;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import univr.*;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

        @Autowired
        private PazienteRepository pazienteRepository;
        @Autowired
        PersonaleMedicoRepository personaleMedicoRepository;
        @Autowired
        private FarmaciRepository farmaciRepository;
        @Autowired
        private AppuntamentoRepository appuntamentoRepository;
        protected static WebDriver driver;
        protected static String URL = "http://localhost:8080";
        @Before
        public void setUp() {
            org.openqa.selenium.chrome.ChromeOptions chrome_options = new ChromeOptions();
            //chrome_options.addArguments("--headless");
            if(SystemUtils.IS_OS_WINDOWS){
                System.setProperty("webdriver.chrome.driver",
                        Paths.get("src/test/resources/chromedriver_win32_96/chromedriver.exe").toString());
            }
            else if (SystemUtils.IS_OS_MAC){
                System.setProperty("webdriver.chrome.driver",
                        Paths.get("src/test/resources/chromedriver_mac64_96/chromedriver").toString());
            }
            else if (SystemUtils.IS_OS_LINUX){
                System.setProperty("webdriver.chrome.driver",
                        Paths.get("src/test/resources/chromedriver_linux64_96/chromedriver").toString());
            }
            if (driver == null)
                driver = new ChromeDriver(chrome_options);
            driver.get(URL);
        }
        @After
        public void tearDown() {
            if (driver != null) {
                //driver.quit();
            }
        }
        public void setUpRepository() throws ParseException {
            personaleMedicoRepository.save(new PersonaleMedico("ACRTTE98L61B256R", "nome", "cognome", "receptionist", "password", "indirizzo","comune", 2, "provincia", 123L, 23L, "Receptionist", "clinica", 12L,1L));
            personaleMedicoRepository.save(new PersonaleMedico("ACRTTE98L61B256M", "nome", "cognome", "medico", "password", "indirizzo","comune", 2, "provincia", 123L, 23L, "Medico", "clinica", 12L,1L));
            personaleMedicoRepository.save(new PersonaleMedico("ACRTTE98L61B256I", "nome", "cognome", "infermiere", "password", "indirizzo","comune", 2, "provincia", 123L, 23L, "Infermiere", "clinica", 12L,1L));
            pazienteRepository.save(new Paziente("ACRTTE98L61B256A","nome","cognome", "pazienteAuto", "password", "indirizzo","comune", 2, "provincia", 123L, 23L,"joker","boh", true,"ACRTTE98L61B256M"));
            pazienteRepository.save(new Paziente("ACRTTE98L61B256N","nome","cognome", "pazienteNonAuto", "password", "indirizzo","comune", 2, "provincia", 123L, 23L,"joker","boh", true,"ACRTTE98L61B256M"));
            farmaciRepository.save(new Farmaci("ACRTTE98L61B256A","id1","farmaco",1,20,null,false,20,"SSRTTE98L61B256I"));
            farmaciRepository.save(new Farmaci("ACRTTE98L61B256N","id2","farmacoCompleto",2,1,null,false,20,"ACRTTE98L61B256I"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = dateFormat.parse("2020-10-21");
            Date data1 = dateFormat.parse("2020-11-21");
            Date data2 = dateFormat.parse("2020-12-21");
            appuntamentoRepository.save(new Appuntamento("ACRTTE98L61B256N","ACRTTE98L61B256M","nome","cognome","nome","cognome",1L,data , "indirizzoclinica", "portare"));
            appuntamentoRepository.save(new Appuntamento("ACRTTE98L61B256N","ACRTTE98L61B256M","nome","cognome","nome","cognome",1L,data1 , "indirizzoclinica", "portare"));
            appuntamentoRepository.save(new Appuntamento("ACRTTE98L61B256N","ACRTTE98L61B256M","nome","cognome","nome","cognome",1L,data2 , "indirizzoclinica", "portare"));

        }
    public void resetRepository() {
        personaleMedicoRepository.deleteAll();
        pazienteRepository.deleteAll();
        farmaciRepository.deleteAll();
        appuntamentoRepository.deleteAll();
    }
}


