package gui.pengugit.swing;

import javax.swing.JLabel;

public class BibLabel extends JLabel implements GUIConstants {

	public BibLabel() {
		super();
		setFont(FONT_LABELS);
		setHorizontalAlignment(LEFT);
	}

	public BibLabel(String string) {
		this();
		this.setText(string);
	}
}
