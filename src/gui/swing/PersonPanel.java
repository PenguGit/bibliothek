package gui.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;

public class PersonPanel extends BibPanel {

	public PersonPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);

		// Components
		BibLabel lblName = new BibLabel("Name");
		BibLabel lblVorname = new BibLabel("Vorname");
		BibLabel lblGeburtsdatum = new BibLabel("Geburtsdatum");
		BibLabel lblGeschlecht = new BibLabel("Geschlecht");
		BibLabel lblPLZ = new BibLabel("PLZ");
		BibLabel lblStadt = new BibLabel("Stadt");
		BibLabel lblStrasse = new BibLabel("Straße");
		BibLabel lblHausnummer = new BibLabel("HausNr.");
		
		BibTextField txtName = new BibTextField(10);
		BibTextField txtVorname = new BibTextField(10);
		BibTextField txtGeburtsdatum = new BibTextField(10);
		BibTextField txtPLZ = new BibTextField(20);
		BibTextField txtStadt = new BibTextField(20);
		BibTextField txtStrasse = new BibTextField(20);
		BibTextField txtHausnummer = new BibTextField(10);
		
		BibRadioButton rbW = new BibRadioButton("W");
		BibRadioButton rbM = new BibRadioButton("M");
		BibRadioButton rbD = new BibRadioButton("D");
		ButtonGroup genderGroup = new ButtonGroup();
		
		BibButton btnSpeichern = new BibButton("Speichern");
		
		
		// Gender Radio Buttons Panel
		BibPanel genderPanel = new BibPanel(new FlowLayout(FlowLayout.LEFT, 1, 0)); // 5px horizontal gap, 0px vertical gap
		genderPanel.setBackground(Color.DARK_GRAY); // Match the background color
		genderPanel.add(rbW);
		genderPanel.add(rbM);
		genderPanel.add(rbD);

		rbW.setBackground(getBackground());
		rbM.setBackground(getBackground());
		rbD.setBackground(getBackground());
		
		genderGroup.add(rbW);
		genderGroup.add(rbM);
		genderGroup.add(rbD);
		
		// Set font and color
		Color fontColor = Color.WHITE;
		lblName.setForeground(fontColor);
		lblVorname.setForeground(fontColor);
		lblGeburtsdatum.setForeground(fontColor);
		lblGeschlecht.setForeground(fontColor);
		lblPLZ.setForeground(fontColor);
		lblStadt.setForeground(fontColor);
		lblStrasse.setForeground(fontColor);
		lblHausnummer.setForeground(fontColor);
		rbW.setForeground(fontColor);
		rbM.setForeground(fontColor);
		rbD.setForeground(fontColor);

		// Layout manager
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Spacing

		// Row 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.2;
		add(lblName, gbc);

		gbc.gridx = 1;
		gbc.weightx = 0.8;
		add(txtName, gbc);

		gbc.gridx = 2;
		gbc.weightx = 0.2;
		add(lblPLZ, gbc);

		gbc.gridx = 3;
		gbc.weightx = 0.8;
		add(txtPLZ, gbc);

		// Row 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		add(lblVorname, gbc);

		gbc.gridx = 1;
		gbc.weightx = 0.8;
		add(txtVorname, gbc);

		gbc.gridx = 2;
		gbc.weightx = 0.2;
		add(lblStadt, gbc);

		gbc.gridx = 3;
		gbc.weightx = 0.8;
		add(txtStadt, gbc);

		// Row 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.2;
		add(lblGeburtsdatum, gbc);

		gbc.gridx = 1;
		gbc.weightx = 0.8;
		add(txtGeburtsdatum, gbc);

		gbc.gridx = 2;
		gbc.weightx = 0.2;
		add(lblStrasse, gbc);

		gbc.gridx = 3;
		gbc.weightx = 0.8;
		add(txtStrasse, gbc);

		// Row 4
		gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.2;
        add(lblHausnummer, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.8;
        add(txtHausnummer, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0.2;
        add(lblGeschlecht, gbc);

		gbc.gridx = 3;
		gbc.weightx = 0.8;
		add(genderPanel, gbc);

		// Row 6 (Button)
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.weightx = 0.8;
		btnSpeichern.setBackground(Color.GREEN);
		btnSpeichern.setForeground(Color.WHITE);
		gbc.anchor = GridBagConstraints.CENTER;
		add(btnSpeichern, gbc);
	}

}
