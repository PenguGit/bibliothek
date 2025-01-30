package gui.pengugit.swing;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BibBirthdateTextField extends BibTextField {

	
	public BibBirthdateTextField() {
		super(10);
        setCaretPosition(0); // Set cursor to start
        setPreferredSize(new Dimension(20, getPreferredSize().height));
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                int pos = getCaretPosition();

                if ((!Character.isDigit(c) && c != '\b') || getText().length() >= 10) {
                    e.consume(); 
                    return;
                }

                if ((pos == 2 || pos == 5) && c != '\b') {
                    setText(getText().substring(0, pos) + "." + getText().substring(pos));
                    setCaretPosition(pos + 1); 
                }

                if (pos == 10) {
                    e.consume(); 
                }
            }
        });
	}

}
