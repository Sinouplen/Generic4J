package org.sinouplen.tools.session;

import java.util.List;
import java.util.Map;

/**
 * @author Sinouplen
 * 
 */
public interface ISession {

	/**
	 * @return
	 */
	public List<String> getTextErrors();
	
	/**
	 * @return
	 */
	public List<String> getTextMessages();
	
	/**
	 * @return
	 */
	public Map<String, Object> getObjectContextMap();

}
