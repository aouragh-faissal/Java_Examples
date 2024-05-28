package com.demo.Novelty;

import java.awt.Color;

public class PngImage implements Image {

    @SuppressWarnings("unused")
    private String filename;
    
    public PngImage( String filename ) {
        this.filename = filename;
        load();
    }
    
    @Override
    public void load() {
        System.out.println( "Imagine: PNG image loaded" );
    }

    @Override
    public void save() {
        System.out.println( "Imagine: PNG image saved" );
    }

    @Override
    public Color[][] getBitmap() {
        // TODO Auto-generated method stub
        return null;
    }
}
