package gui.swing;

import javax.swing.JRadioButton;

import bl.BLGender;

public class BibRadioButton extends JRadioButton implements GUIConstants {
	
	public BibRadioButton() {
		super();
		setFont(FONT_BUTTON);
	}

	public BibRadioButton(String string) {
		this();
		setText(string);
	}

}
