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
			while((msg = comm1.receiveTC()) != null) {
				moveTo(msg.getX(), msg.getY());
			}
		}
		for (Unit unit : units) {
			unit.step();
		}
		for (Unit unit : units) {
			UnitMsg msg = new UnitMsg(unit.getX(), unit.getY(), unit.getOrientation());
			comm1.sendTM(msg);
		}
		for (Unit unit : units) {
			UnitMsg msg = new UnitMsg(unit.getX(), unit.getY(), unit.getOrientation());
			comm2.sendTM(msg);
		}
	}

	public void moveTo(double x, double y) {
		units.get(0).moveTo(x, y);
	}

	public void setComm1(Transceiver comm) {
		this.comm1 = comm;
	}
	public void setComm2(Transceiver comm) {
		this.comm2 = comm;
	}
	
	private List<Unit> units; 
	
	private Transceiver comm1;
	private Transceiver comm2;
}
