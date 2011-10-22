/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
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
