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