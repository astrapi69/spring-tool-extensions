/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.mapstruct.mapper;

import java.util.Collection;
import java.util.List;

/**
 * The interface {@link GenericMapper} maps dto objects to entities and back
 *
 * @param <ENTITY>
 *            the generic type of the entity object
 * @param <DTO>
 *            the generic type of the DTO object
 */
public interface GenericMapper<ENTITY, DTO>
{

	/**
	 * Maps the given entity object to a DTO object
	 *
	 * @param entity
	 *            the entity object
	 * @return the DTO object
	 */
	DTO toDto(final ENTITY entity);

	/**
	 * Maps the given collection of entity objects to a list of DTO objects
	 *
	 * @param entities
	 *            the collection of entities objects
	 * @return the list of DTO objects
	 */
	List<DTO> toDtos(final Collection<ENTITY> entities);

	/**
	 * Maps the given DTO object to a entity object
	 *
	 * @param dto
	 *            the DTO object
	 * @return the entity object
	 */
	ENTITY toEntity(final DTO dto);

	/**
	 * Maps the given collection of DTO objects to a list of entity objects
	 *
	 * @param dtos
	 *            the collection of DTO objects
	 * @return the list of entity objects
	 */
	List<ENTITY> toEntities(final Collection<DTO> dtos);

}