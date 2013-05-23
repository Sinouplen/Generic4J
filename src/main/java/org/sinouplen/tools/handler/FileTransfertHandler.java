/**
 * 
 */
package org.sinouplen.tools.handler;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import org.apache.log4j.Logger;
import org.sinouplen.tools.CastTrouble;

/**
 * @author Sinouplen
 * 
 */
public class FileTransfertHandler extends TransferHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -60770920939920373L;

	private static final Logger LOGGER = Logger
			.getLogger(FileTransfertHandler.class);

	/**
	 * @param jComponent
	 * @param dataFlavors
	 * @return
	 */
	public boolean canimport(JComponent jComponent, DataFlavor[] dataFlavors) {
		for (int i = 0; i < dataFlavors.length; i++) {
			if (dataFlavors[i].equals(DataFlavor.javaFileListFlavor)) {
				return true;
			}
			if (dataFlavors[i].equals(DataFlavor.stringFlavor)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param dataFlavors
	 * @return
	 */
	private boolean hasFileFlavor(DataFlavor[] dataFlavors) {
		boolean result = false;
		for (DataFlavor dataFlavor : dataFlavors) {
			if (DataFlavor.javaFileListFlavor.equals(dataFlavor)) {
				break;
			}
		}
		return result;
	}

	/**
	 * @param dataFlavors
	 * @return
	 */
	private boolean hasStringFlavor(DataFlavor[] dataFlavors) {
		boolean result = false;
		for (DataFlavor dataFlavor : dataFlavors) {
			if (DataFlavor.stringFlavor.equals(dataFlavor)) {
				break;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.TransferHandler#importData(javax.swing.JComponent,
	 * java.awt.datatransfer.Transferable)
	 */
	@Override
	public boolean importData(JComponent jComponent, Transferable transferable) {
		if (this.hasFileFlavor(transferable.getTransferDataFlavors())) {
			try {
				List<File> files = CastTrouble.cast(transferable
						.getTransferData(DataFlavor.javaFileListFlavor));
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < files.size(); i++) {
					File file = files.get(i);
					builder.append(file.getAbsolutePath()).append("\n");
				}
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(builder.toString());
				}
				return true;
			} catch (Exception e) {
				LOGGER.error(e);
			}
			return false;
		}
		if (this.hasStringFlavor(transferable.getTransferDataFlavors())) {
			try {
				String myData = CastTrouble.cast(transferable
						.getTransferData(DataFlavor.stringFlavor));

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(myData);
				}
				return true;
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		return false;
	}

}
