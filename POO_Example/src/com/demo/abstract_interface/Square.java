package com.demo.abstract_interface;

import java.awt.Point;

public class Square extends Shape {

    private int length;
    
    

	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public Square() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Square(Point center ,  int length) {
		super(center);
		this.length = length;
	}



	@Override
	public String toString() {
		return "Square [length=" + length + ", getCenter()=" + getCenter() + "]";
	}



	@Override 
    public double area() {
        return this.length * this.length;
    }

}
