package app;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.dominio.Manager;
import app.dominio.Person;
import app.repositorio.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstTest {
	
	@Autowired
	PersonRepository personrepository;

	@Test
	public void test() {
		
		Person persona1= new Person();
		persona1.setFirstName("Sofia");
		persona1.setLastName("Pocco");
		persona1.setBirthdate(new Date());
		persona1.setUserName("sofia4396");
		persona1.setemail("sofia96@gmail.com");
		persona1.setPassw("789");
		persona1.setType("AVBS1");
		
		Person p = personrepository.save(persona1);
		
		
		
	}
	
}
