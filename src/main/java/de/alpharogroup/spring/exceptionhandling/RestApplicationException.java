package de.alpharogroup.spring.exceptionhandling;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * The general class {@link RestApplicationException} for rest controller exceptions
 */
@Getter @NoArgsConstructor @AllArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE) public class RestApplicationException
	extends RuntimeException
{

	int code;
	String message;

	public RestApplicationException(int code)
	{
		this.code = code;
	}

	public RestApplicationException(String message)
	{
		this.message = message;
	}

}
