package com.springback.SBack.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springback.SBack.model.Usuario;
import com.springback.SBack.repository.UsuarioRep;
import com.springback.SBack.service.Servicio1;

@Service
public class Servicio1Impl implements Servicio1{
	
	@Autowired
	private UsuarioRep uc;
	
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
