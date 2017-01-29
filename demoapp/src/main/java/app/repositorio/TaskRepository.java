package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import app.dominio.Project;
import app.dominio.Task;

public interface TaskRepository extends Repository<Task, Long> {
	Task save(Task task);
	
	@Query("SELECT t FROM Task t")
	List<Task> findAll();
}
