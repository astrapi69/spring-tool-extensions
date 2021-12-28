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
package io.github.astrapi69.spring.web.util;

import java.util.Map;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.astrapi69.collections.array.ArrayFactory;

@UtilityClass
public class UrlExtensions
{

	public static String getBaseUrl(@NonNull final String scheme, @NonNull final String host,
		int serverPort, @NonNull final String restPath)
	{
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
		uriComponentsBuilder.scheme(scheme);
		uriComponentsBuilder.host(host);
		uriComponentsBuilder.port(serverPort);
		uriComponentsBuilder.path(restPath);
		return uriComponentsBuilder.toUriString();
	}

	public static String getBaseUrl(@NonNull final String scheme, @NonNull final String host,
		int serverPort, @NonNull final String restVersion, @NonNull final String restPath)
	{
		return getBaseUrl(scheme, host, serverPort, restVersion + "/" + restPath);
	}

	public static String newBaseUrl(String scheme, String domainName, int port,
		boolean withServerPort, boolean withSlashAtTheEnd)
	{
		StringBuilder domainUrl = new StringBuilder();
		domainUrl.append(scheme);
		domainUrl.append("://");
		domainUrl.append(domainName);
		if (withServerPort)
		{
			domainUrl.append(":");
			domainUrl.append(port);
		}
		if (withSlashAtTheEnd)
		{
			domainUrl.append("/");
		}
		return domainUrl.toString();
	}

	public static String generateUrl(@NonNull final String baseUrl, @NonNull final String methodUrl,
		final String[] requestParams)
	{
		return generateUrl(baseUrl, methodUrl, requestParams, "", ArrayFactory.newArray());
	}

	public static String generateUrl(@NonNull final String baseUrl, @NonNull final String methodUrl)
	{
		return generateUrl(baseUrl, methodUrl, ArrayFactory.newArray());
	}

	public static String generateUrl(@NonNull final String baseUrl, @NonNull final String methodUrl,
		final String[] requestParams, @NonNull final String arrayParamsName,
		final String[] arrayParams)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl).append(methodUrl);
		if (ArrayUtils.isNotEmpty(requestParams))
		{
			sb.append("?");
		}
		else
		{
			return sb.toString();
		}
		int count = 0;
		for (String requestParam : requestParams)
		{
			sb.append(requestParam);
			sb.append("={");
			sb.append(requestParam);
			sb.append("}");
			count++;
			if (count < requestParams.length)
			{
				sb.append("&");
			}
		}
		if (ArrayUtils.isNotEmpty(arrayParams))
		{
			sb.append("&");
		}
		else
		{
			return sb.toString();
		}
		count = 0;
		for (String arrayParam : arrayParams)
		{
			sb.append(arrayParamsName);
			sb.append("=");
			sb.append(arrayParam);
			count++;
			if (count < arrayParams.length)
			{
				sb.append("&");
			}
		}
		return sb.toString();
	}

	public static String expand(String uriTemplate, Map<String, ?> uriVars)
	{
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uriTemplate);
		for (Map.Entry<String, ?> entry : uriVars.entrySet())
		{
			uriComponentsBuilder.queryParam(entry.getKey(), entry.getValue());
		}
		return uriComponentsBuilder.toUriString();
	}
}
