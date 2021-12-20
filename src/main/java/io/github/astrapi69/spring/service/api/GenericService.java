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
package io.github.astrapi69.spring.service.api;

import java.util.Optional;

import lombok.NonNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<ENTITY, ID, REPOSITORY extends JpaRepository<ENTITY, ID>>
{
	default long count()
	{
		return getRepository().count();
	}

	default void delete(@NonNull ENTITY entity)
	{
		getRepository().delete(entity);
	}

	default void deleteAll()
	{
		getRepository().deleteAll();
	}

	default void deleteAll(@NonNull Iterable<? extends ENTITY> entities)
	{
		getRepository().deleteAll(entities);
	}

	default void deleteAllInBatch()
	{
		getRepository().deleteAllInBatch();
	}

	default void deleteById(@NonNull ID id)
	{
		getRepository().deleteById(id);
	}

	default void deleteInBatch(@NonNull Iterable<ENTITY> entities)
	{
		getRepository().deleteAllInBatch(entities);
	}

	default boolean existsById(@NonNull ID id)
	{
		return getRepository().existsById(id);
	}

	default Iterable<ENTITY> findAll()
	{
		return getRepository().findAll();
	}

	default Page<ENTITY> findAll(@NonNull Pageable pageable)
	{
		return getRepository().findAll(pageable);
	}

	default Iterable<ENTITY> findAll(@NonNull Sort sort)
	{
		return getRepository().findAll(sort);
	}

	default Iterable<ENTITY> findAllById(@NonNull Iterable<ID> ids)
	{
		return getRepository().findAllById(ids);
	}

	default Optional<ENTITY> findById(@NonNull ID id)
	{
		return getRepository().findById(id);
	}

	default void flush()
	{
		getRepository().flush();
	}

	default ENTITY getOne(@NonNull ID id)
	{
		return getRepository().getById(id);
	}

	REPOSITORY getRepository();

	default ENTITY save(@NonNull ENTITY entity)
	{
		return getRepository().save(entity);
	}

	default Iterable<ENTITY> saveAll(@NonNull Iterable<ENTITY> entities)
	{
		return getRepository().saveAll(entities);
	}

	default ENTITY saveAndFlush(@NonNull ENTITY entity)
	{
		return getRepository().saveAndFlush(entity);
	}

}
