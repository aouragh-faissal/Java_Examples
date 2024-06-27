package com.demo.annotation;



@TestClass
public class RationalTest {

    @TestMethod
    public void testAddition() {
        Rational r1 = new Rational( 1, 3 );
        Rational r2 = new Rational( 2, 1 );
        Rational result = r1.add( r2 );
        
        Assert.assertEquals( 7,  result.getNumerator() );
        Assert.assertEquals( 3,  result.getDenominator() );
    }

    @TestMethod
    public void testSimply() {
        Rational r = new Rational( 5*7*11*13, 7*11*13*17 );
        Assert.assertEquals( 5,  r.getNumerator() );
        Assert.assertEquals( 17,  r.getDenominator() );
    }
    
    @TestMethod( expected = RuntimeException.class )
    public void testBadDenominator() {
        new Rational( 1, 0 );
    }

}