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

	public BibTextField(int i) {
		super(i);
		setFont(FONT_TEXTFIELD);
	}

	public BibTextField(String string, int i) {
		super(string, i);
		setFont(FONT_TEXTFIELD);
	}
}
