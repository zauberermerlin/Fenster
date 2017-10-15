package org.fenster.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

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

import org.fenster.logic.menuFunktionen;
import org.fenster.model.SlugDaten;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

	// Album-Werte für Combo-Box
	private JComboBox<String> cmbSlugStudio;
	private JComboBox<String> cmbSlugAlbum;
	private JComboBox<String> cmbSlugSterne;
	
//	private String[] datenCmbSlugStudio;
//	private String[] datenCmbSlugAlbum;

	private JTextField txtKonfigVersion;
	private JTextField txtKonfigDatum;
	private JTextField txtKonfigTemplateslug;
	private JTextField txtKonfigLogdatei;
	private JTextField txtKonfigLetzterPfad;
	private JTextField txtKonfigStandardPfad;
	
	private JTextPane txtpnSlugBeschreibung;

	private JCheckBox chckbxKonfigAkutelleFensterposition;
	private JCheckBox chckbxKonfigLogging;
	private JTextField txtKonfigXpos;
	private JTextField txtKonfigYpos;
	private JLabel lblKonfigXpos;
	private JLabel lblKonfigYpos;
	private JLabel lblKonfigLogdatei;

	String strSchublade16 = "/home/thomas/workspace/Fenster/externe_dateien/schublade16x16.png";
	String strSchublade19 = "/home/thomas/workspace/Fenster/externe_dateien/schublade19x19.png";
	String strSchublade25 = "/home/thomas/workspace/Fenster/externe_dateien/schublade25x25.png";

	String strReload16 = "externe_dateien/reload_16x16.png";
	String strReload19 = "/home/thomas/workspace/Fenster/externe_dateien/reload_19x19.png";
	String strReload25 = "/home/thomas/workspace/Fenster/externe_dateien/reload_25x25.png";
	
	String strPfeilOben = "externe_dateien/pfeil_oben.png";
	String strPfeilUnten = "externe_dateien/pfeil_unten.png";
	String strPfeilLinks = "externe_dateien/pfeil_links.png";
	String strPfeilRechts = "externe_dateien/pfeil_rechts.png";
	String strPfeilTauschen = "externe_dateien/pfeil_tauschen.png";
	
	private ImageIcon iconRibbonPfadDialogbox;
	private ImageIcon iconRibbonTitelZuSerie;
	private ImageIcon iconRibbonSlugUmwandeln;
	private ImageIcon iconKonfigReload;
	
	private ImageIcon iconSlugReleaseJahrOben;
	private ImageIcon iconSlugReleaseJahrUnten;
	private ImageIcon iconSlugTauschen;
	
	private JButton btnKonfigReload;
	private JTextField txtKonfigPythonpfad;
	private JTextField txtKonfigXxxshpfad;
	private JTextField txtSlugVersion;
	private JTextField txtSlugVersionsdatum;
	private JTextField txtSlugBraznr;
	private JTextField txtSlugNa;
	private JTextField txtSlugFirst;
	private JTextField txtSlugNear;
	private JTextField txtSlugTitelbild;
	private JTextField txtSlugPortraitbild;
	private JTextField txtSlugReleaseJahr;
	private JTextField txtSlugErstelltAm;
	
	private JFileChooser jfcSlug;
	//private File fileSlugPfad; // sollte irgendwann zu löschen sein!!! 09.10.2017
	private File fileRibbonPfad;
	
	private File fXml;
	private JTextField txtKonfigcomboboxenxml;

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					
				
		
					TripleX window_start = new TripleX();
					
					if (window_start.txtKonfigXpos.getText().equals("")) {
						window_start.txtKonfigXpos.setText("100");
					}

					if (window_start.txtKonfigYpos.getText().equals("")) {
						window_start.txtKonfigYpos.setText("100");
					}

					window_start.frmFenstertitel.setLocation(Integer.valueOf(window_start.txtKonfigXpos.getText()),
							Integer.valueOf(window_start.txtKonfigYpos.getText()));
					window_start.frmFenstertitel.setVisible(true);
					
	} // Ende main Funktion

	
	/*
	 * deprecated muss noch umprogrammiert und dann gelöscht werden!!!
	 */
	public void FensterVersion() {

		menuFunktionen.FensterVersion();

		// System.out.println("Version gedrückt");
		// Version fenster_version = new Version();
		// fenster_version.setVisible(true);

	}
	
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
			JOptionPane.showMessageDialog(null, "Keine konfig.txt im Hauptverzeichnis vorhanden!");

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
				txtStatusleiste.setText("Konfiguration geladen");

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
		 * Schritte: (1) Auslesen und Einsammeln aller Werte (2) Properties
		 * anlegen und Werte setzen (3) in die Konfig-Datei schreiben (4)
		 * Ausgabe in Statuszeile
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
	
	

	public void Slug_laden() {

		// VERSION="0.4";
		// VERSIONSDATUM="23.06.2017";
		// TITEL="Don't";
		// #Mehrere mittels ; (Semikolon) trennen und ohne Leerzeichen nach dem
		// Semikolon
		// ACTRESS="";
		// ACTOR="";
		// BESCHREIBUNG="";
		// BRAZNR="9";
		// #Link des ersten Bildes
		// NA="";
		// # Datum-Format: yyyy:mm:dd hh:mm
		// RELEASE="00:00";
		// ERSTELLT_AM="";
		// #
		// TITELBILD="";
		// PORTRAETBILD="01";
		// #
		// STUDIO="Brazzers";
		// ALBUM="";
		//
		// DVD="";
		// #SERIE="Dont touch her";
		// SERIE="";
		// PART="1";
		// ANZAHLPARTS="";
		// BILDER="j";
		// THUMBS="n";
		// REMASTERED="n";
		// VR="n";
		// FIRST="n";
		// FIRSTNAME="";
		// NEAR="";
		// NEARNAME="";
	

		

	}

	public void SlugDaten_holen(SlugDaten sDatenFunktion) {
		sDatenFunktion.setStrSlug(txtRibbonSlugName.getText());
		sDatenFunktion.setStrPfad(txtRibbonPfad.getText());
		sDatenFunktion.setStrTitel(txtRibbonTitel.getText());
		sDatenFunktion.setStrSerie(txtRibbonSerie.getText());
		
		sDatenFunktion.setStrActress(txtSlugActress.getText());
		sDatenFunktion.setStrActor(txtSlugActor.getText());
		sDatenFunktion.setStrBeschreibung(txtpnSlugBeschreibung.getText());
		sDatenFunktion.setStrBraznr(txtSlugBraznr.getText());

		sDatenFunktion.setStrNA(txtSlugNa.getText());

		
		/*
		 * zu löschen?
		 * in der txt-Datei-Ausgabe steht von jedem : ein Backslash \
		 * Warum?
		 */
		sDatenFunktion.setStrRelease(txtSlugReleaseJahr.getText() + ":" + txtSlugReleaseMonat.getText() + ":" + txtSlugReleaseTag.getText() + " " + txtSlugReleaseZeit.getText());
		sDatenFunktion.setStrErstellt(txtSlugErstelltAm.getText().toString());
		sDatenFunktion.setStrTitelbild(txtSlugTitelbild.getText());
		sDatenFunktion.setStrPortraetbild(txtSlugPortraitbild.getText());
		
		// Werte aus den Comboboxen
		sDatenFunktion.setStrStudio(cmbSlugAlbum.getSelectedItem().toString());
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
	} // Ende Funktion
	
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
		 * Statusleiste ganz weit vorne, damit dort auch alle Angaben ausgegeben
		 * werden können
		 */
		JMenuBar menuBar = new JMenuBar();
		frmFenstertitel.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu menuDatei = new JMenu("Datei");
		menuBar.add(menuDatei);

		JMenuItem mntmffnen = new JMenuItem("Öffnen");
		menuDatei.add(mntmffnen);

		JSeparator separator = new JSeparator();
		menuDatei.add(separator);

		JMenuItem mntmSchliessen = new JMenuItem("Schliessen");
		mntmSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fenster schliessen und Anwendnug beenden
				frmFenstertitel.dispose();
			}
		});
		menuDatei.add(mntmSchliessen);

		JMenu menuFenster = new JMenu("Fenster");
		menuBar.add(menuFenster);

		JMenuItem mntmDebug = new JMenuItem("Debug");
		menuFenster.add(mntmDebug);

		JMenuItem mntmKonfiguration = new JMenuItem("Konfiguration");
		menuFenster.add(mntmKonfiguration);

		JMenu menuUeber = new JMenu("Über");
		menuBar.add(menuUeber);

		JMenuItem menu_item_version = new JMenuItem("Version");
		menu_item_version.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menu_item_version.setEnabled(false);
				FensterVersion();

			}
		});
		menuUeber.add(menu_item_version);

		JPanel panel_mitte = new JPanel();
		frmFenstertitel.getContentPane().add(panel_mitte, BorderLayout.CENTER);
		panel_mitte.setLayout(new BorderLayout(0, 0));

		JPanel panel_ribbon = new JPanel();
		panel_ribbon.setPreferredSize(new Dimension(300, 100));
		
		panel_mitte.add(panel_ribbon, BorderLayout.NORTH);
		panel_ribbon.setLayout(null);

		JLabel lblRibbonPfad = new JLabel("Pfad");
		lblRibbonPfad.setBounds(30, 10, 85, 16);
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
		btnRibbonSlugUmwandeln.setBounds(500, 42, 20, 20);
		panel_ribbon.add(btnRibbonSlugUmwandeln);
		
		
		JLabel lblRibbonTitel = new JLabel("Titel");
		lblRibbonTitel.setBounds(30, 76, 70, 16);
		panel_ribbon.add(lblRibbonTitel);
		
		txtRibbonTitel = new JTextField();
		txtRibbonTitel.setBounds(115, 75, 370, 20);
		panel_ribbon.add(txtRibbonTitel);
		txtRibbonTitel.setColumns(10);

		
		JButton btnRibbonPfaddialogbox = new JButton("");
		btnRibbonPfaddialogbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Dialogbox öffnen (1) Auslese txtSlugPfad Feld und daraus den
				 * Pfad entnehmen (1a) Überprüfen, ob Datei oder Verzeichnis;
				 * event. Verzeichnis daraus extrahieren (2) Dialogbox (3)
				 * Ausgewählten Wert in txtSlugPfad übernehmen
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

			}
		});
		
		/*
		 * Button mit Grafik / Dialogbox - Schublade
		 */
		iconRibbonPfadDialogbox = new ImageIcon(strSchublade16);
		
		btnRibbonPfaddialogbox.setIcon(iconRibbonPfadDialogbox);
		btnRibbonPfaddialogbox.setBounds(500, 9, 20, 20);
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
		btnRibbonTitelZuSerie.setBounds(500, 74, 20, 20);
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
		
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_mitte.add(tabbedPane);

		JPanel panel_1_Datei = new JPanel();
		tabbedPane.addTab("Datei", null, panel_1_Datei, null);
		tabbedPane.setEnabledAt(0, true);
		panel_1_Datei.setLayout(null);

		JButton btnPfad = new JButton("Pfad");
		btnPfad.setBounds(36, 36, 117, 25);
		panel_1_Datei.add(btnPfad);
		JPanel panel_2_slug = new JPanel();
		tabbedPane.addTab("slug", null, panel_2_slug, null);
		panel_2_slug.setLayout(null);
		JLabel lblSlugAlbum = new JLabel("Album");
		lblSlugAlbum.setBounds(30, 202, 55, 15);
		panel_2_slug.add(lblSlugAlbum);

		cmbSlugAlbum = new JComboBox<String>();
		cmbSlugAlbum.setBounds(100, 199, 200, 22);
		panel_2_slug.add(cmbSlugAlbum);
		JLabel lblSlugStudio = new JLabel("Studio");
		lblSlugStudio.setBounds(30, 167, 55, 15);
		panel_2_slug.add(lblSlugStudio);

		cmbSlugStudio = new JComboBox<String>();
		cmbSlugStudio.setBounds(100, 164, 120, 22);
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
												lblSlugActress.setBounds(30, 237, 55, 15);
												panel_2_slug.add(lblSlugActress);

												JLabel lblSlugActor = new JLabel("Actor");
												lblSlugActor.setBounds(30, 272, 55, 15);
												panel_2_slug.add(lblSlugActor);

												txtSlugActress = new JTextField();
												txtSlugActress.setBounds(100, 234, 340, 19);
												panel_2_slug.add(txtSlugActress);
												txtSlugActress.setColumns(10);

												txtSlugActor = new JTextField();
												txtSlugActor.setBounds(100, 270, 340, 19);
												panel_2_slug.add(txtSlugActor);
												txtSlugActor.setColumns(10);

												
												/*
												 * Button "Erzeugen"
												 * 
												 * Slug-Datei wird erzeugt
												 */
												JButton btnSlugErzeugen = new JButton("Erzeugen");
												btnSlugErzeugen.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														SlugDaten sDaten = new SlugDaten();
														SlugDaten_holen(sDaten);
															txtStatusleiste.setText(sDaten.slugSchreiben("/home/thomas/Schreibtisch/test.slug"));
//															txtStatusleiste.setText(sDaten.slug_auf_konsole());
														
														
														
													}
												});
												btnSlugErzeugen.setBounds(660, 435, 110, 25);
												panel_2_slug.add(btnSlugErzeugen);

												JLabel lblSlugVersion = new JLabel("Version");
												lblSlugVersion.setBounds(30, 15, 60, 15);
												panel_2_slug.add(lblSlugVersion);

												txtSlugVersion = new JTextField();
												txtSlugVersion.setEditable(false);
												txtSlugVersion.setBounds(100, 13, 45, 19);
												panel_2_slug.add(txtSlugVersion);
												txtSlugVersion.setColumns(10);

												JLabel lblSlugVersionsdatum = new JLabel("Versionsdatum");
												lblSlugVersionsdatum.setBounds(255, 15, 110, 15);
												panel_2_slug.add(lblSlugVersionsdatum);

												txtSlugVersionsdatum = new JTextField();
												txtSlugVersionsdatum.setEditable(false);
												txtSlugVersionsdatum.setBounds(370, 13, 114, 19);
												panel_2_slug.add(txtSlugVersionsdatum);
												txtSlugVersionsdatum.setColumns(10);

												JLabel lblSlugBeschreibung = new JLabel("Beschreibung");
												lblSlugBeschreibung.setBounds(30, 307, 110, 15);
												panel_2_slug.add(lblSlugBeschreibung);

												txtpnSlugBeschreibung = new JTextPane();
												txtpnSlugBeschreibung.setBounds(145, 310, 300, 100);
												panel_2_slug.add(txtpnSlugBeschreibung);

												JLabel lblSlugBraznr = new JLabel("Braz-Nr.");
												lblSlugBraznr.setBounds(255, 167, 70, 15);
												panel_2_slug.add(lblSlugBraznr);

												txtSlugBraznr = new JTextField();
												txtSlugBraznr.setBounds(325, 165, 50, 19);
												panel_2_slug.add(txtSlugBraznr);
												txtSlugBraznr.setColumns(10);

												JLabel lblSlugNa = new JLabel("NA Bild Link");
												lblSlugNa.setBounds(420, 167, 90, 15);
												panel_2_slug.add(lblSlugNa);

												txtSlugNa = new JTextField();
												txtSlugNa.setBounds(510, 165, 250, 19);
												panel_2_slug.add(txtSlugNa);
												txtSlugNa.setColumns(10);

												JLabel lblSlugRelease = new JLabel("Release");
												lblSlugRelease.setBounds(30, 110, 70, 15);
												panel_2_slug.add(lblSlugRelease);

												JLabel lblSlugErstelltAm = new JLabel("Erstellt am");
												lblSlugErstelltAm.setBounds(350, 110, 85, 15);
												panel_2_slug.add(lblSlugErstelltAm);

												JLabel lblSlugTitelbild = new JLabel("Titelbild");
												lblSlugTitelbild.setBounds(30, 55, 70, 15);
												panel_2_slug.add(lblSlugTitelbild);

												JLabel lblSlugPortraitbild = new JLabel("Portraitbild");
												lblSlugPortraitbild.setBounds(255, 55, 90, 15);
												panel_2_slug.add(lblSlugPortraitbild);

												
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
												
												chckbxSlugFirst.setBounds(465, 307, 70, 23);
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
												
												
												chckbxSlugNear.setBounds(465, 334, 70, 23);
												panel_2_slug.add(chckbxSlugNear);

												chckbxSlugThumbs = new JCheckBox("Thumbs");
												chckbxSlugThumbs.setBounds(465, 361, 129, 23);
												panel_2_slug.add(chckbxSlugThumbs);

												chckbxSlugVr = new JCheckBox("VR");
												chckbxSlugVr.setBounds(465, 388, 129, 23);
												panel_2_slug.add(chckbxSlugVr);

												chckbxSlugRemastered = new JCheckBox("Remastered");
												chckbxSlugRemastered.setBounds(465, 415, 115, 23);
												panel_2_slug.add(chckbxSlugRemastered);

												txtSlugFirst = new JTextField();
												txtSlugFirst.setEditable(false);
												txtSlugFirst.setEnabled(false);
												txtSlugFirst.setBounds(536, 309, 200, 19);
												panel_2_slug.add(txtSlugFirst);
												txtSlugFirst.setColumns(10);

												txtSlugNear = new JTextField();
												txtSlugNear.setEditable(false);
												txtSlugNear.setEnabled(false);
												txtSlugNear.setBounds(536, 336, 200, 19);
												panel_2_slug.add(txtSlugNear);
												txtSlugNear.setColumns(10);

												JButton btnSlugNeuLaden = new JButton("Neu Laden");
												btnSlugNeuLaden.setBounds(660, 400, 110, 25);
												panel_2_slug.add(btnSlugNeuLaden);

												chckbxSlugBilder = new JCheckBox("Bilder");
												chckbxSlugBilder.setBounds(465, 442, 75, 23);
												panel_2_slug.add(chckbxSlugBilder);

												JSeparator separator_1 = new JSeparator();
												separator_1.setBounds(30, 41, 730, 2);
												panel_2_slug.add(separator_1);
												
												JSeparator separator_2 = new JSeparator();
												separator_2.setBounds(30, 80, 730, 2);
												panel_2_slug.add(separator_2);

												JLabel lblSlugSterne = new JLabel("Sterne");
												lblSlugSterne.setBounds(405, 55, 60, 15);
												panel_2_slug.add(lblSlugSterne);

												cmbSlugSterne = new JComboBox<String>();
												cmbSlugSterne.setBounds(465, 52, 40, 20);
												
												String[] sterneDaten = {"1","2","3","4","5"};
												
												ComboBoxBefuellen(cmbSlugSterne, sterneDaten);
												panel_2_slug.add(cmbSlugSterne);

												JSeparator separator_3 = new JSeparator();
												separator_3.setBounds(30, 155, 730, 2);
												panel_2_slug.add(separator_3);

												JLabel lblSlugDvd = new JLabel("DVD");
												lblSlugDvd.setBounds(465, 202, 40, 15);
												panel_2_slug.add(lblSlugDvd);

												JLabel lblSlugPart = new JLabel("Part");
												lblSlugPart.setBounds(465, 237, 40, 15);
												panel_2_slug.add(lblSlugPart);

												JLabel lblSlugAnzahlParts = new JLabel("Anzahl Parts");
												lblSlugAnzahlParts.setBounds(560, 237, 100, 15);
												panel_2_slug.add(lblSlugAnzahlParts);

												txtSlugTitelbild = new JTextField();
												txtSlugTitelbild.setBounds(100, 53, 30, 19);
												panel_2_slug.add(txtSlugTitelbild);
												txtSlugTitelbild.setColumns(10);

												txtSlugPortraitbild = new JTextField();
												txtSlugPortraitbild.setBounds(345, 53, 30, 19);
												panel_2_slug.add(txtSlugPortraitbild);
												txtSlugPortraitbild.setColumns(10);

												txtSlugReleaseJahr = new JTextField();
												txtSlugReleaseJahr.setText("2017");
												txtSlugReleaseJahr.setBounds(100, 108, 40, 20);
												panel_2_slug.add(txtSlugReleaseJahr);
												txtSlugReleaseJahr.setColumns(10);
												
												
												txtSlugErstelltAm = new JTextField();
												txtSlugErstelltAm.setBounds(440, 108, 130, 20);
												// Feld mit dem heutigen Datum in der Form jjjj:mm:tt hh:mm füllen
												DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd");
												LocalDate localDate = LocalDate.now();
												txtSlugErstelltAm.setText(dtf.format(localDate) + " 00:00");												
												panel_2_slug.add(txtSlugErstelltAm);
												txtSlugErstelltAm.setColumns(10);
												
												
												txtSlugReleaseMonat = new JTextField();
												txtSlugReleaseMonat.setBounds(145, 108, 25, 20);
												panel_2_slug.add(txtSlugReleaseMonat);
												txtSlugReleaseMonat.setColumns(10);
												
												txtSlugReleaseTag = new JTextField();
												txtSlugReleaseTag.setText("\n");
												txtSlugReleaseTag.setBounds(175, 108, 25, 20);
												panel_2_slug.add(txtSlugReleaseTag);
												txtSlugReleaseTag.setColumns(10);
												
												txtSlugReleaseZeit = new JTextField();
												txtSlugReleaseZeit.setText("00:00");
												txtSlugReleaseZeit.setBounds(210, 108, 45, 20);
												panel_2_slug.add(txtSlugReleaseZeit);
												txtSlugReleaseZeit.setColumns(10);

												
												/*
												 * ReleaseAm und ErstelltAm Buttons mit Grafik/Pfeilen
												 */
												JButton btnSlugReleaseJahrOben = new JButton("");
												btnSlugReleaseJahrOben.setBounds(110, 87, 18, 18);
												iconSlugReleaseJahrOben = new ImageIcon(strPfeilOben);
												btnSlugReleaseJahrOben.setIcon(iconSlugReleaseJahrOben);
												panel_2_slug.add(btnSlugReleaseJahrOben);
												
												JButton btnSlugReleaseJahrUnten = new JButton("");
												btnSlugReleaseJahrUnten.setBounds(110, 130, 18, 18);
												iconSlugReleaseJahrUnten = new ImageIcon(strPfeilUnten);
												btnSlugReleaseJahrUnten.setIcon(iconSlugReleaseJahrUnten);
												
												panel_2_slug.add(btnSlugReleaseJahrUnten);
												
												JButton btnSlugLeeren = new JButton("Leeren");
												btnSlugLeeren.setBounds(660, 365, 110, 25);
												panel_2_slug.add(btnSlugLeeren);
												
												/*
												 * Pfeil tauschen zwischen Release und Erstellt
												 */
												JButton btnSlugTauschen = new JButton("");
												iconSlugTauschen = new ImageIcon(strPfeilTauschen);
												btnSlugTauschen.setIcon(iconSlugTauschen);
												btnSlugTauschen.setBounds(290, 110, 26, 18);
												panel_2_slug.add(btnSlugTauschen);
												
												txtSlugDvd = new JTextField();
												txtSlugDvd.setBounds(510, 200, 250, 20);
												panel_2_slug.add(txtSlugDvd);
												txtSlugDvd.setColumns(10);
												
												txtSlugPart = new JTextField();
												txtSlugPart.setBounds(510, 234, 25, 20);
												panel_2_slug.add(txtSlugPart);
												txtSlugPart.setColumns(10);
												
												txtSlugAnzahlParts = new JTextField();
												txtSlugAnzahlParts.setBounds(660, 234, 25, 20);
												panel_2_slug.add(txtSlugAnzahlParts);
												txtSlugAnzahlParts.setColumns(10);
												
												
												
												/*
												 * Ende Panel 2
												 */
												

												JPanel panel_3_mp4tag = new JPanel();
												tabbedPane.addTab("mp4tag", null, panel_3_mp4tag, null);

												JPanel panel_4_exif = new JPanel();
												tabbedPane.addTab("exif", null, panel_4_exif, null);

												JPanel panel_5_debug = new JPanel();
												tabbedPane.addTab("debug", null, panel_5_debug, null);
												
												/*
												 * ======================================================
												 * Panel 6: Konfiguration
												 * ======================================================
												 */
												
												
												JPanel panel_6_Konfiguration = new JPanel();
												tabbedPane.addTab("Konfiguration", null, panel_6_Konfiguration, null);
												panel_6_Konfiguration.setLayout(null);

												JButton btnSpeichern = new JButton("Speichern");
												btnSpeichern.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														Konfig_speichern();

													}
												});
												btnSpeichern.setBounds(634, 340, 105, 25);
												panel_6_Konfiguration.add(btnSpeichern);

												JButton btnLaden = new JButton("Laden");
												btnLaden.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														Konfig_laden();
													}
												});
												btnLaden.setBounds(634, 303, 105, 25);
												panel_6_Konfiguration.add(btnLaden);

												JLabel lblKonfigVersion = new JLabel("Version:");
												lblKonfigVersion.setBounds(40, 25, 70, 15);
												panel_6_Konfiguration.add(lblKonfigVersion);

												txtKonfigVersion = new JTextField();
												txtKonfigVersion.setBounds(110, 23, 114, 20);
												panel_6_Konfiguration.add(txtKonfigVersion);
												txtKonfigVersion.setColumns(10);

												JLabel lblKonfigDatum = new JLabel("Datum:");
												lblKonfigDatum.setBounds(40, 60, 70, 15);
												panel_6_Konfiguration.add(lblKonfigDatum);

												txtKonfigDatum = new JTextField();
												txtKonfigDatum.setBounds(110, 58, 114, 20);
												panel_6_Konfiguration.add(txtKonfigDatum);
												txtKonfigDatum.setColumns(10);

												JLabel lblKonfigTemplateSlug = new JLabel("Pfad/Datei template.slug");
												lblKonfigTemplateSlug.setBounds(40, 95, 200, 15);
												panel_6_Konfiguration.add(lblKonfigTemplateSlug);

												txtKonfigTemplateslug = new JTextField();
												txtKonfigTemplateslug.setText("template.slug");
												txtKonfigTemplateslug.setBounds(230, 93, 400, 20);
												panel_6_Konfiguration.add(txtKonfigTemplateslug);
												txtKonfigTemplateslug.setColumns(10);

												chckbxKonfigAkutelleFensterposition = new JCheckBox("akutelle Fensterposition verwenden");
												chckbxKonfigAkutelleFensterposition.setBounds(33, 165, 300, 23);
												panel_6_Konfiguration.add(chckbxKonfigAkutelleFensterposition);

												chckbxKonfigLogging = new JCheckBox("Logging");
												chckbxKonfigLogging.setBounds(33, 215, 100, 23);
												panel_6_Konfiguration.add(chckbxKonfigLogging);

												lblKonfigLogdatei = new JLabel("Pfad/Datei für Log-Datei");
												lblKonfigLogdatei.setEnabled(false);
												lblKonfigLogdatei.setBounds(160, 220, 180, 15);
												panel_6_Konfiguration.add(lblKonfigLogdatei);

												txtKonfigLogdatei = new JTextField();
												txtKonfigLogdatei.setEnabled(false);
												txtKonfigLogdatei.setBounds(340, 218, 114, 20);
												panel_6_Konfiguration.add(txtKonfigLogdatei);
												txtKonfigLogdatei.setColumns(10);

												JLabel lblKonfigLetzterPfad = new JLabel("Letzter Pfad");
												lblKonfigLetzterPfad.setBounds(40, 262, 100, 15);
												panel_6_Konfiguration.add(lblKonfigLetzterPfad);

												JLabel lblKonfigStandardPfad = new JLabel("Standard Pfad");
												lblKonfigStandardPfad.setBounds(40, 300, 110, 15);
												panel_6_Konfiguration.add(lblKonfigStandardPfad);

												txtKonfigLetzterPfad = new JTextField();
												txtKonfigLetzterPfad.setBounds(175, 260, 300, 20);
												panel_6_Konfiguration.add(txtKonfigLetzterPfad);
												txtKonfigLetzterPfad.setColumns(10);

												txtKonfigStandardPfad = new JTextField();
												txtKonfigStandardPfad.setBounds(175, 298, 300, 20);
												panel_6_Konfiguration.add(txtKonfigStandardPfad);
												txtKonfigStandardPfad.setColumns(10);

												lblKonfigXpos = new JLabel("x-Pos:");
												lblKonfigXpos.setEnabled(false);
												lblKonfigXpos.setBounds(340, 149, 50, 15);
												panel_6_Konfiguration.add(lblKonfigXpos);

												lblKonfigYpos = new JLabel("Y-Pos:");
												lblKonfigYpos.setEnabled(false);
												lblKonfigYpos.setBounds(340, 176, 50, 15);
												panel_6_Konfiguration.add(lblKonfigYpos);

												txtKonfigXpos = new JTextField();
												txtKonfigXpos.setEnabled(false);
												txtKonfigXpos.setBounds(395, 147, 40, 20);
												panel_6_Konfiguration.add(txtKonfigXpos);
												txtKonfigXpos.setColumns(10);

												txtKonfigYpos = new JTextField();
												txtKonfigYpos.setEnabled(false);
												txtKonfigYpos.setBounds(395, 174, 40, 20);
												panel_6_Konfiguration.add(txtKonfigYpos);
												txtKonfigYpos.setColumns(10);

												btnKonfigReload = new JButton(iconKonfigReload);
												btnKonfigReload.setIcon(iconKonfigReload);

												btnKonfigReload.setBounds(445, 157, 24, 24);
												panel_6_Konfiguration.add(btnKonfigReload);

												JLabel lblKonfigPythonPfad = new JLabel("Python/mp4 Pfad");
												lblKonfigPythonPfad.setBounds(40, 338, 130, 15);
												panel_6_Konfiguration.add(lblKonfigPythonPfad);

												JLabel lblKopnfigXxxshPfad = new JLabel("xxx.sh Pfad");
												lblKopnfigXxxshPfad.setBounds(40, 376, 100, 15);
												panel_6_Konfiguration.add(lblKopnfigXxxshPfad);

												txtKonfigPythonpfad = new JTextField();
												txtKonfigPythonpfad.setBounds(175, 336, 300, 20);
												panel_6_Konfiguration.add(txtKonfigPythonpfad);
												txtKonfigPythonpfad.setColumns(10);

												txtKonfigXxxshpfad = new JTextField();
												txtKonfigXxxshpfad.setBounds(175, 374, 114, 20);
												panel_6_Konfiguration.add(txtKonfigXxxshpfad);
												txtKonfigXxxshpfad.setColumns(10);

												JLabel lblKonfigComboboxenxml = new JLabel("Pfad/Datei konfig_comboboxen.xml");
												lblKonfigComboboxenxml.setBounds(40, 122, 260, 15);
												panel_6_Konfiguration.add(lblKonfigComboboxenxml);

												txtKonfigcomboboxenxml = new JTextField();
												txtKonfigcomboboxenxml.setBounds(310, 120, 320, 20);
												panel_6_Konfiguration.add(txtKonfigcomboboxenxml);
												txtKonfigcomboboxenxml.setColumns(10);
		txtStatusleiste = new JTextField();
		txtStatusleiste.setText("Statusleiste");
		frmFenstertitel.getContentPane().add(txtStatusleiste, BorderLayout.SOUTH);
		txtStatusleiste.setColumns(10);
		
		


		iconKonfigReload = new ImageIcon(strReload19);

		/*
		 * Abschluss Panel 6
		 * 
		 * Inhalte bzw. Konfiguration laden
		 */
		Konfig_laden();

		/*
		 * Pfade in Panel 2 - Slug setzen
		 */

		// Überprüfen ob letzter Pfad ungleich "leer" ist, ansonsten
		// Standard-Pfad
		if (txtKonfigLetzterPfad.equals("")) {
			txtRibbonPfad.setText(txtKonfigLetzterPfad.getText());
		} else {
			txtRibbonPfad.setText(txtKonfigStandardPfad.getText());
		}

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
