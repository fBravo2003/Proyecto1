package Springback.SBack.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Springback.SBack.model.Usuario;
import Springback.SBack.service.Servicio1;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class SController {
	
	@Autowired
	Servicio1 servicio;
	
	@ApiOperation(value ="Buscar Usuario por id")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Usuario encontrado", response = Usuario.class),
		@ApiResponse(code = 404, message = "Usuario no encontrado", response = HttpStatus.class)
	})
	
	@GetMapping(value = "/solicitar/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable Long id){
		Optional<Usuario> servi = servicio.getById(id);
		
		if(servi.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(servi.get(), HttpStatus.OK);		
		}
	}
	
	@ApiOperation(value ="Creacion Usuario")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Usuario creado", response = Usuario.class)
	})
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody Usuario user){
		servicio.createUsuario(user);
		
		return new ResponseEntity<>("Usuario creado", HttpStatus.OK);
	}
	
	@ApiOperation(value ="Borrar Usuario")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Usuario borrado", response = Usuario.class),
		@ApiResponse(code = 404, message = "Usuario no encontrado", response = HttpStatus.class)
	})
	
	@DeleteMapping(value = "/borrar/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
		boolean isRemoved = servicio.deleteById(id);
		
		if(isRemoved) {
			return new ResponseEntity<>("Usuario borrado", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
}
