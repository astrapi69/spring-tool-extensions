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
package io.github.astrapi69.spring.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public abstract class AbstractSwaggerConfiguration
{
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage(newBasePackage()))
			.paths(regex(newDocketPathsRegex())).build().apiInfo(metaData());
	}

	protected abstract String newApiInfoDescription();

	protected String newApiInfoTermsOfServiceUrl()
	{
		return "";
	}

	protected abstract String newApiInfoTitle();

	protected abstract String newApiInfoVersion();

	protected abstract String newBasePackage();

	protected String newContactEmail()
	{
		return "";
	}

	protected String newApiInfoLicense()
	{
		return "";
	}

	protected String newApiInfoLicenseUrl()
	{
		return "";
	}

	protected abstract String newContactName();

	protected abstract String newContactUrl();

	protected abstract String newDocketPathsRegex();

	protected Contact newContact()
	{
		return new Contact(newContactName(), newContactUrl(), newContactEmail());
	}

	protected ApiInfo metaData()
	{
		return new ApiInfoBuilder().title(newApiInfoTitle())
			.termsOfServiceUrl(newApiInfoTermsOfServiceUrl()).description(newApiInfoDescription())
			.version(newApiInfoVersion()).license(newApiInfoLicense())
			.licenseUrl(newApiInfoLicenseUrl()).contact(newContact()).build();
	}

}
