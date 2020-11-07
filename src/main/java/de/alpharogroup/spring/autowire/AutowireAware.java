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
package de.alpharogroup.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Utility class for autowire classes like in jpa listeners
 */
@Component
public final class AutowireAware implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * Try to autowire the given object that contains the bean instances which need
	 * to be autowired
	 *
	 * @param classHolderToAutowire  the holder instance of the class which
	 *                               holds @Autowire annotations
	 * @param beansToAutowireInClass the beans which have the @Autowire annotation
	 *                               in the specified {#classHolderToAutowire}
	 */
	public static void autowire(Object classHolderToAutowire, Object... beansToAutowireInClass) {
		for (Object bean : beansToAutowireInClass) {
			if (bean == null) {
				applicationContext.getAutowireCapableBeanFactory().autowireBean(classHolderToAutowire);
			}
		}
	}

	private AutowireAware() {
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) {
		AutowireAware.applicationContext = applicationContext;
	}

}