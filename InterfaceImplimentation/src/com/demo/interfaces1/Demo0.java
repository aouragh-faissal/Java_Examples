package com.demo.interfaces1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Demo0 extends JFrame {

    private static final long serialVersionUID = -4939544011287453046L;
    
    private JButton btnClickMe = new JButton( "Click me!" );
    private JButton btnPushMe = new JButton( "Push me!" );
    private JButton btnActivateMe = new JButton( "Activate me!" );
    
    
    public Demo0() {
        super( "Implémentation d'interface" );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        JPanel contentPane = (JPanel) this.getContentPane();
        // Un FlowLayout permet de positionner les boutons les uns à la suite des autres.
        contentPane.setLayout( new FlowLayout() );
        contentPane.add( btnClickMe );
        contentPane.add( btnPushMe );
        contentPane.add( btnActivateMe );
        
        this.setSize( 400, 200 );
        this.setLocationRelativeTo( null );
    }
    
    
    public static void main( String[] args ) throws Exception {        
        // Try to set Nimbus look and feel
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );

        // Start the demo
        Demo0 demo = new Demo0();
        demo.setVisible( true );
    }
    
}