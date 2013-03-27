package org.sinouplen.tools.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Sinouplen
 * 
 */
@Component(GUISession.BEAN_NAME)
public class GUISession implements ISession {

	public static final String BEAN_NAME = "guiSession";

	private List<String> textErrors = new ArrayList<String>();
	private List<String> textMessages = new ArrayList<String>();
	private Map<String, Object> objectContextMap = new HashMap<String, Object>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sinouplen.tools.session.ISession#getTextErrors()
	 */
	public List<String> getTextErrors() {
		return this.textErrors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sinouplen.tools.session.ISession#getTextMessages()
	 */
	public List<String> getTextMessages() {
		return this.textMessages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sinouplen.tools.session.ISession#getObjectContextMap()
	 */
	public Map<String, Object> getObjectContextMap() {
		return this.objectContextMap;
	}

}
