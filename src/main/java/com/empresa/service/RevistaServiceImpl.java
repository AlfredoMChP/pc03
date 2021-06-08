package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Revista;
import com.empresa.repository.RevistaRepository;

@Service
public class RevistaServiceImpl implements RevistaService {

	@Autowired
	private RevistaRepository repository;

	@Override
	public List<Revista> listaRevista() {
		return repository.findAll();
	}

	@Override
	public Revista insertaActualizaRevista(Revista obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaRevista(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Revista> listaRevistaPorNombreLike(String filtro) {
		return repository.listaRevistaPorNombreLike(filtro);
	}

	@Override
	public Optional<Revista> obtienePorId(int idRevista) {
		return repository.findById(idRevista);
	}

	@Override
	public List<Revista> listaPorFrecuencia(String frecuencia) {
		return repository.findByFrecuencia(frecuencia);
	}

	@Override
	public List<Revista> listaPorFrecuencia(String frecuencia, int idRevista) {
		return repository.findByFrecuenciaAndIdRevistaNot(frecuencia, idRevista);
	}

	

}
