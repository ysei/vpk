/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk.comm;

public class MoveMsg {

	public MoveMsg(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	double x;
	
	double y;
}
