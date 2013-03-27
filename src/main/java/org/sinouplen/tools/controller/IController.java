/**
 * 
 */
package org.sinouplen.tools.controller;

import java.util.Map;

import org.sinouplen.tools.action.InfosAction;

/**
 * @author Sinouplen
 * 
 */
public interface IController {

	/**
	 * execute controller
	 */
	public void run();

	/**
	 * @return
	 */
	public Map<String, InfosAction> getInfosActions();

	/**
	 * @param Actions
	 */
	public void setInfosActions(Map<String, InfosAction> Actions);

	/**
	 * @return
	 */
	public String getFirstActionName();

	/**
	 * @param firstActionName
	 */
	public void setFirstActionName(String firstActionName);

	/**
	 * @return
	 */
	public String getLastActionName();

	/**
	 * @param lastActionName
	 */
	public void setLastActionName(String lastActionName);
}
