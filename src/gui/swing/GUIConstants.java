package gui.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public interface GUIConstants {

	// Konstanten für das Fenster
	public static final String APP_TITEL = "Library";
	public static final Rectangle FRAME_BOUNDS = new Rectangle(600, 100, 800, 300);

	// Hintergrundfarben
	public static final Color COLOR_PANEL = Color.WHITE;
	public static final Color COLOR_LABEL_PERSON = Color.WHITE;

	// Allgemeingültige Konstanten
	public static final Font FONT_TAB = new Font("Comic Sans MS", Font.PLAIN, 20);
	public static final Font FONT_TEXTFIELD = new Font("Comic Sans MS", Font.PLAIN, 25);
	public static final Font FONT_LABELS = new Font("Comic Sans MS", Font.PLAIN, 25);
	public static final Font FONT_BUTTON = new Font("Comic Sans MS", Font.PLAIN, 30);
	public static final Font FONT_MESSAGES = new Font("Comic Sans MS", Font.PLAIN, 20);
	public static final Font FONT_PANELTITEL = new Font("Comic Sans MS", Font.PLAIN, 40);

	// Überschriften für die einzelne Elemente
	public static final String LABEL_GEBURTSDATUM = "Geburtsdatum";
	public static final String NAME = "Name";
	public static final String VORNAME = "Vorname";
}
