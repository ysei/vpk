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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import com.jsrc.games.vpk.comm.MoveMsg;
import com.jsrc.games.vpk.comm.UnitMsg;
import com.jsrc.games.vpk.msg.Receiver;
import com.jsrc.games.vpk.msg.Sender;

public class Game implements Runnable {

	public Game() {
		units = new ArrayList<Unit>();
		teams = new ArrayList<Team>();
		tmChannels = new ArrayList<Sender>();
		tcChannels = new ArrayList<Receiver>();
	}
	
	public void addUnit(Unit unit) {
		units.add(unit);
	}
	
	public List<Unit> getUnits() {
		return units;
	}
	
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	public void step() {
		{
			MoveMsg msg;
			while((msg = (MoveMsg)tcChannels.get(0).receive()) != null) {
				moveTo(msg.getX(), msg.getY());
			}
		}
		for (Unit unit : units) {
			unit.step();
		}
		for (Sender tm : tmChannels) {
			for (Unit unit : units) {
				UnitMsg msg = new UnitMsg(unit.getId(), unit.getX(), unit.getY(), unit.getOrientation());
				tm.send(msg);
			}
		}
	}

	public void moveTo(double x, double y) {
		units.get(0).moveTo(x, y);
	}

	public void addTm(Sender tm) {
		tmChannels.add(tm);
	}
	
	public void addTc(Receiver tc) {
		tcChannels.add(tc);
	}
	
	public void start() {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(this, 5, 100, TimeUnit.MILLISECONDS);
	}
	
	public void run() {
		step();
	}
	
	private List<Unit> units;
	
	private List<Team> teams;
	
	private List<Sender> tmChannels;

	private List<Receiver> tcChannels;
	
}
