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
 * The enum class {@link BaseRestPath} holds constants for the base rest path values
 */
@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum BaseRestPath
{
	/** The enum value for the rest path VERSION 1 */
	VERSION_1(BaseRestPath.REST_VERSION_1),
	/** The enum value for the regex docket path version 1 */
	VERSION_1_DOCKET_PATHS_REGEX(BaseRestPath.REST_VERSION_1_DOCKET_PATHS_REGEX),
	/** The enum value for the rest path VERSION 2 */
	VERSION_2(BaseRestPath.REST_VERSION_2),
	/** The enum value for the regex docket path version 2 */
	VERSION_2_DOCKET_PATHS_REGEX(BaseRestPath.REST_VERSION_2_DOCKET_PATHS_REGEX),
	/** The enum value for the rest path VERSION 3 */
	VERSION_3(BaseRestPath.REST_VERSION_3),
	/** The enum value for the regex docket path version 3 */
	VERSION_3_DOCKET_PATHS_REGEX(BaseRestPath.REST_VERSION_3_DOCKET_PATHS_REGEX),
	/** The enum value for the rest path VERSION 4 */
	VERSION_4(BaseRestPath.REST_VERSION_4),
	/** The enum value for the regex docket path version 4 */
	VERSION_4_DOCKET_PATHS_REGEX(BaseRestPath.REST_VERSION_4_DOCKET_PATHS_REGEX),
	/** The enum value for the rest path VERSION 5 */
	VERSION_5(BaseRestPath.REST_VERSION_5),
	/** The enum value for the regex docket path version 1 */
	VERSION_5_DOCKET_PATHS_REGEX(BaseRestPath.REST_VERSION_5_DOCKET_PATHS_REGEX);

	public static final String SLASH = "/";
	public static final String REST_DOCKET_PATHS_REGEX_SUFFIX = "/.*|";
	public static final String REST_API_VERSION_1 = "v1";
	public static final String REST_API_VERSION_2 = "v2";
	public static final String REST_API_VERSION_3 = "v3";
	public static final String REST_API_VERSION_4 = "v4";
	public static final String REST_API_VERSION_5 = "v5";
	public static final String REST_VERSION_1 = SLASH + REST_API_VERSION_1;
	public static final String REST_VERSION_1_DOCKET_PATHS_REGEX = REST_VERSION_1
		+ REST_DOCKET_PATHS_REGEX_SUFFIX;
	public static final String REST_VERSION_2 = SLASH + REST_API_VERSION_2;
	public static final String REST_VERSION_2_DOCKET_PATHS_REGEX = REST_VERSION_2
		+ REST_DOCKET_PATHS_REGEX_SUFFIX;
	public static final String REST_VERSION_3 = SLASH + REST_API_VERSION_3;
	public static final String REST_VERSION_3_DOCKET_PATHS_REGEX = REST_VERSION_3
		+ REST_DOCKET_PATHS_REGEX_SUFFIX;
	public static final String REST_VERSION_4 = SLASH + REST_API_VERSION_4;
	public static final String REST_VERSION_4_DOCKET_PATHS_REGEX = REST_VERSION_4
		+ REST_DOCKET_PATHS_REGEX_SUFFIX;
	public static final String REST_VERSION_5 = SLASH + REST_API_VERSION_5;
	public static final String REST_VERSION_5_DOCKET_PATHS_REGEX = REST_VERSION_5
		+ REST_DOCKET_PATHS_REGEX_SUFFIX;

	String value;

}
