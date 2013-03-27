/**
 * 
 */
package org.sinouplen.tools.action;

import java.util.Map;

import org.sinouplen.tools.view.IView;

/**
 * @author Sinouplen
 * 
 */
public class InfosAction {

	private IAction action;
	private IView view;
	private Map<String, IView> steps;

	/**
	 * @return Returns the action.
	 */
	public IAction getAction() {
		return this.action;
	}

	/**
	 * @param action
	 *            The action to set.
	 */
	public void setAction(IAction action) {
		this.action = action;
	}

	/**
	 * @return Returns the steps.
	 */
	public Map<String, IView> getSteps() {
		return this.steps;
	}

	/**
	 * @param steps
	 *            The steps to set.
	 */
	public void setSteps(Map<String, IView> steps) {
		this.steps = steps;
	}

	/**
	 * @return Returns the view.
	 */
	public IView getView() {
		return view;
	}

	/**
	 * @param view
	 *            The view to set.
	 */
	public void setView(IView view) {
		this.view = view;
	}
}
