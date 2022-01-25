package univr.structure;

import org.springframework.ui.Model;

public interface Utente {

    String login();
    String loginP(String username, String password, Model model);
    String loggout();
    String mostraAppuntamento(String codiceFiscalePersonale, String codiceFiscalePaziente, Model model);

}