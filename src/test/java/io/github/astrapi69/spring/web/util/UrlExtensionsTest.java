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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.collection.array.ArrayFactory;
import io.github.astrapi69.collection.map.MapFactory;

class UrlExtensionsTest
{

	@Test
	void expand()
	{

		String actual;
		String expected;
		String uriTemplate;
		Map<String, String> uriVars;
		//
		uriTemplate = "http://localhost:8080/v1/resource";
		uriVars = MapFactory.newHashMap();
		uriVars.put("foo", "bar");
		uriVars.put("bla", "fasel");
		actual = UrlExtensions.expand(uriTemplate, uriVars);
		expected = "http://localhost:8080/v1/resource?bla=fasel&foo=bar";
		assertEquals(expected, actual);
	}

	@Test
	void generateUrl()
	{

		String actual;
		String expected;
		String baseUrl;
		String methodUrl;
		String[] requestParams;
		String arrayParamsName;
		String[] arrayParams;
		//
		baseUrl = "http://localhost:8080/";
		methodUrl = "GET";
		requestParams = ArrayFactory.newArray("username");
		arrayParamsName = "arrayparamname";
		arrayParams = ArrayFactory.newArray("foo");

		actual = UrlExtensions.generateUrl(baseUrl, methodUrl, requestParams, arrayParamsName,
			arrayParams);
		expected = "http://localhost:8080/GET?username={username}&arrayparamname=foo";
		assertEquals(expected, actual);
	}

	@Test
	void getBaseUrl()
	{
		String actual;
		String expected;
		//
		actual = UrlExtensions.getBaseUrl("http", "localhost", 8080, "v1", "resource");
		expected = "http://localhost:8080/v1/resource";
		assertEquals(expected, actual);
		//
		actual = UrlExtensions.getBaseUrl("http", "localhost", 8080, "v1" + "/" + "resource");
		expected = "http://localhost:8080/v1/resource";
		assertEquals(expected, actual);
	}

	@Test
	void newBaseUrl()
	{
		String actual;
		String expected;
		//
		actual = UrlExtensions.newBaseUrl("http", "localhost", 8080, true, true);
		expected = "http://localhost:8080/";
		assertEquals(expected, actual);
		//
		actual = UrlExtensions.newBaseUrl("http", "localhost", 8080, true, false);
		expected = "http://localhost:8080";
		assertEquals(expected, actual);
		//
		actual = UrlExtensions.newBaseUrl("http", "localhost", 8080, false, false);
		expected = "http://localhost";
		assertEquals(expected, actual);
		//
		actual = UrlExtensions.newBaseUrl("http", "localhost", 8080, false, true);
		expected = "http://localhost/";
		assertEquals(expected, actual);
	}
}
