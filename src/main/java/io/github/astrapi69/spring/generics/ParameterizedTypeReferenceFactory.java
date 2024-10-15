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
package io.github.astrapi69.spring.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.reflect.TypeUtils;
import org.springframework.core.ParameterizedTypeReference;

import lombok.experimental.UtilityClass;

/**
 * A factory for creating ParameterizedTypeReference objects.
 */
@UtilityClass
public class ParameterizedTypeReferenceFactory
{

	public static <K, V> ParameterizedTypeReference<Map<K, V>> newMapParameterizedTypeReference(
		Class<K> keyType, Class<V> valueType)
	{

		return new ParameterizedTypeReference<Map<K, V>>()
		{
			@Override
			public Type getType()
			{
				Type type = super.getType();
				if (type instanceof ParameterizedType)
				{
					Type[] responseWrapperActualTypes = { keyType, valueType };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(Map.class,
						responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

	public static <T> ParameterizedTypeReference<Set<T>> newSetParameterizedTypeReference(
		Class<T> entityClass)
	{
		return new ParameterizedTypeReference<Set<T>>()
		{
			@Override
			public Type getType()
			{
				Type type = super.getType();
				if (type instanceof ParameterizedType)
				{
					Type[] responseWrapperActualTypes = { entityClass };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(Set.class,
						responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

	public static <T> ParameterizedTypeReference<Iterable<T>> newIterableParameterizedTypeReference(
		Class<T> entityClass)
	{
		return new ParameterizedTypeReference<Iterable<T>>()
		{
			@Override
			public Type getType()
			{
				Type type = super.getType();
				if (type instanceof ParameterizedType)
				{
					Type[] responseWrapperActualTypes = { entityClass };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(Iterable.class,
						responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

	public static <T> ParameterizedTypeReference<List<T>> newListParameterizedTypeReference(
		Class<T> entityClass)
	{
		return new ParameterizedTypeReference<List<T>>()
		{
			@Override
			public Type getType()
			{
				Type type = super.getType();
				if (type instanceof ParameterizedType)
				{
					Type[] responseWrapperActualTypes = { entityClass };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(List.class,
						responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

}
