package app.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dominio.Theme;
import app.repositorio.ThemeRepository;

@Service
public class ThemeService {
	@Autowired
	ThemeRepository themeRepository;

	@Transactional
	public void save(Theme theme){
		themeRepository.save(theme);
	}
	
	public List<Theme> findAll(){
		return themeRepository.findAll();
	}
	
	
	public Theme AddTheme(String nameTheme){
		Theme theme = new Theme();
		theme.setName(nameTheme);
		
		Theme th = themeRepository.save(theme);
		return th;
	}

}	
