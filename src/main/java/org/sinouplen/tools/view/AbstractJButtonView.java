/**
 * 
 */
package org.sinouplen.tools.view;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import org.sinouplen.tools.controller.SynchronizeController;
import org.sinouplen.tools.session.ISession;
import org.sinouplen.tools.session.ToolsSessionVariables;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public abstract class AbstractJButtonView extends JButton implements IJButton {

	private static final long serialVersionUID = 692318717025682344L;

	@Autowired
	protected SynchronizeController synchronizerController;
	@Autowired
	protected ISession session;

	public void showView() {
		this.setVisible(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void hidden() {
		this.setVisible(false);
	}

	public void actionToExecute(String action) {
		this.session.getObjectContextMap().put(
				ToolsSessionVariables.NEXT_EXECUTED_ACTION, action);
		this.synchronizerController.set();
	}

}
