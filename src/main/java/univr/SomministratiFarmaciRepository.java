package univr;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SomministratiFarmaciRepository extends CrudRepository<FarmaciSomministrati, Long>{
    List<FarmaciSomministrati> findByIdFarmaco(String idFarmaco);

}