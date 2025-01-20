package gui.swing;

import javax.swing.JTextField;

public class BibTextField extends JTextField implements GUIConstants {
	public BibTextField(String string) {
		this();
		setText(string);
	}
	
	public BibTextField() {
		super();
		setFont(FONT_TEXTFIELD);
	}
}
