package univr.structure;

import org.springframework.ui.Model;
import univr.Appuntamento;

public interface Receptionist {

    String inserisciAppuntamento(String codPersonale, String codPaziente, Model model);
    String inserisciApp(Appuntamento appuntamento);

}