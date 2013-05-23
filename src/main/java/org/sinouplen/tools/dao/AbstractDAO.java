/**
 * 
 */
package org.sinouplen.tools.dao;


/**
 * @author Sinouplen
 * 
 * @param <T>
 * 
 */
public abstract class AbstractDAO<T> {

	protected Class<T> currentClass;

	/**
	 * @param currentClass
	 */
	public final void setClazz(final Class<T> currentClass) {
		this.currentClass = currentClass;
	}

}
