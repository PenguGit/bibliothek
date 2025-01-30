package gui.pengugit.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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

    LocalDate gebdat = LocalDate.EPOCH;
    DTOManager dtoMan;
    GridBagConstraints gbc;
    BLPerson pers;
    ButtonGroup genderGroup;

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
        BibPanel genderPanel = new BibPanel(new FlowLayout(FlowLayout.LEFT, 1, 0)); // 5px horizontal gap, 0px vertical
        ArrayList<BLGender> gList = dtoMan.loadAllGender();
        rbList = new ArrayList<>();

        genderPanel.setBackground(Color.DARK_GRAY); // Match the background color
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

        btnSpeichern.setActionCommand(COMMAND_SAVE);
        btnSpeichern.addActionListener(this);
        btnSpeichern.setBackground(Color.GREEN);
        btnSpeichern.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(btnSpeichern, 8, 2, 0.8);
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

    /**
     * Saves the person data to the database.  Either updates an existing
     * person or creates a new one.
     */
    //TODO ADD DATE CORRECTLY WITH FORMATTER!!!!!
	private void save() {
		if (pers != null) {
			BLAdresse adr = pers.getAdresse();
			if(adr == null) {
				adr = new BLAdresse();
			}
			adr.setPlz(Integer.valueOf(txtPLZ.getText()));
			adr.setStadt(txtStadt.getText());
			adr.setStrasse(txtStrasse.getText());	
			adr.setHaus(txtHausnummer.getText());
			
			pers.setName(txtName.getText());
			pers.setVorname(txtVorname.getText());
			pers.setGender(getGenderFromRadio());
			pers.setAdresse(adr);
			dtoMan.savePerson(pers);
			System.out.println("Updated");
			return;
		}
		
		BLAdresse adr = new BLAdresse(
				Integer.valueOf(txtPLZ.getText()),
				txtStadt.getText(),
				txtStrasse.getText(),
				txtHausnummer.getText());
		pers = new BLPerson(
				txtName.getText(),
				txtVorname.getText(),
				gebdat,
				getGenderFromRadio(),
				adr);
		
		if(pers.getGender()!= null) {
			dtoMan.savePerson(pers);
			System.out.println("Success");
		} else {
			System.out.println("Error no Gender Selected");
		}
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
        txtGeburtsdatum.setText(pers.getGebdat().toString());
        txtPLZ.setText(pers.getAdresse().getPlz() + "");
        txtStadt.setText(pers.getAdresse().getStadt());
        txtStrasse.setText(pers.getAdresse().getStrasse());
        txtHausnummer.setText(pers.getAdresse().getHaus());
        setRadioFromGender(pers.getGender());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(COMMAND_SAVE)) {
            save();
            clearForm();
        } else {
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
    
    /**
     * Clears all input fields in the person form. And sets person to null.
     */
    private void clearForm() {
        txtName.setText("");
        txtVorname.setText("");
        txtGeburtsdatum.setText("");
        txtPLZ.setText("");
        txtStadt.setText("");
        txtStrasse.setText("");
        txtHausnummer.setText("");
        genderGroup.clearSelection();
        pers = null;
    }

}
