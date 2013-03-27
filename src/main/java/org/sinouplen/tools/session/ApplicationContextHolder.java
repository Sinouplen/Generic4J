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

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		_applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return _applicationContext;
	}

}
