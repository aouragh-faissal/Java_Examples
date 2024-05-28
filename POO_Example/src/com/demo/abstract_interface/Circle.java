package com.demo.abstract_interface;

import java.awt.Point;

public class Circle extends Shape {

	 private double radius;
	 
	 

	public Circle(double radius) {
		super();
		this.radius = radius;
	}



	public double getRadius() {
		return radius;
	}


	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Circle(Point center , double radius) {
		super(center);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getCenter()=" + getCenter() + "]";
	}



	@Override 
	    public double area() {
	        return Math.PI * this.radius * this.radius;
	    }

}
