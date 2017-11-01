package org.fenster.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ClassKonfig {

final String strDateiKonfigPfad = "konfig.txt";
private boolean isKonfigSpeichern;

private String StrSlugDateiPfad;
private String StrKonfigComboboxenDateiPfad;

private boolean isAktuelleFensterposVerwenden;
private int intXPos;
private int intYPos;
private boolean KonfigXPosEnabled;
private boolean KonfigYPosEnabled;


private boolean isLogging;
private String StrLoggingPfad;

private String StrLetzterPfad;
private String StrStandardPfad;
private String StrPythonPfad;
private String StrXxxPfad;


/**
 * Konstruktor
 * Standard-Parameter setzen
 */
public ClassKonfig() {
	
	setStrStandardPfad("/netz/krypto/stars/");
	setStrLetzterPfad("");
	setStrLoggingPfad("");
	
	setAktuelleFensterposVerwenden(true);
	setKonfigSpeichern(true);
	setLogging(false);

	setStrKonfigComboboxenDateiPfad("konfig_comboboxen.xml");
	setIntXPos(500);
	setIntYPos(200);
	
	KonfigLaden();
	
} // Ende Konstruktor



/**
 * @return the bolKonfigSpeichern
 */
public boolean isKonfigSpeichern() {
	return isKonfigSpeichern;
}


/**
 * @return the strSlugDateiPfad
 */
public String getStrSlugDateiPfad() {
	return StrSlugDateiPfad;
}


/**
 * @return the strKonfigComboboxenDateiPfad
 */
public String getStrKonfigComboboxenDateiPfad() {
	return StrKonfigComboboxenDateiPfad;
}


/**
 * @return the bolAktuelleFensterposVerwenden
 */
public boolean isAktuelleFensterposVerwenden() {
	return isAktuelleFensterposVerwenden;
}


/**
 * @return the intXPos
 */
public int getIntXPos() {
	return intXPos;
}


/**
 * @return the intYPos
 */
public int getIntYPos() {
	return intYPos;
}


/**
 * @return the bolLogging
 */
public boolean isLogging() {
	return isLogging;
}


/**
 * @return the strLoggingPfad
 */
public String getStrLoggingPfad() {
	return StrLoggingPfad;
}


/**
 * @return the strLetzterPfad
 */
public String getStrLetzterPfad() {
	return StrLetzterPfad;
}


/**
 * @return the strStandardPfad
 */
public String getStrStandardPfad() {
	return StrStandardPfad;
}


/**
 * @return the strPythonPfad
 */
public String getStrPythonPfad() {
	return StrPythonPfad;
}


/**
 * @return the strXxxPfad
 */
public String getStrXxxPfad() {
	return StrXxxPfad;
}


/**
 * @param bolKonfigSpeichern the bolKonfigSpeichern to set
 */
public void setKonfigSpeichern(boolean bolKonfigSpeichern) {
	this.isKonfigSpeichern = bolKonfigSpeichern;
}


/**
 * @param strSlugDateiPfad the strSlugDateiPfad to set
 */
public void setStrSlugDateiPfad(String strSlugDateiPfad) {
	StrSlugDateiPfad = strSlugDateiPfad;
}


/**
 * @param strKonfigComboboxenDateiPfad the strKonfigComboboxenDateiPfad to set
 */
public void setStrKonfigComboboxenDateiPfad(String strKonfigComboboxenDateiPfad) {
	StrKonfigComboboxenDateiPfad = strKonfigComboboxenDateiPfad;
}


/**
 * @param bolAktuelleFensterposVerwenden the bolAktuelleFensterposVerwenden to set
 */
public void setAktuelleFensterposVerwenden(boolean bolAktuelleFensterposVerwenden) {
	this.isAktuelleFensterposVerwenden = bolAktuelleFensterposVerwenden;
}


/**
 * @param intXPos the intXPos to set
 */
public void setIntXPos(int intXPos) {
	this.intXPos = intXPos;
}


/**
 * @param intYPos the intYPos to set
 */
public void setIntYPos(int intYPos) {
	this.intYPos = intYPos;
}


/**
 * @param bolLogging the bolLogging to set
 */
public void setLogging(boolean bolLogging) {
	this.isLogging = bolLogging;
}


/**
 * @param strLoggingPfad the strLoggingPfad to set
 */
public void setStrLoggingPfad(String strLoggingPfad) {
	StrLoggingPfad = strLoggingPfad;
}


/**
 * @param strLetzterPfad the strLetzterPfad to set
 */
public void setStrLetzterPfad(String strLetzterPfad) {
	StrLetzterPfad = strLetzterPfad;
}


/**
 * @param strStandardPfad the strStandardPfad to set
 */
public void setStrStandardPfad(String strStandardPfad) {
	StrStandardPfad = strStandardPfad;
}


/**
 * @param strPythonPfad the strPythonPfad to set
 */
public void setStrPythonPfad(String strPythonPfad) {
	StrPythonPfad = strPythonPfad;
}


/**
 * @param strXxxPfad the strXxxPfad to set
 */
public void setStrXxxPfad(String strXxxPfad) {
	StrXxxPfad = strXxxPfad;
}

// ============= Ende Getters / Setters =============
// ==================================================



/**
 * @return the strDateiKonfigPfad
 */
public String getStrDateiKonfigPfad() {
	return strDateiKonfigPfad;
}



/**
 * @return the konfigXPosEnabled
 */
public boolean isKonfigXPosEnabled() {
	return KonfigXPosEnabled;
}



/**
 * @return the konfigYPosEnabled
 */
public boolean isKonfigYPosEnabled() {
	return KonfigYPosEnabled;
}



/**
 * @param konfigXPosEnabled the konfigXPosEnabled to set
 */
public void setKonfigXPosEnabled(boolean konfigXPosEnabled) {
	KonfigXPosEnabled = konfigXPosEnabled;
}



/**
 * @param konfigYPosEnabled the konfigYPosEnabled to set
 */
public void setKonfigYPosEnabled(boolean konfigYPosEnabled) {
	KonfigYPosEnabled = konfigYPosEnabled;
}



/*
 * Ablauf: Datei/Pfad holen
 * Falls vorhanden, Werte lesen mittels Propertiens
 * Ansonsten bleiben die Standard-Werte
 */
public void KonfigLaden() {
	File konfigDatei = new File(strDateiKonfigPfad);
	
	if (!konfigDatei.exists() | !konfigDatei.isFile()) {
		// Fensterausgabe mit Hinweis
		JOptionPane.showMessageDialog(null, "Keine konfig.txt im Hauptverzeichnis vorhanden!");

	} else {

		Properties konfigProperLaden = new Properties();
		try {

			FileInputStream fis = new FileInputStream(konfigDatei);
			konfigProperLaden.load(fis);

			setStrSlugDateiPfad(konfigProperLaden.getProperty("template-slug"));
			setStrKonfigComboboxenDateiPfad(konfigProperLaden.getProperty("konfig_cmb_xml"));

			if (konfigProperLaden.getProperty("aktuelle_fensterposition_verwenden").equals("ja")) {
				setAktuelleFensterposVerwenden(true);
				setKonfigXPosEnabled(true);
				setKonfigYPosEnabled(true);
			} else {
				setAktuelleFensterposVerwenden(false);
				setKonfigXPosEnabled(false);
				setKonfigYPosEnabled(false);
			}

			setIntXPos(Integer.valueOf(konfigProperLaden.getProperty("fenster_x")));
			setIntYPos(Integer.valueOf(konfigProperLaden.getProperty("fenster_y")));
			
			setStrLetzterPfad(konfigProperLaden.getProperty("last_pfad"));
			setStrStandardPfad(konfigProperLaden.getProperty("standard_pfad"));

			
			if (konfigProperLaden.getProperty("KONFIG_SPEICHERN").equals("an")) {
				setKonfigSpeichern(true);
			} else {
				setKonfigSpeichern(false);
			}

			
			
//			if (konfigProperLaden.getProperty("logging").equals("ein")) {
//				chckbxKonfigLogging.setSelected(true);
//				lblKonfigLogdatei.setEnabled(true);
//				txtKonfigLogdatei.setEnabled(true);
//			} else {
//				chckbxKonfigLogging.setSelected(false);
//				lblKonfigLogdatei.setEnabled(false);
//				txtKonfigLogdatei.setEnabled(false);
//			}

			fis.close();
//			txtStatusleiste.setText("Konfiguration geladen");

		} catch (IOException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}

	} // else wird geschlossen

	
	
} // Ende KonfigLaden
	


/*
 * Schritte:
 * (1) Auslesen und Einsammeln aller Werte
 * (2) Properties anlegen und Werte setzen
 * (3) in die Konfig-Datei schreiben
 * (4) Ausgabe in Statuszeile
 * 
 * Alle Parameter müssen geschrieben werden, auch die nicht geänderten.
 * 
 */
public void KonfigSpeichern() {
	
} // Ende KonfigSpeichern


} // Ende ClassKonfig