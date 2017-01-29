package app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.UserProgmmr;

public interface UserProgrammerRepository extends Repository<UserProgmmr, Long> {
	UserProgmmr save(UserProgmmr userProg);
	
	@Query(value = "SELECT * FROM user_progmmr WHERE user_progmmr.pers_id = ?1", nativeQuery = true)
	UserProgmmr findProgrammer(@Param("idpers")Long idpers);
	
}
