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
package io.github.astrapi69.spring.orm.jpa;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import io.github.astrapi69.spring.datasource.DataSourceBean;


/**
 * A factory class for creating jpa configuration objects.
 */
public class SpringJpaFactory
{

	/**
	 * Factory method for create the new {@link DataSource} object from the given
	 * {@link DataSourceBean} object.
	 *
	 * @param dataSourceBean
	 *            the {@link DataSourceBean} object
	 * @return the new {@link DataSource}
	 */
	public static DataSource newDataSource(final DataSourceBean dataSourceBean)
	{
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceBean.getDriverClassName());
		dataSource.setUrl(dataSourceBean.getUrl());
		dataSource.setUsername(dataSourceBean.getUsername());
		dataSource.setPassword(dataSourceBean.getPassword());
		return dataSource;
	}

	/**
	 * Factory method for create the new {@link LocalContainerEntityManagerFactoryBean} object from
	 * the given persistence unit name as {@link String} object, the {@link DataSource} object, the
	 * {@link JpaVendorAdapter} object and the jpa {@link Properties}.
	 *
	 * @param persistenceUnitName
	 *            the persistence unit name
	 * @param dataSource
	 *            the data source
	 * @param vendorAdapter
	 *            the vendor adapter
	 * @param jpaProperties
	 *            the jpa properties
	 * @return the new {@link LocalContainerEntityManagerFactoryBean} object
	 */
	public static LocalContainerEntityManagerFactoryBean newEntityManagerFactoryBean(
		String persistenceUnitName, DataSource dataSource, JpaVendorAdapter vendorAdapter,
		Properties jpaProperties)
	{
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setPersistenceUnitName(persistenceUnitName);
		entityManagerFactoryBean.setDataSource(dataSource);

		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean;
	}

	/**
	 * Factory method for create the new {@link JdbcTemplate} object from the given
	 * {@link DataSource} object.
	 *
	 * @param dataSource
	 *            the {@link DataSource} object
	 * @return the new {@link JdbcTemplate}
	 */
	public static JdbcTemplate newJdbcTemplate(DataSource dataSource)
	{
		JdbcTemplate jdbcTemplate;
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	/**
	 * Factory method for create the new {@link JpaVendorAdapter} object from the given
	 * {@link Database} object.
	 *
	 * @param db
	 *            the {@link Database} object
	 * @return the new {@link JpaVendorAdapter}
	 */
	public static JpaVendorAdapter newJpaVendorAdapter(Database db)
	{
		final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(db);
		return hibernateJpaVendorAdapter;
	}

	/**
	 * Factory method for create the new {@link JpaTransactionManager} object from the given
	 * {@link EntityManagerFactory} object.
	 *
	 * @param entityManagerFactory
	 *            {@link EntityManagerFactory} object
	 * @return the new {@link JpaTransactionManager}
	 */
	public static JpaTransactionManager newTransactionManager(
		EntityManagerFactory entityManagerFactory)
	{
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

}
