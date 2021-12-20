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
package io.github.astrapi69.spring.batch.mapper;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.validation.DataBinder;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomBeanWrapperFieldSetMapper<T> extends BeanWrapperFieldSetMapper<T>
{

	@NonNull
	DateTimeFormatter formatter;

	public CustomBeanWrapperFieldSetMapper(@NonNull Class<? extends T> type,
		@NonNull DateTimeFormatter formatter)
	{
		setTargetType(type);
		this.formatter = formatter;
	}

	@Override
	protected void initBinder(DataBinder binder)
	{
		binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport()
		{
			@Override
			public String getAsText()
			{
				Object date = getValue();
				if (date != null)
				{
					return formatter.format((LocalDateTime)getValue());
				}
				else
				{
					return "";
				}
			}

			@Override
			public void setAsText(String text)
			{
				if (!text.isEmpty())
				{
					setValue(LocalDateTime.parse(text, formatter));
				}
				else
				{
					setValue(null);
				}
			}
		});
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport()
		{
			@Override
			public String getAsText()
			{
				Object date = getValue();
				if (date != null)
				{
					return formatter.format((LocalDate)getValue());
				}
				else
				{
					return "";
				}
			}

			@Override
			public void setAsText(String text)
			{
				if (!text.isEmpty())
				{
					setValue(LocalDate.parse(text, formatter));
				}
				else
				{
					setValue(null);
				}
			}
		});
		binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport()
		{
			@Override
			public String getAsText()
			{
				Object date = getValue();
				if (date != null)
				{
					return formatter.format((LocalTime)getValue());
				}
				else
				{
					return "";
				}
			}

			@Override
			public void setAsText(String text)
			{
				if (!text.isEmpty())
				{
					setValue(LocalTime.parse(text, formatter));
				}
				else
				{
					setValue(null);
				}
			}
		});
	}
}
