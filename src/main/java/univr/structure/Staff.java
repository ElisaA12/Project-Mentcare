package univr.structure;

import org.springframework.ui.Model;

public interface Staff extends Utente {

    String visualizzaPaziente(String codiceFiscalePersonale, String codiceFiscalePaziente, Model model);

    String farmaciDaSomministrare(String codiceFiscalePaziente, String codiceFiscalePersonale, Model model);

    String farmaciSomministrati(String codPaziente, Model model);

}