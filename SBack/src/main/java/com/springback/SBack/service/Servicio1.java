package com.springback.SBack.service;

import java.util.Optional;

import com.springback.SBack.model.Usuario;

public interface Servicio1{
	void createUsuario(Usuario Usuario); 
	Optional<Usuario> getById(Long id);
	boolean deleteById(Long id);
	Iterable<Usuario> getList();
	boolean isExist(Long id);
}
