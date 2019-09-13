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
package de.alpharogroup.spring.service.api;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<T, ID, R extends JpaRepository<T, ID>>
{
	default long count()
	{
		return getRepository().count();
	}

	default void delete(T entity)
	{
		getRepository().delete(entity);
	}

	default void deleteAll()
	{
		getRepository().deleteAll();
	}

	default void deleteAll(Iterable<? extends T> entities)
	{
		getRepository().deleteAll(entities);
	}

	default void deleteAllInBatch()
	{
		getRepository().deleteAllInBatch();
	}

	default void deleteById(ID id)
	{
		getRepository().deleteById(id);
	}

	default void deleteInBatch(Iterable<T> entities)
	{
		getRepository().deleteInBatch(entities);
	}

	default boolean existsById(ID id)
	{
		return getRepository().existsById(id);
	}

	default Iterable<T> findAll()
	{
		return getRepository().findAll();
	}

	default Page<T> findAll(Pageable pageable)
	{
		return getRepository().findAll(pageable);
	}

	default Iterable<T> findAll(Sort sort)
	{
		return getRepository().findAll(sort);
	}

	default Iterable<T> findAllById(Iterable<ID> ids)
	{
		return getRepository().findAllById(ids);
	}

	default Optional<T> findById(ID id)
	{
		return getRepository().findById(id);
	}

	default void flush()
	{
		getRepository().flush();
	}

	default T getOne(ID id)
	{
		return getRepository().getOne(id);
	}

	R getRepository();

	default <S extends T> S save(S entity)
	{
		return getRepository().save(entity);
	}

	default <S extends T> Iterable<S> saveAll(Iterable<S> entities)
	{
		return getRepository().saveAll(entities);
	}

	default <S extends T> S saveAndFlush(S entity)
	{
		return getRepository().saveAndFlush(entity);
	}

}
