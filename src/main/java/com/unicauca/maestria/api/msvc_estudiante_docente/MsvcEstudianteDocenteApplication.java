package com.unicauca.maestria.api.msvc_estudiante_docente;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unicauca.maestria.api.msvc_estudiante_docente.domain.LineaInvestigacion;
import com.unicauca.maestria.api.msvc_estudiante_docente.repositories.LineaInvestigacionRepository;

@SpringBootApplication
public class MsvcEstudianteDocenteApplication implements CommandLineRunner{

	@Autowired
	private LineaInvestigacionRepository lineaInvestigacionRepository; 

	public static void main(String[] args) {
		SpringApplication.run(MsvcEstudianteDocenteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LineaInvestigacion lineaInvestigacion1 = LineaInvestigacion.builder().
				titulo("titulo1").categoria("categoria1").build();
		LineaInvestigacion lineaInvestigacion2 = LineaInvestigacion.builder().
				titulo("titulo2").categoria("categoria1").build();
		LineaInvestigacion lineaInvestigacion3 = LineaInvestigacion.builder().
				titulo("titulo3").categoria("categoria2").build();
		
		List<LineaInvestigacion> lineasInvestigacion = Arrays.asList(lineaInvestigacion1,lineaInvestigacion2,lineaInvestigacion3);
		
		lineaInvestigacionRepository.saveAll(lineasInvestigacion);
		
	}

}
