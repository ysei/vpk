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

import java.util.Collection;
import java.util.TreeMap;

import com.jsrc.games.vpk.comm.MoveMsg;
import com.jsrc.games.vpk.comm.UnitMsg;
import com.jsrc.games.vpk.geo.Map;
import com.jsrc.games.vpk.msg.Receiver;
import com.jsrc.games.vpk.msg.Sender;

public class Game {

	public Game() {
		units = new TreeMap<Integer, Unit>();
	}
	
	public Collection<Unit> getUnits() {
		return units.values();
	}
	
	public void step() {
		UnitMsg msg;
		while ((msg = (UnitMsg)tm.receive()) != null) {
			if (units.containsKey(msg.getId())) {
				units.get(msg.getId()).updateFromMsg(msg);
			} else {
				units.put(msg.getId(), Unit.createFromMsg(msg));
			}
		}
	}

	public void moveTo(double x, double y) {
		tc.send(new MoveMsg(x, y));
	}
	
	public void setTc(Sender tc) {
		this.tc = tc;
	}

	public void setTm(Receiver tm) {
		this.tm = tm;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	public Map getMap() {
		return map;
	}
	
	private Map map;
	
	private java.util.Map<Integer, Unit> units;
	
	private Sender tc; 
	private Receiver tm;
}
