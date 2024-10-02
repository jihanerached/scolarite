package com.ensias.scolarite.cours;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface CoursRepository extends CrudRepository<Cours, Integer>{
//en plus des méthodes implémentées par défaut au niveau de la classe CrudRepository, nous
    //pouvons définir d’autres en cas de besoin tel que c’est le cas ici
    public List<Cours> findByModuleId(Integer moduleId);
}
