package com.demo.Novelty;

import java.awt.Color;

public class JpgImage implements Image{
	
    @SuppressWarnings("unused")
    private String filename;
    
    

	public JpgImage(String filename) {
		super();
		this.filename = filename;
		load();
	}

    @Override
    public void load() {
        System.out.println( "Imagine: JPG image loaded" );
    }

    @Override
    public void save() {
        System.out.println( "Imagine: JPG image saved" );
    }

    @Override
    public Color[][] getBitmap() {
        // TODO Auto-generated method stub
        return null;
    }

}
