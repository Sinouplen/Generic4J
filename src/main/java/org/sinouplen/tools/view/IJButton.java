/**
 * 
 */
package org.sinouplen.tools.view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JRootPane;

/**
 * @author Sinouplen
 * 
 */
public interface IJButton {

	public void showView();

	public void hidden();

	public void setName(String name);

	public String getName();

	public void actionToExecute(String action);

	public boolean isSelected();

	public void setSelected(boolean isSelected);

	/* BEGIN : Redefine functions of JButton */
	public Color getBackground();

	public void setBackground(Color backgroundColor);

	public Container getParent();

	public JRootPane getRootPane();

	public String getText();

	public void setText(String text);
	/* END : Redefine functions of JButton */
}
