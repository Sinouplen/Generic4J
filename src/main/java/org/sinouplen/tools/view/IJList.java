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

	public void showView();

	public void hidden();

	public void disable();

	public void setName(String name);

	public String getName();

	public void actionToExecute(String executedAction);

	/* BEGIN : Redefine functions of JButton */
	public Object getSelectedValue();

	public Object[] getSelectedValues();

	public void setModel(ListModel listModel);

	public ListModel getModel();

	public void setSelectionMode(int selectionMode);

	public int getSelectionMode();

	public Container getParent();

	public JRootPane getRootPane();

	public void addListSelectionListener(
			ListSelectionListener listSelectionListener);
	/* END : Redefine functions of JButton */
}
