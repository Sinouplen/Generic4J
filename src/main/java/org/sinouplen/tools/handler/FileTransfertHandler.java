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

	private boolean hasFileFlavor(DataFlavor[] dataFlavors) {
		boolean result = false;
		for (DataFlavor dataFlavor : dataFlavors) {
			if (DataFlavor.javaFileListFlavor.equals(dataFlavor)) {
				break;
			}
		}
		return result;
	}

	private boolean hasStringFlavor(DataFlavor[] dataFlavors) {
		boolean result = false;
		for (DataFlavor dataFlavor : dataFlavors) {
			if (DataFlavor.stringFlavor.equals(dataFlavor)) {
				break;
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
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
				// System.out.println(builder.toString());
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		if (this.hasStringFlavor(transferable.getTransferDataFlavors())) {
			try {
				String myData = CastTrouble.cast(transferable
						.getTransferData(DataFlavor.stringFlavor));
				// System.out.println(myData);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
