package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Manager;
import app.dominio.Project;


public interface ProjectRepository extends Repository<Project, Long>{
	Project save(Project proj);
	
	//SELECT P.name, P.description FROM project P JOIN(SELECT man_has_proj.proj_id FROM man_has_proj WHERE (man_has_proj.man_id = 2) ) AS mj ON P.id = mj.proj_id
	
	@Query(value="SELECT * FROM project P JOIN(SELECT man_has_proj.proj_id FROM man_has_proj WHERE (man_has_proj.man_id = ?1) ) AS mj ON P.id = mj.proj_id", nativeQuery = true)
	List<Project> findAllProj(Manager idman);
	
	@Query("SELECT p FROM Project p WHERE p.id= :projid)")
	Project findById(@Param("projid")Long projid);
	
	//Use Programmer
	
	@Query(value="SELECT * FROM project P JOIN (SELECT Task.project_id  FROM Task WHERE (Task.user_progmmr_id = ?1) ) AS Pid ON P.id=Pid.project_id", nativeQuery = true)
	List<Project> findProgrammersProjects(@Param("usprog")Long usprog); 

}