/**
 * 
 */
package org.sinouplen.tools.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Sinouplen
 * 
 */
@Component(MyContextWrapper.BEAN_NAME)
public class MyContextWrapper implements ApplicationContextAware,
		BeanFactoryPostProcessor {

	private ApplicationContext applicationContext;
	private ConfigurableListableBeanFactory beanFactory;

	protected static final String BEAN_NAME = "applicationContext";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#
	 * postProcessBeanFactory
	 * (org.springframework.beans.factory.config.ConfigurableListableBeanFactory
	 * )
	 */
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * @return the beanFactory
	 */
	public ConfigurableListableBeanFactory getBeanFactory() {
		return beanFactory;
	}

	/**
	 * @param beanFactory
	 *            the beanFactory to set
	 */
	public void setBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
