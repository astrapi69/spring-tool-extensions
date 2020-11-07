package de.alpharogroup.spring.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public abstract class AbstractSwaggerConfiguration {
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(getBasePackage())).paths(regex(getDocketPathsPathRegex()))
				.build().apiInfo(metaData());
	}

	public abstract String getApiInfoDescription();

	protected String getApiInfoTermsOfServiceUrl() {
		return "";
	}

	public abstract String getApiInfoTitle();

	public abstract String getApiInfoVersion();

	public abstract String getBasePackage();

	public String getContactEmail() {
		return "";
	}

	public String getContactLicense() {
		return "";
	}

	public String getContactLicenseUrl() {
		return "";
	}

	public abstract String getContactName();

	public abstract String getContactUrl();

	public abstract String getDocketPathsPathRegex();

	protected ApiInfo metaData() {
		return new ApiInfo(getApiInfoTitle(), getApiInfoDescription(), getApiInfoVersion(),
				getApiInfoTermsOfServiceUrl(), new Contact(getContactName(), getContactUrl(), getContactEmail()),
				getContactLicense(), getContactLicenseUrl(), Collections.emptyList());
	}

}
