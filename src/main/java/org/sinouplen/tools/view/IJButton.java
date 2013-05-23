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

	/**
	 * 
	 */
	void showView();

	/**
	 * 
	 */
	void hidden();

	/**
	 * @param name
	 */
	void setName(String name);

	/**
	 * @return
	 */
	String getName();

	/**
	 * @param action
	 */
	void actionToExecute(String action);

	/**
	 * @return
	 */
	boolean isSelected();

	/**
	 * @param isSelected
	 */
	void setSelected(boolean isSelected);

	/* BEGIN : Redefine functions of JButton */
	/**
	 * @return
	 */
	Color getBackground();

	/**
	 * @param backgroundColor
	 */
	void setBackground(Color backgroundColor);

	/**
	 * @return
	 */
	Container getParent();

	JRootPane getRootPane();

	/**
	 * @return
	 */
	String getText();

	/**
	 * @param text
	 */
	void setText(String text);
	/* END : Redefine functions of JButton */
}
