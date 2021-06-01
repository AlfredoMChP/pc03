package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService service; 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> lista(){
		return ResponseEntity.ok(service.listaAlumno());
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Alumno> eliminarPorId(@PathVariable("id") int idAlumno){
		Optional<Alumno> optAlumno = service.obtienePorId(idAlumno);
		if(optAlumno.isPresent()) {
			service.eliminaAlumno(idAlumno);
			return ResponseEntity.ok(optAlumno.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Alumno> listaPorId(@PathVariable("id") int idAlumno){
		Optional<Alumno> optAlumno =  service.obtienePorId(idAlumno);
		if (optAlumno.isPresent()) {
			return ResponseEntity.ok(optAlumno.get());	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Alumno> registra(@RequestBody Alumno obj){
		return ResponseEntity.ok(service.insertaActualizaAlumno(obj));
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Alumno> actualiza(@RequestBody Alumno obj){
		return ResponseEntity.ok(service.insertaActualizaAlumno(obj));
	}
	
	
	
	
}
