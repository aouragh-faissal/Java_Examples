package com.demo.reflection;

class Sut {
    
    private boolean stateToVerify = false;
    
    public boolean methodToTest( boolean input ) {
        stateToVerify = true;
        return ! input;
    }
    
    private void doSomething( int a, int b ) {
        System.out.println( "On passe bien dans la méthode privée" );
        System.out.println( "avec a == " + a + " et b == " + b );
    }
}
