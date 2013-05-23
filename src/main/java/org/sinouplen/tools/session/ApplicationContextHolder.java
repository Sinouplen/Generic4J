/**
 * 
 */
package org.sinouplen.tools.session;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Sinouplen
 * 
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext _applicationContext;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		_applicationContext = applicationContext;
	}

	/**
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return _applicationContext;
	}

}
