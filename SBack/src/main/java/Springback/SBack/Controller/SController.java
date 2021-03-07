package Springback.SBack.Controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Springback.SBack.model.Usuario;
import Springback.SBack.service.Servicio1;

@RestController
public class SController {
	
	Servicio1 servicio;
	
	@GetMapping(value = "/solicitar/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable Long id){
		Optional<Usuario> servi = servicio.getById(id);
		
		if(servi.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(servi.get(), HttpStatus.OK);		
		}
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
		var isRemoved = servicio.deleteById(id);
		
		if(isRemoved) {
			return new ResponseEntity<>("Usuario borrado", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
}
