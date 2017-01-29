package app.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Manager;
import app.dominio.Person;
import app.dominio.UserProgmmr;
import app.repositorio.ManagerRepository;
import app.repositorio.PersonRepository;
import app.repositorio.UserRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	UserRepository userprogRepository;
	
	@Transactional
	public void save(Person pers) {
		personRepository.save(pers);
	}
	
	public Person validarUsuario(String usernam, String paswd){
		return personRepository.validarLogin(usernam, paswd);
	} 
	
	@Transactional
	public Person registertype(String firstnam, String lastnam, String mail , String usernam, String paswd, String personCode ){
		
		Person persona1= new Person();
		persona1.setFirstName(firstnam);
		persona1.setLastName(lastnam);
		//persona1.setBirthdate(birthdate);
		persona1.setemail(mail);
		persona1.setUserName(usernam);
		persona1.setPassw(paswd);
		persona1.setType(personCode);
		
		Person p = personRepository.save(persona1);
		
		if ( p.getType()== Short.parseShort("1") ){
			Manager man = new Manager();
			man.setPerson(p);
			managerRepository.save(man);
		}
		else {
			UserProgmmr userpg = new UserProgmmr();
			userpg.setPerson(p);
			userprogRepository.save(userpg);
		}
		
		return p;
	}
	
	
	public List<Person> getAllTypePerson(Short typePerson){
		return personRepository.getAllTypePerson(typePerson);
	}
	
	
	/*public void sendManagerAndPerson(Manager man, Person pers,   ){
		
	}
	*/
	
	/*
	public Person get(Long id) {
		return personRepository.buscarPorId(id);
	}
	
	public List<Person> getTodos(){
		return personRepository.buscarTodos(); 
	}
	
	
	*/
}
