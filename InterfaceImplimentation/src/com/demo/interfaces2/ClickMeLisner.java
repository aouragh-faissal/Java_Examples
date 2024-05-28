package com.demo.interfaces2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClickMeLisner  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("clique me");
		
		 // L'objet d'événement sait qui est le générateur de cet événement.
        JButton clickedButton = (JButton) event.getSource();
        
        // Un composant graphique connaît son conteneur de plus haut niveau (la fenêtre).
        Demo2 window = (Demo2) clickedButton.getTopLevelAncestor();
        window.setTitle("Click");
		
	}

}
