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
package io.github.astrapi69.hibernate.generator;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import io.github.astrapi69.data.identifiable.GenericIdentifiable;

/**
 * The class {@link IdentifiableSequenceStyleGenerator} is custom implementation of
 * {@link SequenceStyleGenerator} that can be used in the GenericGenerator
 */
public class IdentifiableSequenceStyleGenerator extends SequenceStyleGenerator
{

	/**
	 * The Constant for the fully qualified class name that can be used in the GenericGenerator for
	 * the strategy attribute
	 */
	public static final String STRATEGY_CLASS_NAME = "io.github.astrapi69.hibernate.generator.IdentifiableSequenceStyleGenerator";

	@SuppressWarnings("rawtypes")
	public Object generate(SharedSessionContractImplementor session, Object object)
		throws HibernateException
	{
		if (object instanceof GenericIdentifiable)
		{
			GenericIdentifiable identifiable = (GenericIdentifiable)object;
			Object id = identifiable.getId();
			if (id != null)
			{
				return id;
			}
		}
		return super.generate(session, object);
	}
}
