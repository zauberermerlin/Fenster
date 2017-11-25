package org.fenster.model;



public class ExifDaten {

	private String strDatei;
	
	private String strTitle;
	private String strLabel;
	private String strXpauthor;
	private String strKeywords;
	private String strPersoninimage;
	private String strXpcomment;
	private String strCaptionAbstract;
	private String strDescription;
	
	
	public String getStrDatei() {
		return strTitle;
	}


	public void setStrDatei(String strDatei) {
		this.strDatei = strDatei;
	}
	
	
	public String getStrTitle() {
		return strTitle;
	}


	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
		System.out.println(strTitle);
	}


	public String getStrLabel() {
		return strLabel;
	}


	public void setStrLabel(String strLabel) {
		this.strLabel = strLabel;
	}


	public String getStrXpauthor() {
		return strXpauthor;
	}


	public void setStrXpauthor(String strXpauthor) {
		this.strXpauthor = strXpauthor;
	}


	public String getStrKeywords() {
		return strKeywords;
	}


	public void setStrKeywords(String strKeywords) {
		this.strKeywords = strKeywords;
	}


	public String getStrPersoninimage() {
		return strPersoninimage;
	}


	public void setStrPersoninimage(String strPersoninimage) {
		this.strPersoninimage = strPersoninimage;
	}


	public String getStrXpcomment() {
		return strXpcomment;
	}


	public void setStrXpcomment(String strXpcomment) {
		this.strXpcomment = strXpcomment;
	}


	public String getStrCaptionAbstract() {
		return strCaptionAbstract;
	}


	public void setStrCaptionAbstract(String strCaptionAbstract) {
		this.strCaptionAbstract = strCaptionAbstract;
	}


	public String getStrDescription() {
		return strDescription;
	}


	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}


	public String getStrImageDescription() {
		return strImageDescription;
	}


	public void setStrImageDescription(String strImageDescription) {
		this.strImageDescription = strImageDescription;
	}


	public String getStrDateTimeOriginal() {
		return strDateTimeOriginal;
	}


	public void setStrDateTimeOriginal(String strDateTimeOriginal) {
		this.strDateTimeOriginal = strDateTimeOriginal;
	}

	private String strImageDescription;
	private String strDateTimeOriginal;
	

	public String ExifDatenAusDateiLaden(String strDatei) {
		return "Fertig Exif Laden";
	}

	public String ExifDatenDateiErzeugen(String strDatei) {
		return "Fertig";
	}

	public Boolean SlugDateiVorhanden(String strDatei) {
		
		return true;
	}
	
	
	public void ExifDatenBerechnen() {
		
	}
	
	
	public void ExifDatenAnzeigen() {
		
	}
	
	public Boolean ExifDatenAufBilderAnwenden() {
		
		return true;
	}
	
} // Ende der Klasse ExifDaten


//##############################
//# Mo 20. Nov 14:06:17 CET 2017
//##############################
//
//# exiftool -overwrite_original -@ slug.exif bilder.jpg
//
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
