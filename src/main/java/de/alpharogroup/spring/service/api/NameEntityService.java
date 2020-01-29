package de.alpharogroup.spring.service.api;

import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.db.entity.name.Nameable;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NameEntityService<T extends Nameable>
{

	/**
	 * Find the entities objects from the given name value.
	 *
	 * @param nameValue
	 *            the name value
	 * @return the list with the entities
	 */
	List<T> findEntities(final String nameValue);

	/**
	 * Find the entity object from the given name value.
	 *
	 * @param nameValue
	 *            the name value
	 * @return the found entity object or null if not.
	 */
	default T findFirst(final String nameValue)
	{
		final List<T> nameEntities = findEntities(nameValue);
		return ListExtensions.getFirst(nameEntities);
	}

	/**
	 * Gets the or creates a new entity object
	 *
	 * @param value
	 *            the value
	 * @return the entity object
	 */
	@Transactional
	default T getOrCreateNewNameEntity(final String value)
	{
		T nameEntity = findFirst(value);
		if (nameEntity == null)
		{
			nameEntity = newNameEntity(value);
			nameEntity = merge(nameEntity);
		}
		return nameEntity;
	}

	/**
	 * Merges the given object. @see Hibernate documentation.
	 *
	 * @param object
	 *            the object
	 * @return the object
	 */
	T merge(final T object);

	/**
	 * Factory method for create a new name entity.
	 *
	 * @param value
	 *            the value
	 * @return the new name entity
	 */
	T newNameEntity(final String value);
}