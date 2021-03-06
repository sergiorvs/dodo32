package app.controlador;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpotifyController {
	  														 //Post: para crear, actualizar, eliminar datos del lado del servidor
	@RequestMapping(value = "/", method = RequestMethod.GET) //Get : recupera datos del lado del servidor
	String home(ModelMap model) {
	return "home";
	}
	
	// Borrar los que estan a continuacion si o si
	/*
		@RequestMapping(value = "/register", method = RequestMethod.GET)		
		String register(ModelMap model){
		return "register";
		}
		
		@PostMapping("/user_register")
		String formuserReg(String firstnam, String lastnam,  Date birthdate, String mail , String usernam, String paswd, String personCode, ModelMap model ){
			
			return "";
		}
		
		@RequestMapping(value = "/manager", method = RequestMethod.GET)
		String manager(ModelMap model){
		return "manager";
		}

		
		@RequestMapping(value = "/manprojects", method = RequestMethod.GET)
		String manprojects(ModelMap model){
		return "manprojects";
		}
		
		@RequestMapping(value = "/man_create_project", method = RequestMethod.GET)
		String mancreateproj(ModelMap model){
		return "man_create_project";
		}
		
		@RequestMapping(value = "/mandetailproj", method = RequestMethod.GET)
		String mandetailproj(ModelMap model){
		return "mandetailproj";
		}
		
		@RequestMapping(value = "/man_create_task", method = RequestMethod.GET)
		String mancreatetask(ModelMap model){
		return "man_create_task";
		}
		
		@RequestMapping(value = "/man_add_theme", method = RequestMethod.GET)
		String mancreatetask(ModelMap model){
		return "man_add_theme";
		}
		
		@RequestMapping(value = "/man_delete_task", method = RequestMethod.GET)
		String mandeletetask(ModelMap model){
		return "man_delete_task";
		}
		
		//User Programmer
		
		@RequestMapping(value = "/userprog", method = RequestMethod.GET)
		String userprog(ModelMap model){
		return "userprog";
		}	
		
		
		@RequestMapping(value = "/userprojects", method = RequestMethod.GET)
		String userprojects(ModelMap model){
		return "userprojects";
		}
		
		@RequestMapping(value = "/manmeetinglist", method = RequestMethod.GET)
		String manmeetinglist(ModelMap model){
		return "manmeetinglist";
		}
		
		@RequestMapping(value = "/man_create_meeting", method = RequestMethod.GET)
		String mancreatemeeting(ModelMap model){
		return "man_create_meeting";
		}
		
	*/	
		
	
		@RequestMapping(value = "/manuserproglist", method = RequestMethod.GET)
		String manuserproglist(ModelMap model){
		return "manuserproglist";
		}
							
		
		@RequestMapping(value = "/mandetailpendtask", method = RequestMethod.GET)
		String mandetailpendtask(ModelMap model){
		return "mandetailpendtask";
		}
		
		@RequestMapping(value = "/mandetailcomptask", method = RequestMethod.GET)
		String mandetailcomptask(ModelMap model){
		return "mandetailcomptask";
		}	
		
		@RequestMapping(value = "/man_prog_rank", method = RequestMethod.GET)
		String manprogrank(ModelMap model){
		return "man_prog_rank";
		}
		
		
		
		
		
			

		@RequestMapping(value = "/usermeetings", method = RequestMethod.GET)
		String usermeetings(ModelMap model){
		return "usermeetings";
		}
		
		@RequestMapping(value = "/usermeetiopt", method = RequestMethod.GET)
		String usermeetiopt(ModelMap model){
		return "usermeetiopt";
		}
		
		@RequestMapping(value = "/useraddopt", method = RequestMethod.GET)
		String useraddopt(ModelMap model){
		return "useraddopt";
		}
		
		
		
		@RequestMapping(value = "/usertasks", method = RequestMethod.GET)
		String usertasks(ModelMap model){
		return "usertasks";
		}
		
		@RequestMapping(value = "/userdetailpendtask", method = RequestMethod.GET)
		String userdetailpendtask(ModelMap model){
		return "userdetailpendtask";
		}
		
		@RequestMapping(value = "/userdetailcomptask", method = RequestMethod.GET)
		String completedlist(ModelMap model){
		return "userdetailcomptask";
		}
		
		@RequestMapping(value = "/user_score", method = RequestMethod.GET)
		String userscore(ModelMap model){
		return "user_score";
		}
		
}


