package univr;

import org.springframework.data.repository.CrudRepository;


public interface PazienteRepository extends CrudRepository<Paziente, Long> {
    Paziente findByCodFiscale(String codFiscale);
    Paziente findByUsername(String username);
}
