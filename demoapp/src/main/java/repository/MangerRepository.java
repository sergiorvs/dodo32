package repository;

import java.util.List;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import domain.Manager;

public interface MangerRepository extends Repository<Manager, Long> {
	Manager save(Manager manag);
	
	@Query("SELECT m FROM Manager m ")
	List<Manager> buscarTodos();
	
	@Query("SELECT m FROM Manager m WHERE m.id = :id")
	Manager buscarPorId(@Param("id") Long id);
	
	@Query("SELECT m FROM Manager m ")
	Collection<Manager> ColeccionManagers();

	@Query("SELECT M FROM Manager m WHERE m.id = :id_persona")
	Manager BuscarPersonasPorId(@Param("id_persona") Long id_persona);
}
