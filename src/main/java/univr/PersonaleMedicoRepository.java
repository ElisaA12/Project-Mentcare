package univr;

import org.springframework.data.repository.CrudRepository;

public interface PersonaleMedicoRepository extends CrudRepository<PersonaleMedico, Long> {

    PersonaleMedico findByUsername(String username);
    PersonaleMedico findByCodFiscale(String codFiscale);
}
