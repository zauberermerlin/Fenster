package org.fenster.testversuche;

import javax.swing.JOptionPane;

public class DialogFenster extends javax.swing.JOptionPane{
	private static final long serialVersionUID = -2268113222298728101L;


	
	
	
	// Fenster bzw. Programm starten
	public static void main(String[] args) {
		int rueckgabe;
		
//		JOptionPane.showConfirmDialog(null, "test");
		rueckgabe = JOptionPane.showConfirmDialog(null, "test","Nachricht", INFORMATION_MESSAGE);
		
		// 0 = ja
		// 1 = nein
		// 2 = Abbruch
		System.out.println("Ich wurde gedrückt" + rueckgabe);
		
		JOptionPane.showMessageDialog(null, "Info-Box");
		
	}

}
