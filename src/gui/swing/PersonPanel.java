package gui.swing;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PersonPanel extends BibPanel {
	
	GroupLayout gLayout;
	
	public PersonPanel() {
		super();
		gLayout = new GroupLayout(this);
		setLayout(gLayout);
		gLayout.setAutoCreateGaps(true);
		gLayout.setAutoCreateContainerGaps(true);
		initInputFields();
	}

	private void initInputFields() {
		BibLabel label = new BibLabel("Name");
		BibTextField name = new BibTextField();
		
		BibLabel label2 = new BibLabel("Vorname");
		BibTextField vname = new BibTextField();
		
		BibLabel label3 = new BibLabel("Geburtsdatum");
		BibTextField gebDat = new BibTextField();
		
		gLayout.setHorizontalGroup(
				gLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(gLayout.createSequentialGroup()
						.addComponent(label)
						.addComponent(name))
					.addGroup(gLayout.createSequentialGroup()
						.addComponent(label2)
						.addComponent(vname))
					.addGroup(gLayout.createSequentialGroup()
							.addComponent(label3)
							.addComponent(gebDat))
				);
		gLayout.setVerticalGroup(
				gLayout.createSequentialGroup()
					.addGroup(gLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(name))
					.addGroup(gLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label2)
						.addComponent(vname))
					.addGroup(gLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label3)
							.addComponent(gebDat))
				);
		add(label);
	}
	
}
