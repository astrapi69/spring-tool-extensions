package de.alpharogroup.spring.web.util;

import de.alpharogroup.collections.array.ArrayFactory;
import de.alpharogroup.collections.map.MapFactory;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UrlExtensionsTest
{

	@Test void getBaseUrl()
	{
		String actual;
		String expected;
		//
		actual = UrlExtensions.getBaseUrl("http", "localhost", 8080, "v1", "resource");
		expected = "http://localhost:8080/v1/resource";
		assertEquals(expected, actual);
	}

	@Test void expand() {

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

	@Test void generateUrl() {

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

		actual = UrlExtensions.generateUrl(baseUrl, methodUrl, requestParams, arrayParamsName, arrayParams);
		expected = "http://localhost:8080/GET?username={username}&arrayparamname=foo";
		assertEquals(expected, actual);
	}

	@Test void newBaseUrl()
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
