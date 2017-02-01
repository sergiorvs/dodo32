package app.servicio;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dominio.Task;
import app.dominio.TaskHasThemes;
import app.repositorio.TaskRepository;
import app.repositorio.TaskhasThemesRepository;
import app.repositorio.UserProgrammerRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TaskhasThemesRepository taskHasThemesRepository;
	
	@Autowired
	UserProgrammerRepository userProgRepository;
	
	@Transactional
	public void save(Task task){
		taskRepository.save(task);
	}
	
	public List<Task> findAllTask(){
		return taskRepository.findAll();
	}
	
	
	public Task AddTask(String name, String descript, Long usProgmmrId, Date startdate, Date deadlinedate, String[] selectthemes,  Long idproj,Long idman){
		Task task = new Task();
		//TaskHasThemes tht = new TaskHasThemes();
		task.setName(name);
		task.setDescription(descript);
		task.setuserProgmmrId(userProgRepository.findProgrammer(usProgmmrId).getId());		
		task.setStarDate(startdate);
		task.setDeadLineDate(deadlinedate);
		
		//renderFromValue() 
		task.setProjectId(idproj);
		task.setmanagerId(idman);
		Task t_aux = taskRepository.save(task); 
		
		//for(Long theme_ : selectthemes){
		for(int i = 0; i< selectthemes.length ;i++ ){
			//tht.setThemeId(theme_);
			TaskHasThemes tht = new TaskHasThemes();
			tht.setThemeId(Long.parseLong(selectthemes[i]));
			tht.setTaskId(t_aux.getId());	
			taskHasThemesRepository.save(tht);
		}
		return t_aux;
	} 
	
	public List<Task> findPendingTask(){
		return taskRepository.findPendingTask();
	}
	
	public void deleteTaskById(String[] stasks){
		for(int i = 0; i< stasks.length ; i++){		
			taskRepository.deleteTaskById(Long.parseLong(stasks[i]));
		}
	}
	
	
	
}
