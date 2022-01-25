package univr.structure;

import org.springframework.ui.Model;

public interface PazienteNonAutoSufficiente extends Paziente{

    String mostraFarmaci(String codPaziente, String codPersonale, Model model);

}