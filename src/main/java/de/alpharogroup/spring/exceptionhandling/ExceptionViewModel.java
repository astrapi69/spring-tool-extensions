package de.alpharogroup.spring.exceptionhandling;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link ExceptionViewModel} holds data for exception representations
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class ExceptionViewModel
{

	/** The request url. */
	String requestUrl;

	/** The http status. */
	HttpStatus httpStatus;

	/** The developer message. */
	String developerMessage;

	/** The user message. */
	String userMessage;

	/** The time when the exception is occured. */
	LocalDateTime occured;

	/** The map for additional informations */
	@Builder.Default
	final Map<String, String> additionalInfos = new LinkedHashMap<>();

}