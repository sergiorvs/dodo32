package app.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.collections.impl.Vector;
import app.dominio.Theme;
import app.dominio.UserProgmmr;
import app.repositorio.ManagerRepository;

@Controller
public class ManagerController {

	@Autowired
	ManagerRepository managerrepository;
	
	
	List<Long> th;
	
	
	/*
	@RequestMapping(value = "/manprojects", method = RequestMethod.GET)
	String manprojects(ModelMap model){
	return "manprojects";
	}*/
	
	
    Long promediar_array(Long[] a)
	{
		Long prom=0L;
		for(int i=0;i<a.length;i++)
		{
			prom+=a[i];
		}
		return (prom/a.length);
	}
    
    /*@RequestMapping(value = "/manuserproglist", method = RequestMethod.GET)
    String solicitar_temas(ModelMap model)
    {
    	///falta agregar id de los temas al vector
    	//for...
    		//th.add(managerrepository.find_id_theme([arreglo con nombre de temas seleccionados][i]));
    	return "manuserproglist";
    }*/
    
	
	@PostMapping("/man_prog_rank")
	String mostrar_ranking_prog(ModelMap model)
	{
		th.add(1L);//momentario hasta que sepa como recolectar los temas
		th.add(2L);//momentario hasta que sepa como recolectar los temas
		List<UserProgmmr> prog = managerrepository.AllProgramers();
		Long[] scoreaux = new Long[th.size()];
		Long[] score = new Long[prog.size()];
		//Long scpreaux[]
		for(int i=0 ; i<prog.size() ; i++)
		{
			for(int j=0 ; j<th.size() ; j++)
			{
				scoreaux[j] = managerrepository.find_score_by_programmer(prog.get(i).getId() , th.get(i) );
			}
			score[i]=promediar_array(scoreaux);
		}
		/////////////////ordenando arreglos/////////////////////////////
		
		Long aux_score;
		UserProgmmr aux_prog;
		boolean v=false;
		while(true)
		{
			v=false;
			for(int i=1;i<score.length;i++)
			{
				if(score[i]>score[i-1])
				{
					aux_score=score[i];
					aux_prog=prog.get(i);
					
					score[i]=score[i-1];
					score[i-1]=aux_score;
					
					prog.set(i , prog.get(i-1));
					prog.set(i-1, aux_prog);
					v=true;
				}
			}
			if(v==false) break;
		}
		
		//////////////////////////////////////////////////////////////
			
		model.addAttribute("programer",prog);
		model.addAttribute("score",score);
		return "man_prog_rank";		
	}
}
