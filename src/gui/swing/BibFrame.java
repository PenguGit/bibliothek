package gui.swing;

import javax.swing.JFrame;

public class BibFrame extends JFrame implements GUIConstants {

	public BibFrame() {
		super(APP_TITEL);

		setBounds(FRAME_BOUNDS);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BibPanel bP = new BibPanel(); // Eine Fläche mit Tabs
		bP.setVisible(true);
		setVisible(true); // immer als letzte Zeile
	}

	public static void main(String[] args) {
		new BibFrame();
	}

}