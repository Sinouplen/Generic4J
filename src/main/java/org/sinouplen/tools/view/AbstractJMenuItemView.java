package org.sinouplen.tools.view;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import org.sinouplen.tools.controller.SynchronizeController;
import org.sinouplen.tools.session.ISession;
import org.sinouplen.tools.session.ToolsSessionVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sinouplen
 * 
 */
@Component
public class AbstractJMenuItemView extends JMenuItem implements IJMenuItem,
		IView {

	private static final long serialVersionUID = 2162807647359465874L;

	private String name;
	@Autowired
	private SynchronizeController synchronizerController;
	@Autowired
	protected ISession session;

	public AbstractJMenuItemView() {

	}

	public AbstractJMenuItemView(String name) {
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	public void showView() {
		this.setVisible(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void hidden() {
		this.setVisible(false);
	}

	public void actionToExecute(String executedAction) {
		this.session.getObjectContextMap().put(
				ToolsSessionVariables.NEXT_EXECUTED_ACTION, executedAction);
		this.synchronizerController.set();
	}

	public void run() {
		this.setVisible(true);
	}
}
