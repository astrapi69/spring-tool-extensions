package io.github.astrapi69.spring.security;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class GenericPrincipal<T> implements UserDetails
{
	private static final long serialVersionUID = 1L;

	@NonNull
	T user;
}
