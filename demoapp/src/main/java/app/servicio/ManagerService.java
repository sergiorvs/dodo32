package app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Manager;
import app.dominio.Person;
import app.repositorio.ManagerRepository;

@Service
public class ManagerService {
	@Autowired
	ManagerRepository managerRepository;
	
	@Transactional
	public void save(Manager man){
		managerRepository.save(man);
	}
	
	public Manager findManager(Long idpers){
		return managerRepository.findManager(idpers);
	}
}
