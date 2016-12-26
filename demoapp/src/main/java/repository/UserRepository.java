package repository;

import java.util.List;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import domain.UserProgmmr;


public interface UserRepository {
	UserProgmmr save(UserProgmmr usr);
	
	@Query("SELECT m FROM UserProgmmr m ")
	List<UserProgmmr> buscarTodos();
	
	@Query("SELECT m FROM UserProgmmr m WHERE m.id = :id")
	UserProgmmr buscarPorId(@Param("id") Long id);
	
	@Query("SELECT m FROM UserProgmmr m ")
	Collection<UserProgmmr> ColeccionUserProgmmrs();

	@Query("SELECT m FROM UserProgmmr m WHERE m.id = :id_persona")
	UserProgmmr BuscarPersonasPorId(@Param("id_persona") Long id_persona);
}
