package com.demo.interfaces4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Demo4 extends JFrame {

    private static final long serialVersionUID = -4939544011287453046L;
    
    private JButton btnClickMe = new JButton( "Click me!" );
    private JButton btnPushMe = new JButton( "Push me!" );
    private JButton btnActivateMe = new JButton( "Activate me!" );
    
    
    public Demo4() {
        super( "Implémentation d'interface" );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        JPanel contentPane = (JPanel) this.getContentPane();
        // Un FlowLayout permet de positionner les boutons les uns à la suite des autres.
        contentPane.setLayout( new FlowLayout() );
        contentPane.add( btnClickMe );
        contentPane.add( btnPushMe );
        contentPane.add( btnActivateMe );
        
        // Enregistrement d'un objet produit grâce à une classe anonyme basée sur
        // l'interface ActionListener. Cet objet peut directement accèder au bouton.   
        btnClickMe.addActionListener( 
        	new ActionListener() {
            @Override public void actionPerformed( ActionEvent event ) {
                btnActivateMe.setText( "First button clicked!" );
               Demo4.this.btnActivateMe.setForeground(Color.GREEN) ;
            }
        } 
        );
        
        this.setSize( 400, 200 );
        this.setLocationRelativeTo( null );
    }
    
    
    public static void main( String[] args ) throws Exception {        
        // Try to set Nimbus look and feel
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );

        // Start the demo
        Demo4 demo = new Demo4();
        demo.setVisible( true );
    }
    
}