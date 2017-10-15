package org.fenster.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 * 
 * @author thomas / 09.10.2017
 * @see todo Umschreiben als JOptionPane Information/Message-Fenster
 * Vermutlich nicht in einer eigenen Klasse, sondern direkt im ActionListener im Hauptprogramm TripleX.java
 *
 */
public class VersionsFenster extends JFrame {

	private static final long serialVersionUID = 4530442760640484097L;
	private JPanel contentPane;


	public VersionsFenster() {
		setTitle("Version");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnSchliessen = new JButton("Schliessen");
		btnSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		contentPane.add(btnSchliessen, BorderLayout.SOUTH);
		
		JPanel panel_Version = new JPanel();
		contentPane.add(panel_Version, BorderLayout.CENTER);
		panel_Version.setLayout(null);
		
		
		/*
		 * Versionen der Klasse Versionen
		 * 
		 * Programm selbst
		 * Template.slug
		 * python
		 * xxx.sh
		 * 
		 */
		
		
		JLabel lblVersion = new JLabel("Version:");
		lblVersion.setBounds(102, 73, 70, 15);
		panel_Version.add(lblVersion);
	}
}
