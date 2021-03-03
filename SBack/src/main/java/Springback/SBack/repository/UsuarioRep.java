package Springback.SBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Springback.SBack.model.Usuario;

public interface UsuarioRep extends JpaRepository<Usuario, Long>{
}
