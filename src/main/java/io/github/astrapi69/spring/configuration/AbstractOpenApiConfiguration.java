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

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class AbstractOpenApiConfiguration
{

	@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI().info(apiInfo());
	}

	private Info apiInfo()
	{
		return new Info().title(newApiInfoTitle()).description(newApiInfoDescription())
			.version(newApiInfoVersion()).contact(apiContact()).license(apiLicence());
	}

	private License apiLicence()
	{
		return new License().name(newApiInfoLicenseName()).url(newApiInfoLicenseUrl());
	}

	private Contact apiContact()
	{
		return new Contact().name(newApiInfoContactName()).email(newApiInfoContactEmail())
			.url(newApiInfoContactUrl());
	}

	protected abstract String newApiInfoTitle();

	protected abstract String newApiInfoVersion();

	protected abstract String newApiInfoDescription();

	protected abstract String newApiInfoLicenseName();

	protected abstract String newApiInfoLicenseUrl();

	protected abstract String newApiInfoContactName();

	protected abstract String newApiInfoContactUrl();

	protected abstract String newApiInfoContactEmail();

}
