package org.sinouplen.tools.view;

import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import org.sinouplen.tools.controller.SynchronizeController;
import org.sinouplen.tools.session.ISession;
import org.sinouplen.tools.session.ToolsSessionVariables;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public class AbstractJMenuBarView extends JMenuBar implements IView, Runnable {

	private static final long serialVersionUID = 8909784008763933074L;

	private String name;
	@Autowired
	private SynchronizeController synchronizerController;
	@Autowired
	protected ISession session;

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

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.view.IView#showView()
	 */
	public void showView() {
		this.setVisible(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.view.IView#hidden()
	 */
	public void hidden() {
		this.setVisible(false);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.view.IView#actionToExecute(java.lang.String)
	 */
	public void actionToExecute(String executedAction) {
		this.session.getObjectContextMap().put(
				ToolsSessionVariables.NEXT_EXECUTED_ACTION, executedAction);
		this.synchronizerController.set();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.setVisible(true);
	}
}
