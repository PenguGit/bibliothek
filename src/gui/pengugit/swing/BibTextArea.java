package gui.pengugit.swing;

import javax.swing.JTextArea;

public class BibTextArea extends JTextArea implements GUIConstants {

	public BibTextArea(String string) {
		super();
		setFont(FONT_TEXTFIELD);
		setText(string);
	}
	
	public BibTextArea() {
		super();
		setFont(FONT_TEXTFIELD);
	}
	
}
