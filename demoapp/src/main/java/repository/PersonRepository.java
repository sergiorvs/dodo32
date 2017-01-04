package repository;

import java.util.List;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import domain.Person;

public interface PersonRepository {
	Person save(Person pers);
	
	@Query("SELECT p FROM Person p ")
	List<Person> buscarTodos();
	
	@Query("SELECT p FROM Person p WHERE p.id = :id")
	Person buscarPorId(@Param("id") Long id);
	
	@Query("SELECT p FROM Person p WHERE p.id = :id_persona")
	Person BuscarPersonasPorId(@Param("id_persona") Long id_persona);
	
	@Query("SELECT p.id, p.typePerson FROM Person p WHERE p.email = :email_send AND p.password =: pass_send")
	Person SearchForEmailPasswd(@Param("email_send") String email_send, @Param("pass_send") String pass_send);
	
}