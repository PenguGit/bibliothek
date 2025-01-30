package gui.pengugit.swing;

import javax.swing.JButton;

public class BibButton extends JButton implements GUIConstants {
	
	public BibButton() {
		super("Click me");
		setFont(FONT_BUTTON);
	}
	
	public BibButton(String string) {
		this();
		setText(string);
	}
}
