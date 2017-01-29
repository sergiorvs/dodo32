package app.repositorio;

import org.springframework.data.repository.Repository;

import app.dominio.Man_has_Proj;

public interface ManhasprojRepository extends Repository<Man_has_Proj, Long>{
	Man_has_Proj save(Man_has_Proj manhproj);
	
	
}
