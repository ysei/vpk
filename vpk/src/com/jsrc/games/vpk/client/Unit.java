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
package com.jsrc.games.vpk.client;

import com.jsrc.games.vpk.comm.UnitMsg;

public class Unit {
	
	public static Unit createFromMsg(UnitMsg msg) {
		Unit u = new Unit(msg.getId(), msg.getX(), msg.getY(), msg.getOrientation());
		return u;
	}
	
	public void updateFromMsg(UnitMsg msg) {
		x = msg.getX();
		y = msg.getY();
		orientation = msg.getOrientation();
	}

	public Unit(int id, double x, double y, double orientation) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	public int getId() {
		return id;
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
		
	private int id;
		
	private double x;
	
	private double y;
			
	/** Orientation in radians, 0 is east. */ 
	private double orientation;

}
