package org.fenster.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SlugDaten {

	
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
	
	
public String slugSchreiben(String strSlugDateiName) {
	
	FileWriter writer;
	Properties props = new Properties();
	
	String strRueckgabe;
	
//	FileOutputStream fisDatei;
	try {
		writer = new FileWriter(strSlugDateiName);
		writer.write("ERSTELLT=\"" + strErstellt + "\"");
		writer.write(System.getProperty("line.separator"));
		
		writer.flush();
		writer.close();
		strRueckgabe = "Slug-Datei " + strSlugDateiName + " wurde erfolgreich geschrieben."; 
		
//		fisDatei = new FileOutputStream(strSlugDateiName);
//		props.setProperty("PFAD", strPfad);
//		props.setProperty("SLUG", strSlug);
//		props.setProperty("TITEL", strTitel);
//		props.setProperty("ACTRESS", strActress);
//		props.setProperty("ACTOR", strActor);
//		props.setProperty("BESCHREIBUNG", strBeschreibung);
//		props.setProperty("BRAZNR", strBraznr);
//		props.setProperty("NA", strNA);
//		props.setProperty("RELEASE", strRelease);
//		props.setProperty("ERSTELLT", strErstellt);
//		props.setProperty("TITELBILD", strTitelbild);
//		props.setProperty("PORTRAETBILD", strPortraetbild);
//		props.setProperty("STUDIO", strStudio);
//		props.setProperty("ALBUM", strAlbum);
//		props.setProperty("DVD", strDVD);
//		props.setProperty("SERIE", strSerie);	
//		props.setProperty("PART", strPart);
//		props.setProperty("ANZAHLPARTS", strAnzahlparts);
//		props.setProperty("BILDER", strBilder);
//		props.setProperty("THUMBS", strThumbs);	
//		props.setProperty("REMASTERED", strRemastered);
//		props.setProperty("VR", strVR);
//		props.setProperty("FIRST", strFirst);
//		props.setProperty("FIRSTNAME", strFirstname);
//		props.setProperty("Near", strNear);	
//		props.setProperty("NEARNAME", strNearname);
//		props.setProperty("STERNE", strSterne);
//		
//		props.store(fisDatei, null);
	} catch (IOException e) {
		// TODO Automatisch generierter Erfassungsblock
		e.printStackTrace();
	} finally {
		
//		writer.flush();
//		writer.close();
		
	}
	
	
//	props.load(in);
//	in.close();
//	String str = props.getProperty("info");
	
	
	return "Slug-Datei geschrieben.";
}

public String slugLesen(File fSlugDatei) {
	
	
	return "Slug-Daten gelesen";
}


public static String getVersion() {
	return strVersion;
}

public static String getVersionsdatum() {
	return strVersionsdatum;
}

	
}
