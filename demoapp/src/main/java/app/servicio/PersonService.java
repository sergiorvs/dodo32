package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Person;
import app.repositorio.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Transactional
	public void save(Person pers) {
		personRepository.save(pers);
	}
	
	public Person validarUsuario(String usernam, String paswd){
		return personRepository.validarLogin(usernam, paswd);
	} 
	/*

	public Person get(Long id) {
		return personRepository.buscarPorId(id);
	}
	
	public List<Person> getTodos(){
		return personRepository.buscarTodos(); 
	}
	
	
	*/
}
