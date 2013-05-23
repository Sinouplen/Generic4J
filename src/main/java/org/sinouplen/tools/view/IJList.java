/**
 * 
 */
package org.sinouplen.tools.view;

import java.awt.Container;

import javax.swing.JRootPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;

/**
 * @author Sinouplen
 * 
 */
public interface IJList {

	/**
	 * 
	 */
	void showView();

	/**
	 * 
	 */
	void hidden();

	/**
	 * 
	 */
	void disable();

	/**
	 * @param name
	 */
	void setName(String name);

	/**
	 * @return
	 */
	String getName();

	/**
	 * @param executedAction
	 */
	void actionToExecute(String executedAction);

	/* BEGIN : Redefine functions of JButton */
	/**
	 * @return
	 */
	Object getSelectedValue();

	/**
	 * @return
	 */
	Object[] getSelectedValues();

	/**
	 * @param listModel
	 */
	void setModel(ListModel listModel);

	/**
	 * @return
	 */
	ListModel getModel();

	/**
	 * @param selectionMode
	 */
	void setSelectionMode(int selectionMode);

	int getSelectionMode();

	/**
	 * @return
	 */
	Container getParent();

	/**
	 * @return
	 */
	JRootPane getRootPane();

	/**
	 * @param listSelectionListener
	 */
	void addListSelectionListener(ListSelectionListener listSelectionListener);
	/* END : Redefine functions of JButton */
}
