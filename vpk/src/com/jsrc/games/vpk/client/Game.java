/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk.client;

import java.util.ArrayList;
import java.util.List;

import com.jsrc.games.vpk.comm.MoveMsg;
import com.jsrc.games.vpk.comm.Transceiver;
import com.jsrc.games.vpk.comm.UnitMsg;

public class Game {

	public Game() {
		units = new ArrayList<Unit>();
	}
	
	public List<Unit> getUnits() {
		return units;
	}
	
	public void step() {
		units.clear();
		UnitMsg msg;
		while ((msg = comm.receiveTM()) != null) {
			units.add(new Unit(msg.getX(), msg.getY(), msg.getOrientation()));
		}
	}

	public void moveTo(double x, double y) {
		comm.sendTC(new MoveMsg(x, y));
	}
	
	public void setComm(Transceiver comm) {
		this.comm = comm;
	}

	private List<Unit> units; 
	
	private Transceiver comm;

}
