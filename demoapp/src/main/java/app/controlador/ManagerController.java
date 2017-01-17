package app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.servicio.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	ManagerService managerService;
}
