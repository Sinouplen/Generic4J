/**
 * 
 */
package org.sinouplen.tools.services.exception;

/**
 * @author Sinouplen
 * 
 */
public class GenericServiceException extends Exception {

	private static final long serialVersionUID = 7664011544853583190L;

	public GenericServiceException(String string) {
		super(string);
	}

	public GenericServiceException(Throwable e) {
		super(e);
	}
}
