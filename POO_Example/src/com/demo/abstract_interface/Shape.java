package com.demo.abstract_interface;

import java.awt.Point;

abstract public class Shape /* extends Object */ {

    // --- The center attribute ---
    private Point center;
    
    // --- 2 constructors ---
    public Shape() {
        this( new Point( 0, 0 ) );
    }
    
    public Shape( Point center ) {
        // super();     // Appel au constructeur parent sous-entendu
        this.setCenter( center );
    }
      
    // --- The center property ---
    public Point getCenter() {
        return center;
    }
    
    public void setCenter( Point center ) {
        if ( center == null ) {
            throw new NullPointerException( "center parameter cannot be null" );
        }
        this.center = center;
    }
    
    // --- An abstract method for compute the area of the shape ---
    public abstract double area();
    
    // --- A method for compute a shape representation string ---
    @Override 
    public String toString() {
        return "Unknown shape placed at " + center;
    }
    
}