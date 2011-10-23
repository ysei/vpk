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
package com.jsrc.games.vpk.comm;

import java.util.ArrayDeque;
import java.util.Queue;

public class Transceiver {

	public Transceiver() {
		tm = new ArrayDeque<UnitMsg>();
		tc = new ArrayDeque<MoveMsg>();
	}
	
	public void sendTM(UnitMsg msg) {
		tm.add(msg);
	}
	
	public UnitMsg receiveTM() {
		return tm.poll();
	}
	
	public void sendTC(MoveMsg msg) {
		tc.add(msg);
	}
	
	public MoveMsg receiveTC() {
		return tc.poll();
	}
	
	private Queue<UnitMsg> tm;

	private Queue<MoveMsg> tc;
}
