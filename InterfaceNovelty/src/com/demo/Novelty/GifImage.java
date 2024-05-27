package com.demo.Novelty;

import java.awt.Color;

public class GifImage implements Image {
	
    @SuppressWarnings("unused")
    private String filename;
    
    

	public GifImage(String filename) {
		super();
		this.filename = filename;
		load();
	}

    @Override
    public void load() {
        System.out.println( "Imagine: GIF image loaded" );
    }

    @Override
    public void save() {
        System.out.println( "Imagine: GIF image saved" );
    }

    @Override
    public Color[][] getBitmap() {
        // TODO Auto-generated method stub
        return null;
    }

}
