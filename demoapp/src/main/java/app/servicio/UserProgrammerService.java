package app.servicio;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dominio.UserProgmmr;
import app.repositorio.UserProgrammerRepository;

@Service
public class UserProgrammerService {
	@Autowired
	UserProgrammerRepository userprogRepository;
	
	@Transactional
	public void save(UserProgmmr userProgr){
		userprogRepository.save(userProgr);
	}
	
	public UserProgmmr findProgrammer(Long idpers){
		return userprogRepository.findProgrammer(idpers);
	}
}
