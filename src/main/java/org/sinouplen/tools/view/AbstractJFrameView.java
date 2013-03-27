package org.sinouplen.tools.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.sinouplen.tools.controller.SynchronizeController;
import org.sinouplen.tools.session.ISession;
import org.sinouplen.tools.session.ToolsSessionVariables;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public class AbstractJFrameView extends JFrame implements IView, Runnable {

	private static final long serialVersionUID = 8909784008763933074L;

	private String name;
	@Autowired
	private SynchronizeController synchronizerController;
	@Autowired
	protected ISession session;
	private Thread threadView;
	private Map<String, AbstractJPanelView> contentPanel;

	public AbstractJFrameView() {
		this.initialize();
	}

	private void initialize() {
		contentPanel = new HashMap<String, AbstractJPanelView>();
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

	/**
	 * @return the contentPanel
	 */
	public Map<String, AbstractJPanelView> getContentPanel() {
		return contentPanel;
	}

	public void showView() {
		if (this.threadView == null) {
			this.threadView = new Thread(this);
			this.threadView.start();
		} else {
			this.setVisible(true);
		}
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
