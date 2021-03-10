package com.springback.SBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springback.SBack.model.Usuario;

public interface UsuarioRep extends JpaRepository<Usuario, Long>{
}
