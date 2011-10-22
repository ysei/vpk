/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk.server;

import java.util.List;

import com.jsrc.games.vpk.comm.MoveMsg;
import com.jsrc.games.vpk.comm.Transceiver;
import com.jsrc.games.vpk.comm.UnitMsg;

public class Game {

	public Game(List<Unit> units) {
		this.units = units;
	}
	
	public List<Unit> getUnits() {
		return units;
	}
	
	public void step() {
		{
			MoveMsg msg;
			while((msg = comm.receiveTC()) != null) {
				moveTo(msg.getX(), msg.getY());
			}
		}
		for (Unit unit : units) {
			unit.step();
		}
		for (Unit unit : units) {
			UnitMsg msg = new UnitMsg(unit.getX(), unit.getY(), unit.getOrientation());
			comm.sendTM(msg);
		}
	}

	public void moveTo(double x, double y) {
		units.get(0).moveTo(x, y);
	}

	public void setComm(Transceiver comm) {
		this.comm = comm;
	}
	
	private List<Unit> units; 
	
	private Transceiver comm;
}
