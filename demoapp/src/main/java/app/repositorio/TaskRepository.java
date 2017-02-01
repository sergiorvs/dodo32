package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Task;	

public interface TaskRepository extends Repository<Task, Long> {
	Task save(Task task);
	
	@Query("SELECT t FROM Task t")
	List<Task> findAll();
	
	@Query(value="SELECT * FROM TASK WHERE task.act_pend= true",nativeQuery = true)
	List<Task> findPendingTask();
	
	@Query(value="DELETE FROM TASK WHERE task.id=?1", nativeQuery = true)
	void deleteTaskById(@Param("taskId")Long taskId );

}
