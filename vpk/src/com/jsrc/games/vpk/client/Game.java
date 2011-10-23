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
