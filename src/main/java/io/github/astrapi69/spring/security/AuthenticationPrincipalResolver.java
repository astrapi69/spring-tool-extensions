package io.github.astrapi69.spring.security;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationPrincipalResolver
{

	public static <T> Optional<T> getAuthenticationPrincipal()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null)
		{
			return Optional.empty();
		}
		T principal = (T)authentication.getPrincipal();
		return Optional.of(principal);
	}


	public static <T> Optional<T> getCurrentUser()
	{
		Optional<GenericPrincipal<T>> authenticationPrincipal = getAuthenticationPrincipal();
		if (!authenticationPrincipal.isPresent())
		{
			return Optional.empty();
		}
		GenericPrincipal<T> usersPrincipal = authenticationPrincipal.get();
		return Optional.of(usersPrincipal.getUser());
	}
}
