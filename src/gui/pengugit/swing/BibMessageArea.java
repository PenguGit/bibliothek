package gui.pengugit.swing;

import java.awt.Color;

public class BibMessageArea extends BibTextArea {
	/**
	 * Empties the Area
	 */
	public void reset() {
		setText("");
	}
	
	/**
	 * Shows Success
	 * @param msg
	 */
	public void showMessage(String msg) {
		setForeground(Color.GREEN);
		setText(msg);
	}
	
	/**
	 * Shows ErrorMessage
	 * @param err
	 */
	public void showError(String err) {
		setForeground(Color.RED);
		setText(err);
	}
}
