package de.alpharogroup.spring.exceptionhandling;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import de.alpharogroup.throwable.ThrowableExtensions;
import lombok.experimental.UtilityClass;

/**
 * The class {@link ExceptionHandlerExtensions} holds factory methods for create the view model bean
 * for exception representations
 */
@UtilityClass
public class ExceptionHandlerExtensions
{

	/**
	 * Factory method for create a new {@link ResponseEntity} with the given
	 * {@link ExceptionViewModel} object
	 *
	 * @param exceptionViewModel
	 *            the {@link ExceptionViewModel} object
	 * @return the new {@link ResponseEntity} object
	 */
	public static ResponseEntity<Object> newResponseEntity(ExceptionViewModel exceptionViewModel)
	{
		return new ResponseEntity<>(exceptionViewModel, exceptionViewModel.getHttpStatus());
	}

	/**
	 * Factory method for create a new {@link ExceptionViewModel} from the given arguments
	 *
	 * @param request
	 *            the request
	 * @param status
	 *            the status
	 * @param developerMessage
	 *            the developer message
	 * @param userMessage
	 *            the user message
	 * @return the new {@link ExceptionViewModel} object
	 */
	public static ExceptionViewModel newExceptionViewModelWith(WebRequest request,
		HttpStatus status, String developerMessage, String userMessage)
	{
		if (request instanceof ServletWebRequest)
		{
			return newExceptionViewModel((ServletWebRequest)request, status, developerMessage,
				userMessage);
		}
		return ExceptionViewModel.builder().requestUrl(request.getDescription(false))
			.occured(LocalDateTime.now()).httpStatus(status).developerMessage(developerMessage)
			.userMessage(userMessage).build();
	}

	/**
	 * Factory method for create a new {@link ExceptionViewModel} from the given arguments
	 *
	 * @param request
	 *            the request
	 * @param status
	 *            the status
	 * @param developerMessage
	 *            the developer message
	 * @param userMessage
	 *            the user message
	 * @return the new {@link ExceptionViewModel} object
	 */
	public static ExceptionViewModel newExceptionViewModel(ServletWebRequest request,
		HttpStatus status, String developerMessage, String userMessage)
	{
		return newExceptionViewModel(request.getRequest(), status, developerMessage, userMessage);
	}

	/**
	 * Factory method for create a new {@link ExceptionViewModel} from the given arguments
	 *
	 * @param request
	 *            the request
	 * @param httpStatus
	 *            the http status
	 * @param developerMessage
	 *            the developer message
	 * @param userMessage
	 *            the user message
	 * @return the new {@link ExceptionViewModel} object
	 */
	public static ExceptionViewModel newExceptionViewModel(HttpServletRequest request,
		HttpStatus httpStatus, String developerMessage, String userMessage)
	{
		return ExceptionViewModel.builder()
			.requestUrl(ServletUriComponentsBuilder.fromRequest(request).build().toUriString())
			.occured(LocalDateTime.now()).httpStatus(httpStatus).developerMessage(developerMessage)
			.userMessage(userMessage).build();
	}

	/**
	 * Factory method for create a new {@link ResponseEntity} from the given arguments
	 *
	 * @param exception
	 *            the exception
	 * @param headers
	 *            the headers
	 * @param status
	 *            the status
	 * @param request
	 *            the request
	 * @param messageSource
	 *            the message source
	 * @return the new {@link ResponseEntity} object
	 */
	public static ResponseEntity<Object> newResponseEntity(BindException exception,
		HttpHeaders headers, HttpStatus status, WebRequest request, MessageSource messageSource)
	{
		int i = 0;
		ExceptionViewModel exceptionViewModel = newExceptionViewModelWith(request, status,
			ThrowableExtensions.newThrowableMessage(exception, "Invalid request"),
			"An Binding error occured");

		for (FieldError fieldError : exception.getBindingResult().getFieldErrors())
		{
			String defaultMessage = fieldError.getDefaultMessage();
			exceptionViewModel.getAdditionalInfos().put("defaultMessageId_" + i++, defaultMessage);
			exceptionViewModel.getAdditionalInfos().put(fieldError.getField(),
				messageSource.getMessage(defaultMessage, null, defaultMessage, null));
		}
		return newResponseEntity(exceptionViewModel);
	}

}
