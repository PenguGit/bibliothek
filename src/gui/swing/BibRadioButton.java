package gui.swing;

import javax.swing.JRadioButton;

import bl.Gender;

public class BibRadioButton extends JRadioButton implements GUIConstants {
	
	Gender gen;
	
	public BibRadioButton() {
		super();
		setFont(FONT_BUTTON);
	}

	public BibRadioButton(String string) {
		this();
		setText(string);
	}

	public BibRadioButton(Gender g) {
		this(g.getKuerzel());
		gen = g;
	}
	
}
