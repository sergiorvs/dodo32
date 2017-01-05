package repository;

import java.util.List;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import domain.MeetingCall;
import domain.Task;
import domain.UserProgmmr;


public interface UserRepository {

	UserProgmmr save(UserProgmmr usr);
	
	@Query("SELECT m FROM UserProgmmr m ")
	List<UserProgmmr> buscarTodos();
	
	@Query("SELECT m FROM UserProgmmr m WHERE m.id = :id")
	UserProgmmr buscarPorId(@Param("id") Long id);
	
	@Query("SELECT m FROM UserProgmmr m ")
	Collection<UserProgmmr> ColeccionUserProgmmrs();

	@Query("SELECT m FROM UserProgmmr m WHERE m.id = :id_persona")
	UserProgmmr BuscarPersonasPorId(@Param("id_persona") Long id_persona);
	
	@Query("SELECT t FROM Task t WHERE t.dead_line_date> 'today' ")
	List<Task> tareas_pendientes();
	
	@Query("UPDATE Task t SET act_pend = false WHERE t.id=?1")
	void finalizar_tarea(Long id_task);
	
	@Query("SELECT mt FROM meeting_call mt WHERE mt.act_past=true")
	List<MeetingCall> ver_reuniones();
	
	//falta setear una hora para la reunion
}
