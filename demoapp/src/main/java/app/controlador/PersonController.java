package app.controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.dominio.Manager;
import app.dominio.Person;
import app.dominio.Project;
import app.dominio.Task;
import app.dominio.Theme;
import app.dominio.UserProgmmr;
import app.servicio.ManagerService;
import app.servicio.PersonService;
import app.servicio.ProjectService;
import app.servicio.TaskService;
import app.servicio.ThemeService;
import app.servicio.UserProgrammerService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	UserProgrammerService userprogService;
	
	@Autowired
	ProjectService projService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ThemeService themeService;
	
	Person person;
	Manager manager;
	UserProgmmr programmer;
	Project project;
	Map<String, Object> params = new HashMap<>();
	Map referenceData = new HashMap();
	
	
	@PostMapping("/startpage")  //PARA METODO=POST en el form de home.twig.html 
	String validarUsuario(String usernam, String paswd, ModelMap model){
		person = personService.validarUsuario(usernam,paswd);
		if(person!=null){
			 
			 params.put("person", person);
			 
			if (person.typePerson == 1 ){ //manager = 1 
				manager = managerService.findManager(person.getId());
				params.put("manager",manager);
				//model.addAttribute("person",person);
				model.addAllAttributes(params);
 				return "manager";
			}
			else {	//programmer = 2
				programmer = userprogService.findProgrammer(person.getId());
				params.put("programmer", programmer);
				model.addAttribute("person",person);  
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
	
	@PostMapping("/user_register") //user_register  
	String formuserReg(String firstn, String lastn, String mailpers, String userna, String paswd, String personCode){
		Person person1 = personService.registertype(firstn, lastn, mailpers, userna, paswd, personCode);
		return "home";
	}
	
	@RequestMapping(value = "/manprojects", method = RequestMethod.GET)
	String manprojects(ModelMap model){
	//model.addAttribute("person",person);
	//model.addAllAttributes(params);
	params.put("projects", projService.findAllProjects(manager));
	model.addAllAttributes(params);
	//model.addAttribute("projects", projService.findAllProjects(manager.getId()));
	return "manprojects";
	}
	
	@RequestMapping(value = "/man_create_project", method = RequestMethod.GET)
	String createProj(ModelMap model){
		//model.addAttribute("person",person);
		model.addAllAttributes(params);
		return "man_create_project";
	}
	
	
	@PostMapping("/form_create_project")
	String mancreateproj(String pname, String dname, ModelMap model){		
		Project proj = projService.save_project(pname, dname, manager.getId());
		//model.addAttribute("person",person);
		params.put("projects", projService.findAllProjects(manager));
		model.addAllAttributes(params);
	return "manprojects";
	}
	
	@RequestMapping(value = "/open_project", method = RequestMethod.GET)
	String mandetailproj(ModelMap model, Long proj){
		project = projService.findById(proj);
		params.put("project", project);
		model.addAllAttributes(params);
	return "mandetailproj";
	}
	
	@RequestMapping(value="/man_addTheme",method = RequestMethod.GET)
	String manaddtheme(ModelMap model){
	return "man_add_theme";
	}
	
	
	@PostMapping("/manaddtheme")
	String manbackfromtheme(String newtheme, ModelMap model){
		Theme theme = themeService.AddTheme(newtheme);
	return "mandetailproj";
	}
	
	@RequestMapping(value = "/man_create_task", method = RequestMethod.GET)
	String mancreatetask(ModelMap model){
		List<Theme> themes = themeService.findAll();
		List<Person> programmers = personService.getAllTypePerson((short) 2);
		params.put("themes",themes);
		params.put("programmers",programmers);		
		model.addAllAttributes(params);
	return "man_create_task";
	}
	
	@PostMapping("/form_create_task")
	String formcreatetask(HttpServletRequest request, String taskname, String taskdescript, Long taskprogrammer, Date stardate, Date deadlinedate, String[] selectthemes, ModelMap model){
		String[] sthemes = request.getParameterValues("selectthemes");   //Get all checkboxes checked in the form
		Task task = taskService.AddTask(taskname, taskdescript, taskprogrammer, stardate, deadlinedate, sthemes, project.getId(),manager.getId());
		model.addAllAttributes(params);
		return "mandetailproj";
	}
	
	@RequestMapping(value = "/man_delete_task", method = RequestMethod.GET)
	String mandeletetask(ModelMap model){
		List<Task> pendingtasks = taskService.findPendingTask();
		params.put("pendingtasks", pendingtasks);
		model.addAllAttributes(params);
	return "man_delete_task";
	}
	
	@RequestMapping(value = "/delete_task", method = RequestMethod.GET) 
	//@PostMapping("/delete_task")
	String delete_task(HttpServletRequest request, String[] selecttasks, ModelMap model){
		String[] stasks = request.getParameterValues("selecttasks");
		taskService.deleteTaskById(stasks);
		model.addAllAttributes(params);
		return "man_delete_task";
	}
	
	
	/*	 Programmer's Pages */
	
	@RequestMapping(value = "/userprojects", method = RequestMethod.GET)
	String userprojects(ModelMap model){
		List<Project> projects = projService.findProgrammersProjects(programmer.getId());
		params.put("projects", projects);
		model.addAllAttributes(params);
	return "userprojects";
	}
	
	@RequestMapping(value="/user_detail_project",method = RequestMethod.GET)
	String userDetailProjects(Long usproj,  ModelMap model){
		project = projService.findById(usproj);
		params.put("project", project);
		model.addAllAttributes(params);
		return "usertasks";
	}
	
	
	
}
