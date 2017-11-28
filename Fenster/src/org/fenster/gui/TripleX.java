package org.fenster.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.fenster.model.ClassKonfig;
import org.fenster.model.ExifDaten;
import org.fenster.model.SlugDaten;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.xml.internal.utils.URI;
import com.sun.xml.internal.ws.util.StringUtils;

import sun.nio.cs.CharsetMapping;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.FlowLayout;

public class TripleX extends JFrame {

	private static final long serialVersionUID = 906608270381572622L;
	
	private JFrame frmFenstertitel;
	
	private JTextField txtStatusleiste;
	private JTextField txtSlugActress;
	private JTextField txtSlugActor;

	File konfigDatei;
	// ohne Pfad-Angabe identisch zu: /home/thomas/workspace/Fenster/konfig.txt
	// String strKonfigDatei="konfig.txt";

	String test;

	private JTabbedPane tabbedPane;
	private JPanel panel_1_Datei;
	private JPanel panel_4_bilder;
	private JScrollPane scrollPaneBilder;
	private JPanel panelBilderRahmen;
	
	// Register Bilder, als ArrayList
	private ArrayList<JLabel> lblBilderNummer;
	private ArrayList<JCheckBox> chckbxTitelbild;
	private ArrayList<JCheckBox> chckbxPortraetbild;
	private ArrayList<JPanel> panelBilder;
	private Dimension dimensionBilder = new Dimension(210, 260);
	private ArrayList<String> strBildNameVerzeichnis;
	
	private JLabel lblSlugTitelbild;
	private JLabel lblSlugTitelbildAnzeige;
	private JLabel lblSlugPortraitbild;
	private JLabel lblSlugPortraetbildAnzeige;

	
	private JTextField txtKonfigVersion;
	private JTextField txtKonfigDatum;
	private JTextField txtKonfigTemplateslug;
	private JTextField txtKonfigLogdatei;
	private JTextField txtKonfigLetzterPfad;
	private JTextField txtKonfigStandardPfad;
	
	private JTextPane txtpnSlugBeschreibung;
	private JTextArea txtAreaDebug;
	
	private JCheckBox chckbxKonfigAkutelleFensterposition;
	private JCheckBox chckbxKonfigLogging;
	private JCheckBox chckbxKonfigSpeichernBeimBeenden;
	private JTextField txtKonfigXpos;
	private JTextField txtKonfigYpos;
	private JLabel lblKonfigXpos;
	private JLabel lblKonfigYpos;
	private JLabel lblKonfigLogdatei;

	String strSchublade16 = "Fenster/externe_dateien/schublade16x16.png";
	String strSchublade19 = "Fenster/externe_dateien/schublade19x19.png";
	String strSchublade25 = "Fenster/externe_dateien/schublade25x25.png";
	String strSchubladeHome = "Fenster/externe_dateien/schublade_2.png";
	
	String strReload16 = "Fenster/externe_dateien/reload_16x16.png";
	String strReload19 = "Fenster/externe_dateien/reload_19x19.png";
	String strReload25 = "Fenster/externe_dateien/reload_25x25.png";
	
	String strPfeilOben = "Fenster/externe_dateien/pfeil_oben.png";
	String strPfeilUnten = "Fenster/externe_dateien/pfeil_unten.png";
	String strPfeilLinks = "Fenster/externe_dateien/pfeil_links.png";
	String strPfeilRechts = "Fenster/externe_dateien/pfeil_rechts.png";
	String strPfeilTauschen = "Fenster/externe_dateien/pfeil_tauschen.png";
	String strPfeilDownload = "Fenster/externe_dateien/pfeil_download.png";
	
	String strRefresh ="Fenster/externe_dateien/refresh.png";
	String strSlugActressToFirst ="Fenster/externe_dateien/first.png";
	String strSlugActressToNear ="Fenster/externe_dateien/near.png";
	String strCheck = "Fenster/externe_dateien/check.png";
	String strDownload = "Fenster/externe_dateien/pfeil_download.png";
	
	String strSlugErzeugen ="Fenster/externe_dateien/slug_erzeugen.png";
	
	
	private ImageIcon iconRibbonPfadDialogbox;
	private ImageIcon iconRibbonTitelZuSerie;
	private ImageIcon iconRibbonSlugUmwandeln;
	private ImageIcon iconRibbonRefresh;
	private ImageIcon iconRibbonStarverzeichnis;
	private ImageIcon iconRibbonTitel2Slug;
	
	private ImageIcon iconKonfigReload;
	private ImageIcon iconSlugErstelltAmNachRelase;
	private ImageIcon iconSlugRelaseNachErstelltAm;
	private ImageIcon iconSlugTitelbildOben;
	private ImageIcon iconSlugTitelbildUnten;
	private ImageIcon iconSlugPortraetbildOben;
	private ImageIcon iconSlugPortraetbildUnten;

	private ImageIcon iconSlugActressToFrist;
	private ImageIcon iconSlugActressToNear;
	private ImageIcon iconSlugActressCheck;
	private ImageIcon iconSlugBilderDownload;
	
	private ImageIcon iconSlugErzeugen;

	
	
	private ImageIcon iconSlugReleaseJahrOben;
	private ImageIcon iconSlugReleaseJahrUnten;
	private ImageIcon iconSlugTauschen;
	
	
	private ImageIcon iconSlugErstelltAmJahrOben;
	private ImageIcon iconSlugErstelltAmJahrUnten;
	private ImageIcon iconSlugErstelltAmMonatOben;
	private ImageIcon iconSlugErstelltAmMonatUnten;
	private ImageIcon iconSlugErstelltAmTagOben;
	private ImageIcon iconSlugErstelltAmTagUnten;
	
	private JButton btnKonfigReload;
	private JTextField txtKonfigPythonpfad;
	private JTextField txtKonfigXxxshpfad;
	private JTextField txtSlugBraznr;
	private JTextField txtSlugNa;
	private JTextField txtSlugFirst;
	private JTextField txtSlugNear;
	private JTextField txtSlugTitelbild;
	private JTextField txtSlugPortraitbild;
	private JTextField txtSlugReleaseJahr;
	
	private JFileChooser jfcSlug;
	private File fileRibbonPfad;
	
	private File fXml; // Datei mit den Daten für die Comboboxen Album und Studio
	private JTextField txtKonfigcomboboxenxml;
	
	// Album-Werte für Combo-Box
	private JComboBox<String> cmbSlugStudio;
	private JComboBox<String> cmbSlugAlbum;
	private JComboBox<String> cmbSlugSterne;

	private JTextField txtRibbonPfad;
	private JTextField txtRibbonSlugName;
	private JTextField txtRibbonTitel;
	private JTextField txtSlugReleaseMonat;
	private JTextField txtSlugReleaseTag;
	private JTextField txtSlugReleaseZeit;
	private JTextField txtRibbonSerie;
	private JTextField txtRibbonHttp;
	private JTextField txtSlugDvd;
	private JTextField txtSlugPart;
	private JTextField txtSlugAnzahlParts;

	private JCheckBox chckbxSlugFirst;
	private JCheckBox chckbxSlugNear;
	private JCheckBox chckbxSlugBilder;
	
	private JCheckBox chckbxSlugThumbs;
	private JCheckBox chckbxSlugVr;
	private JCheckBox chckbxSlugRemastered;
	private JTextField txtSlugErstelltAmJahr;
	private JTextField txtSlugErstelltAmMonat;
	private JTextField txtSlugErstelltAmTag;
	private JTextField txtSlugErstelltAmZeit;
	
	private DateTimeFormatter dtf;
	private LocalDate localDate;
	
	private JList<String> listDateiVerzeichnis;
	private DefaultListModel<String> dflModel;
	private JTextField txtRibbonVersion;
	private JTextField txtRibbonVersionsdatum;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		// Konfig initialisieren und laden
		ClassKonfig konfiguration = new ClassKonfig();

		TripleX window_start = new TripleX();

		
		konfiguration.KonfigLaden();
		
//		SlugDaten slugDaten = new SlugDaten(window_start);
	
		
		
//		if (window_start.txtKonfigXpos.getText().equals("")) {
//			window_start.txtKonfigXpos.setText("100");
//		}
//
//		if (window_start.txtKonfigYpos.getText().equals("")) {
//			window_start.txtKonfigYpos.setText("100");
//		}

//		window_start.frmFenstertitel.setLocation(Integer.valueOf(window_start.txtKonfigXpos.getText()),
//				Integer.valueOf(window_start.txtKonfigYpos.getText()));

		window_start.frmFenstertitel.setLocation(konfiguration.getIntXPos(), konfiguration.getIntYPos());
		
		window_start.frmFenstertitel.setVisible(true);
		window_start.DebugInfoSchreiben("Ich wurde gestartet");
		
		
	} // Ende main Funktion

	

	
	/*
	 * Funktion: Laden der Konfigurationsdatei i.d.R bei Programmstart
	 */
	public void Konfig_laden() {
		/*
		 * Werte in Version 0.2 vom 04.10.2017:
		 * 
		 * version datum template-slug konfig_cmb_xml <-neu
		 * aktuelle_fensterposition_verwenden fenster_x fenster_y last_pfad
		 * standard_pfad logging log
		 */

		// ohne Pfad-Angabe identisch zu:
		// /home/thomas/workspace/Fenster/konfig.txt
		konfigDatei = new File("konfig.txt");
		
		if (!konfigDatei.exists() | !konfigDatei.isFile()) {
			// Fensterausgabe mit Hinweis
			JOptionPane.showMessageDialog(null, "Keine konfig.txt im Hauptverzeichnis vorhanden!\nPfad:\n" + konfigDatei.getAbsolutePath());

		} else {

			Properties konfigProperLaden = new Properties();
			try {

				FileInputStream fis = new FileInputStream(konfigDatei);
				konfigProperLaden.load(fis);

				txtKonfigVersion.setText(konfigProperLaden.getProperty("version"));
				txtKonfigDatum.setText(konfigProperLaden.getProperty("datum"));
				txtKonfigTemplateslug.setText(konfigProperLaden.getProperty("template-slug"));
				txtKonfigcomboboxenxml.setText(konfigProperLaden.getProperty("konfig_cmb_xml"));

				if (konfigProperLaden.getProperty("aktuelle_fensterposition_verwenden").equals("ja")) {
					chckbxKonfigAkutelleFensterposition.setSelected(true);
					lblKonfigXpos.setEnabled(true);
					lblKonfigYpos.setEnabled(true);
					txtKonfigXpos.setEnabled(true);
					txtKonfigYpos.setEnabled(true);
				} else {
					chckbxKonfigAkutelleFensterposition.setSelected(false);
					lblKonfigXpos.setEnabled(false);
					lblKonfigYpos.setEnabled(false);
					txtKonfigXpos.setEnabled(false);
					txtKonfigYpos.setEnabled(false);
				}

				txtKonfigXpos.setText(konfigProperLaden.getProperty("fenster_x"));
				txtKonfigYpos.setText(konfigProperLaden.getProperty("fenster_y"));

				txtKonfigLetzterPfad.setText(konfigProperLaden.getProperty("last_pfad"));
				txtKonfigStandardPfad.setText(konfigProperLaden.getProperty("standard_pfad"));

				if (konfigProperLaden.getProperty("logging").equals("ein")) {
					chckbxKonfigLogging.setSelected(true);
					lblKonfigLogdatei.setEnabled(true);
					txtKonfigLogdatei.setEnabled(true);
				} else {
					chckbxKonfigLogging.setSelected(false);
					lblKonfigLogdatei.setEnabled(false);
					txtKonfigLogdatei.setEnabled(false);
				}

				fis.close();
//				txtStatusleiste.setText("Konfiguration geladen");
				DebugInfoSchreiben("TripleX-Klasse: Funktion Konfig_Laden(): Konfiguration geladen");

			} catch (IOException e) {
				// TODO Automatisch generierter Erfassungsblock
				e.printStackTrace();
			}

		} // else wird geschlossen

	} // Funktion wird geschlossen

/*
 * Funktion: Speichern der Konfigurationsdatei
 */
public void Konfig_speichern() {
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

	/*
	 * Werte in Version 0.2 vom 03.10.2017:
	 * 
	 * version datum template-slug konfig_cmb_xml <-neu
	 * aktuelle_fensterposition_verwenden fenster_x fenster_y last_pfad
	 * standard_pfad logging log
	 */

	Properties konfigProperSchreiben = new Properties();

	Point fensterPosition;
	fensterPosition = frmFenstertitel.getLocation();
	txtStatusleiste.setText("x-Pos: " + fensterPosition.x + " // y-Pos: " + fensterPosition.y);
	konfigProperSchreiben.setProperty("fenster_x", String.valueOf(fensterPosition.x));
	konfigProperSchreiben.setProperty("fenster_y", String.valueOf(fensterPosition.y));

	konfigDatei = new File("konfig.txt");

	try {
		FileOutputStream fos = new FileOutputStream(konfigDatei);
		konfigProperSchreiben.store(fos, null);
		fos.close();
	} catch (IOException e) {
		// TODO Automatisch generierter Erfassungsblock
		e.printStackTrace();
	}

	txtStatusleiste.setText("Konfiguration gespeichert");

} // Ende Funktion Konfig_speichern

	
public void KonfigDatenSetzen(ClassKonfig konfigDaten) {
	// Konfig beim Verlassen speichern
	
	chckbxKonfigSpeichernBeimBeenden.setSelected(konfigDaten.isKonfigSpeichern());
	
	txtKonfigXpos.setText(String.valueOf(konfigDaten.getIntXPos()));
}

	
	/**
	 * Laden der Daten für die beiden ComboBoxem im Reiter Slug.
	 *
	 * @param XmlDatei: Typ: File (Name der Datei mit den xml-Daten)
	 * @param combobox
	 * @param StudioOderAlbum
	 * @param datenreihe
	 * @throws IOException 
	 */
	public String[] ComboBoxDatenLaden(File XmlDatei, JComboBox<String> combobox, String StudioOderAlbum, int datenreihe) throws IOException {

		String[] rueckgabe;
		
		if (XmlDatei.exists()){
			
			Document doc = Jsoup.parse(XmlDatei, "UTF-8");
			Elements elementsStudio = doc.select("eintrag > studio");
			
			String albumAuswahl = "auswahl." + datenreihe +" > album";
			Elements elementsAlbum = doc.select(albumAuswahl);
			
			if (StudioOderAlbum.equals("studio") | StudioOderAlbum.equals("Studio")) {
				rueckgabe = new String[elementsStudio.size()];
			} else {
				rueckgabe = new String[elementsAlbum.size()];
			}
			
			switch (StudioOderAlbum) {
			case "studio":
			case "Studio":
					// alle Daten in das String-Array datenCmbSlugStudio schreiben
					for(int i=0;i<elementsStudio.size();i++) {
						Element elementStudio = doc.select("studio").get(i);
						rueckgabe[i] = elementStudio.text();
					} // Ende i-Schleife
					return rueckgabe;
				
			case "album":
			case "Album":
				// alle Daten mit <album> unterhalb der <auswahl class="xxxx">
				for(int i=0;i<elementsAlbum.size();i++){
					Element elementAlbum = doc.select(albumAuswahl).get(i);
					rueckgabe[i] = elementAlbum.text();
				} // Ende i-Schleife
				return rueckgabe;
				
			default:
				
				System.out.println("Fehler beim Aufruf der Funktion: ComboBoxDatenLaden()");
				txtStatusleiste.setText("Schwerwiegender Fehler!!! Rückgabewert der Funktion ComBoxDatenLaden()");
				System.exit(0);
				return rueckgabe;
			} // Ende Switch
			
			} // Ende if
		// Das sollte nie zum Tragen kommem
		String[] notausstieg = {"Brazzers","NaugthyAmerica","Tushy","RealityKings"};
		txtStatusleiste.setText("Schwerwiegender Fehler!!! Rückgabewert der Funktion ComBoxDatenLaden()");
		return notausstieg;
	} // Ende ComboBoxDatenLaden
	
	
	/**
	 * Initialisierung der Combo-Boxen
	 *
	 * @param combobox
	 * @param daten
	 */
	public void ComboBoxBefuellen(JComboBox<String> combobox, String[] daten) {
		//ComboBox-Einträge alle löschen
		combobox.removeAllItems();
		
		// ComboBox neu befüllen
		for(int zaehler=0;zaehler<daten.length;zaehler++){
			combobox.addItem(daten[zaehler]);
		} //Ende zaehler-Schleife
		
	} //Ende ComboBoxBefuellen
	
	
	public void SlugDaten_holen(SlugDaten sDatenFunktion) {
		sDatenFunktion.setStrSlug(txtRibbonSlugName.getText().trim());
		sDatenFunktion.setStrPfad(txtRibbonPfad.getText());
		sDatenFunktion.setStrTitel(txtRibbonTitel.getText().trim());
		sDatenFunktion.setStrSerie(txtRibbonSerie.getText().trim());
		
		sDatenFunktion.setStrActress(txtSlugActress.getText().trim());
		sDatenFunktion.setStrActor(txtSlugActor.getText().trim());
		sDatenFunktion.setStrBeschreibung(txtpnSlugBeschreibung.getText().trim());
		sDatenFunktion.setStrBraznr(txtSlugBraznr.getText().trim());

		sDatenFunktion.setStrNA(txtSlugNa.getText());

		
		sDatenFunktion.setStrRelease(txtSlugReleaseJahr.getText() + ":" + txtSlugReleaseMonat.getText() + ":" + txtSlugReleaseTag.getText() + " " + txtSlugReleaseZeit.getText());
		sDatenFunktion.setStrErstellt(txtSlugErstelltAmJahr.getText() + ":" + txtSlugErstelltAmMonat.getText() + ":" + txtSlugErstelltAmTag.getText() + " " + txtSlugErstelltAmZeit.getText());
		
//		sDatenFunktion.setStrErstellt(txtSlugErstelltAm.getText().toString());

		
		sDatenFunktion.setStrTitelbild(txtSlugTitelbild.getText());
		sDatenFunktion.setStrPortraetbild(txtSlugPortraitbild.getText());
		
		// Werte aus den Comboboxen
		sDatenFunktion.setStrStudio(cmbSlugStudio.getSelectedItem().toString());
		sDatenFunktion.setStrAlbum(cmbSlugAlbum.getSelectedItem().toString());

		sDatenFunktion.setStrDVD(txtSlugDvd.getText());
		sDatenFunktion.setStrPart(txtSlugPart.getText());
		sDatenFunktion.setStrAnzahlparts(txtSlugAnzahlParts.getText());
		
		/*
		 * Bilder ausgewählt
		 */
		if (chckbxSlugBilder.isSelected()) {
			sDatenFunktion.setStrBilder("j");
		} else {
			sDatenFunktion.setStrBilder("n");
		}

		/*
		 * Thumbs ausgewählt
		 */
		if (chckbxSlugThumbs.isSelected()) {
			sDatenFunktion.setStrThumbs("j");
		} else {
			sDatenFunktion.setStrThumbs("n");
		}
		
		/*
		 * Remastered ausgewählt
		 */
		if (chckbxSlugRemastered.isSelected()) {
			sDatenFunktion.setStrRemastered("j");
		} else {
			sDatenFunktion.setStrRemastered("n");
		}

		/*
		 * VR ausgewählt
		 */
		if (chckbxSlugVr.isSelected()) {
			sDatenFunktion.setStrVR("j");
		} else {
			sDatenFunktion.setStrVR("n");
		}

		/*
		 * First ausgewählt
		 */
		if (chckbxSlugFirst.isSelected()) {
			sDatenFunktion.setStrFirst("j");
			sDatenFunktion.setStrFirstname(txtSlugFirst.getText());
		} else {
			sDatenFunktion.setStrFirst("n");
			sDatenFunktion.setStrFirstname("");
		}
		
		/*
		 * Near ausgewählt
		 */
		if (chckbxSlugNear.isSelected()) {
			sDatenFunktion.setStrNear("j");
			sDatenFunktion.setStrNearname(txtSlugNear.getText());
		} else {
			sDatenFunktion.setStrNear("n");
			sDatenFunktion.setStrNearname("");
		}
		
		sDatenFunktion.setStrSterne(cmbSlugSterne.getSelectedItem().toString());
		DebugInfoSchreiben("btn - Slug-Daten aus Datei laden");
	} // Ende Funktion

	
public void SlugDatenLeeren() {
	// Bereich Ribbon
	txtRibbonHttp.setText("");
	txtRibbonSerie.setText("");
	txtRibbonSlugName.setText("");
	txtRibbonTitel.setText("");
	
	// Bereich Slug
	
	txtSlugActress.setText("");
	txtSlugActor.setText("");
	txtpnSlugBeschreibung.setText("");
	txtSlugBraznr.setText("");
	txtSlugNa.setText("");
		
	dtf = DateTimeFormatter.ofPattern("yyyy");
	localDate = LocalDate.now();
	txtSlugReleaseJahr.setText(dtf.format(localDate));
	txtSlugReleaseMonat.setText("");
	txtSlugReleaseTag.setText("");
	txtSlugReleaseZeit.setText("00:00");
	
	dtf = DateTimeFormatter.ofPattern("yyyy");
	localDate = LocalDate.now();
	txtSlugErstelltAmJahr.setText(dtf.format(localDate));

	dtf = DateTimeFormatter.ofPattern("MM");
	localDate = LocalDate.now();
	txtSlugErstelltAmMonat.setText(dtf.format(localDate));
	
	dtf = DateTimeFormatter.ofPattern("dd");
	localDate = LocalDate.now();
	txtSlugErstelltAmTag.setText(dtf.format(localDate));
	
	txtSlugErstelltAmZeit.setText("00:00");
	
	// Titelbild leeren
	txtSlugTitelbild.setText("01");
	lblSlugTitelbildAnzeige.setIcon(null);
	lblSlugTitelbildAnzeige.setText("");

	// Portraetbild leeren
	txtSlugPortraitbild.setText("01");
	lblSlugPortraetbildAnzeige.setIcon(null);
	lblSlugPortraetbildAnzeige.setText("");
	
	// ComboBoxen werden auf den ersten Wert, also Index 0 gesetzt
	cmbSlugAlbum.setSelectedIndex(0);
	cmbSlugStudio.setSelectedIndex(0);

	txtSlugDvd.setText("");
	
	txtSlugPart.setText("1");
	txtSlugAnzahlParts.setText("");
	chckbxSlugBilder.setSelected(false);
	chckbxSlugThumbs.setSelected(false);
	chckbxSlugRemastered.setSelected(false);
	chckbxSlugVr.setSelected(false);
	chckbxSlugFirst.setSelected(false);
	txtSlugFirst.setText("");
	txtSlugFirst.setEditable(false);
	txtSlugFirst.setEnabled(false);
	
	chckbxSlugNear.setSelected(false);
	txtSlugNear.setText("");
	txtSlugNear.setEditable(false);
	txtSlugNear.setEnabled(false);
	
	cmbSlugSterne.setSelectedIndex(0);

	DebugInfoSchreiben("btn - Slug Daten geleert");
} // Ende Funktion SlugDatenLeeren

public String SlugDatenSetzen(SlugDaten sDatenFunktion) {

	txtRibbonPfad.setText(sDatenFunktion.getStrPfad());
	txtRibbonSlugName.setText(sDatenFunktion.getStrSlug().trim());
	txtRibbonTitel.setText(sDatenFunktion.getStrTitel());
	
	txtSlugActress.setText(sDatenFunktion.getStrActress());
	txtSlugActor.setText(sDatenFunktion.getStrActor());
	txtpnSlugBeschreibung.setText(sDatenFunktion.getStrBeschreibung());
	txtSlugBraznr.setText(sDatenFunktion.getStrBraznr());
	txtSlugNa.setText(sDatenFunktion.getStrNA());
	
	// Format: 2017:08:07 00:00
	txtSlugReleaseJahr.setText(sDatenFunktion.getStrRelease().substring(0, 4));
	txtSlugReleaseMonat.setText(sDatenFunktion.getStrRelease().substring(5, 7));
	txtSlugReleaseTag.setText(sDatenFunktion.getStrRelease().substring(8, 10));
	txtSlugReleaseZeit.setText(sDatenFunktion.getStrRelease().substring(11, 16));
	
	txtSlugErstelltAmJahr.setText(sDatenFunktion.getStrErstellt().substring(0, 4));
	txtSlugErstelltAmMonat.setText(sDatenFunktion.getStrErstellt().substring(5, 7));
	txtSlugErstelltAmTag.setText(sDatenFunktion.getStrErstellt().substring(8, 10));
	txtSlugErstelltAmZeit.setText(sDatenFunktion.getStrErstellt().substring(11, 16));

	txtSlugTitelbild.setText(sDatenFunktion.getStrTitelbild());
	txtSlugPortraitbild.setText(sDatenFunktion.getStrPortraetbild());
	
	// In ComboBoxen
//	writer.write("STUDIO=\"" + strStudio + "\"");
//	writer.write("ALBUM=\"" + strAlbum + "\"");
	DebugInfoSchreiben("Studio: " +sDatenFunktion.getStrStudio());
	DebugInfoSchreiben("Album: " +sDatenFunktion.getStrAlbum());
	
	txtSlugDvd.setText(sDatenFunktion.getStrDVD());
	txtRibbonSerie.setText(sDatenFunktion.getStrSerie());
	
	txtSlugPart.setText(sDatenFunktion.getStrPart());
	txtSlugAnzahlParts.setText(sDatenFunktion.getStrAnzahlparts());
	
	// Bilder
	if (sDatenFunktion.getStrBilder().equals("j") | sDatenFunktion.getStrBilder().equals("J")) {
		chckbxSlugBilder.setSelected(true);
	} else {
		chckbxSlugBilder.setSelected(false);
	}
	
	// Thumbs
	if (sDatenFunktion.getStrThumbs().equals("j") | sDatenFunktion.getStrThumbs().equals("J")) {
		chckbxSlugThumbs.setSelected(true);
	} else {
		chckbxSlugThumbs.setSelected(false);
	}
	
	// Remastered
	if (sDatenFunktion.getStrRemastered().equals("j") | sDatenFunktion.getStrRemastered().equals("J")) {
		chckbxSlugRemastered.setSelected(true);
	} else {
		chckbxSlugRemastered.setSelected(false);
	}

	// VR
	if (sDatenFunktion.getStrVR().equals("j") | sDatenFunktion.getStrVR().equals("J")) {
		chckbxSlugVr.setSelected(true);
	} else {
		chckbxSlugVr.setSelected(false);
	}
	
	// First
	if (sDatenFunktion.getStrFirst().equals("j") | sDatenFunktion.getStrFirst().equals("J")) {
		chckbxSlugFirst.setSelected(true);
	} else {
		chckbxSlugFirst.setSelected(false);
	}

	txtSlugFirst.setText(sDatenFunktion.getStrFirstname());
	
	// Near
	if (sDatenFunktion.getStrNear().equals("j") | sDatenFunktion.getStrNear().equals("J")) {
		chckbxSlugNear.setSelected(true);
	} else {
		chckbxSlugNear.setSelected(false);
	}

	txtSlugNear.setText(sDatenFunktion.getStrFirstname());

	// Sterne
	if (sDatenFunktion.getStrSterne().equals("")) {
		cmbSlugSterne.setSelectedIndex(0);
	} else {
		cmbSlugSterne.setSelectedIndex(Integer.valueOf(sDatenFunktion.getStrSterne())-1);
	}
	
	return "Slug-Daten geladen";
} // Ende Funktion SlugDatenSetzen


/**
 * @param strPfad
 * @param dflModel
 * @return
 */
public String VerzeichnisAkutalisieren(String strPfad, DefaultListModel<String> dflModel) {

	DebugInfoSchreiben("Funktion VerzeichnisAktualisieren() wurde aufgerufen.");
//	System.out.println("Funktionsaufruf: " + strPfad);
	File fPfad = new File(strPfad);
	
	if (fPfad.isDirectory() && fPfad.exists()) {
		
		String strArrayInhalt[] = fPfad.list();

		// Liste leeren
		this.dflModel.removeAllElements();
		
		// Liste alphabetisch sortieren
		Arrays.sort(strArrayInhalt);
		for (int i = 0; i < strArrayInhalt.length; i++) {
			this.dflModel.addElement(strArrayInhalt[i]);
		}
		
		return "Verzeichnis aktualisiert.";
	} else {
//		System.out.println("123Datei existiert NICHT!");
		return "Pfad konnte nicht gefunden werden!.";
	}
}


/**
 * 
 */
public void TitelbildAnzeigen() {
	// Ablauf
	// Pfad holen
	// Slug holen
	// Bildnummer holen
	//	Bild als SetIcon setzen

	String strTitelbildPfad;
	String strTitelbildNamePfad;
	File fTitelbild;
	
	// abschliessendes Slash (sofern vorhanden) entfernen
	if (txtRibbonPfad.getText().endsWith("/")) {
		strTitelbildPfad = txtRibbonPfad.getText().substring(0, txtRibbonPfad.getText().length() - 1);
	} else {
		strTitelbildPfad = txtRibbonPfad.getText();
	}
	
	strTitelbildNamePfad = strTitelbildPfad + "/" + txtSlugTitelbild.getText() + "-" + txtRibbonSlugName.getText() + ".jpg";
	
	fTitelbild = new File(strTitelbildNamePfad);
	if (fTitelbild.isFile() && fTitelbild.exists()) {
			
			BufferedImage bufferedimg = null;
			try {
				bufferedimg = ImageIO.read(new File(strTitelbildNamePfad));
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Resize
			Image dimg = null;
				if (bufferedimg.getWidth() > bufferedimg.getHeight()) {
					dimg = bufferedimg.getScaledInstance(lblSlugTitelbildAnzeige.getWidth(), lblSlugTitelbildAnzeige.getHeight(),
							Image.SCALE_SMOOTH);
				} else {
					// hochkant
					dimg = bufferedimg.getScaledInstance((lblSlugTitelbildAnzeige.getWidth()/3)*2, lblSlugTitelbildAnzeige.getHeight(),
							Image.SCALE_SMOOTH);													
				}

			// Icon lesen
			ImageIcon iconSlugTitelbild = new ImageIcon(dimg);
			lblSlugTitelbildAnzeige.setHorizontalAlignment(SwingConstants.CENTER);
			lblSlugTitelbildAnzeige.setIcon(iconSlugTitelbild);
		
	} else {
		// Text des Labels auf "Kein Titelbild" / "No" setzen
		lblSlugTitelbildAnzeige.setIcon(null);
		lblSlugTitelbildAnzeige.setText("Kein Titelbild");
	} // Ende if
} // Ende TitelbildAnzeigen Funktion



/**
 *
 */
public void PortraetbildAnzeigen() {
	// Ablauf
	// Pfad holen
	// Slug holen
	// Bildnummer holen
	//	Bild als SetIcon setzen

	String strPortraetbildPfad;
	String strPortraetbildNamePfad;
	File fPortraetbild;
	
	// abschliessendes Slash (sofern vorhanden) entfernen
	if (txtRibbonPfad.getText().endsWith("/")) {
		strPortraetbildPfad = txtRibbonPfad.getText().substring(0, txtRibbonPfad.getText().length() - 1);
	} else {
		strPortraetbildPfad = txtRibbonPfad.getText();
	}
	
	strPortraetbildNamePfad = strPortraetbildPfad + "/" + txtSlugPortraitbild.getText() + "-" + txtRibbonSlugName.getText() + ".jpg";
	
	fPortraetbild = new File(strPortraetbildNamePfad);
	if (fPortraetbild.isFile() && fPortraetbild.exists()) {
			
			BufferedImage bufferedimg = null;
			try {
				bufferedimg = ImageIO.read(new File(strPortraetbildNamePfad));
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Resize
			Image dimg = null;
				if (bufferedimg.getWidth() > bufferedimg.getHeight()) {
					dimg = bufferedimg.getScaledInstance(lblSlugPortraetbildAnzeige.getWidth(), lblSlugPortraetbildAnzeige.getHeight(), Image.SCALE_SMOOTH);
				} else {
					// hochkant
					dimg = bufferedimg.getScaledInstance((lblSlugPortraetbildAnzeige.getWidth()/3)*2, lblSlugPortraetbildAnzeige.getHeight(), Image.SCALE_SMOOTH);													
				}

			// Icon lesen
			ImageIcon iconSlugPortraetbild = new ImageIcon(dimg);
			lblSlugPortraetbildAnzeige.setHorizontalAlignment(SwingConstants.CENTER);
			lblSlugPortraetbildAnzeige.setIcon(iconSlugPortraetbild);
		
	} else {
		
		// Text des Labels auf "Kein Titelbild" / "No" setzen
		lblSlugTitelbildAnzeige.setIcon(null);
		lblSlugTitelbildAnzeige.setText("Kein Titelbild");

		
	} // Ende if
} // Ende Funktion PortraetbildAnzeigen


public void BilderDownloaden() {
/*
 * Ablauf
 * (1) Download von Brazzers oder NA?
 * (2) Pfad- und Slug-Angaben überprüfen/festlegen
 * (3) Gibt es die Bilder schon? Überschreiben?
 * (3) Download mit Anzeige in Statusleiste oder Progressbar
 */
	
	String strDownloadDatei;
	
// beide Felder leer --> Infofenster und Ende	
if (txtSlugBraznr.getText().equals("") && txtSlugNa.getText().equals("")) {
	JOptionPane.showMessageDialog(frmFenstertitel, "Weder BrazNr noch NA-Link-Bild gefüllt!");
} else {
	// beide Felder gefüllt --> Infofenster und Ende
	if (!txtSlugBraznr.getText().equals("") && !txtSlugNa.getText().equals("")) {
		JOptionPane.showMessageDialog(frmFenstertitel, "Beide Felder BrazNr und NA-Link-Bild gefüllt!\nNur ein Feld darf gefüllt sein!");
	} else {
		// Pfad muss gefüllt sein
		if (txtRibbonPfad.getText().equals("")) {
			JOptionPane.showMessageDialog(frmFenstertitel, "Pfad muss gefüllt sein!");
		} else {
			File fVerzeichnisPfad = new File(txtRibbonPfad.getText());
			// Pfad muss existieren und Verzeichnis sein			
			if (!fVerzeichnisPfad.isDirectory() || !fVerzeichnisPfad.exists()) {
				JOptionPane.showMessageDialog(frmFenstertitel, "Pfad ist kein Verzeichnis und/oder nicht vorhanden!");
			} else {
				// Slug muss gefüllt sein
				if (txtRibbonSlugName.getText().equals("")) {
					JOptionPane.showMessageDialog(frmFenstertitel, "Slug muss gefüllt sein!");
				} else {
					// Brazzer oder NA
					// Brazzer: entweder 5 oder 15 Bilder
					if (!txtSlugBraznr.getText().equals("")) {
						
						String strStamm_braz_1="http://static.brazzers.com/scenes/";
						String strStamm_braz_2="/preview/img";
						String strQuelle;
						
						int iAnzahlBilder = 0;
						
						for (int i = 1; i < 10; i++) {
							strQuelle = strStamm_braz_1 + txtSlugBraznr.getText() + strStamm_braz_2 + "/0" + i + ".jpg";
							
							URL url;
							try {
								url = new URL(strQuelle);
								BufferedImage img;
								img = ImageIO.read(url);
								strDownloadDatei = txtRibbonPfad.getText() + "/0" + i + "-" + txtRibbonSlugName.getText() + ".jpg";
								File fDownload = new File(strDownloadDatei);
								ImageIO.write(img, "jpg", fDownload);
								DebugInfoSchreiben("geladen: Bild: " + strDownloadDatei);
								iAnzahlBilder++;
							} catch (IOException e) {
								strDownloadDatei = txtRibbonPfad.getText() + "/0" + i + "-" + txtRibbonSlugName.getText() + ".jpg";
								DebugInfoSchreiben("nicht vorhanden: Bild: " + strDownloadDatei);
								//								e.printStackTrace();
							}
						} // Ende for-Schleife
						
						for (int i = 10; i < 16; i++) {
							strQuelle = strStamm_braz_1 + txtSlugBraznr.getText() + strStamm_braz_2 + "/" + i + ".jpg";
							
							URL url;
							try {
								url = new URL(strQuelle);
								BufferedImage img;
								img = ImageIO.read(url);
								strDownloadDatei = txtRibbonPfad.getText() + "/" + i + "-" + txtRibbonSlugName.getText() + ".jpg";
								File fDownload = new File(strDownloadDatei);
								ImageIO.write(img, "jpg", fDownload);
								DebugInfoSchreiben("geladen: Bild: " + strDownloadDatei);
								iAnzahlBilder++;
							} catch (IOException e) {
								strDownloadDatei = txtRibbonPfad.getText() + "/" + i + "-" + txtRibbonSlugName.getText() + ".jpg";
								DebugInfoSchreiben("nicht vorhanden: Bild: " + strDownloadDatei);
								//								e.printStackTrace();
							}
							txtStatusleiste.setText("Download Brazzers-Bilder fertig.");
						} // Ende for-Schleife
						txtStatusleiste.setText("Es wurden " + iAnzahlBilder + " Bilder ge-downloaded");
					} else {
					// NA	
					// Je nach Link entweder das huge.jpg-Bild oder das big_img1.jpg Bild	
					
					DebugInfoSchreiben("NaughtyAmerica Bilder werden gedownloaded");
						
					String strNaStammName = "";
					
//						https://images3.naughtycdn.com/datana/upload/source/mgbf/lexijmac/lexijmacvert_scene_huge.jpg
//						https://images1.naughtycdn.com/datana/upload/source/mgbf/lexijmac/lexijmachor_big_img1.jpg
//						https://images1.naughtycdn.com/datana/upload/source/mgbf/lexijmac/lexijmachor_big_img4.jpg
					if (txtSlugNa.getText().contains("huge")) {
						strNaStammName = txtSlugNa.getText().substring(0, txtSlugNa.getText().length() - 19);
						DebugInfoSchreiben("Angegebenes Bild: huge: " + strNaStammName);
					}
					
					if (txtSlugNa.getText().contains("hor_big")) {
						strNaStammName = txtSlugNa.getText().substring(0, txtSlugNa.getText().length() - 16);
						DebugInfoSchreiben("Angegebenes Bild: big: " + strNaStammName);
					}
						
					
					// Jetzt startet das Downloaden
					// Huge-Bild als Nummer 05
					URL url;
					try {
						url = new URL(strNaStammName + "vert_scene_huge.jpg");
						BufferedImage img;
						img = ImageIO.read(url);
						strDownloadDatei = txtRibbonPfad.getText() + "/05-" + txtRibbonSlugName.getText() + ".jpg";
						File fDownload = new File(strDownloadDatei);
						ImageIO.write(img, "jpg", fDownload);
						DebugInfoSchreiben("geladen: Bild: " + strDownloadDatei);
					} catch (IOException e) {
						strDownloadDatei = txtRibbonPfad.getText() + "/0-" + txtRibbonSlugName.getText() + ".jpg";
						DebugInfoSchreiben("nicht vorhanden: Bild: " + strDownloadDatei);
					}
						
					// die nächsten 4 Bilder
					for (int j = 1; j < 5; j++) {
						
						try {
							url = new URL(strNaStammName + "hor_big_img" + j +".jpg");
							BufferedImage img;
							img = ImageIO.read(url);
							strDownloadDatei = txtRibbonPfad.getText() + "/0" +j + "-" + txtRibbonSlugName.getText() + ".jpg";
							File fDownload = new File(strDownloadDatei);
							ImageIO.write(img, "jpg", fDownload);
							DebugInfoSchreiben("geladen: Bild: " + strDownloadDatei);
						} catch (IOException e) {
							strDownloadDatei = txtRibbonPfad.getText() + "/0" + j + "-" + txtRibbonSlugName.getText() + ".jpg";
							DebugInfoSchreiben("nicht vorhanden: Bild: " + strDownloadDatei);
						}	
						
						
					} // Ende for-Schleife
					
					
					
					txtStatusleiste.setText("Download Bilder NaughtyAmerica fertig.");
					
					}
				}
			}
		}
	}	
} // Ende äußerste if-Abfrage
	

} // Ende Funktion BilderDownloaden


public void BilderAnzeigen() {
	
	/*
	 * Ablauf:
	 * (1) RibbonPfad als String holen
	 * (2) endet der String mit "/", dann entfernen
	 * (3) String splitten nach "/"
	 * (4) Letztes Feld = Teil des Dateinamens
	 * (5) Dateinamen zusammensetzen
	 * 
	 * Anzeige: pro Reihe 3 Bilder
	 */

	DebugInfoSchreiben("Funktion BilderAnzeigen() wird aufgerufen");
	
	// ungelöster Fehler: keine Aktualisierung
	
	String strBildName;
	String strBildPfad;
	String strBildPfadName;
	File fBilder;
	
	// Wenn Pfad nicht gefüllt, dann braucht auch nix angezeigt zu werden
	if ( ! txtRibbonPfad.getText().equals("")) {

		// nur für Linux
		// Letzes Slash wird entfernt
		if (txtRibbonPfad.getText().endsWith("/")) {
			strBildPfad = txtRibbonPfad.getText().substring(0, txtRibbonPfad.getText().length() - 1);
		} else {
			strBildPfad = txtRibbonPfad.getText();
		} // Ende if

		
		//Bilder im Pfad holen
		//Sofern Datei auf .jpg endet anzeigen
		fBilder = new File(txtRibbonPfad.getText());
		String strAlleBilder[] = fBilder.list();
		Arrays.sort(strAlleBilder);
		
		
		lblBilderNummer = new ArrayList<JLabel>();
		chckbxTitelbild = new ArrayList<JCheckBox>();
		chckbxPortraetbild = new ArrayList<JCheckBox>();
		panelBilder = new ArrayList<JPanel>();
		strBildNameVerzeichnis = new ArrayList<String>();

		// Panel leeren
		panelBilderRahmen.removeAll();
		
		
		// Variablen anlegen
		for (int i = 0; i < strAlleBilder.length; i++) {
			if (strAlleBilder[i].endsWith(".jpg")) {
				// Bildname mit kompletten Pfad setzen
				strBildNameVerzeichnis.add(new String(txtRibbonPfad.getText() + "/" + strAlleBilder[i]));
//				System.out.println(strBildNameVerzeichnis.get(i));
				panelBilder.add(new JPanel());
				lblBilderNummer.add(new JLabel());
				chckbxTitelbild.add(new JCheckBox(strAlleBilder[i].substring(0, 2) + "-Titelbild"));
				chckbxPortraetbild.add(new JCheckBox(strAlleBilder[i].substring(0, 2) + "-Porträtbild"));
			}
		}

		
		// Größe des eingebetteten Panels setzen
		// 3 Bilder pro Reihe/Zeile
		
		Dimension dimensionPanelBilder;
		if (lblBilderNummer.size() % 3 != 0) {
			dimensionPanelBilder = new Dimension(600, ((lblBilderNummer.size() / 3) +1 ) * 280);
//			DebugInfoSchreiben("Register Bilder; Panel-Größe: 600x" + ((lblBilderNummer.size() / 3) +1 ) * 330);
		} else {
			dimensionPanelBilder = new Dimension(600, (lblBilderNummer.size() / 3) * 280);
//			DebugInfoSchreiben("Register Bilder; Panel-Größe: 600x" + (lblBilderNummer.size() / 3) * 330);
		}
		
		panelBilderRahmen.setPreferredSize(dimensionPanelBilder);
		
		
		
		// Werte setzen und anzeigen
		for (int i = 0; i < lblBilderNummer.size(); i++) {
//			lblBilderNummer.get(i).setHorizontalAlignment(SwingConstants.CENTER);
//			lblBilderNummer.get(i).setBorder(new LineBorder(new Color(0, 0, 0)));
			lblBilderNummer.get(i).setSize(150, 100);
			// Dimension 210 x 260
			panelBilder.get(i).setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBilder.get(i).setPreferredSize(dimensionBilder);
			panelBilder.get(i).setLayout(new BoxLayout(panelBilder.get(i), BoxLayout.Y_AXIS));
			
			DebugInfoSchreiben("Bild: " + strBildNameVerzeichnis.get(i));
			
			File fBildDatei = new File(strBildNameVerzeichnis.get(i));
			if (fBildDatei.isFile() && fBildDatei.exists()) {
				
				BufferedImage bufferedimg = null;
				try {
					bufferedimg = ImageIO.read(new File(strBildNameVerzeichnis.get(i)));
				} catch (IOException e) {
					e.printStackTrace();
				}

				// Resize
				Image dimg = null;
					if (bufferedimg.getWidth() > bufferedimg.getHeight()) {
						dimg = bufferedimg.getScaledInstance(210, 140, Image.SCALE_SMOOTH);
//						dimg = bufferedimg.getScaledInstance(lblAnzeigeBild1.getWidth(), lblAnzeigeBild1.getHeight(),
					} else {
						// hochkant
						dimg = bufferedimg.getScaledInstance(140, 210, Image.SCALE_SMOOTH);													
					}

				// Icon lesen
				ImageIcon iconAnzeigeBild = new ImageIcon(dimg);
				lblBilderNummer.get(i).setIcon(iconAnzeigeBild);
				// Mittig das Bild bzw. Icon darstellen
				lblBilderNummer.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			} // Ende if fBildDatei
			
			
			panelBilder.get(i).add(lblBilderNummer.get(i));
			panelBilder.get(i).add(chckbxTitelbild.get(i));
			panelBilder.get(i).add(chckbxPortraetbild.get(i));
			panelBilderRahmen.add(panelBilder.get(i));
		} // Ende for-Schleife
	} // Ende der 1. if-Abfrage und Funktionsende	
} // Ende BilderAnzeigen - Funktion


/**
 * @param strInfo
 */
public void DebugInfoSchreiben(String strInfo) {
	
	//aktuelle Zeit holen
	LocalTime localTime = LocalTime.now();
	txtAreaDebug.append(localTime.toString() + ": ");
	
	txtAreaDebug.append(strInfo + "\n");
}

public void DebugExceptionSchreiben(Exception e) {
	//aktuelle Zeit holen
		LocalTime localTime = LocalTime.now();
		txtAreaDebug.append("===================== Exception ===================================================");
		txtAreaDebug.append(localTime.toString() + ": ");
//		txtAreaDebug.append(e.printStackTrace());
		txtAreaDebug.append("===================================================================================");
}

/**
 * @param strEingang
 * @return [String]
 */
public String StringUmwandeln(String strEingang) {
/*
 * Schritte der Umwandlung
 * Alles in Kleinbuchstaben
 * Sonderzeichen entfernen
 * Punkt entfernen
 * Komma entfernen
 * runde Klammern entfernen
 * Leerzeichen in Bindestrich
 * Unterstrich in Bindestrich
 * 2 Bindestriche zu einem Bindestrich
 * 
 */
	String strAusgang = strEingang.toLowerCase().replace(" ", "-").replace("(", "").replace(")", "")
			.replace(",", "").replace("_", "-").replace("/", "").replace("&", "").replace("--", "-").replace("'", "").replace(".", "");
	
	return strAusgang;
}



public void setExifDaten(ExifDaten exifDaten) {
	exifDaten.setStrTitle(txtRibbonTitel.getText());
	DebugInfoSchreiben("Exif-Daten");
	DebugInfoSchreiben("-title=" + txtRibbonTitel.getText());
	
	exifDaten.setStrLabel(txtRibbonTitel.getText());
	DebugInfoSchreiben("-label=" + txtRibbonTitel.getText());
	
	exifDaten.setStrXpauthor(cmbSlugStudio.getSelectedItem().toString());
	DebugInfoSchreiben("-xpauthor=" + cmbSlugStudio.getSelectedItem().toString());
	
	exifDaten.setStrKeywords(txtSlugActress.getText() + ";" + txtSlugActor.getText());

	
	exifDaten.setStrPersoninimage(txtSlugActress.getText());
	exifDaten.setStrXpcomment(txtpnSlugBeschreibung.getText());
	exifDaten.setStrCaptionAbstract(txtpnSlugBeschreibung.getText());
	exifDaten.setStrDescription(txtpnSlugBeschreibung.getText());
	exifDaten.setStrImageDescription(txtpnSlugBeschreibung.getText());
	
	exifDaten.setStrDateTimeOriginal(txtSlugReleaseJahr.getText() + ":" + txtSlugReleaseMonat.getText() + ":" +
										txtSlugReleaseTag.getText() + " " + txtSlugReleaseZeit.getText());
	
	
	//-title=Wives On Vacation / Ava Addams & Eva Notty & Jessy Jones
	//-label=Wives On Vacation / Ava Addams & Eva Notty & Jessy Jones
	//-xpauthor=Naughty America
	//-keywords=Ava Addams;Eva Notty; Jessy Jones
	//-personinimage=Ava Addams;Eva Notty
	//
	//-xpcomment=Ava Addams & Eva Notty are on vacation. While they are away from their husbands they decide to have some fun and bring a complete stranger back to their room. These girls just want to have fun
	//-Caption-Abstract=Ava Addams & Eva Notty are on vacation. While they are away from their husbands they decide to have some fun and bring a complete stranger back to their room. These girls just want to have fun
	//-Description=Ava Addams & Eva Notty are on vacation. While they are away from their husbands they decide to have some fun and bring a complete stranger back to their room. These girls just want to have fun
	//-imagedescription=Ava Addams & Eva Notty are on vacation. While they are away from their husbands they decide to have some fun and bring a complete stranger back to their room. These girls just want to have fun
	//
	//-DateTimeOriginal=2015:01:16 00:00


} // Ende Funktion setExifDaten


public void getExifDaten() {
	
}


public Boolean ExifDatenAusDateiLaden(String strDatei) {
	
	File fDatei = new File(strDatei);
	if (fDatei.exists()) {
		
//		FileInputStream fis;
		FileReader fReader;
		BufferedReader br;
		String strZeile = "";
		
		try {
			fReader = new FileReader(fDatei);
			br = new BufferedReader(fReader);
			
			while (br.read() != -1) {
				strZeile = br.readLine();
				DebugInfoSchreiben(strZeile);
				
			}
			
			
		} catch (IOException e) {
			DebugInfoSchreiben("Fehler beim Lesen der Datei: " + strDatei + "Funktion ExifDatenAusDateiLaden");
			e.printStackTrace();
		}
		
		return true;		
	} else {
		return false;
	}
} // Ende Funktion ExifDatenAusDateiLaden


public void ExifDatenInDateiSchreiben(ExifDaten exifDaten) {
/*
 * Ablauf:
 * (1) es muss eine slug-Datei existieren
 * (2) wenn eine exif-Datei bereits existiert -> Nachfrage bzgl. Überschreiben
 * (3) Check der Datenfelder auf Vollständigkeit
 * (4) Datei schreiben
 */
	
	
	DebugInfoSchreiben("Funktion ExifDatenInDateiSchreiben() wurde aufgerufen.");
	
// existiert die entsprechende *.slug-Datei?
	String strSlugDatei;
	String strExifDatei;
	int iExifUeberschreiben;
	
	if (txtRibbonPfad.getText().endsWith("/")) {
		strSlugDatei = txtRibbonPfad.getText() + txtRibbonSlugName.getText() + ".slug";
		strExifDatei = txtRibbonPfad.getText() + txtRibbonSlugName.getText() + ".exif"; 
	} else {
		strSlugDatei = txtRibbonPfad.getText() + "/" + txtRibbonSlugName.getText() + ".slug";
		strExifDatei = txtRibbonPfad.getText() + "/" + txtRibbonSlugName.getText() + ".exif";
	}
	
	DebugInfoSchreiben("Slug-Datei: " + strSlugDatei);
	DebugInfoSchreiben("Exif-Datei: " + strExifDatei);
	
	File fSlugDatei = new File(strSlugDatei);
	// Slug-Datei existiert
	if (fSlugDatei.exists()) {

		// Überprüfen, ob exif-Datei existiert
		File fExifDatei = new File(strExifDatei);
		if (fExifDatei.exists()) {
			iExifUeberschreiben = JOptionPane.showConfirmDialog(frmFenstertitel, "Soll die Exifdatei:\n" + strExifDatei + "\nüberschrieben werden?", "Überschreiben", JOptionPane.YES_NO_OPTION);
		} else {
			// ExifDatei endlich schreiben
			DebugInfoSchreiben(exifDaten.ExifDatenDateiErzeugen(strExifDatei));
			
		}
		
		// Exif-Datei soll überschrieben werden
		
		
	} else {
		JOptionPane.showMessageDialog(frmFenstertitel, "Es existiert keine Slug-Datei.\nEs kann keine exif-Datei erstellt werden.");
		DebugInfoSchreiben("Es existiert keine Slug-Datei. Erwarteter Name: " + strSlugDatei
				+ ". Es kann keine exif-Datei erstellt werden.");
	} // Ende if
} // Ende Funktion ExifDatenInDateiSchreiben()

	/**
	 * Create the frame.
	 */
public TripleX() {
		frmFenstertitel = new JFrame();
		frmFenstertitel.setTitle("Hauptfenster");
		frmFenstertitel.setBounds(100, 100, 800, 670);
		frmFenstertitel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFenstertitel.getContentPane().setLayout(new BorderLayout(0, 0));

	
		/*
		 * ======================================
		 * Menüs
		 * ======================================
		 * 
		 */
		JMenuBar menuBar = new JMenuBar();
		frmFenstertitel.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu menuFenster = new JMenu("Fenster");
		menuBar.add(menuFenster);
		
		JMenuItem mntmSlugtemplate = new JMenuItem("Slug-Template");
		menuFenster.add(mntmSlugtemplate);
		
		JSeparator mntmSeparator_1 = new JSeparator();
		menuFenster.add(mntmSeparator_1);

		JMenuItem mntmDebug = new JMenuItem("Debug");
		menuFenster.add(mntmDebug);

		JMenuItem mntmKonfiguration = new JMenuItem("Konfiguration");
		menuFenster.add(mntmKonfiguration);
				
		JSeparator mntmSeparator_2 = new JSeparator();
		menuFenster.add(mntmSeparator_2);
		
		JMenuItem mntmSchliessen = new JMenuItem("Schliessen");
		menuFenster.add(mntmSchliessen);
		mntmSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fenster schliessen und Anwendnug beenden
				frmFenstertitel.dispose();
			}
		});

		JMenu menuUeber = new JMenu("Über");
		menuBar.add(menuUeber);

		JMenuItem menu_item_version = new JMenuItem("Version");
		menu_item_version.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(frmFenstertitel, "Version");

			}
		});
		menuUeber.add(menu_item_version);

		/*
		 * Menüs -Ende
		 */
		
		/*
		 * ===========================================
		 * Start Ribbons
		 * ===========================================
		 * 
		 */
		JPanel panel_mitte = new JPanel();
		frmFenstertitel.getContentPane().add(panel_mitte, BorderLayout.CENTER);
		panel_mitte.setLayout(new BorderLayout(0, 0));

		JPanel panel_ribbon = new JPanel();
		panel_ribbon.setPreferredSize(new Dimension(300, 100));
		
		panel_mitte.add(panel_ribbon, BorderLayout.NORTH);
		panel_ribbon.setLayout(null);

		JLabel lblRibbonPfad = new JLabel("Pfad");
		lblRibbonPfad.setBounds(30, 10, 35, 16);
		panel_ribbon.add(lblRibbonPfad);
		
		txtRibbonPfad = new JTextField();
		txtRibbonPfad.setBounds(115, 9, 370, 20);
		panel_ribbon.add(txtRibbonPfad);
		txtRibbonPfad.setColumns(10);
		
		txtRibbonSlugName = new JTextField();
		txtRibbonSlugName.setBounds(115, 42, 370, 20);
		panel_ribbon.add(txtRibbonSlugName);
		txtRibbonSlugName.setColumns(10);
		
		JLabel lblRibbonSlugName = new JLabel("Slug-Name");
		lblRibbonSlugName.setBounds(30, 43, 85, 16);
		panel_ribbon.add(lblRibbonSlugName);

		/*
		 * Button mit Grafik
		 */
		JButton btnRibbonSlugUmwandeln = new JButton();
		iconRibbonSlugUmwandeln = new ImageIcon(strReload16);
		
		btnRibbonSlugUmwandeln.setIcon(iconRibbonSlugUmwandeln);
		btnRibbonSlugUmwandeln.setBounds(490, 42, 20, 20);
		panel_ribbon.add(btnRibbonSlugUmwandeln);
		
		
		JLabel lblRibbonTitel = new JLabel("Titel");
		lblRibbonTitel.setBounds(30, 76, 40, 16);
		panel_ribbon.add(lblRibbonTitel);
		
		txtRibbonTitel = new JTextField();
		txtRibbonTitel.setBounds(115, 75, 370, 20);
		panel_ribbon.add(txtRibbonTitel);
		txtRibbonTitel.setColumns(10);

		/*
		 * Pfad-Auswahl Button im Bereich Ribbon
		 */
		JButton btnRibbonPfaddialogbox = new JButton("");
		btnRibbonPfaddialogbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Dialogbox öffnen
				 * (1) Auslese txtSlugPfad Feld und daraus den Pfad entnehmen 
				 * (1a) Überprüfen, ob Datei oder Verzeichnis;
				 * 		event. Verzeichnis daraus extrahieren
				 * (2) Dialogbox
				 * (3) Ausgewählten Wert in txtSlugPfad übernehmen
				 */
				txtStatusleiste.setText("Dialogfenster zur Pfadauswahl geöffnet");

				fileRibbonPfad = new File(txtRibbonPfad.getText());

				jfcSlug = new JFileChooser();
				jfcSlug.setCurrentDirectory(fileRibbonPfad);
				
				jfcSlug.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfcSlug.setMultiSelectionEnabled(false);

				int ergebnis = jfcSlug.showOpenDialog(frmFenstertitel);
				// ergebnis = 0: Button Öffnen wurde gedrückt
				// ergebnis = 1: Button Abbruch oder Fensterschliesser wurde
				// gedrückt
				if (ergebnis == 0) {
					txtRibbonPfad.setText(jfcSlug.getSelectedFile().toString());
				}

				txtStatusleiste.setText(VerzeichnisAkutalisieren(txtRibbonPfad.getText(), dflModel));
				
			}
		});
		
		/*
		 * Button mit Grafik / Dialogbox - Schublade
		 */
		iconRibbonPfadDialogbox = new ImageIcon(strSchublade16);
		
		btnRibbonPfaddialogbox.setIcon(iconRibbonPfadDialogbox);
		btnRibbonPfaddialogbox.setBounds(490, 9, 20, 20);
		panel_ribbon.add(btnRibbonPfaddialogbox);
		
		JLabel lblRibbonSerie = new JLabel("Serie");
		lblRibbonSerie.setBounds(530, 76, 45, 16);
		panel_ribbon.add(lblRibbonSerie);
		
		txtRibbonSerie = new JTextField();
		txtRibbonSerie.setBounds(575, 75, 185, 20);
		panel_ribbon.add(txtRibbonSerie);
		txtRibbonSerie.setColumns(10);
		
		JButton btnRibbonTitelZuSerie = new JButton("");
		btnRibbonTitelZuSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Wert aus dem Titel-Feld ins Serien Feld
				txtRibbonSerie.setText(txtRibbonTitel.getText());
				txtStatusleiste.setText("Titel nach Serie kopiert.");
			}
		});
		iconRibbonTitelZuSerie = new ImageIcon(strPfeilRechts);
		btnRibbonTitelZuSerie.setIcon(iconRibbonTitelZuSerie);
		btnRibbonTitelZuSerie.setBounds(490, 74, 20, 20);
		panel_ribbon.add(btnRibbonTitelZuSerie);
		
		JLabel lblRibbonHttp = new JLabel("http");
		lblRibbonHttp.setBounds(530, 43, 40, 15);
		panel_ribbon.add(lblRibbonHttp);
		
		txtRibbonHttp = new JTextField();
		txtRibbonHttp.setBounds(575, 42, 160, 20);
		panel_ribbon.add(txtRibbonHttp);
		txtRibbonHttp.setColumns(10);
		
		JButton btnRibbonHttp = new JButton("");
		btnRibbonHttp.setBounds(739, 42, 20, 19);
		panel_ribbon.add(btnRibbonHttp);
		
		JLabel lblRibbonVersion = new JLabel("Version");
		lblRibbonVersion.setBounds(530, 10, 70, 15);
		panel_ribbon.add(lblRibbonVersion);
		
		txtRibbonVersion = new JTextField();
		txtRibbonVersion.setEditable(false);
		txtRibbonVersion.setBounds(595, 9, 35, 20);
		panel_ribbon.add(txtRibbonVersion);
		txtRibbonVersion.setColumns(10);
		
		txtRibbonVersionsdatum = new JTextField();
		txtRibbonVersionsdatum.setEditable(false);
		txtRibbonVersionsdatum.setBounds(640, 9, 100, 20);
		panel_ribbon.add(txtRibbonVersionsdatum);
		txtRibbonVersionsdatum.setColumns(10);
		
		
		// Speziell für NA
		// Kopiert den Titel nach Slug
		// anschliessend alles in Kleinbuchstaben und Zeichenkonvertierung
		JButton btnRibbonTitel2Slug = new JButton();
		btnRibbonTitel2Slug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtRibbonSlugName.setText(StringUmwandeln(txtRibbonTitel.getText()));
				DebugInfoSchreiben("btnRibbonTitel2Slug - würde gedrückt");
				DebugInfoSchreiben("Umwandlung des Titels: " + txtRibbonTitel.getText() + "nach: " + StringUmwandeln(txtRibbonTitel.getText()));
			}
		});
		iconRibbonTitel2Slug = new ImageIcon(strPfeilOben);
		btnRibbonTitel2Slug.setIcon(iconRibbonTitel2Slug);
		btnRibbonTitel2Slug.setBounds(92, 74, 20, 20);
		panel_ribbon.add(btnRibbonTitel2Slug);
		
		JButton btnRibbonStartverzeichnis = new JButton();
		iconRibbonStarverzeichnis = new ImageIcon(strSchubladeHome);
		btnRibbonStartverzeichnis.setIcon(iconRibbonStarverzeichnis);
		btnRibbonStartverzeichnis.setBounds(92, 8, 20, 20);
		panel_ribbon.add(btnRibbonStartverzeichnis);
		
		
		JButton btnRibbonRefresh = new JButton("");
		btnRibbonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DebugInfoSchreiben("btnRibbonRefresh wurde gedrückt.");
				txtStatusleiste.setText(VerzeichnisAkutalisieren(txtRibbonPfad.getText(), dflModel));
			}
		});
		iconRibbonRefresh = new ImageIcon(strRefresh);
		btnRibbonRefresh.setBounds(67, 8, 20, 20);
		panel_ribbon.add(btnRibbonRefresh);
		btnRibbonRefresh.setIcon(iconRibbonRefresh);
		
		
		
		/*
		 * ========================
		 * Start Panel 1 : Datei
		 * ========================
		 * 
		 */
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		/*
		 * ======================
		 * ChangeListener
		 * Welcher Tab ist aktiv?
		 * SelectedIndex: 0 -> erster Tab
		 * 
		 * ======================
		 * 
		 */
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				switch (tabbedPane.getSelectedIndex()) {
				
				// Panel: Datei
				case 0:
				
					break;
				
				// Panel: Slug
				case 1:
					
					break;
				
				// Panel: Bild
				case 3:
					BilderAnzeigen();
					
					break;
					

				default:
					break;
				} // Ende switch - case
			}
		}); // Ende ChangeListener
		panel_mitte.add(tabbedPane);

		panel_1_Datei = new JPanel();
		tabbedPane.addTab("Datei", null, panel_1_Datei, null);
		tabbedPane.setEnabledAt(0, true);
		panel_1_Datei.setLayout(null);

		JButton btnDateiVerzeichnisErstellen = new JButton("Verz. erstellen");
		btnDateiVerzeichnisErstellen.setBounds(400, 35, 150, 25);
		panel_1_Datei.add(btnDateiVerzeichnisErstellen);
		
		JButton btnDateiDateiKopieren = new JButton("Datei kopieren");
		btnDateiDateiKopieren.setBounds(400, 70, 150, 25);
		panel_1_Datei.add(btnDateiDateiKopieren);
		
		JButton btnDateiErstellenUndKopieren = new JButton("Erst. + kopieren");
		btnDateiErstellenUndKopieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DebugInfoSchreiben("btnDateiErstellenUndKopieren wurde betätigt");
				
				//ersten markierten Eintrag holen
				// Wert: -1, wenn nix markiert ist
				int iMarkierung = listDateiVerzeichnis.getSelectedIndex();
				// strErgebnis wird der neue Dateiname, der im Eingabefeld eingegeben wurde
				String strErgebnis;
				if (iMarkierung != -1) {

					DebugInfoSchreiben("Erster, markierter Eintrag aus der ist: " + dflModel.get(iMarkierung));
					
					// Datei muss auf .mp4 enden
					if (dflModel.get(iMarkierung).endsWith(".mp4")) {
						strErgebnis = JOptionPane.showInputDialog(frmFenstertitel, "Datei\n\t" + dflModel.get(iMarkierung) + "\nwird umbenannt und\nins Unterverzeichnis kopiert.", dflModel.get(iMarkierung) );

						DebugInfoSchreiben("Neuer Dateiname aufgrund Eingabefeld: " + strErgebnis);
						
						// Neuer Dateiname muss auf mp4 enden und darf nicht identisch zum bisherigen Namen sein
						if (strErgebnis.endsWith(".mp4") && !strErgebnis.equals(dflModel.get(iMarkierung))) {
							
							String strAlterDateiname = "";
							String strNeuerDateiname = "";
							String strNeuesVerzeichnis = "";
							String strNeueDateiNeuesVerzeichnis = "";

							if (txtRibbonPfad.getText().endsWith("/")) {
								strAlterDateiname = txtRibbonPfad.getText() + dflModel.get(iMarkierung);
								strNeuerDateiname = txtRibbonPfad.getText() + strErgebnis;
								// letzten 4 Zeichen = .mp4 abschneiden
								strNeuesVerzeichnis = txtRibbonPfad.getText() + strErgebnis.subSequence(0, (strErgebnis.length()-4));
							} else {
								strNeuesVerzeichnis = txtRibbonPfad.getText() + "/" + strErgebnis.subSequence(0, (strErgebnis.length()-4));
								strAlterDateiname = txtRibbonPfad.getText() + "/" + dflModel.get(iMarkierung);
								strNeuerDateiname = txtRibbonPfad.getText() + "/" + strErgebnis;
							}
							
							strNeueDateiNeuesVerzeichnis = strNeuesVerzeichnis + "/" + strErgebnis;							
//							DebugInfoSchreiben("strAlterDateiname: " + strAlterDateiname);
//							DebugInfoSchreiben("strNeuerDateiname: " + strNeuerDateiname);
//							DebugInfoSchreiben("strNeuesVerzeichnis: " + strNeuesVerzeichnis);
//							DebugInfoSchreiben("strNeueDateiNeuesVerzeichnis: " + strNeueDateiNeuesVerzeichnis);
							
							File fAlterDateiname = new File(strAlterDateiname);
							File fNeuerDateiname = new File(strNeuerDateiname);
							File fNeuesVerzeichnis = new File(strNeuesVerzeichnis);
							
							// Datei umbenennen
							if (fAlterDateiname.renameTo(fNeuerDateiname)) {
								
								DebugInfoSchreiben("Datei von: " + strAlterDateiname + " nach " + strNeuerDateiname + " umbenannt.");

								// Neues Verzeichnis anlegen
								if (fNeuesVerzeichnis.mkdir()) {
									DebugInfoSchreiben("Verzeichnis: " + strNeuesVerzeichnis + " angelegt.");
									
									Path moveQuellePath = Paths.get(strNeuerDateiname);
									Path moveZielPath = Paths.get(strNeueDateiNeuesVerzeichnis);
									try {
										Files.move(moveQuellePath, moveZielPath);
										DebugInfoSchreiben("Datei: " + strNeuerDateiname + " wurde nach " + strNeueDateiNeuesVerzeichnis + " verschoben.");
										txtStatusleiste.setText("Datei umbenannt, Verzeichnis angelegt und Datei verschoben.");
										txtRibbonPfad.setText(strNeuesVerzeichnis);
										VerzeichnisAkutalisieren(strNeuesVerzeichnis, dflModel);
									} catch (IOException e1) {
										DebugInfoSchreiben("Datei: " + strNeuerDateiname + " kann nicht nach " + strNeueDateiNeuesVerzeichnis + " verschoben werden.");
										e1.printStackTrace();
									}
									
									
								} else {
									DebugInfoSchreiben("Verzeichnis: " + strNeuesVerzeichnis + " konnte nicht angelegt werden.");
								} // Ende Verzeichnis anlegen
							} else {
								DebugInfoSchreiben("Umbenennung von: " + strAlterDateiname + " nach " + strNeuerDateiname + " fehlgeschlagen.");
								txtStatusleiste.setText("Umbenennung von: " + strAlterDateiname + " nach " + strNeuerDateiname + " fehlgeschlagen.");
							} // Ende Datei umbenennen
							
						} else {
							JOptionPane.showMessageDialog(frmFenstertitel, "Dateiname endet nicht auf .mp4\n" + strErgebnis);
						}
					} else {
						JOptionPane.showMessageDialog(frmFenstertitel, "Es wurde keine *.mp4 - Datei ausgewählt!\nAuswahl: " + dflModel.get(iMarkierung));
						DebugInfoSchreiben("Es wurde keine mp4-Datei ausgewählt. Keine weitere Aktion.");
					}
				} // Ende äussere If-Bedingung
			}
		}); // Ende actionlistener
		btnDateiErstellenUndKopieren.setBounds(400, 105, 150, 25);
		panel_1_Datei.add(btnDateiErstellenUndKopieren);
		
		JLabel lblDateiVerzeichnis = new JLabel("Verzeichnis:");
		lblDateiVerzeichnis.setBounds(50, 40, 100, 15);
		panel_1_Datei.add(lblDateiVerzeichnis);
		
		
		/*
		 * JList
		 * Register: Datei
		 * Verzeichnis-Liste
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 70, 300, 300);
		panel_1_Datei.add(scrollPane);
		

		
		dflModel = new DefaultListModel<>();
		listDateiVerzeichnis = new JList(dflModel);
		scrollPane.setViewportView(listDateiVerzeichnis);
		
												
		/*
		 * Button "Erzeugen"
		 * 
		 * Slug-Datei wird erzeugt
		 */

		
		/*
		 * Button "Neu Laden"
		 * Register Slug
		 * (1) Alle Felder leeren
		 */



		String[] sterneDaten = {"1","2","3","4","5"};


		
		/*
		 * ========================
		 * Start Panel 2 : Slug
		 * ========================
		 * 
		 */
		JPanel panel_2_slug = new JPanel();
		tabbedPane.addTab("slug", null, panel_2_slug, null);
		panel_2_slug.setLayout(null);

		/*
		 * ComboBox
		 * Register: Slug
		 * Album
		 */
		JLabel lblSlugAlbum = new JLabel("Album");
		lblSlugAlbum.setBounds(30, 252, 55, 15);
		panel_2_slug.add(lblSlugAlbum);
		
		//Hier kein ActionListener, da nur bei Studio-Auswahl sich die Combo-Boxen ändern
		cmbSlugAlbum = new JComboBox<String>();
		cmbSlugAlbum.setBounds(100, 250, 200, 22);
		panel_2_slug.add(cmbSlugAlbum);
		JLabel lblSlugStudio = new JLabel("Studio");
		lblSlugStudio.setBounds(30, 217, 55, 15);
		panel_2_slug.add(lblSlugStudio);

		/*
		 * ComboBox
		 * Register: Slug
		 * Studio
		 */
		cmbSlugStudio = new JComboBox<String>();
		cmbSlugStudio.setBounds(100, 214, 120, 22);
		panel_2_slug.add(cmbSlugStudio);
		
		cmbSlugStudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// erster Eintrag entspricht dem Wert 0
				try {
					ComboBoxBefuellen(cmbSlugAlbum, ComboBoxDatenLaden(fXml, cmbSlugAlbum, "album", cmbSlugStudio.getSelectedIndex()));
				} catch (IOException e1) {
					// TODO Automatisch generierter Erfassungsblock
					e1.printStackTrace();
				}
				txtStatusleiste.setText("Studio: " + cmbSlugStudio.getSelectedItem() + " ausgewählt.");
			}
		});
		
		JLabel lblSlugActress = new JLabel("Actress");
		lblSlugActress.setBounds(30, 290, 55, 15);
		panel_2_slug.add(lblSlugActress);

		JLabel lblSlugActor = new JLabel("Actor");
		lblSlugActor.setBounds(30, 325, 55, 15);
		panel_2_slug.add(lblSlugActor);

		txtSlugActress = new JTextField();
		txtSlugActress.setBounds(100, 290, 290, 20);
		panel_2_slug.add(txtSlugActress);
		txtSlugActress.setColumns(10);
								
		txtSlugActor = new JTextField();
		txtSlugActor.setBounds(100, 325, 290, 20);
		panel_2_slug.add(txtSlugActor);
		txtSlugActor.setColumns(10);
		
		JButton btnSlugErzeugen = new JButton();
		btnSlugErzeugen.setToolTipText("Slug-Datei wird erzeugt bzw. gespeichert.");
		btnSlugErzeugen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SlugDaten sDaten = new SlugDaten();
				SlugDaten_holen(sDaten);

				// es muss vorab überprüft werden:
				// (1) existiert Pfad
				// (2) existiert Pfad und Datei? -> Frage nach dem Überschreiben

				File fileErzeugen;
				if (!txtRibbonPfad.getText().equals("")){
					fileErzeugen = new File(txtRibbonPfad.getText());
					if (fileErzeugen.isDirectory() || fileErzeugen.exists()){
						if (!txtRibbonSlugName.getText().equals("")) {
							String strVollstaendigerPfad = txtRibbonPfad.getText() + "/" + txtRibbonSlugName.getText() + ".slug";
							fileErzeugen = new File(strVollstaendigerPfad);
							//							System.out.println(strVollstaendigerPfad);
							if (fileErzeugen.exists()) {
								int ueberschreiben = JOptionPane.showConfirmDialog(frmFenstertitel, "Slug-Datei besteht bereits.\nÜberschreiben?", "Nachfrage", JOptionPane.YES_NO_OPTION);
								//								System.out.println(ueberschreiben);
								if (ueberschreiben == 0) {
									DebugInfoSchreiben("Slug-Datei wurde überschrieben: " + sDaten.slugDatenLaden(strVollstaendigerPfad));
									txtStatusleiste.setText(sDaten.slugDatenLaden(strVollstaendigerPfad));									
								} // Ende 5. if
							} else {
								txtStatusleiste.setText(sDaten.slugDatenLaden(strVollstaendigerPfad));
							} // Ende 4. if
						} else {
							JOptionPane.showMessageDialog(null, "Die Slug-Angabe ist nicht gefüllt!", "Hinweis", JOptionPane.WARNING_MESSAGE);
						} // Ende 3. if
					} else {
						JOptionPane.showMessageDialog(null, "Die Pfad-Angabe ist kein Verzeichnis\noder existiert nicht!", "Hinweis", JOptionPane.WARNING_MESSAGE);
					} // Ende 2. if
				} else { // else aus 1. if
					JOptionPane.showMessageDialog(null, "Die Pfad-Angabe ist nicht gefüllt!", "Hinweis", JOptionPane.WARNING_MESSAGE);
				} // Ende 1. if
				DebugInfoSchreiben("btnSlugErzeugen gedrückt.");
			}
		});
		btnSlugErzeugen.setBounds(550, 400, 50, 25);
		iconSlugErzeugen = new ImageIcon(strSlugErzeugen);
		btnSlugErzeugen.setIcon(iconSlugErzeugen);
		panel_2_slug.add(btnSlugErzeugen);

		JButton btnSlugDateiLaden = new JButton("Slug Laden");
		btnSlugDateiLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File fileLesen;

				// Slug-Name setzt sich zusammen aus Pfad + Slug-Name + Endung .slug
				fileLesen = new File(txtRibbonPfad.getText());
				if (fileLesen.isDirectory() || fileLesen.exists()) {
					// Verzeichnis auslesen, ob dort eine Slug-Datei enthalten ist.
					File[] Dateiliste = fileLesen.listFiles();
					int intAnzahldateien = Dateiliste.length;

					for(int i=0; i < intAnzahldateien; i++) {
						if (Dateiliste[i].toString().endsWith(".slug")) {

							/*
							 * Hier startet das Laden der Slug-Datei.
							 */
							SlugDatenLeeren();
							SlugDaten sDaten = new SlugDaten();

							txtStatusleiste.setText(sDaten.slugDatenSetzen(Dateiliste[i].getPath().toString()));
							SlugDatenSetzen(sDaten);
							TitelbildAnzeigen();
							PortraetbildAnzeigen();

							break;
						} else {
							if (i == intAnzahldateien - 1) {
								JOptionPane.showMessageDialog(null, "Keine Slug-Datei im Pfad:\n\n" + txtRibbonPfad.getText() + "\n\nvorhanden!");
							}
						}
					} // Ende For-Schleife
				} else {
					JOptionPane.showMessageDialog(null, "Es konnte keine Slug-Datei gelesen werden.\nDie Pfadangabe ist falsch oder nicht erreichbar!     \n\nPfad: " + txtRibbonPfad.getText());
				}
				DebugInfoSchreiben("btnSlugDatenLaden gedrückt.");
			}
		}); // Ende ActionListener
		
		btnSlugDateiLaden.setBounds(550, 365, 115, 25);
		panel_2_slug.add(btnSlugDateiLaden);

		JLabel lblSlugBeschreibung = new JLabel("Beschreibung");
		lblSlugBeschreibung.setBounds(30, 360, 110, 15);
		panel_2_slug.add(lblSlugBeschreibung);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(130, 361, 300, 100);
		panel_2_slug.add(scrollPane_1);

		txtpnSlugBeschreibung = new JTextPane();
		scrollPane_1.setViewportView(txtpnSlugBeschreibung);

		JLabel lblSlugBraznr = new JLabel("Braz-Nr.");
		lblSlugBraznr.setBounds(255, 217, 70, 15);
		panel_2_slug.add(lblSlugBraznr);

		txtSlugBraznr = new JTextField();
		txtSlugBraznr.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugBraznr.setBounds(325, 215, 50, 19);
		panel_2_slug.add(txtSlugBraznr);
		txtSlugBraznr.setColumns(10);

		JLabel lblSlugNa = new JLabel("NA Bild Link");
		lblSlugNa.setBounds(420, 217, 90, 15);
		panel_2_slug.add(lblSlugNa);

		txtSlugNa = new JTextField();
		txtSlugNa.setBounds(510, 215, 250, 19);
		panel_2_slug.add(txtSlugNa);
		txtSlugNa.setColumns(10);


		iconSlugBilderDownload = new ImageIcon(strDownload);
		JButton btnSlugBilderDownload = new JButton("");
		btnSlugBilderDownload.setBounds(390, 215, 18, 18);
		btnSlugBilderDownload.setIcon(iconSlugBilderDownload);
		btnSlugBilderDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BilderDownloaden();
				
			}
		}); // Ende ActionListener
		panel_2_slug.add(btnSlugBilderDownload);
		
		
		/*
		 * Checkbox First
		 * 
		 * Wenn angehakt (=true), dann wird das dazugehörige txt-Feld eingeschaltet
		 * 
		 */
		chckbxSlugFirst = new JCheckBox("First");
		chckbxSlugFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxSlugFirst.isSelected()){
					txtSlugFirst.setEditable(true);
					txtSlugFirst.setEnabled(true);
					txtStatusleiste.setText("First: an");
				} else {
					txtSlugFirst.setEditable(false);
					txtSlugFirst.setEnabled(false);
					txtStatusleiste.setText("First: aus");
				} // Ende else


			} // Ende ActionPerformed
		}); // Ende Listener

		chckbxSlugFirst.setBounds(465, 245, 65, 23);
		panel_2_slug.add(chckbxSlugFirst);
		
		
		
		/*
		 * Checkbox Near
		 * 
		 * Wenn angehakt (=true), dann wird das dazugehörige txt-Feld eingeschaltet
		 * 
		 */
		chckbxSlugNear = new JCheckBox("Near");

		chckbxSlugNear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxSlugNear.isSelected()){
					txtSlugNear.setEditable(true);
					txtSlugNear.setEnabled(true);
					txtStatusleiste.setText("Near: an");
				} else {
					txtSlugNear.setEditable(false);
					txtSlugNear.setEnabled(false);
					txtStatusleiste.setText("Near: aus");
				} // Ende else


			} // Ende ActionPerformed
		}); // Ende Listener

		
		chckbxSlugNear.setBounds(465, 275, 65, 23);
		panel_2_slug.add(chckbxSlugNear);
		
		chckbxSlugThumbs = new JCheckBox("Thumbs");
		chckbxSlugThumbs.setBounds(435, 361, 80, 23);
		panel_2_slug.add(chckbxSlugThumbs);
		
		chckbxSlugVr = new JCheckBox("VR");
		chckbxSlugVr.setBounds(435, 388, 70, 23);
		panel_2_slug.add(chckbxSlugVr);

		chckbxSlugRemastered = new JCheckBox("Remastered");
		chckbxSlugRemastered.setBounds(435, 415, 115, 23);
		panel_2_slug.add(chckbxSlugRemastered);

		txtSlugFirst = new JTextField();
		txtSlugFirst.setEditable(false);
		txtSlugFirst.setEnabled(false);
		txtSlugFirst.setBounds(536, 245, 200, 20);
		panel_2_slug.add(txtSlugFirst);
		txtSlugFirst.setColumns(10);

		txtSlugNear = new JTextField();
		txtSlugNear.setEditable(false);
		txtSlugNear.setEnabled(false);
		txtSlugNear.setBounds(536, 275, 200, 20);
		panel_2_slug.add(txtSlugNear);
		txtSlugNear.setColumns(10);


		chckbxSlugBilder = new JCheckBox("Bilder");
		chckbxSlugBilder.setBounds(435, 442, 75, 23);
		panel_2_slug.add(chckbxSlugBilder);

		JLabel lblSlugSterne = new JLabel("Sterne");
		lblSlugSterne.setBounds(657, 97, 60, 15);
		panel_2_slug.add(lblSlugSterne);

		cmbSlugSterne = new JComboBox<String>();
		cmbSlugSterne.setBounds(715, 95, 40, 20);

		ComboBoxBefuellen(cmbSlugSterne, sterneDaten);
		panel_2_slug.add(cmbSlugSterne);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 205, 730, 2);
		panel_2_slug.add(separator_3);

		JLabel lblSlugDvd = new JLabel("DVD");
		lblSlugDvd.setBounds(565, 9, 35, 15);
		panel_2_slug.add(lblSlugDvd);



		/*
		 * 
		 * Bereich: Titelbild
		 * 
		 */
		iconSlugTitelbildOben = new ImageIcon(strPfeilOben);
		iconSlugTitelbildUnten = new ImageIcon(strPfeilUnten);
		
		lblSlugTitelbild = new JLabel("Titelbild");
		lblSlugTitelbild.setBounds(30, 9, 70, 15);
		panel_2_slug.add(lblSlugTitelbild);

		lblSlugTitelbildAnzeige = new JLabel((String) null);
		lblSlugTitelbildAnzeige.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlugTitelbildAnzeige.setBounds(95, 10, 150, 100);
		panel_2_slug.add(lblSlugTitelbildAnzeige);

		
		// Titelbild: Button Pfeil nach oben
		txtSlugTitelbild = new JTextField();
		txtSlugTitelbild.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugTitelbild.setText("01");
		txtSlugTitelbild.setBounds(40, 45, 30, 20);
		panel_2_slug.add(txtSlugTitelbild);
		txtSlugTitelbild.setColumns(10);
		
				JButton btnSlugTitelbildOben = new JButton("");
				btnSlugTitelbildOben.setIcon(iconSlugTitelbildOben);
				btnSlugTitelbildOben.addActionListener(new ActionListener() {
					// Wert muss zweistellig abgeildet werden, bswp. 01 anstelle von 1
					// Wert 00 soll 0 als Integer sein
					public void actionPerformed(ActionEvent e) {
						int intTitelbild = Integer.valueOf(txtSlugTitelbild.getText());
						String strTitelbild = txtSlugTitelbild.getText();
						
						if (strTitelbild.equals("00")) {
							intTitelbild = 0;
						}
						intTitelbild++;
						
						if (intTitelbild < 10){
							txtSlugTitelbild.setText("0" + String.valueOf(intTitelbild));
						} else {
							txtSlugTitelbild.setText(String.valueOf(intTitelbild));
						}
						// geändertes Titelbild anzeigen
						TitelbildAnzeigen();
					}
				});
				btnSlugTitelbildOben.setBounds(45, 25, 18, 18);
				panel_2_slug.add(btnSlugTitelbildOben);
				
		// Titelbild: Button Pfeil nach unten
		JButton btnSlugTitelbildUnten = new JButton();
		btnSlugTitelbildUnten.setIcon(iconSlugTitelbildUnten);
		btnSlugTitelbildUnten.addActionListener(new ActionListener() {
			// Wert 00 soll 0 als Integer sein
			// Wert 00 oder 01 oder 1 oder 0 und Button gedrückt soll 15 werden
			public void actionPerformed(ActionEvent e) {
				int intTitelbild = Integer.valueOf(txtSlugTitelbild.getText());
				String strTitelbild = txtSlugTitelbild.getText();
				
				if (strTitelbild.equals("00") | strTitelbild.equals("0") | strTitelbild.equals("01") | strTitelbild.equals("1")) {
					intTitelbild = 15;
				} else {
					intTitelbild--;
				}
				
				if (intTitelbild < 10){
					txtSlugTitelbild.setText("0" + String.valueOf(intTitelbild));
				} else {
					txtSlugTitelbild.setText(String.valueOf(intTitelbild));
				}
				// geändertes Titelbild anzeigen
				TitelbildAnzeigen();
			}
		});
		btnSlugTitelbildUnten.setBounds(45, 66, 18, 18);
		panel_2_slug.add(btnSlugTitelbildUnten);
		
		
		/*
		 * 
		 * Bereich: Porträtbild
		 * 
		 */
		iconSlugPortraetbildOben = new ImageIcon(strPfeilOben);
		iconSlugPortraetbildUnten = new ImageIcon(strPfeilUnten);
		
		lblSlugPortraitbild = new JLabel("Portraitbild");
		lblSlugPortraitbild.setBounds(305, 9, 90, 15);
		panel_2_slug.add(lblSlugPortraitbild);
		
		JButton btnSlugPortraetbildOben = new JButton("");
		btnSlugPortraetbildOben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Wert muss zweistellig abgeildet werden, bswp. 01 anstelle von 1
				// Wert 00 soll 0 als Integer sein
				int intPortraetbild = Integer.valueOf(txtSlugPortraitbild.getText());
				String strPortraetbild = txtSlugPortraitbild.getText();

				if (strPortraetbild.equals("00")) {
					intPortraetbild = 0;
				}
				intPortraetbild++;

				if (intPortraetbild < 10){
					txtSlugPortraitbild.setText("0" + String.valueOf(intPortraetbild));
				} else {
					txtSlugPortraitbild.setText(String.valueOf(intPortraetbild));
				}
				// geändertes Porträtbild anzeigen
				PortraetbildAnzeigen();
			}
		});
		btnSlugPortraetbildOben.setIcon(iconSlugPortraetbildOben);
		btnSlugPortraetbildOben.setBounds(345, 25, 18, 18);
		panel_2_slug.add(btnSlugPortraetbildOben);
			
		JButton btnSlugPortraetbildUnten = new JButton("");
		btnSlugPortraetbildUnten.addActionListener(new ActionListener() {
			// Wert 00 soll 0 als Integer sein
			// Wert 00 oder 01 oder 1 oder 0 und Button gedrückt soll 15 werden
			public void actionPerformed(ActionEvent e) {
				int intPortraetbild = Integer.valueOf(txtSlugPortraitbild.getText());
				String strPortraetbild = txtSlugPortraitbild.getText();

				if (strPortraetbild.equals("00") | strPortraetbild.equals("0") | strPortraetbild.equals("01") | strPortraetbild.equals("1")) {
					intPortraetbild = 15;
				} else {
					intPortraetbild--;
				}

				if (intPortraetbild < 10){
					txtSlugPortraitbild.setText("0" + String.valueOf(intPortraetbild));
				} else {
					txtSlugPortraitbild.setText(String.valueOf(intPortraetbild));
				}
				// geändertes Porträtbild anzeigen
				PortraetbildAnzeigen();
			}
		});

		btnSlugPortraetbildUnten.setIcon(iconSlugPortraetbildUnten);
		btnSlugPortraetbildUnten.setBounds(345, 66, 18, 18);
		panel_2_slug.add(btnSlugPortraetbildUnten);

		lblSlugPortraetbildAnzeige = new JLabel("");
		lblSlugPortraetbildAnzeige.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlugPortraetbildAnzeige.setBounds(400, 10, 150, 100);
		panel_2_slug.add(lblSlugPortraetbildAnzeige);

		txtSlugPortraitbild = new JTextField();
		txtSlugPortraitbild.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugPortraitbild.setText("01");
		txtSlugPortraitbild.setBounds(340, 45, 30, 19);
		panel_2_slug.add(txtSlugPortraitbild);
		txtSlugPortraitbild.setColumns(10);



		/*
		 * ReleaseAm und ErstelltAm Buttons mit Grafik/Pfeilen
		 */
		iconSlugReleaseJahrOben = new ImageIcon(strPfeilOben);
		iconSlugReleaseJahrUnten = new ImageIcon(strPfeilUnten);

		iconSlugTauschen = new ImageIcon(strPfeilTauschen);
		
		iconSlugErstelltAmNachRelase = new ImageIcon(strPfeilLinks);
		iconSlugRelaseNachErstelltAm = new ImageIcon(strPfeilRechts);

		JLabel lblSlugRelease = new JLabel("Release");
		lblSlugRelease.setBounds(30, 160, 70, 15);
		panel_2_slug.add(lblSlugRelease);

		JLabel lblSlugErstelltAm = new JLabel("Erstellt am");
		lblSlugErstelltAm.setBounds(350, 160, 85, 15);
		panel_2_slug.add(lblSlugErstelltAm);

		

		/*
		 * Bereich Datum: ReleaseAM
		 * Jahr: aktuelles Jahr
		 * Monat und Tag leer
		 * Zeit: 00:00
		 */
		dtf = DateTimeFormatter.ofPattern("yyyy");
		localDate = LocalDate.now();

		txtSlugReleaseJahr = new JTextField();
		txtSlugReleaseJahr.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugReleaseJahr.setText(dtf.format(localDate).toString());
		txtSlugReleaseJahr.setBounds(100, 158, 40, 20);
		panel_2_slug.add(txtSlugReleaseJahr);
		txtSlugReleaseJahr.setColumns(10);

		
		txtSlugReleaseMonat = new JTextField();
		txtSlugReleaseMonat.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugReleaseMonat.setBounds(145, 158, 25, 20);
		panel_2_slug.add(txtSlugReleaseMonat);
		txtSlugReleaseMonat.setColumns(10);

		
		txtSlugReleaseTag = new JTextField();
		txtSlugReleaseTag.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugReleaseTag.setText("");
		txtSlugReleaseTag.setBounds(175, 158, 25, 20);
		panel_2_slug.add(txtSlugReleaseTag);
		txtSlugReleaseTag.setColumns(10);
		
		txtSlugReleaseZeit = new JTextField();
		txtSlugReleaseZeit.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugReleaseZeit.setText("00:00");
		txtSlugReleaseZeit.setBounds(210, 158, 41, 20);
		panel_2_slug.add(txtSlugReleaseZeit);
		txtSlugReleaseZeit.setColumns(10);
		
		// Feld mit dem heutigen Datum in der Form jjjj:mm:tt hh:mm füllen
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd");
		// LocalDate localDate = LocalDate.now();

		// Feld mit dem heutigen Datum in der Form jjjj:mm:tt hh:mm füllen
		// dtf = DateTimeFormatter.ofPattern("yyyy");
		// localDate = LocalDate.now();
		txtSlugErstelltAmJahr = new JTextField();
		txtSlugErstelltAmJahr.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugErstelltAmJahr.setBounds(440, 158, 40, 20);
		txtSlugErstelltAmJahr.setText(dtf.format(localDate).toString());
		panel_2_slug.add(txtSlugErstelltAmJahr);
		txtSlugErstelltAmJahr.setColumns(10);
		
		dtf = DateTimeFormatter.ofPattern("MM");
		localDate = LocalDate.now();
		
		txtSlugErstelltAmMonat = new JTextField();
		txtSlugErstelltAmMonat.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugErstelltAmMonat.setBounds(485, 158, 25, 20);
		txtSlugErstelltAmMonat.setText(dtf.format(localDate).toString());
		panel_2_slug.add(txtSlugErstelltAmMonat);
		txtSlugErstelltAmMonat.setColumns(10);

		
		dtf = DateTimeFormatter.ofPattern("dd");
		localDate = LocalDate.now();
		
		txtSlugErstelltAmTag = new JTextField();
		txtSlugErstelltAmTag.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugErstelltAmTag.setBounds(515, 158, 25, 20);
		txtSlugErstelltAmTag.setText(dtf.format(localDate).toString());
		panel_2_slug.add(txtSlugErstelltAmTag);
		txtSlugErstelltAmTag.setColumns(10);
		
		txtSlugErstelltAmZeit = new JTextField();
		txtSlugErstelltAmZeit.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugErstelltAmZeit.setText("00:00");
		txtSlugErstelltAmZeit.setBounds(550, 158, 41, 20);
		panel_2_slug.add(txtSlugErstelltAmZeit);
		txtSlugErstelltAmZeit.setColumns(10);
		
		
		JButton btnSlugReleaseJahrOben = new JButton("");
		btnSlugReleaseJahrOben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intReleaseJahr = Integer.parseInt(txtSlugReleaseJahr.getText());
				intReleaseJahr++;
				txtSlugReleaseJahr.setText(String.valueOf(intReleaseJahr));
			}
		});
		btnSlugReleaseJahrOben.setBounds(110, 137, 18, 18);
		btnSlugReleaseJahrOben.setIcon(iconSlugReleaseJahrOben);
		panel_2_slug.add(btnSlugReleaseJahrOben);
		
		JButton btnSlugReleaseJahrUnten = new JButton("");
		btnSlugReleaseJahrUnten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intReleaseJahr = Integer.parseInt(txtSlugReleaseJahr.getText());
				intReleaseJahr--;
				txtSlugReleaseJahr.setText(String.valueOf(intReleaseJahr));
			}
		});

		btnSlugReleaseJahrUnten.setBounds(110, 180, 18, 18);
		btnSlugReleaseJahrUnten.setIcon(iconSlugReleaseJahrUnten);

		panel_2_slug.add(btnSlugReleaseJahrUnten);
		JButton btnSlugLeeren = new JButton("Leeren");
		btnSlugLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SlugDatenLeeren();
				txtStatusleiste.setText("Slug-Daten geleert!");

			}
		});
		btnSlugLeeren.setBounds(550, 330, 115, 25);
		panel_2_slug.add(btnSlugLeeren);
		

		
		/*
		 * Buttons für ErstelltAm zu verändern
		 * 
		 * 
		 */
		JButton btnSlugErstelltAmJahrOben = new JButton("");
		btnSlugErstelltAmJahrOben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSlugErstelltAmJahrOben.setBounds(450, 137, 18, 18);
		iconSlugErstelltAmJahrOben = new ImageIcon(strPfeilOben);
		btnSlugErstelltAmJahrOben.setIcon(iconSlugErstelltAmJahrOben);
		panel_2_slug.add(btnSlugErstelltAmJahrOben);
		
		JButton btnSlugErstelltAmJahrUnten = new JButton("");
		btnSlugErstelltAmJahrUnten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSlugErstelltAmJahrUnten.setBounds(450, 180, 18, 18);
		iconSlugErstelltAmJahrUnten = new ImageIcon(strPfeilUnten);
		btnSlugErstelltAmJahrUnten.setIcon(iconSlugErstelltAmJahrUnten);
		panel_2_slug.add(btnSlugErstelltAmJahrUnten);

		JButton btnSlugErstelltAmMonatOben = new JButton("");
		btnSlugErstelltAmMonatOben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strMonat = txtSlugErstelltAmMonat.getText();
				// Wenn Feld nicht gefüllt sein sollte
				if (strMonat.equals("")) {
					strMonat = "00";
				}
				
				if (strMonat.startsWith("0")) {
					strMonat = strMonat.substring(1, 2);
				}
				int iMonat = Integer.parseInt(strMonat);
				iMonat++;
				
				// bei 31 wird der nächste Tag -> 1
				if (iMonat > 12) {
					iMonat = 1;
				}
				
				// führende Null hinzufügen
				if (iMonat <10) {
					strMonat = "0" + String.valueOf(iMonat);
				} else {
					strMonat = String.valueOf(iMonat);
				}
				
				txtSlugErstelltAmMonat.setText(strMonat);
				DebugInfoSchreiben("Schaltfläche btnSlugErstelltAmMonatOben wurde gedrückt. Neuer Monat:" + strMonat);
			}
		});
		btnSlugErstelltAmMonatOben.setBounds(488, 137, 18, 18);
		iconSlugErstelltAmMonatOben = new ImageIcon(strPfeilOben);
		btnSlugErstelltAmMonatOben.setIcon(iconSlugErstelltAmMonatOben);
		panel_2_slug.add(btnSlugErstelltAmMonatOben);
		
		JButton btnSlugErstelltAmMonatUnten = new JButton("");
		btnSlugErstelltAmMonatUnten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strMonat = txtSlugErstelltAmMonat.getText();
				// Wenn Feld nicht gefüllt sein sollte
				if (strMonat.equals("")) {
					strMonat = "02";
				}
				
				if (strMonat.startsWith("0")) {
					strMonat = strMonat.substring(1, 2);
				}
				int iMonat = Integer.parseInt(strMonat);
				iMonat--;
				
				// bei 31 wird der nächste Tag -> 1
				if (iMonat < 1) {
					iMonat = 12;
				}
				
				// führende Null hinzufügen
				if (iMonat <10) {
					strMonat = "0" + String.valueOf(iMonat);
				} else {
					strMonat = String.valueOf(iMonat);
				}
				
				txtSlugErstelltAmMonat.setText(strMonat);
				DebugInfoSchreiben("Schaltfläche btnSlugErstelltAmMonatUnten wurde gedrückt. Neuer Monat:" + strMonat);
			}
		});
		btnSlugErstelltAmMonatUnten.setBounds(488, 180, 18, 18);
		iconSlugErstelltAmMonatUnten = new ImageIcon(strPfeilUnten);
		btnSlugErstelltAmMonatUnten.setIcon(iconSlugErstelltAmMonatUnten);
		panel_2_slug.add(btnSlugErstelltAmMonatUnten);
		
		
		JButton btnSlugErstelltAmTagOben = new JButton("");
		btnSlugErstelltAmTagOben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strTag = txtSlugErstelltAmTag.getText();
				// Wenn Feld nicht gefüllt sein sollte
				if (strTag.equals("")) {
					strTag = "00";
				}
				
				if (strTag.startsWith("0")) {
					strTag = strTag.substring(1, 2);
				}
				int iTag = Integer.parseInt(strTag);
				iTag++;
				
				// bei 31 wird der nächste Tag -> 1
				if (iTag > 31) {
					iTag = 1;
				}
				
				// führende Null hinzufügen
				if (iTag <10) {
					strTag = "0" + String.valueOf(iTag);
				} else {
					strTag = String.valueOf(iTag);
				}
				
				txtSlugErstelltAmTag.setText(strTag);
				DebugInfoSchreiben("Schaltfläche btnSlugErstelltAmTagOben wurde gedrückt. Neuer Tag:" + strTag);
			}
		});
		btnSlugErstelltAmTagOben.setBounds(518, 137, 18, 18);
		iconSlugErstelltAmTagOben = new ImageIcon(strPfeilOben);
		btnSlugErstelltAmTagOben.setIcon(iconSlugErstelltAmTagOben);
		panel_2_slug.add(btnSlugErstelltAmTagOben);
		
		JButton btnSlugErstelltAmTagUnten = new JButton("");
		btnSlugErstelltAmTagUnten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strTag = txtSlugErstelltAmTag.getText();
				// Wenn Feld nicht gefüllt sein sollte
				if (strTag.equals("")) {
					strTag = "2";
				}
				
				if (strTag.startsWith("0")) {
					strTag = strTag.substring(1, 2);
				}
				int iTag = Integer.parseInt(strTag);
				iTag--;
				
				// bei 31 wird der nächste Tag -> 1
				if (iTag < 1) {
					iTag = 31;
				}
				
				// führende Null hinzufügen
				if (iTag <10) {
					strTag = "0" + String.valueOf(iTag);
				} else {
					strTag = String.valueOf(iTag);
				}
				
				txtSlugErstelltAmTag.setText(strTag);
				DebugInfoSchreiben("Schaltfläche btnSlugErstelltAmTagUnten wurde gedrückt. Neuer Tag:" + strTag);
			}
		});
		btnSlugErstelltAmTagUnten.setBounds(518, 180, 18, 18);
		iconSlugErstelltAmTagUnten = new ImageIcon(strPfeilUnten);
		btnSlugErstelltAmTagUnten.setIcon(iconSlugErstelltAmTagUnten);
		panel_2_slug.add(btnSlugErstelltAmTagUnten);

		
		
		
		
		
		/*
		 * Buttons zwischen den Datümern
		 * 
		 * Release nach Erstellt_am
		 * Tauschen
		 * Erstellt_am nach Release
		 */
		JButton btnSlugTauschen = new JButton("");
		btnSlugTauschen.setIcon(iconSlugTauschen);
		btnSlugTauschen.setBounds(290, 160, 26, 18);
		panel_2_slug.add(btnSlugTauschen);

				
		JButton btnSlugErstelltAmNachRelease = new JButton("");
		btnSlugErstelltAmNachRelease.setIcon(iconSlugErstelltAmNachRelase);
		btnSlugErstelltAmNachRelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Werte Jahr - Monat - Tag - Zeit von Erstellt am nach Release kopiern
				txtSlugReleaseJahr.setText(txtSlugErstelltAmJahr.getText());
				txtSlugReleaseMonat.setText(txtSlugErstelltAmMonat.getText());
				txtSlugReleaseTag.setText(txtSlugErstelltAmTag.getText());
				txtSlugReleaseZeit.setText(txtSlugErstelltAmZeit.getText());
			}
		});
		btnSlugErstelltAmNachRelease.setBounds(269, 160, 18, 18);
		panel_2_slug.add(btnSlugErstelltAmNachRelease);

		JButton btnSlugReleaseNachErstelltAm = new JButton("");
		btnSlugReleaseNachErstelltAm.setBounds(320, 160, 18, 18);
		btnSlugReleaseNachErstelltAm.setIcon(iconSlugRelaseNachErstelltAm);
		panel_2_slug.add(btnSlugReleaseNachErstelltAm);
		btnSlugReleaseNachErstelltAm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Werte Jahr - Monat - Tag - Zeit von Release nach Erstellt am kopiern
				txtSlugErstelltAmJahr.setText(txtSlugReleaseJahr.getText());
				txtSlugErstelltAmMonat.setText(txtSlugReleaseMonat.getText());
				txtSlugErstelltAmTag.setText(txtSlugReleaseTag.getText());
				txtSlugErstelltAmZeit.setText(txtSlugReleaseZeit.getText());
			}
		});

		JLabel lblSlugPart = new JLabel("Part");
		lblSlugPart.setBounds(692, 130, 40, 15);
		panel_2_slug.add(lblSlugPart);

		txtSlugPart = new JTextField();
		txtSlugPart.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugPart.setText("1");
		txtSlugPart.setBounds(731, 128, 25, 20);
		panel_2_slug.add(txtSlugPart);
		txtSlugPart.setColumns(10);



		JLabel lblSlugAnzahlParts = new JLabel("Anzahl Parts");
		lblSlugAnzahlParts.setBounds(631, 160, 100, 15);
		panel_2_slug.add(lblSlugAnzahlParts);

		txtSlugAnzahlParts = new JTextField();
		txtSlugAnzahlParts.setHorizontalAlignment(SwingConstants.CENTER);
		txtSlugAnzahlParts.setBounds(731, 158, 25, 20);
		panel_2_slug.add(txtSlugAnzahlParts);
		txtSlugAnzahlParts.setColumns(10);



		txtSlugDvd = new JTextField();
		txtSlugDvd.setBounds(600, 8, 170, 20);
		panel_2_slug.add(txtSlugDvd);
		txtSlugDvd.setColumns(10);
		
		
		/*
		 * Button rund um Actress und Actor
		 */
		
		iconSlugActressCheck = new ImageIcon(strRefresh);
		iconSlugActressToFrist = new ImageIcon(strSlugActressToFirst);
		iconSlugActressToNear = new ImageIcon(strSlugActressToNear);
		
		
		// beginnende und endende Leerzeichen werden entfernt
		// aus der Zeichenfolge Komma-Leerzeichen wird Strichpunkt
		// das Kaufmännische Und zum Trenner; alles was dahinter steht wird ins Textfeld actor geschoben
		JButton btnSlugCheckActress = new JButton("");
		btnSlugCheckActress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iAnzahlTrenner = txtSlugActress.getText().length() - txtSlugActress.getText().replace("&", "").length(); 
				String inhalt[]=(txtSlugActress.getText().trim().replace(", ", ";").split("&"));
				String strActress = "";
				
				
				// Wenn Studio NA und keine Überschneidung zwischen txtslugActress und txtRibbonTitel
				// dann txtSlug nach txtRibbonTitel
				// wenn neben Studio NA gefüllt auch Album gefüllt, dann dies in den Titel
				
				
				if (cmbSlugStudio.getSelectedIndex() == 2) {
					
					if (cmbSlugAlbum.getSelectedIndex() == 0) {
						
						DebugInfoSchreiben("Ausgewähltes Studio: " + cmbSlugStudio.getSelectedItem().toString());
						txtRibbonTitel.setText(txtRibbonTitel.getText() + "/ " + txtSlugActress.getText().trim());
					} else {
						DebugInfoSchreiben("Titel: " + cmbSlugAlbum.getSelectedItem().toString() + " / " + txtSlugActress.getText().trim());
						txtRibbonTitel.setText(cmbSlugAlbum.getSelectedItem().toString() + " / " + txtSlugActress.getText().trim());
					}
					

				} // Ende if
				
				// Erster Eintrag ist immer für Actress
				// bei zwei oder mehr Einträgen ist der letzte Eintrag für Actor, alles andere für Actress
				
				switch (iAnzahlTrenner) {
				case 0:
						txtSlugActress.setText(inhalt[0].trim());														
					break;

				case 1:
						txtSlugActress.setText(inhalt[0].trim());
						txtSlugActor.setText(inhalt[iAnzahlTrenner].trim());
					break;
					
				default:
					txtSlugActor.setText(inhalt[iAnzahlTrenner].trim());
						for (int i = 0; i < iAnzahlTrenner; i++) {
							strActress = strActress + inhalt[i].trim() + ";";
						}
					// Letztes Zeichen = Semikoln entfernen
					txtSlugActress.setText(strActress.substring(0, strActress.length()-1));
			
					
					break;
				} // Ende switch
				
				DebugInfoSchreiben("btn - actress bereinigt und aufgeteilt");
			}
		});
		btnSlugCheckActress.setBounds(395, 291, 18, 18);
		btnSlugCheckActress.setIcon(iconSlugActressCheck);
		panel_2_slug.add(btnSlugCheckActress);
		
		JButton btnSlugActressToFirst = new JButton("");
		btnSlugActressToFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxSlugFirst.setSelected(true);
				txtSlugFirst.setEditable(true);
				txtSlugFirst.setEnabled(true);
				txtSlugFirst.setText(txtSlugActress.getText());
				DebugInfoSchreiben("btn - actress nach first kopiert");
			}
		});
		btnSlugActressToFirst.setBounds(420, 280, 18, 18);
		btnSlugActressToFirst.setIcon(iconSlugActressToFrist);
		panel_2_slug.add(btnSlugActressToFirst);
		
		JButton btnSlugActressToNear = new JButton("");
		btnSlugActressToNear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxSlugNear.setSelected(true);
				txtSlugNear.setEditable(true);
				txtSlugNear.setEnabled(true);
				txtSlugNear.setText(txtSlugActress.getText());
				DebugInfoSchreiben("btn - actress nach near kopiert");
			}
		});
		btnSlugActressToNear.setBounds(420, 305, 18, 18);
		btnSlugActressToNear.setIcon(iconSlugActressToNear);
		panel_2_slug.add(btnSlugActressToNear);
		
		JButton btnSlugExifErzeugen = new JButton("Exif Erzeu");
		btnSlugExifErzeugen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DebugInfoSchreiben("btnSlugExifErzeugen gedrückt.");
			ExifDaten exifDaten = new ExifDaten();
			setExifDaten(exifDaten);
			ExifDatenInDateiSchreiben(exifDaten);	
			
			}
		});
		btnSlugExifErzeugen.setBounds(670, 330, 110, 25);
		panel_2_slug.add(btnSlugExifErzeugen);
		
		JButton btnSlugExifAusfuehren = new JButton("Exif ausfü");
		btnSlugExifAusfuehren.setBounds(670, 365, 110, 25);
		panel_2_slug.add(btnSlugExifAusfuehren);
		
		JButton btnSlugExifBeides = new JButton("Exif beides");
		btnSlugExifBeides.setBounds(670, 400, 110, 25);
		panel_2_slug.add(btnSlugExifBeides);
		
		JButton btnSlugMp4Erzeugen = new JButton("mp4 schrei");
		btnSlugMp4Erzeugen.setBounds(670, 435, 110, 25);
		panel_2_slug.add(btnSlugMp4Erzeugen);
		
	


		/*
		 * Ende Panel 2
		 */

		/*
		 * ==========================================================
		 * Start Panel 4: Bilder
		 * 
		 * Bilder im Verzeichnis in der Vorschau
		 * 
		 * Vorschau wird erst dann erzeugt, wenn das Registerblatt aufgerufen wird
		 * 
		 * ==========================================================
		 */
		
		JPanel panel_3_slugdatei = new JPanel();
		tabbedPane.addTab("slug-datei", null, panel_3_slugdatei, null);
		panel_3_slugdatei.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSlugdateiRahmen = new JPanel();
		panel_3_slugdatei.add(panelSlugdateiRahmen);
		panelSlugdateiRahmen.setLayout(new BoxLayout(panelSlugdateiRahmen, BoxLayout.Y_AXIS));
		
		JPanel panelSlugdateiButtons = new JPanel();
		panelSlugdateiRahmen.add(panelSlugdateiButtons);
		
		JScrollPane scrollPaneSlugDatei = new JScrollPane();
		panelSlugdateiRahmen.add(scrollPaneSlugDatei);
		
		JTextPane txtPaneSlugDatei = new JTextPane();
		panelSlugdateiRahmen.add(txtPaneSlugDatei);


		panel_4_bilder = new JPanel();
		tabbedPane.addTab("bilder", null, panel_4_bilder, null);
		panel_4_bilder.setLayout(null);
		
		scrollPaneBilder = new JScrollPane();
		scrollPaneBilder.setBounds(1, 1, 790, 470);
		panel_4_bilder.add(scrollPaneBilder);
		
		panelBilderRahmen = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBilderRahmen.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		scrollPaneBilder.setViewportView(panelBilderRahmen);


		/*
		 * Ende Panel 4
		 */


		/*
		 * ==========================================================
		 * Start Panel 5: exif und mp4
		 * 
		 * 
		 * ==========================================================
		 */
		JPanel panel_5_exifmp4 = new JPanel();
		tabbedPane.addTab("exif - mp4tag", null, panel_5_exifmp4, null);
		panel_5_exifmp4.setLayout(null);

		// Exif Button erzeugen
		JButton btnExifErzeugen = new JButton("Exif-Datei erzeugen");
		btnExifErzeugen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExifErzeugen.setBounds(395, 291, 180, 25);
		panel_5_exifmp4.add(btnExifErzeugen);
		
		// Button Exif-Daten schreiben
		JButton btnExifDatenSchreiben = new JButton("Exif Daten schreiben");
		btnExifDatenSchreiben.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			    
				try {
				Process process = Runtime.getRuntime().exec("exiftool -overwrite_original -@ 01.slug /home/thomas/workspace/Xxx//a-tip-to-the-school-nurse/01.jpg");
				
			    } catch (IOException e1) {
					e1.printStackTrace();
				}
			System.out.println("Exif geschrieben");
			
			}
			
		});
		btnExifDatenSchreiben.setBounds(395, 200, 180, 25);
		panel_5_exifmp4.add(btnExifDatenSchreiben);
		
		// Button mp4 Tag Schreiben

		/*
		 * 
		 * mp4tag: eigenes Python-Script mit zwingend diesen 9 Parametern
		 * 
		 * # print 'Argument List:', str(sys.argv)
		 * # 1. Parameter: Dateiname
		 * # 2. Parameter: Titel
		 * # 3. Artist
		 * # 4. Album
		 * # 5. Jahr
		 * # 6. Nummer/Track
		 * # 7. Genre/Studio
		 * # 8. Kommentar
		 * # 9. Cover-Bild
		 */
		
		JButton btnExifMp4TagSchreiben = new JButton("mp4-Tag schreiben");
		btnExifMp4TagSchreiben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Process process = Runtime.getRuntime().exec("/home/thomas/scripts/mp4tag.py /home/thomas/workspace/Xxx//a-tip-to-the-school-nurse/01-city.mp4 1 2 3 4 5 6 7 9");
					
				    } catch (IOException e1) {
						e1.printStackTrace();
					}
				System.out.println("mp4tag.py geschrieben");
					
				
			}
		});
		btnExifMp4TagSchreiben.setBounds(395, 100, 180, 25);
		panel_5_exifmp4.add(btnExifMp4TagSchreiben);
		
		/*
		 * ==========================================================
		 * Start Panel 7: Debug
		 * ==========================================================
		 */
		
		JPanel panel_6_exifdatei = new JPanel();
		tabbedPane.addTab("exif-datei", null, panel_6_exifdatei, null);
		JPanel panel_7_debug = new JPanel();
		tabbedPane.addTab("debug", null, panel_7_debug, null);
		panel_7_debug.setLayout(new BorderLayout(0, 0));

		txtAreaDebug = new JTextArea();
		JScrollPane scrollPaneDebug = new JScrollPane(txtAreaDebug);

		panel_7_debug.add(scrollPaneDebug);
		
				
		/*
		 * ======================================================
		 * Panel 8: Konfiguration
		 * ======================================================
		 */


		JPanel panel_8_Konfiguration = new JPanel();
		tabbedPane.addTab("Konfiguration", null, panel_8_Konfiguration, null);
		panel_8_Konfiguration.setLayout(null);

		chckbxKonfigSpeichernBeimBeenden = new JCheckBox("Konfig beim beenden Speichern");
		chckbxKonfigSpeichernBeimBeenden.setSelected(true);
		chckbxKonfigSpeichernBeimBeenden.setBounds(33, 23, 250, 23);
		panel_8_Konfiguration.add(chckbxKonfigSpeichernBeimBeenden);

		
		JLabel lblKonfigVersion = new JLabel("Version:");
		lblKonfigVersion.setBounds(420, 25, 70, 15);
		panel_8_Konfiguration.add(lblKonfigVersion);

		txtKonfigVersion = new JTextField();
		txtKonfigVersion.setBounds(485, 23, 30, 20);
		panel_8_Konfiguration.add(txtKonfigVersion);
		txtKonfigVersion.setColumns(10);

		JLabel lblKonfigDatum = new JLabel("Datum:");
		lblKonfigDatum.setBounds(545, 25, 70, 15);
		panel_8_Konfiguration.add(lblKonfigDatum);

		txtKonfigDatum = new JTextField();
		txtKonfigDatum.setBounds(605, 23, 85, 20);
		panel_8_Konfiguration.add(txtKonfigDatum);
		txtKonfigDatum.setColumns(10);

		// Checkbox Logging an/aus
		chckbxKonfigLogging = new JCheckBox("Logging");
		chckbxKonfigLogging.setBounds(33, 60, 100, 23);
		chckbxKonfigLogging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxKonfigLogging.isSelected()) {
					txtKonfigLogdatei.setEditable(true);
					txtKonfigLogdatei.setEnabled(true);
					lblKonfigLogdatei.setEnabled(true);
				} else {
					txtKonfigLogdatei.setEditable(false);
					txtKonfigLogdatei.setEnabled(false);
					lblKonfigLogdatei.setEnabled(false);
				}
				
			}
		});
		
		panel_8_Konfiguration.add(chckbxKonfigLogging);

		lblKonfigLogdatei = new JLabel("Pfad/Datei für Log-Datei");
		lblKonfigLogdatei.setBounds(160, 65, 180, 15);
		panel_8_Konfiguration.add(lblKonfigLogdatei);

		txtKonfigLogdatei = new JTextField();
		txtKonfigLogdatei.setBounds(340, 63, 114, 20);
		panel_8_Konfiguration.add(txtKonfigLogdatei);
		txtKonfigLogdatei.setColumns(10);
		
		
		JButton btnKonfigSpeichern = new JButton("Speichern");
		btnKonfigSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Konfig_speichern();

			}
		});
		btnKonfigSpeichern.setBounds(634, 340, 110, 25);
		panel_8_Konfiguration.add(btnKonfigSpeichern);

		JButton btnKonfigLaden = new JButton("Laden");
		btnKonfigLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Konfig_laden();
			}
		});
		btnKonfigLaden.setBounds(634, 303, 110, 25);
		panel_8_Konfiguration.add(btnKonfigLaden);

		JLabel lblKonfigTemplateSlug = new JLabel("Pfad/Datei template.slug");
		lblKonfigTemplateSlug.setBounds(40, 200, 200, 15);
		panel_8_Konfiguration.add(lblKonfigTemplateSlug);

		txtKonfigTemplateslug = new JTextField();
		txtKonfigTemplateslug.setText("template.slug");
		txtKonfigTemplateslug.setBounds(230, 198, 400, 20);
		panel_8_Konfiguration.add(txtKonfigTemplateslug);
		txtKonfigTemplateslug.setColumns(10);

		


		JLabel lblKonfigLetzterPfad = new JLabel("Letzter Pfad");
		lblKonfigLetzterPfad.setBounds(40, 262, 100, 15);
		panel_8_Konfiguration.add(lblKonfigLetzterPfad);

		JLabel lblKonfigStandardPfad = new JLabel("Standard Pfad");
		lblKonfigStandardPfad.setBounds(40, 300, 110, 15);
		panel_8_Konfiguration.add(lblKonfigStandardPfad);

		txtKonfigLetzterPfad = new JTextField();
		txtKonfigLetzterPfad.setBounds(175, 260, 300, 20);
		panel_8_Konfiguration.add(txtKonfigLetzterPfad);
		txtKonfigLetzterPfad.setColumns(10);

		txtKonfigStandardPfad = new JTextField();
		txtKonfigStandardPfad.setBounds(175, 298, 300, 20);
		panel_8_Konfiguration.add(txtKonfigStandardPfad);
		txtKonfigStandardPfad.setColumns(10);

		// Checkbox für aktuelle Fensterposition
		chckbxKonfigAkutelleFensterposition = new JCheckBox("akutelle Fensterposition verwenden");
		chckbxKonfigAkutelleFensterposition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxKonfigAkutelleFensterposition.isSelected()) {
					lblKonfigXpos.setEnabled(true);
					txtKonfigXpos.setEnabled(true);
					txtKonfigXpos.setEditable(true);
					
					lblKonfigYpos.setEnabled(true);
					txtKonfigYpos.setEnabled(true);
					txtKonfigYpos.setEditable(true);
				} else {
					lblKonfigXpos.setEnabled(false);
					txtKonfigXpos.setEnabled(false);
					txtKonfigXpos.setEditable(false);
					
					lblKonfigYpos.setEnabled(false);
					txtKonfigYpos.setEnabled(false);
					txtKonfigYpos.setEditable(false);
				} // Ende else
			}
		});
		
		chckbxKonfigAkutelleFensterposition.setBounds(33, 105, 300, 23);
		panel_8_Konfiguration.add(chckbxKonfigAkutelleFensterposition);
		
		lblKonfigXpos = new JLabel("x-Pos:");
		lblKonfigXpos.setBounds(340, 90, 50, 15);
		panel_8_Konfiguration.add(lblKonfigXpos);

		lblKonfigYpos = new JLabel("Y-Pos:");
		lblKonfigYpos.setBounds(340, 120, 50, 15);
		panel_8_Konfiguration.add(lblKonfigYpos);

		txtKonfigXpos = new JTextField();
		txtKonfigXpos.setEnabled(false);
		txtKonfigXpos.setBounds(395, 90, 40, 20);
		panel_8_Konfiguration.add(txtKonfigXpos);
		txtKonfigXpos.setColumns(10);

		txtKonfigYpos = new JTextField();
		txtKonfigYpos.setEnabled(false);
		txtKonfigYpos.setBounds(395, 120, 40, 20);
		panel_8_Konfiguration.add(txtKonfigYpos);
		txtKonfigYpos.setColumns(10);

		iconKonfigReload = new ImageIcon(strRefresh);
		btnKonfigReload = new JButton(iconKonfigReload);
		btnKonfigReload.setIcon(iconKonfigReload);

		btnKonfigReload.setBounds(445, 100, 20, 20);
		panel_8_Konfiguration.add(btnKonfigReload);

		JLabel lblKonfigPythonPfad = new JLabel("Python/mp4 Pfad");
		lblKonfigPythonPfad.setBounds(40, 338, 130, 15);
		panel_8_Konfiguration.add(lblKonfigPythonPfad);

		JLabel lblKopnfigXxxshPfad = new JLabel("xxx.sh Pfad");
		lblKopnfigXxxshPfad.setBounds(40, 376, 100, 15);
		panel_8_Konfiguration.add(lblKopnfigXxxshPfad);

		txtKonfigPythonpfad = new JTextField();
		txtKonfigPythonpfad.setBounds(175, 336, 300, 20);
		panel_8_Konfiguration.add(txtKonfigPythonpfad);
		txtKonfigPythonpfad.setColumns(10);

		txtKonfigXxxshpfad = new JTextField();
		txtKonfigXxxshpfad.setBounds(175, 374, 114, 20);
		panel_8_Konfiguration.add(txtKonfigXxxshpfad);
		txtKonfigXxxshpfad.setColumns(10);

		JLabel lblKonfigComboboxenxml = new JLabel("Pfad/Datei konfig_comboboxen.xml");
		lblKonfigComboboxenxml.setBounds(40, 230, 260, 15);
		panel_8_Konfiguration.add(lblKonfigComboboxenxml);

		txtKonfigcomboboxenxml = new JTextField();
		txtKonfigcomboboxenxml.setBounds(310, 228, 320, 20);
		panel_8_Konfiguration.add(txtKonfigcomboboxenxml);
		txtKonfigcomboboxenxml.setColumns(10);
		
		JButton btnKonfigAnwenden = new JButton("Anwenden");
		btnKonfigAnwenden.setBounds(634, 266, 110, 25);
		panel_8_Konfiguration.add(btnKonfigAnwenden);

		
		txtStatusleiste = new JTextField();
		txtStatusleiste.setText("Statusleiste");
		frmFenstertitel.getContentPane().add(txtStatusleiste, BorderLayout.SOUTH);
		txtStatusleiste.setColumns(10);
		

		

		/*
		 * Abschluss Panel 6
		 * 
		 * Inhalte bzw. Konfiguration laden
		 */
		Konfig_laden();
		

		// Überprüfen ob letzter Pfad ungleich "leer" ist, ansonsten
		// Standard-Pfad
		if (txtKonfigLetzterPfad.equals("")) {
			txtRibbonPfad.setText(txtKonfigLetzterPfad.getText());
		} else {
			txtRibbonPfad.setText(txtKonfigStandardPfad.getText());
		}
		// initialer Aufruf beim Programmstart
		// vorher ist das Feld txtRibbonPfad nicht gefüllt-
		VerzeichnisAkutalisieren(txtRibbonPfad.getText(), dflModel);
		
		
		/*
		 * ===================================================================
		 * ComboBoxen Studio und Album (NICHT: Sterne) in Panel2 Slug befüllen
		 * ===================================================================
		 */
		// Standardwerte
		String[] datenCmbSlugStudio = {"Brazzers","NaugthyAmerica","Tushy","RealityKings"};
		String[] datenCmbSlugAlbum = {"Big Tits At Work","Big Tits In Uniform","Brazzers Exxtra"};
		
		if (!txtKonfigcomboboxenxml.getText().equals("")) {
			
			fXml = new File(txtKonfigcomboboxenxml.getText());
			if (fXml.exists() && fXml.isFile()) {
				try {
					ComboBoxBefuellen(cmbSlugStudio, ComboBoxDatenLaden(fXml, cmbSlugStudio, "studio", 0)); // letzter Parameter = 0 - ist unerheblich - wird bei studio nicht benötigt
					ComboBoxBefuellen(cmbSlugAlbum, ComboBoxDatenLaden(fXml, cmbSlugAlbum, "album", 0)); // letzter Wert = 0 = erster Eintrag aus der xml-Datei
				} catch (IOException e1) {
					// TODO Automatisch generierter Erfassungsblock
					e1.printStackTrace();
				}
			} else {
				ComboBoxBefuellen(cmbSlugAlbum, datenCmbSlugAlbum);
				ComboBoxBefuellen(cmbSlugStudio, datenCmbSlugStudio);
			} // Ende innere else
			
		} else {
			ComboBoxBefuellen(cmbSlugAlbum, datenCmbSlugAlbum);
			ComboBoxBefuellen(cmbSlugStudio, datenCmbSlugStudio);
		} //Ende else
	}
}
