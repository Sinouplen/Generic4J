/**
 * 
 */
package org.sinouplen.tools.view;

/**
 * @author Sinouplen
 * 
 */
public interface IView {

	public void showView();

	public void hidden();

	public void disable();

	public void setName(String name);

	public String getName();

	public void actionToExecute(String executedAction);
}
