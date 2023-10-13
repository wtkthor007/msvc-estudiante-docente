package com.unicauca.maestria.api.msvc_estudiante_docente.services.estudiante;

import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Service;

import com.unicauca.maestria.api.msvc_estudiante_docente.dtos.estudiante.CamposUnicosEstudianteDto;
import com.unicauca.maestria.api.msvc_estudiante_docente.dtos.estudiante.EstudianteSaveDto;
import com.unicauca.maestria.api.msvc_estudiante_docente.dtos.estudiante.ProrrogaDto;
import com.unicauca.maestria.api.msvc_estudiante_docente.dtos.estudiante.ReingresoDto;

@Service
public class InformacionUnicaEstudiante implements Function<EstudianteSaveDto, CamposUnicosEstudianteDto>{

	@Override
	public CamposUnicosEstudianteDto apply(EstudianteSaveDto estudianteSaveDto) {
		List<String> resolucionProrrogas = estudianteSaveDto.getProrrogas().
				stream().map(ProrrogaDto::getResolucion).toList();
		
		List<String> resolucionReingresos = estudianteSaveDto.getReingresos().
				stream().map(ReingresoDto::getResolucion).toList();
		
		return CamposUnicosEstudianteDto.builder()
				.codigo(estudianteSaveDto.getCodigo())
				.identificacion(estudianteSaveDto.getPersona().getIdentificacion())
				.correoElectronico(estudianteSaveDto.getPersona().getCorreoElectronico())
				.correoUniversidad(estudianteSaveDto.getCorreoUniversidad())
				.resolucionesProrroga(resolucionProrrogas)
				.resolucionesReingreso(resolucionReingresos)
				.build();
	}

}
