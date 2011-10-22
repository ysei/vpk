/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk;

import java.util.ArrayList;
import java.util.List;

import com.jsrc.games.vpk.server.Game;
import com.jsrc.games.vpk.server.Unit;

public class GameBuilder {

	public static Game build() {
		List<Unit> units = new ArrayList<Unit>();
		units.add(new Unit(100, 100, 0));
		units.add(new Unit(400, 400, 1.6));
		return new Game(units);
	}
}
