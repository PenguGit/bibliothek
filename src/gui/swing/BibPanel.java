package gui.swing;

import java.awt.FlowLayout;

import javax.swing.JPanel;


public class BibPanel extends JPanel implements GUIConstants {

	public BibPanel() {
		super();
		setBackground(COLOR_PANEL);
	}

	public BibPanel(FlowLayout flowLayout) {
		super(flowLayout);
	}

}