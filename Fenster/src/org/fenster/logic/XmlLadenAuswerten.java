package org.fenster.logic;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

import org.jsoup.*;

public class XmlLadenAuswerten {

	public static void main(String[] args) throws IOException {

		File fdatei = new File("konfig_comboboxen.xml");
		if (fdatei.exists()){
		
		Document doc = Jsoup.parse(fdatei, "UTF-8");
		Element element = doc.select("studio").first();

		System.out.println(element.text());
//		System.out.println(element.nextElementSibling());
//		System.out.println(element.nextElementSibling().nextElementSibling().text());
		
		
		Elements elementsStudio = doc.select("eintrag > studio");
		Elements elementsAlbum = doc.select("auswahl > album");

		// studio: 6
		// Studio: -> braz -> 7
		System.out.println(elementsStudio.size());
		System.out.println(elementsAlbum.size());
		
		//erster Eintrag
		Element elementStudioNeu = doc.select("studio").get(0);
		Elements elementsAlbumNeu = doc.select("auswahl.2 > album");
		
		System.out.println("StudioNeu: 1: " + elementStudioNeu.text());
		
		for(int i=0;i<elementsAlbumNeu.size();i++){
			Element elementStudio = doc.select("auswahl.2 > album").get(i);
			System.out.println(elementStudio.text());
		}
		
		
		
		} // Ende if
	}

}
