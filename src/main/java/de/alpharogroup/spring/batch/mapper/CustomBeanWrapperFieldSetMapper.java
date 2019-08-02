package de.alpharogroup.spring.batch.mapper;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.validation.DataBinder;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomBeanWrapperFieldSetMapper<T> extends BeanWrapperFieldSetMapper<T> {

    @NonNull
    DateTimeFormatter formatter;

    public CustomBeanWrapperFieldSetMapper(@NonNull Class<? extends T> type, @NonNull DateTimeFormatter formatter) {
        setTargetType(type);
        this.formatter = formatter;
    }

    @Override
    protected void initBinder(DataBinder binder) {
         binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (!text.isEmpty()) {
                    setValue(LocalDateTime.parse(text, formatter));
                } else {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                Object date = getValue();
                if (date != null) {
                    return formatter.format((LocalDateTime) getValue());
                } else {
                    return "";
                }
            }
        });
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (!text.isEmpty()) {
                    setValue(LocalDate.parse(text, formatter));
                } else {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                Object date = getValue();
                if (date != null) {
                    return formatter.format((LocalDate) getValue());
                } else {
                    return "";
                }
            }
        });
        binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (!text.isEmpty()) {
                    setValue(LocalTime.parse(text, formatter));
                } else {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                Object date = getValue();
                if (date != null) {
                    return formatter.format((LocalTime) getValue());
                } else {
                    return "";
                }
            }
        });
    }
}