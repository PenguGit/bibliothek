package gui.pengugit.swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BibNumberTextField extends BibTextField {
	
	public BibNumberTextField(int i) {
        super(i);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != '\b') {
                    e.consume(); 
                }
            }
        });
    }
}
