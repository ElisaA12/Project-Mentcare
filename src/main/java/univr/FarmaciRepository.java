package univr;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FarmaciRepository extends CrudRepository<Farmaci, Long>  {
        List<Farmaci> findByCodPaziente(String codPaziente);
        Farmaci findByIdFarmaco(String idFarmaco);

}
