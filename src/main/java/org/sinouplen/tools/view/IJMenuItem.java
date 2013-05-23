/**
 * 
 */
package org.sinouplen.tools.view;

/**
 * @author Sinouplen
 * 
 */
public interface IJMenuItem {

	/**
	 * 
	 */
	void showView();

	/**
	 * 
	 */
	void hidden();

	/**
	 * @param name
	 */
	void setName(String name);

	/**
	 * @return
	 */
	String getName();

	/**
	 * @param action
	 */
	void actionToExecute(String action);
}
