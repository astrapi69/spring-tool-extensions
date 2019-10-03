package de.alpharogroup.spring.generics;
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

	public static <K, V> ParameterizedTypeReference<Map<K, V>> newMapParameterizedTypeReference(Class<K> keyType, Class<V> valueType){

		return new ParameterizedTypeReference<Map<K, V>>() {
			@Override
			public Type getType() {
				Type type = super.getType();
				if (type instanceof ParameterizedType) {
					Type[] responseWrapperActualTypes = { keyType, valueType };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(Map.class, responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

	public static <T> ParameterizedTypeReference<Set<T>> newSetParameterizedTypeReference(Class<T> entityClass){
		return new ParameterizedTypeReference<Set<T>>() {
			@Override
			public Type getType() {
				Type type = super.getType();
				if (type instanceof ParameterizedType) {
					Type[] responseWrapperActualTypes = { entityClass };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(Set.class, responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

	public static <T> ParameterizedTypeReference<Iterable<T>> newIterableParameterizedTypeReference(Class<T> entityClass){
		return new ParameterizedTypeReference<Iterable<T>>() {
			@Override
			public Type getType() {
				Type type = super.getType();
				if (type instanceof ParameterizedType) {
					Type[] responseWrapperActualTypes = { entityClass };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(Iterable.class, responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

	public static <T> ParameterizedTypeReference<List<T>> newListParameterizedTypeReference(Class<T> entityClass){
		return new ParameterizedTypeReference<List<T>>() {
			@Override
			public Type getType() {
				Type type = super.getType();
				if (type instanceof ParameterizedType) {
					Type[] responseWrapperActualTypes = { entityClass };
					ParameterizedType responseWrapperType = TypeUtils.parameterize(List.class, responseWrapperActualTypes);
					return responseWrapperType;
				}
				return type;
			}
		};
	}

}