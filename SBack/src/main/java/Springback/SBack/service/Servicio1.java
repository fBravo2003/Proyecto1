package Springback.SBack.service;

import java.util.Optional;

import Springback.SBack.model.Usuario;

public interface Servicio1{
	void createUsuario(String nombre); 
	Optional<Usuario> getById(Long id);
	boolean deleteById(Long id);
}
