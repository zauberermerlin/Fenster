package org.fenster.model;

/**
 * 
 * @author thomas / 09.10.2017
 * <p></p>
 * Aufgabe der Klasse ist es, die Versionen zu "holen" und in einem String zur Verfügung zu stellen.
 * <p></p>
 * <li>Programm selbst
 * <li>Template.slug
 * <li>python/mp4
 * <li>xxx.sh
 * <li>konfig_comboboxen.xml
 * <li>konfig.txt
 * 
 */
public class Versionen {

	// aus der Klasse SlugDaten.java als statische Funktionen
	String versionSlug = SlugDaten.getVersion();
	String versionsdatumSlug = SlugDaten.getVersionsdatum();

	
//	System.out.println(System.getProperty("os.name")); //Windows XP
//	System.out.println(System.getProperty("os.arch")); //x86
//	System.out.println(System.getProperty("os.version")); //5.1
}
