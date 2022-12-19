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
