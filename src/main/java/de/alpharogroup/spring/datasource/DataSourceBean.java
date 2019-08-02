package de.alpharogroup.spring.datasource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class {@link DataSourceBean}.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DataSourceBean
{

	/** The default h2 builder as start point to build a new DataSourceBean. */
	public static final DataSourceBean DEFAULT_H2_BUILDER = DataSourceBean.builder()
		.driverClassName("org.h2.Driver").username("sa").password("").build();

	/** The driver class name. */
	private String driverClassName;

	/** The password. */
	private String password;

	/** The url. */
	private String url;

	/** The username. */
	private String username;
}