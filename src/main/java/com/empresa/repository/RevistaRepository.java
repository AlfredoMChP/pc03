package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Integer> {

	
	@Query("Select a from Revista a where nombre like :fil")
	public abstract List<Revista> listaRevistaPorNombreLike(@Param("fil") String filtro);

	public abstract List<Revista> findByFrecuencia(String frecuencia);
	public abstract List<Revista> findByFrecuenciaAndIdRevistaNot(String frecuencia, int idRevista);
}
