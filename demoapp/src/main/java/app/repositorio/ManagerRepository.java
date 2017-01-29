package app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Manager;
import app.dominio.Person;

public interface ManagerRepository extends Repository<Manager,Long>{ 
	Manager save(Manager manag);
	
	@Query(value = "SELECT * FROM Manager WHERE pers_id = ?1", nativeQuery = true)
	Manager findManager(@Param("idpers")Long idpers);	
	
	
	
	//Task save(Task tarea); 
	
	/*
	///primero se deberia crear un projecto	
		@Query("INSERT INTO Project VALUES(?1 , ?2 ,?3 ,?4)")
		void crear_projecto(Long id,String descripcion,String nombre ,Boolean activo);
		
		///son dos claves foraneas
		@Query("INSERT INTO Manager_has_projects VALUES(?1 , ?2) ")
		void crear_meeting(Long id_manager,Long id_project);
		
		@Query("INSERT INTO Theme VALUES(?1 , ?2)")
		void crear_tema(Long id,String nombre);

		///asignar tarea a un progrmador (FALTA...)
		
		@Query("SELECT m FROM Manager m ")
		List<Manager> buscarTodos();
		
		@Query("SELECT m FROM Manager m WHERE m.id = :id")
		Manager buscarPorId(@Param("id") Long id);
		
		@Query("SELECT m FROM Manager m ")
		Collection<Manager> ColeccionManagers();

		@Query("SELECT M FROM Manager m WHERE m.id = :id_persona")
		Manager BuscarPersonasPorId(@Param("id_persona") Long id_persona);
	*/	
	
}
