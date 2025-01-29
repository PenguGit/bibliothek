package gui.swing;

import bl.BLGender;

public class BibPersonRadioButton extends BibRadioButton implements GUIConstants {
	
	BLGender gen;
	
	public BibPersonRadioButton() {
		super();
		setForeground(COLOR_LABEL_PERSON);
	}

	public BibPersonRadioButton(BLGender g) {
		super(g.getKuerzel());
		setForeground(COLOR_LABEL_PERSON);
		gen = g;
	}
}
