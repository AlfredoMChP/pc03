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

import com.empresa.entity.Revista;
import com.empresa.service.RevistaService;

@RestController
@RequestMapping("/rest/revista")
public class RevistaController {

	@Autowired
	private RevistaService service; 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Revista>> lista(){
		return ResponseEntity.ok(service.listaRevista());
	}
	

	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Revista> eliminarPorId(@PathVariable("id") int idRevista){
		Optional<Revista> optRevista = service.obtienePorId(idRevista);
		if(optRevista.isPresent()) {
			service.eliminaRevista(idRevista);
			return ResponseEntity.ok(optRevista.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("porId/{id}")
	@ResponseBody
	public ResponseEntity<Revista> listaPorId(@PathVariable("id") int idRevista){
		Optional<Revista> optRevista =  service.obtienePorId(idRevista);
		if (optRevista.isPresent()) {
			return ResponseEntity.ok(optRevista.get());	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("porFrecuencia/{frecuencia}")
	@ResponseBody
	public ResponseEntity<List<Revista>> listaPorFrecuencia(@PathVariable("frecuencia") String frecuencia){
		List<Revista> optRevista =  service.listaPorFrecuencia(frecuencia);
		return ResponseEntity.ok(optRevista);	

	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Revista> registra(@RequestBody Revista obj){
		return ResponseEntity.ok(service.insertaActualizaRevista(obj));
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Revista> actualiza(@RequestBody Revista obj){
		return ResponseEntity.ok(service.insertaActualizaRevista(obj));
	}
	
	
	
	
}
