/**
 * 
 */
package org.sinouplen.tools.view;

import javax.swing.JList;
import javax.swing.SwingUtilities;

import org.sinouplen.tools.controller.SynchronizeController;
import org.sinouplen.tools.session.ISession;
import org.sinouplen.tools.session.ToolsSessionVariables;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public abstract class AbstractJList extends JList implements IJList {

	private static final long serialVersionUID = 6094461624428694431L;

	@Autowired
	protected SynchronizeController synchronizerController;
	@Autowired
	protected ISession session;

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.view.IJList#showView()
	 */
	public void showView() {
		this.setVisible(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.view.IJList#hidden()
	 */
	public void hidden() {
		this.setVisible(false);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.view.IJList#actionToExecute(java.lang.String)
	 */
	public void actionToExecute(String action) {
		this.session.getObjectContextMap().put(
				ToolsSessionVariables.NEXT_EXECUTED_ACTION, action);
		this.synchronizerController.set();
	}

}
