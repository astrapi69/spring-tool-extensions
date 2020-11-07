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
package de.alpharogroup.spring.batch.factory;

import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

import de.alpharogroup.reflection.ReflectionExtensions;
import de.alpharogroup.spring.batch.mapper.CustomBeanWrapperFieldSetMapper;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SpringBatchObjectFactory {

	public static final String READER_SUFFIX = "Reader";
	public static final String WRITER_SUFFIX = "Writer";

	public static <T> JdbcBatchItemWriter<T> newJdbcBatchItemWriter(final @NonNull DataSource dataSource,
			final @NonNull String sql) {
		return new JdbcBatchItemWriterBuilder<T>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>()).sql(sql)
				.dataSource(dataSource).build();
	}

	public static <T> FlatFileItemReader<T> newCsvFileItemReader(final @NonNull Resource resource,
			final @NonNull Class<T> typeClass, final @NonNull String delimiter, final int linesToSkip) {
		return newCsvFileItemReader(resource, typeClass, DateTimeFormatter.ofPattern("dd-MM-yyyy"), delimiter,
				linesToSkip);
	}

	public static <T> FlatFileItemReader<T> newCsvFileItemReader(final @NonNull Resource resource,
			final @NonNull Class<T> typeClass, final @NonNull DateTimeFormatter formatter,
			final @NonNull String delimiter, final int linesToSkip) {
		return newCsvFileItemReader(resource, typeClass, new CustomBeanWrapperFieldSetMapper<>(typeClass, formatter),
				delimiter, linesToSkip);
	}

	public static <T> FlatFileItemReader<T> newCsvFileItemReader(final @NonNull Resource resource,
			final @NonNull Class<T> typeClass, final @NonNull FieldSetMapper<T> fieldSetMapper,
			final @NonNull String delimiter, final int linesToSkip) {
		DefaultLineMapper<T> lineMapper = new DefaultLineMapper<>();
		String[] fieldNames = ReflectionExtensions.getDeclaredFieldNames(typeClass);
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(delimiter);
		delimitedLineTokenizer.setNames(fieldNames);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		lineMapper.setLineTokenizer(delimitedLineTokenizer);
		return new FlatFileItemReaderBuilder<T>().name(typeClass.getSimpleName() + READER_SUFFIX).resource(resource)
				.lineMapper(lineMapper).linesToSkip(linesToSkip).build();
	}

	public static <T> JpaItemWriter<T> newJpaItemWriter(final @NonNull EntityManagerFactory entityManagerFactory) {
		JpaItemWriter<T> writer = new JpaItemWriter<>();
		writer.setEntityManagerFactory(entityManagerFactory);
		return writer;
	}

	public static <T> CustomBeanWrapperFieldSetMapper<T> newCustomBeanWrapperFieldSetMapper(
			final @NonNull Class<? extends T> typeClass, final @NonNull DateTimeFormatter formatter) {
		return new CustomBeanWrapperFieldSetMapper<>(typeClass, formatter);
	}

}
