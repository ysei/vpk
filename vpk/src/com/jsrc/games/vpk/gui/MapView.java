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
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import com.jsrc.games.vpk.client.Game;

/**
 * A view of the complete area of the conflict.
 */
@SuppressWarnings("serial")
public class MapView extends JPanel {
	
	public MapView() {
		super();
		region = new Rectangle2D.Double();
		transform = new AffineTransform();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.transform(transform);
		g2.draw(region);
	}
	
	public void setRegion(Shape region) {
		this.region = region;
	}

	public void setGame(Game game) {
		this.game = game;
		adjustTransform();
	}
	
	private void adjustTransform() {
		transform.setToIdentity();
		transform.scale(1, -1);
		transform.translate(0, -getHeight());
		double height = game.getMap().getHeight();
		double width = game.getMap().getWidth();
		transform.scale(getWidth() / width, getHeight() / height);
	}
	
	private Shape region;
	
	private AffineTransform transform;
	
	private Game game;
}
