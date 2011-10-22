/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk.client;

public class Unit {

	public Unit(double x, double y, double orientation) {
		this.x = x;
		this.y = y;
		this.speed = 1;
		this.orientation = orientation;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getOrientation() {
		return orientation;
	}
	
	public void step() {		
		x = x + speed * Math.cos(orientation);
		y = y - speed * Math.sin(orientation);
	}
	
	public void moveTo(double x, double y) {
		System.out.println("Unit: Move to " + x + ", " + y);
		
		double dx = x - this.x;
		double dy = - (y - this.y);
		orientation = Math.atan2(dy, dx);
	}
		
	private double x;
	
	private double y;
	
	private double speed;
		
	/** Orientation in radians, 0 is east. */ 
	private double orientation;

}
