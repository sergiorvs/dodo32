package app.repositorio;

import org.springframework.data.repository.Repository;

import app.dominio.UserprHasConvoc;

public interface UserprHasConvocRepository extends Repository<UserprHasConvoc, Long> {
	UserprHasConvoc save(UserprHasConvoc userpHasConvoc);
}
