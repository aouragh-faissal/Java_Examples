package com.demo.interfaces1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

//Implémentation de l'interface via une classe normale

public class Demo1 extends JFrame implements ActionListener {

    private static final long serialVersionUID = -4939544011287453046L;
    
    private JButton btnClickMe = new JButton( "Click me!" );
    private JButton btnPushMe = new JButton( "Push me!" );
    private JButton btnActivateMe = new JButton( "Activate me!" );
    
    
    public Demo1() {
        super( "Implémentation d'interface" );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        JPanel contentPane = (JPanel) this.getContentPane();
        // Un FlowLayout permet de positionner les boutons les uns à la suite des autres.
        contentPane.setLayout( new FlowLayout() );
        contentPane.add( btnClickMe );
        contentPane.add( btnPushMe );
        contentPane.add( btnActivateMe );
        
        btnClickMe.addActionListener(this);
        btnPushMe.addActionListener(this);
        btnActivateMe.addActionListener(this);
        
        this.setSize( 400, 200 );
        this.setLocationRelativeTo( null );
    }
    
    
    public static void main( String[] args ) throws Exception {        
        // Try to set Nimbus look and feel
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );

        // Start the demo
        Demo1 demo = new Demo1();
        demo.setVisible( true );
    }


	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(((JButton) event.getSource()).getText());
		
	}
    
}