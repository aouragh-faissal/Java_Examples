package com.demo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Start4 {

	public static void main( String[] args ) throws Exception {
		
        // On monte le scénario de tests
        Sut sut = new Sut();
        boolean result = sut.methodToTest( true );

        // On vérifie le résultat produit
        assert result == false;
        
        // On vérifie l'état interne du composant en test
        Class<Sut> metadata = Sut.class;
        Field probe = metadata.getDeclaredField( "stateToVerify" );
        probe.setAccessible( true );
        boolean value = probe.getBoolean( sut );    // <- ne marche pas
        assert value == true;
        
        
        System.out.println("\n*********************************************\n");
        
        
        Method doSomethingMethod = metadata.getDeclaredMethod( "doSomething", int.class, int.class );
        doSomethingMethod.setAccessible( true );
        doSomethingMethod.invoke( sut, 10, 20 );

	}

}
