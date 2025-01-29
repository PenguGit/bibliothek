package gui.swing;

public class BibPersonLabel extends BibLabel implements GUIConstants {

	public BibPersonLabel() {
		super();
		setForeground(COLOR_LABEL_PERSON);
	}

	public BibPersonLabel(String string) {
		super(string);
		setForeground(COLOR_LABEL_PERSON);
	}
}
