package de.alpharogroup.spring.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GenericService<T, ID, R extends JpaRepository<T, ID>>
{
	R getRepository();

	default <S extends T> S save(S entity)
	{
		return getRepository().save(entity);
	}

	default <S extends T> Iterable<S> saveAll(Iterable<S> entities)
	{
		return getRepository().saveAll(entities);
	}

	default Optional<T> findById(ID id)
	{
		return getRepository().findById(id);
	}

	default boolean existsById(ID id)
	{
		return getRepository().existsById(id);
	}

	default Iterable<T> findAll()
	{
		return getRepository().findAll();
	}

	default Iterable<T> findAllById(Iterable<ID> ids)
	{
		return getRepository().findAllById(ids);
	}

	default long count()
	{
		return getRepository().count();
	}

	default void deleteById(ID id)
	{
		getRepository().deleteById(id);
	}

	default void delete(T entity)
	{
		getRepository().delete(entity);
	}

	default void deleteAll(Iterable<? extends T> entities)
	{
		getRepository().deleteAll(entities);
	}

	default void deleteAll()
	{
		getRepository().deleteAll();
	}

	default Iterable<T> findAll(Sort sort)
	{
		return getRepository().findAll(sort);
	}

	default Page<T> findAll(Pageable pageable)
	{
		return getRepository().findAll(pageable);
	}

	default void flush()
	{
		getRepository().flush();
	}

	default <S extends T> S saveAndFlush(S entity)
	{
		return getRepository().saveAndFlush(entity);
	}

	default void deleteInBatch(Iterable<T> entities)
	{
		getRepository().deleteInBatch(entities);
	}

	default void deleteAllInBatch()
	{
		getRepository().deleteAllInBatch();
	}

	default T getOne(ID id)
	{
		return getRepository().getOne(id);
	}

}
