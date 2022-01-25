package univr.structure;

import org.springframework.ui.Model;
import univr.Paziente;

public interface Medico extends Staff{

    String mostraFarmaci(String codPaziente, String codPersonale, Model model);
    String inserisciFarmaco(String codPaziente, String codPersonale, Model model);
    String nuovoPaziente(String codPersonale, Model model);
    String create(Paziente paziente, Model model);



}