package gui.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;

import bl.DTOManager;
import bl.Gender;

public class PersonPanel extends BibPanel {

	DTOManager dtoMan;
	GridBagConstraints gbc;
	
	private BibTextField txtName;
	private BibTextField txtVorname;
	private BibTextField txtGeburtsdatum;
	private BibTextField txtPLZ;
	private BibTextField txtStadt;
	private BibTextField txtStrasse;
	private BibTextField txtHausnummer;

	/**
	 * Builds everything
	 */
	public PersonPanel() {
		dtoMan = new DTOManager();
		ArrayList<Gender> gList = dtoMan.loadAllGender();

		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		 gbc = new GridBagConstraints();
		 gbc.insets = new Insets(5, 5, 5, 5);

		// Components
		BibLabel lblName = new BibLabel("Name");
		txtName = new BibTextField(10);
		addComponent(lblName, 0, 0, 0.2);
        addComponent(txtName, 0, 1, 0.8);

		BibLabel lblVorname = new BibLabel("Vorname");
		txtVorname = new BibTextField(10);
		addComponent(lblVorname, 1, 0, 0.2);
        addComponent(txtVorname, 1, 1, 0.8);

		BibLabel lblGeburtsdatum = new BibLabel("Geburtsdatum");
		txtGeburtsdatum = new BibTextField(10);
		addComponent(lblGeburtsdatum, 2, 0, 0.2);
        addComponent(txtGeburtsdatum, 2, 1, 0.8);

		BibLabel lblGeschlecht = new BibLabel("Geschlecht");

		BibLabel lblPLZ = new BibLabel("PLZ");
		txtPLZ = new BibTextField(10);
		addComponent(lblPLZ, 0, 2, 0.2);
        addComponent(txtPLZ, 0, 3, 0.8);

		BibLabel lblStadt = new BibLabel("Stadt");
		txtStadt = new BibTextField(10);
		addComponent(lblStadt, 1, 2, 0.2);
        addComponent(txtStadt, 1, 3, 0.8);

		BibLabel lblStrasse = new BibLabel("Straße");
		txtStrasse = new BibTextField(10);
		addComponent(lblStrasse, 2, 2, 0.2);
        addComponent(txtStrasse, 2, 3, 0.8);

		BibLabel lblHausnummer = new BibLabel("HausNr.");
		txtHausnummer = new BibTextField(10);
		addComponent(lblHausnummer, 3, 0, 0.2);
        addComponent(txtHausnummer, 3, 1, 0.8);
        
        
        //TODO Methode fuer Radiobuttons generieren
		ButtonGroup genderGroup = new ButtonGroup();
		BibPanel genderPanel = new BibPanel(new FlowLayout(FlowLayout.LEFT, 1, 0)); // 5px horizontal gap, 0px vertical
																					// gap
		genderPanel.setBackground(Color.DARK_GRAY); // Match the background color
		Color fontColor = Color.WHITE;
		for (Gender g : gList) {
			BibRadioButton rbG = new BibRadioButton(g);
			rbG.setToolTipText(g.getInfo());
			rbG.setBackground(getBackground());
			rbG.setForeground(fontColor);
			genderGroup.add(rbG);
			genderPanel.add(rbG);
		}
		addComponent(lblGeschlecht, 3, 2, 0.2);
        addComponent(genderPanel, 3, 3, 0.8);
        
		BibButton btnSpeichern = new BibButton("Speichern");

        setLabelColor(fontColor, lblName, lblVorname, lblGeburtsdatum, lblGeschlecht, lblPLZ, lblStadt, lblStrasse, lblHausnummer);
        btnSpeichern.setBackground(Color.GREEN);
        btnSpeichern.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(btnSpeichern, 4, 3, 0.8);
	}
	
	/**
	 * Sets all fonts for labels
	 * @param fontColor
	 * @param labels
	 */
	//TODO remove this and add motherclass BibPersonLabel
	private void setLabelColor(Color fontColor, BibLabel... labels) {
        for (BibLabel label : labels) {
            label.setForeground(fontColor);
        }
    }
	
	/**
	 * Just add components with constraints
	 * @param component
	 * @param row
	 * @param col
	 * @param weightx
	 */
	private void addComponent(Component component, int row, int col, double weightx) {
        gbc.gridy = row;
        gbc.gridx = col;
        gbc.weightx = weightx;
        add(component, gbc);
    }

}
