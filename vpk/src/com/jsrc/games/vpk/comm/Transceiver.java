/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
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
