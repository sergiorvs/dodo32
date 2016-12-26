package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(ModelMap model) {
	return "home";
}
	
	// Borrar los que estan a continuacion si o si
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	String manager(ModelMap model){
	return "manager";
	}

	@RequestMapping(value = "/userprog", method = RequestMethod.GET)
	String userprog(ModelMap model){
	return "userprog";
	}
	
	@RequestMapping(value = "/manprojectlist", method = RequestMethod.GET)
	String manprojectlist(ModelMap model){
	return "manprojectlist";
	}
	
	@RequestMapping(value = "/form_create_project", method = RequestMethod.GET)
	String formcreateproj(ModelMap model){
	return "form_create_project";
	}
	
	@RequestMapping(value = "/manuserproglist", method = RequestMethod.GET)
	String manuserproglist(ModelMap model){
	return "manuserproglist";
	}
	
}
