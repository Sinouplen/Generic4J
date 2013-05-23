/**
 * 
 */
package org.sinouplen.tools.view;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.sinouplen.tools.controller.SynchronizeController;
import org.sinouplen.tools.session.ISession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public abstract class AbstractJTextFieldView extends JTextField {

	private static final long serialVersionUID = 2496533512356845218L;

	@Autowired
	protected SynchronizeController synchronizerController;
	@Autowired
	protected ISession session;

	/**
	 * 
	 */
	public void showView() {
		this.setVisible(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

	/**
	 * 
	 */
	public void hidden() {
		this.setVisible(false);
	}
}
