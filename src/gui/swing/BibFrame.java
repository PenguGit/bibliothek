package gui.swing;

import javax.swing.JFrame;

public class BibFrame extends JFrame implements GUIConstants {

	public BibFrame() {
		super(APP_TITEL);

		setBounds(FRAME_BOUNDS);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setSize(600, 400);
		
		PersonPanel pP = new PersonPanel(); // Eine Fläche mit Tabs
		add(pP);
		pack();
		setVisible(true); // immer als letzte Zeile
	}

	public static void main(String[] args) {
		new BibFrame();
	}
}