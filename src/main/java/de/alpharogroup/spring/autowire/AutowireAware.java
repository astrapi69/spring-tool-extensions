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

	private AutowireAware() {
	}

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

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) {
		AutowireAware.applicationContext = applicationContext;
	}

}