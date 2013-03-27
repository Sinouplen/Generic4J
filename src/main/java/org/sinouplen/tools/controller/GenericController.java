/**
 * 
 */
package org.sinouplen.tools.controller;

import java.awt.Component;
import java.awt.Cursor;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.sinouplen.tools.CastTrouble;
import org.sinouplen.tools.action.InfosAction;
import org.sinouplen.tools.session.ISession;
import org.sinouplen.tools.session.ToolsSessionVariables;
import org.sinouplen.tools.view.IView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public class GenericController implements IController {

	private static final Logger LOGGER = Logger
			.getLogger(GenericController.class);

	private Map<String, InfosAction> infosActions;
	private String firstActionName;
	private String lastActionName;
	@Autowired
	private SynchronizeController synchronizerController;
	@Autowired
	private ISession session;

	/**
	 * @return the actions
	 */
	public Map<String, InfosAction> getInfosActions() {
		return infosActions;
	}

	/**
	 * @param actions
	 *            the actions to set
	 */
	public void setInfosActions(Map<String, InfosAction> infosActions) {
		this.infosActions = infosActions;
	}

	/**
	 * @return the firstActionName
	 */
	public String getFirstActionName() {
		return firstActionName;
	}

	/**
	 * @param firstActionName
	 *            the firstActionName to set
	 */
	public void setFirstActionName(String firstActionName) {
		this.firstActionName = firstActionName;
	}

	/**
	 * @return the lastActionName
	 */
	public String getLastActionName() {
		return lastActionName;
	}

	/**
	 * @param lastActionName
	 *            the lastActionName to set
	 */
	public void setLastActionName(String lastActionName) {
		this.lastActionName = lastActionName;
	}

	/**
	 * @return the synchronizerController
	 */
	public SynchronizeController getSynchronizerController() {
		return synchronizerController;
	}

	/**
	 * @param synchronizerController
	 *            the synchronizerController to set
	 */
	public void setSynchronizerController(
			SynchronizeController synchronizerController) {
		this.synchronizerController = synchronizerController;
	}

	public void run() {
		InfosAction configAction = null;
		String actionName = null;
		String step = null;
		IView currentView = null;
		IView previousView = null;
		Component previousFrame = null;

		actionName = this.firstActionName;
		while (!actionName.equals(this.lastActionName)) {
			configAction = CastTrouble.cast(this.infosActions.get(actionName));
			if (configAction == null) {
				throw new RuntimeException("The action [" + actionName
						+ "] was not good configuration");
			}
			if (configAction.getAction() != null) {
				step = configAction.getAction().execute();
				currentView = CastTrouble.cast(configAction.getSteps()
						.get(step));
				if (currentView == null) {
					throw new RuntimeException("The step [" + step
							+ "] of the action [" + actionName
							+ "] was not good configuration");
				}
			} else {
				step = "";
				currentView = configAction.getView();
			}
			if (currentView != previousView && previousView != null) {
				if (currentView instanceof JFrame
						&& previousView instanceof JFrame
						&& currentView != previousView && previousView != null) {
					previousView.hidden();
				} else if (previousView instanceof JPanel
						&& currentView instanceof JPanel) {
					// previousView.disable();
				}
			}
			initView(actionName, step, currentView.getName());

			this.synchronizerController.reset();
			LOGGER.debug("BEGIN : Open View " + currentView.getName());
			currentView.showView();
			LOGGER.debug("END : Open View " + currentView.getName());
			Component component = CastTrouble.cast(currentView);
			Component mainFrame = SwingUtilities.getRoot(component);
			mainFrame.setCursor(Cursor.getDefaultCursor());
			if (previousFrame != null && mainFrame != previousFrame) {
				previousFrame.setCursor(Cursor.getDefaultCursor());
			}
			this.synchronizerController.waitOne();

			mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

			actionName = CastTrouble.cast(this.session.getObjectContextMap()
					.get(ToolsSessionVariables.NEXT_EXECUTED_ACTION));
			this.session.getObjectContextMap().remove(
					ToolsSessionVariables.NEXT_EXECUTED_ACTION);
			previousView = currentView;
			previousFrame = mainFrame;
		}
		if (currentView != null) {
			currentView.hidden();
		}
	}

	/**
	 * Override this methode to initialize a view
	 * 
	 * @param action
	 * @param step
	 * @param view
	 */
	public void initView(String action, String step, String view) {
		// Delegate action for the other derivate classes
	}
}
