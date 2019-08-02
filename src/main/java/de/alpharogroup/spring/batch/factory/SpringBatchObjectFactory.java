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
import lombok.experimental.UtilityClass;

@UtilityClass
public class SpringBatchObjectFactory {

	private static final String READER_SUFFIX = "Reader";

	public static <T> JdbcBatchItemWriter<T> newJdbcBatchItemWriter(DataSource dataSource, String sql){
		return new JdbcBatchItemWriterBuilder<T>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql(sql)
        .dataSource(dataSource)
        .build();
	}

	public static <T> FlatFileItemReader<T> newCsvFileItemReader(Resource resource, Class<T> typeClass,
		String delimiter, int linesToSkip) {
		return newCsvFileItemReader(resource, typeClass, new CustomBeanWrapperFieldSetMapper<>(typeClass, DateTimeFormatter
			.ofPattern("dd-MM-yyyy")), delimiter, linesToSkip);
	}

	public static <T> FlatFileItemReader<T> newCsvFileItemReader(Resource resource, Class<T> typeClass,
		FieldSetMapper<T> fieldSetMapper, String delimiter, int linesToSkip) {
		DefaultLineMapper<T> lineMapper = new DefaultLineMapper<>();
		String[] fieldNames = ReflectionExtensions.getDeclaredFieldNames(typeClass);
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(delimiter);
		delimitedLineTokenizer.setNames(fieldNames);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		lineMapper.setLineTokenizer(delimitedLineTokenizer);
		return new FlatFileItemReaderBuilder<T>()
			.name(typeClass.getSimpleName() + READER_SUFFIX)
			.resource(resource)
			.lineMapper(lineMapper).linesToSkip(linesToSkip).build();
	}

	public static <T> JpaItemWriter<T> newJpaItemWriter(EntityManagerFactory entityManagerFactory) {
		JpaItemWriter<T> writer = new JpaItemWriter<>();
		writer.setEntityManagerFactory(entityManagerFactory);
		return writer;
	}

}
