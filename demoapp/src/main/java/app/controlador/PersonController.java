package app.controlador;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.dominio.Person;
import app.servicio.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping("/startpage")  //PARA METODO=POST en el form de home.twig.html 
	String validarUsuario(String usernam, String paswd, ModelMap model){
		Person person = personService.validarUsuario(usernam,paswd);
		if(person!=null){
			if (person.typePerson == 1 ){ //manager = 1 
				model.addAttribute("person",person);  //("manager",person);
 				return "manager";
			}
			else {	//programmer = 2
				model.addAttribute("person",person);  //("userprog",person);
				return "userprog";
			}
		}
		else {
			System.out.println("noexisteuser");
			return "home";
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)		
	String register(ModelMap model){
	return "register";
	}
	
	@PostMapping("/user_register")  
	String formuserReg(String firstn, String lastn, String mailpers, String userna, String paswd, String personCode){
		Person person1 = personService.registertype(firstn, lastn, mailpers, userna, paswd, personCode);
		return "home";
	}
	

}
