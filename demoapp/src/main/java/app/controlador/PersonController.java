package app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.dominio.Person;
import app.servicio.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value= "/validar-usuario",method = RequestMethod.GET)
	String validarUsuario(@RequestParam(required = true) String usernam, @RequestParam(required = true) String paswd, ModelMap model){
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
	

}
