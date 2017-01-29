package app.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dominio.Task;
import app.repositorio.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Transactional
	public void save(Task task){
		taskRepository.save(task);
	}
	
	public List<Task> findAllTask(){
		return taskRepository.findAll();
	}
	
	public Task AddTask(String name,String descript){
		Task task = new Task();
		task.setName(name);
		task.setDescription(descript);
		return taskRepository.save(task);
	} 
	
}
