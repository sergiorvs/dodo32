package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Person;

public interface PersonRepository extends Repository<Person, Long> {
		//its like login
		Person save(Person pers);
		
		@Query("SELECT u FROM Person u WHERE u.username= :usernam  and u.password= :paswd ")
		Person validarLogin(@Param("usernam") String usernam, @Param("paswd") String paswd);
		
		//@Query(value = "SELECT person.id, person.birth_date,person.email, person.first_name, person.last_name, person.username FROM person WHERE person.type_person = ?1",nativeQuery = true)
		@Query(value = "SELECT * FROM person WHERE person.type_person = ?1",nativeQuery = true)
		List<Person> getAllTypePerson(@Param("typePers")Short typePers);
		
		/*
		@Query("SELECT p FROM Person p ")
		List<Person> buscarTodos();
		
		@Query("SELECT p FROM Person p WHERE p.id = :id")
		Person buscarPorId(@Param("id") Long id);
		
		 */
		
		
		
		
		
		/* ROLO LO COMENTO
		@Query("SELECT p FROM Person p WHERE p.id = :id_persona")
		Person BuscarPersonasPorId(@Param("id_persona") Long id_persona);
		
		@Query("SELECT p.id, p.typePerson FROM Person p WHERE p.email = :email_send AND p.password =: pass_send")
		Person SearchForEmailPasswd(@Param("email_send") String email_send, @Param("pass_send") String pass_send);
		*/
}
