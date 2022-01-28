package univr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import univr.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitTest {

    @Autowired
    PazienteRepository pazienteRepository;

    @Autowired
    PersonaleMedicoRepository personaleMedicoRepository;
    @Test
    public void CreazionePaziente() throws Exception {
        Paziente paziente = new Paziente("paz","nome","cognome",
                "paziente", "password", "indirizzo","comune", 2,
                "provincia", 123L, 23L,"joker","boh",
                true,"med");
        assertEquals("paz", paziente.getCodFiscale());
        assertEquals("nome", paziente.getNome());
        assertEquals("cognome", paziente.getCognome());
        assertEquals("paziente", paziente.getUsername());
        assertEquals("password", paziente.getPassword());
        assertEquals("indirizzo", paziente.getIndirizzo());
        assertEquals("comune", paziente.getComune());
        assertEquals(2, paziente.getCap());
        assertEquals("provincia", paziente.getProvincia());
        assertEquals(Long.valueOf(123L), paziente.getTelefono1());
        assertEquals(Long.valueOf(23L), paziente.getTelefono2());
        assertEquals("joker", paziente.getPatologia());
        assertEquals("boh", paziente.getDescrizione());
        assertTrue(paziente.isAutosufficiente());
        assertEquals("med", paziente.getCodiceMedico());
    }

    @Test
    public void ModificaPaziente() throws Exception {
        Paziente paziente = new Paziente("paz","nome","cognome",
                "paziente", "password", "indirizzo","comune", 2,
                "provincia", 123L, 23L,"joker","boh",
                true,"med");
        paziente.setCodFiscale("paz2");
        paziente.setNome("Elisa");
        paziente.setCognome("Giulio");
        paziente.setUsername("user2");
        paziente.setPassword("passssword");
        paziente.setIndirizzo("via s.polenta");
        paziente.setComune("Perugia");
        paziente.setCap(37134);
        paziente.setProvincia("PG");
        paziente.setTelefono1(3386135044L);
        paziente.setTelefono2(3326135044L);
        paziente.setPatologia("joker");
        paziente.setDescrizione("malattia");
        paziente.setAutosufficiente(false);
        paziente.setCodiceMedico("medico2");

        assertEquals("paz2", paziente.getCodFiscale());
        assertEquals("Elisa", paziente.getNome());
        assertEquals("Giulio", paziente.getCognome());
        assertEquals("user2", paziente.getUsername());
        assertEquals("passssword", paziente.getPassword());
        assertEquals("via s.polenta", paziente.getIndirizzo());
        assertEquals("Perugia", paziente.getComune());
        assertEquals(37134, paziente.getCap());
        assertEquals("PG", paziente.getProvincia());
        assertEquals(Long.valueOf(3386135044L), paziente.getTelefono1());
        assertEquals(Long.valueOf(3326135044L), paziente.getTelefono2());
        assertEquals("joker", paziente.getPatologia());
        assertEquals("malattia", paziente.getDescrizione());
        assertFalse(paziente.isAutosufficiente());
        assertEquals("medico2", paziente.getCodiceMedico());
    }

    @Test
    public void CreazionePersonaleMedico() throws Exception {
        PersonaleMedico personaleMedico = new PersonaleMedico("medic", "nome", "cognome",
                "medico2", "password", "indirizzo","comune", 2,
                "provincia", 123L, 23L, "Medico", "clinica",
                12L, 1L);

        assertEquals("medic", personaleMedico.getCodFiscale());
        assertEquals("nome", personaleMedico.getNome());
        assertEquals("cognome", personaleMedico.getCognome());
        assertEquals("medico2", personaleMedico.getUsername());
        assertEquals("password", personaleMedico.getPassword());
        assertEquals("indirizzo", personaleMedico.getIndirizzo());
        assertEquals("comune", personaleMedico.getComune());
        assertEquals(2, personaleMedico.getCap());
        assertEquals("provincia", personaleMedico.getProvincia());
        assertEquals(Long.valueOf(123L), personaleMedico.getTelefono1());
        assertEquals(Long.valueOf(23L), personaleMedico.getTelefono2());
        assertEquals("Medico", personaleMedico.getRuolo());
        assertEquals("clinica", personaleMedico.getClinica());
        assertEquals(Long.valueOf(12L), personaleMedico.getIdClinica());
        assertEquals(Long.valueOf(1L), personaleMedico.getAmbulatorio());
    }

    @Test
    public void ModificaPersonaleMedico() throws Exception {
        PersonaleMedico personaleMedico = new PersonaleMedico("med", "Giulio", "Elisa",
                "gcea", "passworddd", "indirizzo1","Gualdo Tadino", 06023,
                "PG", 334512630L, 2334512630L, "Medico", "clinica2",
                12L, 1L);

        personaleMedico.setCodFiscale("medic");
        personaleMedico.setNome("nome");
        personaleMedico.setCognome("cognome");
        personaleMedico.setUsername("medico2");
        personaleMedico.setPassword("password");
        personaleMedico.setIndirizzo("indirizzo");
        personaleMedico.setComune("comune");
        personaleMedico.setCap(2);
        personaleMedico.setProvincia("provincia");
        personaleMedico.setTelefono1(123L);
        personaleMedico.setTelefono2(23L);
        personaleMedico.setRuolo("Medico");
        personaleMedico.setClinica("clinica");
        personaleMedico.setIdClinica(12L);
        personaleMedico.setAmbulatorio(1L);

        assertEquals("medic", personaleMedico.getCodFiscale());
        assertEquals("nome", personaleMedico.getNome());
        assertEquals("cognome", personaleMedico.getCognome());
        assertEquals("medico2", personaleMedico.getUsername());
        assertEquals("password", personaleMedico.getPassword());
        assertEquals("indirizzo", personaleMedico.getIndirizzo());
        assertEquals("comune", personaleMedico.getComune());
        assertEquals(2, personaleMedico.getCap());
        assertEquals("provincia", personaleMedico.getProvincia());
        assertEquals(Long.valueOf(123L), personaleMedico.getTelefono1());
        assertEquals(Long.valueOf(23L), personaleMedico.getTelefono2());
        assertEquals("Medico", personaleMedico.getRuolo());
        assertEquals("clinica", personaleMedico.getClinica());
        assertEquals(Long.valueOf(12L), personaleMedico.getIdClinica());
        assertEquals(Long.valueOf(1L), personaleMedico.getAmbulatorio());
    }

    @Test
    public void CreazioneFarmaco() throws Exception {
        Farmaci farmaci = new Farmaci("paz","id","nome",2,
                31,null,false,20,"med");

        assertEquals("paz", farmaci.getCodPaziente());
        assertEquals("id", farmaci.getIdFarmaco());
        assertEquals("nome", farmaci.getNome_farmaco());
        assertEquals(2, farmaci.getDose());
        assertEquals(31, farmaci.getNumGiorni());
        assertNull(farmaci.getSomministratore());
        assertFalse(farmaci.isSomministrato());
        assertEquals(20, farmaci.getCosto(), 0);
        assertEquals("med", farmaci.getCodMedico());
    }

    @Test
    public void ModificaFarmaco() throws Exception {
        Farmaci farmaci = new Farmaci("paziente","id2","farm",20,
                3,"cppgli",false,20,"medico");

        farmaci.setCodPaziente("paz");
        farmaci.setIdFarmaco("id");
        farmaci.setNome_farmaco("nome");
        farmaci.setDose(2);
        farmaci.setNumGiorni(31);
        farmaci.setSomministratore(null);
        farmaci.setSomministrato(false);
        farmaci.setCosto(20.8);
        farmaci.setCodMedico("med");

        assertEquals("paz", farmaci.getCodPaziente());
        assertEquals("id", farmaci.getIdFarmaco());
        assertEquals("nome", farmaci.getNome_farmaco());
        assertEquals(2, farmaci.getDose());
        assertEquals(31, farmaci.getNumGiorni());
        assertNull(farmaci.getSomministratore());
        assertFalse(farmaci.isSomministrato());
        assertEquals(20.8, farmaci.getCosto(), 0);
        assertEquals("med", farmaci.getCodMedico());
    }

    @Test
    public void CreazioneAppuntamento() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = dateFormat.parse("2020-10-21");

        Appuntamento appuntamento = new Appuntamento("paz", "med", "nome", "cognome",
                "nome", "cognome", 1L, data ,
                "indirizzoclinica", "portare");

        assertEquals("paz", appuntamento.getCodFiscalePaziente());
        assertEquals("med", appuntamento.getCodFiscalePersonale());
        assertEquals("nome", appuntamento.getNomePaziente());
        assertEquals("cognome", appuntamento.getCognomePaziente());
        assertEquals("nome", appuntamento.getNomePersonale());
        assertEquals("cognome", appuntamento.getCognomePersonale());
        assertEquals(Long.valueOf(1L), Long.valueOf(appuntamento.getAmbulatorio()));
        assertEquals(data, appuntamento.getData());
        assertEquals("indirizzoclinica", appuntamento.getIndirizzo());
        assertEquals("portare", appuntamento.getDescrizione());
    }

    @Test
    public void ModificaAppuntamento() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = dateFormat.parse("2020-10-21");
        Date data1 = dateFormat.parse("2020-10-21");
        Appuntamento appuntamento = new Appuntamento("paz2", "med2",
                "Giulio", "Elisa", "Elisa",
                "Giulio", 12L, data1 ,
                "via mastin della scala", "portare ...");

        appuntamento.setCodFiscalePaziente("paz");
        appuntamento.setCodFiscalePersonale("med");
        appuntamento.setNomePaziente("nome");
        appuntamento.setCognomePaziente("cognome");
        appuntamento.setNomePersonale("nome");
        appuntamento.setCognomePersonale("cognome");
        appuntamento.setAmbulatorio(1L);
        appuntamento.setData(data);
        appuntamento.setIndirizzo("indirizzoclinica");
        appuntamento.setDescrizione("portare");

        assertEquals("paz", appuntamento.getCodFiscalePaziente());
        assertEquals("med", appuntamento.getCodFiscalePersonale());
        assertEquals("nome", appuntamento.getNomePaziente());
        assertEquals("cognome", appuntamento.getCognomePaziente());
        assertEquals("nome", appuntamento.getNomePersonale());
        assertEquals("cognome", appuntamento.getCognomePersonale());
        assertEquals(Long.valueOf(1L), Long.valueOf(appuntamento.getAmbulatorio()));
        assertEquals(data, appuntamento.getData());
        assertEquals("indirizzoclinica", appuntamento.getIndirizzo());
        assertEquals("portare", appuntamento.getDescrizione());
    }

    @Test
    public void FarmacoSomministrato() throws Exception {
        FarmaciSomministrati farmaci = new FarmaciSomministrati("paz","id","nome",2,
                31,null,false,20,"med");

        assertEquals("paz", farmaci.getCodPaziente());
        assertEquals("id", farmaci.getIdFarmaco());
        assertEquals("nome", farmaci.getNome_farmaco());
        assertEquals(2, farmaci.getDose());
        assertEquals(31, farmaci.getNumGiorni());
        assertNull(farmaci.getSomministratore());
        assertFalse(farmaci.isSomministrato());
        assertEquals(20, farmaci.getCosto(), 0);
        assertEquals("med", farmaci.getCodMedico());
    }

    @Test
    public void ModificaFarmacoSomministrato() throws Exception {
        FarmaciSomministrati farmaci = new FarmaciSomministrati("paziente","id2","farm",20,
                3,"cppgli",false,20,"medico");

        farmaci.setCodPaziente("paz");
        farmaci.setIdFarmaco("id");
        farmaci.setNome_farmaco("nome");
        farmaci.setDose(2);
        farmaci.setNumGiorni(31);
        farmaci.setSomministratore(null);
        farmaci.setSomministrato(false);
        farmaci.setCosto(20.8);
        farmaci.setCodMedico("med");

        assertEquals("paz", farmaci.getCodPaziente());
        assertEquals("id", farmaci.getIdFarmaco());
        assertEquals("nome", farmaci.getNome_farmaco());
        assertEquals(2, farmaci.getDose());
        assertEquals(31, farmaci.getNumGiorni());
        assertNull(farmaci.getSomministratore());
        assertFalse(farmaci.isSomministrato());
        assertEquals(20.8, farmaci.getCosto(), 0);
        assertEquals("med", farmaci.getCodMedico());
    }

    
        

}
