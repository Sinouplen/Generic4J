/**
 * 
 */
package org.sinouplen.tools.view;

/**
 * @author Sinouplen
 * 
 */
public interface IJMenuItem {

	public void showView();

	public void hidden();

	public void setName(String name);

	public String getName();

	public void actionToExecute(String action);
}
