package Springback.SBack.service.impl;

import java.util.Optional;

import Springback.SBack.model.Usuario;
import Springback.SBack.repository.UsuarioRep;
import Springback.SBack.service.Servicio1;

public class Servicio1Impl implements Servicio1{

	UsuarioRep uc;
	
	@Override
	public void createUsuario(Usuario Usuario) {
		uc.save(Usuario);
	}

	@Override
	public Optional<Usuario> getById(Long id) {
		if(uc.existsById(id)) return uc.findById(id);
		else return null;
	}

	@Override
	public boolean deleteById(Long id) {
		if(uc.existsById(id)) {
			uc.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
