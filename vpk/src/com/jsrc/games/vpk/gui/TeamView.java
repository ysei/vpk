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
package com.jsrc.games.vpk.gui;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * A view of the units belonging to a team.
 */
@SuppressWarnings("serial")
public class TeamView extends JPanel {
	
	public TeamView() {
		super();
		setBackground(Color.blue);
	}

}
