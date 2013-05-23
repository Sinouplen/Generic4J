/**
 * 
 */
package org.sinouplen.tools.controller;

import org.springframework.stereotype.Component;

/**
 * @author Sinouplen
 * 
 */
@Component
public class SynchronizeController {

	// State open or closed
	private boolean open;

	/**
	 * @return Returns the ouverte.
	 */
	public boolean isOpen() {
		return this.open;
	}

	/**
	 * @param ouverte
	 *            The ouverte to set.
	 */
	public synchronized void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * Closed the listener
	 */
	public synchronized void reset() {
		this.open = false;
	}

	/**
	 * Opened the listener
	 */
	public synchronized void set() {
		if (!this.open) {
			this.open = true;
			this.notify();
		}
	}

	/**
	 * Wait the next event
	 * 
	 * @throws RuntimeException
	 */
	public synchronized void waitOne() throws RuntimeException {
		while (!this.open) {
			try {
				this.wait();
			} catch (InterruptedException ex) {
				throw new RuntimeException(ex.toString());
			}
		}
	}

}
