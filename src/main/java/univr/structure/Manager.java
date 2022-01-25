package univr.structure;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import univr.PersonaleMedico;

public interface Manager {

    String loginManager();
    String logManager(String key, Model model);
    String nuovoPersonale( Model model);
    String createAccPersonale( @ModelAttribute PersonaleMedico personale);
    String mostraPersonale(String codPersonale, Model model);
}