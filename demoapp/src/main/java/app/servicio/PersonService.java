package app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Person;
import app.repositorio.PersonRepository;


@Service
public class PersonService {
	/*@Autowired
	PersonRepository personRepository;
	
	@Transactional
	public void save(Person Persona) {
		personRepository.save(Persona);
	}

	public Person get(Long id) {
		return personRepository.buscarPorId(id);
	}
	
	public List<Person> getTodos(){
		return personRepository.buscarTodos(); 
	}*/
	
}
