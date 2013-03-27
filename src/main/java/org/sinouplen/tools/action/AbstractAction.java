package org.sinouplen.tools.action;

import org.sinouplen.tools.session.ISession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public abstract class AbstractAction implements IAction {

	@Autowired
	protected ISession session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sinouplen.tools.action.IAction#execute()
	 */
	public abstract String execute();
}
