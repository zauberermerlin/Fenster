package org.fenster.model;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * @author thomas
 *
 */
public class SlugDaten {
	
	public static String getStrVersion() {
		return strVersion;
	}

	public static String getStrVersionsdatum() {
		return strVersionsdatum;
	}

	public String getStrPfad() {
		return strPfad;
	}

	public String getStrTitel() {
		return strTitel;
	}

	public String getStrActress() {
		return strActress;
	}

	public String getStrActor() {
		return strActor;
	}

	public String getStrBeschreibung() {
		return strBeschreibung;
	}

	public String getStrBraznr() {
		return strBraznr;
	}

	public String getStrNA() {
		return strNA;
	}

	public String getStrRelease() {
		return strRelease;
	}

	public String getStrErstellt() {
		return strErstellt;
	}

	public String getStrTitelbild() {
		return strTitelbild;
	}

	public String getStrPortraetbild() {
		return strPortraetbild;
	}

	public String getStrStudio() {
		return strStudio;
	}

	public String getStrAlbum() {
		return strAlbum;
	}

	public String getStrDVD() {
		return strDVD;
	}

	public String getStrSerie() {
		return strSerie;
	}

	public String getStrPart() {
		return strPart;
	}

	public String getStrAnzahlparts() {
		return strAnzahlparts;
	}

	public String getStrBilder() {
		return strBilder;
	}

	public String getStrThumbs() {
		return strThumbs;
	}

	public String getStrRemastered() {
		return strRemastered;
	}

	public String getStrVR() {
		return strVR;
	}

	public String getStrFirst() {
		return strFirst;
	}

	public String getStrFirstname() {
		return strFirstname;
	}

	public String getStrNear() {
		return strNear;
	}

	public String getStrNearname() {
		return strNearname;
	}

	public String getStrSterne() {
		return strSterne;
	}

	private static String strVersion = "0.5";
	private static String strVersionsdatum = "11.10.2017";

	private String strSlug;
	private String strPfad;
	private String strTitel;
	private String strActress;
	private String strActor;
	private String strBeschreibung;
	private String strBraznr;
	private String strNA;
	private String strRelease;
	private String strErstellt;
	private String strTitelbild;
	private String strPortraetbild;

	private String strStudio;
	private String strAlbum;
	private String strDVD;
	private String strSerie;
	private String strPart;
	private String strAnzahlparts;
	private String strBilder;
	private String strThumbs;
	private String strRemastered;
	private String strVR;
	private String strFirst;
	private String strFirstname;
	private String strNear;
	private String strNearname;
	private String strSterne;
	
	
public static void setStrVersion(String strVersion) {
		SlugDaten.strVersion = strVersion;
	}

public static void setStrVersionsdatum(String strVersionsdatum) {
		SlugDaten.strVersionsdatum = strVersionsdatum;
	}
	
public void setStrPfad(String strPfad) {
	this.strPfad = strPfad;
}

public void setStrTitel(String strTitel) {
	this.strTitel = strTitel;
}

public void setStrSlug(String strSlug) {
		this.strSlug = strSlug;
	}

public String getStrSlug() {
	return strSlug;
}

public static String getVersion() {
	return strVersion;
}

public static String getVersionsdatum() {
	return strVersionsdatum;
}

public void setStrSerie(String strSerie) {
	this.strSerie = strSerie;
}

public void setStrActress(String strActress) {
	this.strActress = strActress;
}

public void setStrActor(String strActor) {
	this.strActor = strActor;
}

public void setStrBeschreibung(String strBeschreibung) {
	this.strBeschreibung = strBeschreibung;
}

public void setStrBraznr(String strBraznr) {
	this.strBraznr = strBraznr;
}

public void setStrNA(String strNA) {
	this.strNA = strNA;
}

public void setStrRelease(String strRelease) {
	this.strRelease = strRelease;
}

public void setStrErstellt(String strErstellt) {
	this.strErstellt = strErstellt;
}

public void setStrTitelbild(String strTitelbild) {
	this.strTitelbild = strTitelbild;
}

public void setStrPortraetbild(String strPortraetbild) {
	this.strPortraetbild = strPortraetbild;
}

public void setStrStudio(String strStudio) {
	this.strStudio = strStudio;
}

public void setStrAlbum(String strAlbum) {
	this.strAlbum = strAlbum;
}

public void setStrDVD(String strDVD) {
	this.strDVD = strDVD;
}

public void setStrPart(String strPart) {
	this.strPart = strPart;
}

public void setStrAnzahlparts(String strAnzahlparts) {
	this.strAnzahlparts = strAnzahlparts;
}

public void setStrBilder(String strBilder) {
	this.strBilder = strBilder;
}

public void setStrThumbs(String strThumbs) {
	this.strThumbs = strThumbs;
}

public void setStrRemastered(String strRemastered) {
	this.strRemastered = strRemastered;
}

public void setStrVR(String strVR) {
	this.strVR = strVR;
}

public void setStrFirst(String strFirst) {
	this.strFirst = strFirst;
}

public void setStrFirstname(String strFirstname) {
	this.strFirstname = strFirstname;
}

public void setStrNear(String strNear) {
	this.strNear = strNear;
}

public void setStrNearname(String strNearname) {
	this.strNearname = strNearname;
}

public void setStrSterne(String strSterne) {
	this.strSterne = strSterne;
}

public String slug_auf_konsole() {
	System.out.println("Pfad: " + strPfad);
	System.out.println("Slug: " + strSlug);
	System.out.println("Titel: " + strTitel);
	System.out.println("Actress: " + strActress);
	System.out.println("Actor: " + strActor);
	System.out.println("Beschreibung: " + strBeschreibung);
	System.out.println("Braz-Nr: " + strBraznr);
	System.out.println("NA-Link: " + strNA);
	System.out.println("Release am: " + strRelease);
	System.out.println("Erstellt am: " + strErstellt);
	System.out.println("Titelbild: " + strTitelbild);
	System.out.println("Porträtbild: " + strPortraetbild);
	System.out.println("Studio: " + strStudio);
	System.out.println("Album: " + strAlbum);
	System.out.println("DVD: " + strDVD);
	System.out.println("Serie: " + strSerie);	
	System.out.println("Part: " + strPart);
	System.out.println("Anzahl-Parts: " + strAnzahlparts);
	System.out.println("Bilder: " + strBilder);
	System.out.println("Thumbs: " + strThumbs);	
	System.out.println("Remastered: " + strRemastered);
	System.out.println("VR: " + strVR);
	System.out.println("First: " + strFirst);
	System.out.println("First-Name: " + strFirstname);
	System.out.println("Near: " + strNear);	
	System.out.println("Near-Name: " + strNearname);
	System.out.println("Sterne: " + strSterne);
	
	return "Slug Daten auf Konsole ausgegeben";
	
}
	
	
/**
 * @param strSlugDateiName [String]
 * @return Text für txtStatuszeile [String]
 */
public String slugDatenLaden(String strSlugDateiName) {
	
	FileWriter writer;
	
	String strRueckgabe = "";
	
	try {
		writer = new FileWriter(strSlugDateiName);
		
		writer.write("#Aus der Gui-Anwendung heraus erstellt.");
		writer.write(System.getProperty("line.separator"));
		// Hier beginnen die Werte
		writer.write("PFAD=\"" + strPfad + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("SLUG=\"" + strSlug + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("TITEL=\"" + strTitel + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("#Mehrere mittels ; (Semikolon) trennen und ohne Leerzeichen nach dem Semikolon");
		writer.write(System.getProperty("line.separator"));
		writer.write("ACTRESS=\"" + strActress + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("ACTOR=\"" + strActor + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("BESCHREIBUNG=\"" + strBeschreibung + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("BRAZNR=\"" + strBraznr + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("NA=\"" + strNA + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("RELEASE=\"" + strRelease + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("ERSTELLT=\"" + strErstellt + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("TITELBILD=\"" + strTitelbild + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("PORTRAETBILD=\"" + strPortraetbild + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("STUDIO=\"" + strStudio + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("ALBUM=\"" + strAlbum + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("DVD=\"" + strDVD + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("#SERIE=\"Dont touch her\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("SERIE=\"" + strSerie + "\"");	
		writer.write(System.getProperty("line.separator"));
		writer.write("PART=\"" + strPart + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("ANZAHLPARTS=\"" + strAnzahlparts + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("BILDER=\"" + strBilder + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("THUMBS=\"" + strThumbs + "\"");	
		writer.write(System.getProperty("line.separator"));
		writer.write("REMASTERED=\"" + strRemastered + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("VR=\"" + strVR + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("FIRST=\"" + strFirst + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("FIRSTNAME=\"" + strFirstname + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("NEAR=\"" + strNear + "\"");	
		writer.write(System.getProperty("line.separator"));
		writer.write("NEARNAME=\"" + strNearname + "\"");
		writer.write(System.getProperty("line.separator"));
		writer.write("STERNE=\"" + strSterne + "\"");
		writer.write(System.getProperty("line.separator"));

		writer.flush();
		writer.close();
		strRueckgabe = "Slug-Datei " + strSlugDateiName + " wurde erfolgreich geschrieben."; 
		return strRueckgabe;
		
	} catch (IOException e) {
		
		strRueckgabe = "Fehler beim Schreiben der Slug-Datei " + strSlugDateiName + "."; 
		e.printStackTrace();
		return strRueckgabe;
	}
} // Ende Funktion slugDatenLaden




/**
 * @param strSlugDateiName
 * @return
 */
public String slugDatenSetzen(String strSlugDateiName) {
	
	String strRueckgabe = "";
	
	try {
		FileInputStream fis = new FileInputStream(strSlugDateiName);
		Properties properties = new Properties();
		properties.load(fis);

		// erstes und Letztes doppelte Anführungszeichen löschen
		// was ist mit abschliessendem Strichpunkt
		// zum Teil heisst das Datenfeld ERSTELLT_AM
		// Fehler bzw. Null-Pointer-Exception, wenn Datenfeld nicht vorhanden
		
		if (properties.getProperty("PFAD") != null) {
			this.setStrPfad(propertiesBereinigen(properties.getProperty("PFAD")));	
		} else {
			JOptionPane.showMessageDialog(null,	"Fehler beim Lesen der Slug-Datei:\n" + strSlugDateiName + "\n\nDie Eigenschaft PFAD existiert nicht.");
			this.setStrErstellt(propertiesBereinigen("bitte ändern"));
		}
		
		
		
		this.setStrSlug(propertiesBereinigen(properties.getProperty("SLUG")));
		this.setStrTitel(propertiesBereinigen(properties.getProperty("TITEL")));
		this.setStrActress(propertiesBereinigen(properties.getProperty("ACTRESS")));
		this.setStrActor(propertiesBereinigen(properties.getProperty("ACTOR")));
		this.setStrBeschreibung(propertiesBereinigen(properties.getProperty("BESCHREIBUNG")));
		
		
		// fehlt das Feld BRAZNR überall, wo es sich um NaughtyAmerica handelt???
		this.setStrBraznr(propertiesBereinigen(properties.getProperty("BRAZNR")));
		this.setStrNA(propertiesBereinigen(properties.getProperty("NA")));
		this.setStrRelease(propertiesBereinigen(properties.getProperty("RELEASE")));
		
		if (properties.getProperty("ERSTELLT") != null ) {
			this.setStrErstellt(propertiesBereinigen(properties.getProperty("ERSTELLT")));
		} else {
			JOptionPane.showMessageDialog(null,	"Fehler beim Lesen der Slug-Datei:\n" + strSlugDateiName + "\n\nDie Eigenschaft ERSTELLT existiert nicht.");
			this.setStrErstellt(propertiesBereinigen(properties.getProperty("ERSTELLT_AM")));
		}
		
		this.setStrTitelbild(propertiesBereinigen(properties.getProperty("TITELBILD")));
		this.setStrPortraetbild(propertiesBereinigen(properties.getProperty("PORTRAETBILD")));
		this.setStrStudio(propertiesBereinigen(properties.getProperty("STUDIO")));
		this.setStrAlbum(propertiesBereinigen(properties.getProperty("ALBUM")));
		this.setStrDVD(propertiesBereinigen(properties.getProperty("DVD")));
		this.setStrSerie(propertiesBereinigen(properties.getProperty("SERIE")));
		this.setStrPart(propertiesBereinigen(properties.getProperty("PART")));
		this.setStrAnzahlparts(propertiesBereinigen(properties.getProperty("ANZAHLPARTS")));
		this.setStrBilder(propertiesBereinigen(properties.getProperty("BILDER")));
		this.setStrThumbs(propertiesBereinigen(properties.getProperty("THUMBS")));
		this.setStrRemastered(propertiesBereinigen(properties.getProperty("REMASTERED")));
		this.setStrVR(propertiesBereinigen(properties.getProperty("VR")));
		this.setStrFirst(propertiesBereinigen(properties.getProperty("FIRST")));
		this.setStrFirstname(propertiesBereinigen(properties.getProperty("FIRSTNAME")));
		this.setStrNear(propertiesBereinigen(properties.getProperty("NEAR")));
		this.setStrNearname(propertiesBereinigen(properties.getProperty("NEARNAME")));
		this.setStrSterne(propertiesBereinigen(properties.getProperty("STERNE")));
		
		strRueckgabe = "Slug-Datei " + strSlugDateiName + " wurde erfolgreich geladen."; 
		return strRueckgabe;
		
	} catch (IOException e) {
		strRueckgabe = "Fehler beim Laden der Slug-Datei " + strSlugDateiName + "."; 
		e.printStackTrace();
		return strRueckgabe;
	}
} // Ende SlugDatenSpeichern

/**
 * @param strProperties
 * @return Bereinigten Wert; Datentyp [String]
 */
public String propertiesBereinigen (String strProperties) {
	
	// Semikolon bzw. Strichpunkt am Ende entfernen
	if (strProperties.endsWith(";")) {
		strProperties = strProperties.substring(0, strProperties.length() - 1);
	}
	
	return strProperties.replaceFirst("^\"", "").replaceAll("\"$", "");
}

	
}
