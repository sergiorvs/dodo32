package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import app.dominio.Theme;

public interface ThemeRepository  extends Repository<Theme, Long> {
	Theme save(Theme theme);
	
	@Query("SELECT th FROM Theme th")
	List<Theme> findAll();
	
	
	
}
