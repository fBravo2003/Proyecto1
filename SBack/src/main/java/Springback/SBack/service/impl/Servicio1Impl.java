package Springback.SBack.service.impl;

import Springback.SBack.model.Usuario;
import Springback.SBack.repository.UsuarioRep;
import Springback.SBack.service.Servicio1;

public class Servicio1Impl implements Servicio1{

	UsuarioRep uc;
	
	@Override
	public void createUsuario(String nombre) {
		uc.save(new Usuario(nombre));
	}

}
