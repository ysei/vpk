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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import com.jsrc.games.vpk.client.Game;
import com.jsrc.games.vpk.client.Unit;

@SuppressWarnings("serial")
public class BattlefieldView extends JPanel {
	
	public BattlefieldView() {
		super();
		enableEvents(MouseEvent.MOUSE_CLICKED);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
				
		g2.scale(1, -1);
		g2.translate(0, -getHeight());
		
		for (Unit u : game.getUnits()) {
			g2.draw(new Ellipse2D.Double(u.getX(), u.getY(), 20, 20));
		}
	}
	
	@Override
	protected void processMouseEvent(MouseEvent e) {
		super.processMouseEvent(e);
		if (e.getID() == MouseEvent.MOUSE_CLICKED) {
			game.moveTo(e.getX(), e.getY());
		}
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	private Game game;

}
