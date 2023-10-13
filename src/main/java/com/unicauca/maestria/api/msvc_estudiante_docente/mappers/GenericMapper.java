package com.unicauca.maestria.api.msvc_estudiante_docente.mappers;

import java.util.List;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenericMapper<D,E> {
	
	E toEntity(D dto);
	D toDto(E entity);
	List<E> toEntityList(List<D> dtos);
	List<D> toDtoList(List<E> entities);
	
	default Page<D> toDtoPage(Page<E> entityPage) {
		return entityPage.map(this::toDto);
	}
}
