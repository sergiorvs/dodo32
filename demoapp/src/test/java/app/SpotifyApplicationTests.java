package app;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.dominio.Person;
import app.repositorio.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotifyApplicationTests {
	
	@Autowired
	PersonRepository personrepository;

	@Test
	public void test() {
		short num;
		num = 2;
		Person persona1= new Person();
		persona1.setFirstName("Ximena");
		persona1.setLastName("Pocco");
		persona1.setBirthdate(new Date());
		persona1.setemail("ximena@gmail.com");
		persona1.setPassw("123");
		persona1.setType(num);
		
		Person p = personrepository.save(persona1);
	}
	
}
