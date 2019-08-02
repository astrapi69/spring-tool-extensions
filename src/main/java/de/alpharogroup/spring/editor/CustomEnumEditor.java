package de.alpharogroup.spring.editor;

import java.beans.PropertyEditorSupport;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("rawtypes")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomEnumEditor<T extends Enum> extends PropertyEditorSupport {
    @NonNull Class<T> enumClass;

    public CustomEnumEditor(@NonNull Class<T> enumClass) {
        this.enumClass = enumClass;
    }

	@Override
	public String getAsText() {
        return (getValue() == null ? null : ((Enum) getValue()).name());
    }

    @SuppressWarnings("unchecked")
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isBlank(text) || StringUtils.equalsIgnoreCase(text, "-1")) {
            setValue(null);
        } else {
            setValue(Enum.<T>valueOf(this.enumClass, text));
        }
    }
}