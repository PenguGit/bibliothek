package gui.pengugit.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bl.BLAdresse;
import bl.BLGender;
import bl.BLPerson;
import bl.DTOManager;
import bl.ListData;

/**
 * A panel for managing person data, including displaying a list of persons,
 * input fields for person details, and buttons for saving changes.
 */
public class PersonPanel extends BibPanel implements ActionListener, ListSelectionListener {

    private static final String COMMAND_SAVE = "Save";
	private static final String COMMAND_CLEAR = "Clear";
	private static final String COMMAND_DELETE = "Del";

    DTOManager dtoMan;
    GridBagConstraints gbc;
    BLPerson pers;
    ButtonGroup genderGroup;
    BibMessageArea outputArea;

    /**
     * List of Data in the JList
     */
    JList<ListData> list;
    /**
     * Array base for the JList
     */
    ArrayList<ListData> data;
    ArrayList<BibPersonRadioButton> rbList;
    
    
    private BibTextField txtName;
    private BibTextField txtVorname;
    private BibBirthdateTextField txtGeburtsdatum;
    private BibNumberTextField txtPLZ;
    private BibTextField txtStadt;
    private BibTextField txtStrasse;
    private BibTextField txtHausnummer;

    /**
     * Builds everything
     */
    public PersonPanel() {
    	dtoMan = new DTOManager();

        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        initInput();
        initOutput();
        initList();
    }

    /**
     * Initializes the list component for displaying persons.
     */
    private void initList() {
        BibPanel listPanel = new BibPanel();

        data = dtoMan.loadAllPerson();
        DefaultListModel<ListData> listModel = new DefaultListModel<>();
        listModel.addAll(data);

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(10);
        list.setFont(FONT_TEXTFIELD);

        list.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listPanel.add(scrollPane);
        gbc.gridheight = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        addComponent(listPanel, 0, 0, 0.8);
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
    }

    /**
     * Initializes the output components (text fields and labels) for displaying person details.
     */
    void initOutput() {
    	
    	outputArea = new BibMessageArea();
    	
    	outputArea.setBackground(getBackground());
    	outputArea.setAlignmentX(CENTER_ALIGNMENT);
    	outputArea.setEditable(false);
    	outputArea.setFocusable(false);
    	gbc.gridheight = 2;
    	addComponent(outputArea, 8, 0, 0.8);
    	gbc.gridheight = 1;
    	
        BibPersonLabel lblName = new BibPersonLabel("Name");
        txtName = new BibTextField(10);
        addComponent(lblName, 0, 1, 0.2);
        addComponent(txtName, 0, 2, 0.8);

        BibPersonLabel lblVorname = new BibPersonLabel("Vorname");
        txtVorname = new BibTextField(10);
        addComponent(lblVorname, 1, 1, 0.2);
        addComponent(txtVorname, 1, 2, 0.8);

        BibPersonLabel lblGeburtsdatum = new BibPersonLabel("Geburtsdatum");
        txtGeburtsdatum = new BibBirthdateTextField();
        addComponent(lblGeburtsdatum, 2, 1, 0.2);
        addComponent(txtGeburtsdatum, 2, 2, 0.8);

        BibPersonLabel lblPLZ = new BibPersonLabel("PLZ");
        txtPLZ = new BibNumberTextField(10);
        addComponent(lblPLZ, 3, 1, 0.2);
        addComponent(txtPLZ, 3, 2, 0.8);

        BibPersonLabel lblStadt = new BibPersonLabel("Stadt");
        txtStadt = new BibTextField(10);
        addComponent(lblStadt, 4, 1, 0.2);
        addComponent(txtStadt, 4, 2, 0.8);

        BibPersonLabel lblStrasse = new BibPersonLabel("Straße");
        txtStrasse = new BibTextField(10);
        addComponent(lblStrasse, 5, 1, 0.2);
        addComponent(txtStrasse, 5, 2, 0.8);

        BibPersonLabel lblHausnummer = new BibPersonLabel("HausNr.");
        txtHausnummer = new BibTextField(10);
        addComponent(lblHausnummer, 6, 1, 0.2);
        addComponent(txtHausnummer, 6, 2, 0.8);
        
        
        
    }

    /**
     * Initializes the input components (radio buttons for gender and the save button).
     */
    void initInput() {
        genderGroup = new ButtonGroup();
        BibPanel genderPanel = new BibPanel(new FlowLayout(FlowLayout.LEFT, 1, 0)); 
        ArrayList<BLGender> gList = dtoMan.loadAllGender();
        rbList = new ArrayList<>();

        genderPanel.setBackground(Color.DARK_GRAY);
        for (BLGender g : gList) {
            BibPersonRadioButton rbG = new BibPersonRadioButton(g);
            rbG.setBackground(getBackground());
            genderGroup.add(rbG);
            genderPanel.add(rbG);
            rbList.add(rbG);
        }
        BibPersonLabel lblGeschlecht = new BibPersonLabel("Geschlecht");
        addComponent(lblGeschlecht, 7, 1, 0.2);
        addComponent(genderPanel, 7, 2, 0.8);

        BibButton btnSpeichern = new BibButton("Speichern");
        BibButton btnClear = new BibButton("Clear");
        BibButton btnDel = new BibButton("Löschen");
        
        
        btnSpeichern.setActionCommand(COMMAND_SAVE);
        btnSpeichern.addActionListener(this);
        btnSpeichern.setBackground(Color.GREEN);
        btnSpeichern.setForeground(Color.WHITE);
        
        btnClear.setActionCommand(COMMAND_CLEAR);
        btnClear.addActionListener(this);
        btnClear.setBackground(Color.BLUE);
        btnClear.setForeground(Color.WHITE);
        
        btnDel.setActionCommand(COMMAND_DELETE);
        btnDel.addActionListener(this);
        btnDel.setBackground(Color.RED);
        btnDel.setForeground(Color.WHITE);
        
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(btnSpeichern, 9, 2, 0.8);
        addComponent(btnClear, 8, 2, 0.8);
        addComponent(btnDel, 9, 1, 0.8);
        
    }
    
    
    
    /**
	 * Refreshes the JList after extracting the Model and reloading it
	 */
	private void refreshList() {
		DefaultListModel<ListData> m = (DefaultListModel<ListData>) list.getModel();
		m.clear();
		data = dtoMan.loadAllPerson();
		m.addAll(data);
	}

    /**
     * Just add components with constraints
     *
     * @param component The component to add.
     * @param row       The row in the grid.
     * @param col       The column in the grid.
     * @param weightx   The weight of the component in the x direction.
     */
    private void addComponent(Component component, int row, int col, double weightx) {
        gbc.gridy = row;
        gbc.gridx = col;
        gbc.weightx = weightx;
        add(component, gbc);
    }
    
    private void delete() {

		if (pers != null && pers.getId() > 0) {
			String err = dtoMan.deletePerson(pers);
			if (err != null) {
				outputArea.showError(err);
			} else {
				outputArea.showMessage("Gelöscht");
			}
			refreshList();
			clearForm();
		}
	}
    
    /**
     * Saves the person data to the database.  Either updates an existing
     * person or creates a new one.
     */
	private void save() {
		String err;
		if (!validateFields()) {
			outputArea.showError("Bitte fülle alle\nPflichtfelder aus");
			return;
		}
		if (pers != null) {
			BLAdresse adr = pers.getAdresse();
			if(adr == null) {
				adr = new BLAdresse();
			}
			adr.setPlz(txtPLZ.getInt());
			adr.setStadt(txtStadt.getText());
			adr.setStrasse(txtStrasse.getText());	
			adr.setHaus(txtHausnummer.getText());
			
			pers.setName(txtName.getText());
			pers.setVorname(txtVorname.getText());
			pers.setGender(getGenderFromRadio());
			pers.setAdresse(adr);
			
			err = dtoMan.savePerson(pers);
			if (err != null) {
				outputArea.showError(err);
			}
			refreshList();
			outputArea.showMessage("Updated");
			return;
		}
		
		BLAdresse adr = new BLAdresse(
				txtPLZ.getInt(),
				txtStadt.getText(),
				txtStrasse.getText(),
				txtHausnummer.getText());
		pers = new BLPerson(
				txtName.getText(),
				txtVorname.getText(),
				txtGeburtsdatum.getDate(),
				getGenderFromRadio(),
				adr);
		if(pers.getGebdat() == null) {
			outputArea.showError("Kein Valides\nGeburtsdatum");
			txtGeburtsdatum.setFilled(false);
			return;
		}
		err = dtoMan.savePerson(pers);
		if (err != null) {
			outputArea.showError(err);
		}
		refreshList();
		outputArea.showMessage("Saved");
	}
	
	 /**
     * Retrieves the selected gender from the radio button group.
     *
     * @return The selected BLGender object, or null if no gender is selected.
     */
    private BLGender getGenderFromRadio() {
        if (genderGroup.getSelection() != null) {
            for (BibPersonRadioButton rb : rbList) {
                if (rb.isSelected()) {
                    return rb.gen;
                }
            }
        }
        return null;
    }

    /**
     * Sets the radio button selection based on the provided BLGender object.
     *
     * @param g The BLGender object to select.
     */
    private void setRadioFromGender(BLGender g) {
        for (BibPersonRadioButton rb : rbList) {
            if (rb.gen.getId() == g.getId()) {
                rb.setSelected(true);
                //Alternative to above line
                //genderGroup.setSelected(rb.getModel(), true);
            }
        }
    }

    /**
     * Fills the input form fields with the details of the currently selected person.
     */
    private void fillForm() {
    	
        txtName.setText(pers.getName());
        txtVorname.setText(pers.getVorname());
        txtGeburtsdatum.setDate(pers.getGebdat());
        txtGeburtsdatum.changeStatus(false);;
        txtPLZ.setText(pers.getAdresse().getPlz() + "");
        txtStadt.setText(pers.getAdresse().getStadt());
        txtStrasse.setText(pers.getAdresse().getStrasse());
        txtHausnummer.setText(pers.getAdresse().getHaus());
        setRadioFromGender(pers.getGender());
        validateFields();
        outputArea.showMessage("Person geladen");
    }

    /**
     * Clears all input fields in the person form. And sets person to null.
     */
    private void clearForm() {
        txtName.setText("");
        txtVorname.setText("");
        txtGeburtsdatum.changeStatus(true);
        txtGeburtsdatum.setText("");
        txtPLZ.setText("");
        txtStadt.setText("");
        txtStrasse.setText("");
        txtHausnummer.setText("");
        genderGroup.clearSelection();
        pers = null;
    }
    

    /**
     * Validates that all required input fields are filled.  Gives a red border
     * to the fields that are not filled.
     *
     * @return {@code true} if all fields are filled, {@code false} otherwise.
     */
    public boolean validateFields() {
        boolean isValid = true;

        isValid &= txtName.isFilled();
        isValid &= txtVorname.isFilled();
        isValid &= txtGeburtsdatum.isFilled();
        isValid &= txtPLZ.isFilled();
        isValid &= txtStadt.isFilled();
        isValid &= txtStrasse.isFilled();
        isValid &= txtHausnummer.isFilled();

        return isValid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(COMMAND_SAVE)) {
            save();
        } else if (e.getActionCommand().equals(COMMAND_CLEAR)){
        	clearForm();
        } else if (e.getActionCommand().equals(COMMAND_DELETE)){
        	delete();
        }

    }

    /**
     * Listener to check if a different Item in the List was selected.
     * Updates the form with the details of the selected person.
     *
     * @param e The ListSelectionEvent.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (e.getSource() == list && !e.getValueIsAdjusting()) {
            ListData ld = list.getSelectedValue();
            if (ld != null) {
                pers = dtoMan.loadByIDPerson(ld.getId());
                fillForm();
            }
        }
    }
    

}
