package de.alpharogroup.mapstruct.mapper;

public interface GenericMapper<ENTITY, DTO>
{

	DTO toDto(ENTITY entity);

	ENTITY toEntity(DTO dto);

}