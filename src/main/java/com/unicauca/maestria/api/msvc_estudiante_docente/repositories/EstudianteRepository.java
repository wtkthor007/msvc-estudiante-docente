package com.unicauca.maestria.api.msvc_estudiante_docente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unicauca.maestria.api.msvc_estudiante_docente.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

	public boolean existsByCodigo(String codigo);
	public boolean existsByCorreoUniversidad(String correoUniversidad);
	

}
