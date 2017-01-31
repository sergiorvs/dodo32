package app.repositorio;

import org.springframework.data.repository.Repository;

import app.dominio.TaskHasThemes;

public interface TaskhasThemesRepository extends Repository<TaskHasThemes, Long> {
	TaskHasThemes save(TaskHasThemes tahth);
}
