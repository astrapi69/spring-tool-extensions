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
package io.github.astrapi69.spring.cache.factory;

import java.util.List;

import lombok.experimental.UtilityClass;

import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;

import io.github.astrapi69.collection.list.ListFactory;

/**
 * A factory class for creating cache configuration objects.
 */
@UtilityClass
public class SpringCacheConfigurationFactory
{

	/**
	 * Factory method for create the new composite {@link CacheManager} from the given
	 * {@link CacheManager}'s.
	 *
	 * @param cacheCacheManager
	 *            the cache cache manager
	 * @return the new {@link CacheManager}
	 */
	public static CacheManager newCacheManager(final CacheManager... cacheCacheManager)
	{

		final List<CacheManager> cacheManagers = ListFactory.newArrayList();
		for (final CacheManager cm : cacheCacheManager)
		{
			if (cm != null)
			{
				cacheManagers.add(cm);
			}
		}

		final CompositeCacheManager cacheManager = new CompositeCacheManager();

		cacheManager.setCacheManagers(cacheManagers);
		cacheManager.setFallbackToNoOpCache(false);

		return cacheManager;
	}

	/**
	 * Factory method for create the new {@link SimpleKeyGenerator} object.
	 *
	 * @return the new {@link SimpleKeyGenerator}
	 */
	public static KeyGenerator newSimpleKeyGenerator()
	{
		return new SimpleKeyGenerator();
	}

	/**
	 * Factory method for create the new {@link SimpleCacheResolver} object.
	 *
	 * @return the new {@link SimpleCacheResolver}
	 */
	public static CacheResolver newSimpleCacheResolver()
	{
		return new SimpleCacheResolver();
	}

	/**
	 * Factory method for create the new {@link SimpleCacheErrorHandler} object.
	 *
	 * @return the new {@link SimpleCacheErrorHandler}
	 */
	public static CacheErrorHandler newSimpleCacheErrorHandler()
	{
		return new SimpleCacheErrorHandler();
	}

}
