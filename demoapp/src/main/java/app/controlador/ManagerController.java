package app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.servicio.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	ManagerService managerService;
	
	/*
	@RequestMapping(value = "/manprojects", method = RequestMethod.GET)
	String manprojects(ModelMap model){
	return "manprojects";
	}*/
}
