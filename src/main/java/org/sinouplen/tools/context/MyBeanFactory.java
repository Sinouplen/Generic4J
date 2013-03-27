/**
 * 
 */
package org.sinouplen.tools.context;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.stereotype.Component;

/**
 * @author Sinouplen
 * 
 */
@Component(MyBeanFactory.BEAN_NAME)
public class MyBeanFactory extends BeanFactoryUtils {

	protected static final String BEAN_NAME = "springBeanFactory";

}
