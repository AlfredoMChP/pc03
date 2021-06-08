package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Revista;

public interface RevistaService {

	public abstract List<Revista> listaRevista();
	public abstract Revista insertaActualizaRevista(Revista obj);
	public abstract Optional<Revista> obtienePorId(int idRevista);
	public abstract void eliminaRevista(int id);
	public abstract List<Revista> listaRevistaPorNombreLike(String filtro);
	public abstract List<Revista> listaPorFrecuencia(String frecuencia);
	public abstract List<Revista> listaPorFrecuencia(String frecuencia, int idRevista);
	
}
