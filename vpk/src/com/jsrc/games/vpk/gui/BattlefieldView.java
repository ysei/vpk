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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import com.jsrc.games.vpk.client.Game;
import com.jsrc.games.vpk.client.Unit;

/**
 * A view of a region within the area of the battle.
 */
@SuppressWarnings("serial")
public class BattlefieldView extends JPanel {
	
	public BattlefieldView() {
		super();
		
		region = new Rectangle2D.Double();
		transform = new AffineTransform();
		scale = 1;
		
		pointSelectionListeners = new ArrayList<PointSelectionListener>();
		
		addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Point2D point = transform.inverseTransform(e.getPoint(), null);
					for (PointSelectionListener l : pointSelectionListeners) {
						l.pointSelected(new PointSelectionEvent(this, point));
					}
				} catch (NoninvertibleTransformException x) {
					throw new RuntimeException(x);
				}
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustTransform();
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.transform(transform);
		for (Unit u : game.getUnits()) {
			g2.draw(new Ellipse2D.Double(u.getX() - 10, u.getY() - 10, 20, 20));
			g2.draw(new Line2D.Double(
					u.getX(), 
					u.getY(), 
					u.getX() + 10 * Math.cos(u.getOrientation()),
					u.getY() + 10 * Math.sin(u.getOrientation())));
		}
	}
			
	public void setGame(Game game) {
		this.game = game;
		adjustTransform();
	}
	
	public Shape getRegion() {
		return (Shape) region.clone();
	}
	
	public void setRegionCenter(Point2D center) {
		Point2D corner = new Point2D.Double(center.getX() + region.getWidth() / 2, 
				                            center.getY() + region.getHeight() / 2);
		region.setFrameFromCenter(center, corner);
		adjustTransform();
	}
	
	public void addPointSelectionListener(PointSelectionListener l) {
		pointSelectionListeners.add(l);
	}
	
	public void removePointSelectionListener(PointSelectionListener l) {
		pointSelectionListeners.remove(l);
	}
	
	private void adjustTransform() {
		transform.setToIdentity();
		transform.scale(1, -1);
		transform.translate(0, -getHeight());
		transform.scale(scale, scale);
		transform.translate(-region.getX(), -region.getY());
		
		region.setRect(region.getX(), region.getY(), 
				getWidth() / scale, getHeight() / scale);
	}
	
	private Game game;
	
	private Rectangle2D.Double region;
	
	private AffineTransform transform;
	
	double scale;
	
	protected List<PointSelectionListener> pointSelectionListeners;
}
