/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk.comm;

public class UnitMsg {

	public UnitMsg(double x, double y, double orientation) {
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
	
	public double getSpeed() {
		return speed;
	}
	
	public double getOrientation() {
		return orientation;
	}
			
	private double x;
	
	private double y;
	
	private double speed;
		
	/** Orientation in radians, 0 is east. */ 
	private double orientation;

}
