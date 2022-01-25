package univr.structure;

import org.springframework.ui.Model;

public interface Paziente extends Utente {

    String farmaciDaSomministrare(String codiceFiscalePaziente, String codiceFiscalePersonale, Model model);
    String farmaciSomministrati(String codPaziente, Model model);

}