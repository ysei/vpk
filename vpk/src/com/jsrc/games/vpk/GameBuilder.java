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
