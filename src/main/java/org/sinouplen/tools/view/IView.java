/**
 * 
 */
package org.sinouplen.tools.view;

/**
 * @author Sinouplen
 * 
 */
public interface IView {

	/**
	 * 
	 */
	void showView();

	/**
	 * 
	 */
	void hidden();

	/**
	 * 
	 */
	void disable();

	/**
	 * @param name
	 */
	void setName(String name);

	/**
	 * @return
	 */
	String getName();

	/**
	 * @param executedAction
	 */
	void actionToExecute(String executedAction);
}
