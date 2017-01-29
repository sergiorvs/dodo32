package app.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import app.dominio.Man_has_Proj;
import app.dominio.Manager;
import app.dominio.Project;
import app.repositorio.ManhasprojRepository;
import app.repositorio.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ManhasprojRepository manhasproRepository;
	
	@Transactional
	public void save(Project proj){
		projectRepository.save(proj);
	}
	
	public Project save_project(String name, String descript, Long manId){
		Project proj = new Project();
		proj.setName(name);
		proj.setDescript(descript);
				
		Man_has_Proj mhp = new Man_has_Proj();
		mhp.setManId(manId);
	
		Project proj1 = projectRepository.save(proj);
		
		mhp.setProjId(proj1.getId());
		
		manhasproRepository.save(mhp);
		
		return proj1;
		
	}	
	
	public List<Project> findAllProjects(Manager idman){
		return projectRepository.findAllProj(idman);
	}
	
	public Project findById(Long projid){
		return projectRepository.findById(projid);
	}
}
