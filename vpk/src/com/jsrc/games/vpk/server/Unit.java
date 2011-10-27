/*
 *  Copyright 2011 Jose Sebastian Reguera Candal
 *
 *  This file is part of VPK.
 *
 *  VPK is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  VPK is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with VPK.  If not, see <http://www.gnu.org/licenses/>. 
 */
package com.jsrc.games.vpk.server;

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
		y = y + speed * Math.sin(orientation);
	}
	
	public void moveTo(double x, double y) {
		System.out.println("Unit: Move to " + x + ", " + y);
		
		double dx = x - this.x;
		double dy = y - this.y;
		orientation = Math.atan2(dy, dx);
	}
		
	private double x;
	
	private double y;
	
	private double speed;
		
	/** Orientation in radians, 0 is east. */ 
	private double orientation;
}
