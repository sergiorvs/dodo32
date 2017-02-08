package app.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Manager;
import app.dominio.Person;
import app.dominio.UserProgmmr;

public interface ManagerRepository extends Repository<Manager,Long>{ 
	Manager save(Manager manag);
	
	@Query(value = "SELECT * FROM Manager WHERE pers_id = ?1", nativeQuery = true)
	Manager findManager(@Param("idpers")Long idpers);	
	
	//seleccionar todos los programadores
	@Query(value = "SELECT * FROM user_progmmr",nativeQuery = true)
	List<UserProgmmr>AllProgramers();
	
	//buscar el id del tema  (creo que no es necesario)
	@Query(value="SELECT id FROM theme t WHERE t.nombre=?1", nativeQuery = true)
	int find_id_theme(String nombre_tema);
	
	//buscar score del programador en un tema
	@Query(value = "SELECT theme_score FROM user_prog_has_theme upt WHERE upt.user_progmmr_id=?1 and upt.theme_id=?2", nativeQuery=true)
	Long find_score_by_programmer(Long id_prog,Long id_theme);
	/*
	//Task save(Task tarea); 
	
	
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
		Collection<Manager> buscarTodos();
		
		@Query("SELECT m FROM Manager m WHERE m.id = :id")
		Manager buscarPorId(@Param("id") Long id);
		
		@Query("SELECT m FROM Manager m ")
		Collection<Manager> ColeccionManagers();

		@Query("SELECT M FROM Manager m WHERE m.id = :id_persona")
		Manager BuscarPersonasPorId(@Param("id_persona") Long id_persona);
	*/
	
}
