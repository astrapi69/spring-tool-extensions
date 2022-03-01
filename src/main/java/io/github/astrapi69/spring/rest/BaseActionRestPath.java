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
package io.github.astrapi69.spring.rest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * The enum class {@link BaseActionRestPath} holds constants for the base action that follows after
 * base rest paths
 */
@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum BaseActionRestPath
{
	/** The constant for the action save */
	SAVE(BaseActionRestPath.ACTION_SAVE),
	/** The constant for the action persist. */
	PERSIST(BaseActionRestPath.ACTION_PERSIST),
	/** The constant for the action update. */
	UPDATE(BaseActionRestPath.ACTION_UPDATE),
	/** The constant for the action save or update */
	SAVE_OR_UPDATE(BaseActionRestPath.ACTION_SAVE_OR_UPDATE),
	/** The constant for the action delete */
	DELETE(BaseActionRestPath.ACTION_DELETE),
	/** The constant for the action find */
	FIND(BaseActionRestPath.ACTION_FIND),
	/** The constant for the action find by */
	FIND_BY(BaseActionRestPath.ACTION_FIND_BY),
	/** The constant for the action find all */
	FIND_ALL(BaseActionRestPath.ACTION_FIND_ALL),
	/** The constant for the action find by name */
	FIND_BY_NAME(BaseActionRestPath.ACTION_FIND_BY_NAME);

	public static final String ACTION_SAVE = "/save";
	public static final String ACTION_PERSIST = "/persist";
	public static final String ACTION_UPDATE = "/update";
	public static final String ACTION_SAVE_OR_UPDATE = ACTION_SAVE + "/or" + ACTION_UPDATE;
	public static final String ACTION_DELETE = "/delete";
	public static final String ACTION_FIND = "/find";
	public static final String ACTION_FIND_BY = ACTION_FIND + "/by";
	public static final String ACTION_FIND_BY_NAME = ACTION_FIND_BY + "/name";
	public static final String ACTION_FIND_ALL = ACTION_FIND + "/all";
	String value;
}
