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

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.jsrc.games.vpk.client.Game;

/**
 * A view that integrates other views in a coherent and coordinated way.
 */
@SuppressWarnings("serial")
public class IntegratedView extends JPanel {

	public IntegratedView() {
		super();

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		battlefieldView = new BattlefieldView();
		battlefieldView.setPreferredSize(new Dimension(600, 600));

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		
		mapView = new MapView();
		mapView.setMinimumSize(new Dimension(200, 200));
		mapView.setPreferredSize(new Dimension(200, 200));
		mapView.setMaximumSize(new Dimension(200, 200));
		
		TeamView teamView = new TeamView();
		teamView.setMinimumSize(new Dimension(200, 200));
		teamView.setPreferredSize(new Dimension(200, 200));
		teamView.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
		
		CommandView commandView = new CommandView();
		commandView.setMinimumSize(new Dimension(200, 200));
		commandView.setPreferredSize(new Dimension(200, 200));
		commandView.setMaximumSize(new Dimension(200, 200));
		
		controlPanel.add(mapView);
		controlPanel.add(teamView);
		controlPanel.add(commandView);
		
		add(battlefieldView);
		add(controlPanel);
		
		battlefieldView.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				mapView.setRegion(battlefieldView.getRegion());				
			}
		});
		
		battlefieldView.addPointSelectionListener(new PointSelectionListener() {
			@Override
			public void pointSelected(PointSelectionEvent e) {
				game.moveTo(e.getPoint().getX(), e.getPoint().getY());
			}
		});
		
		mapView.addPointSelectionListener(new PointSelectionListener() {
			@Override
			public void pointSelected(PointSelectionEvent e) {
				battlefieldView.setRegionCenter(e.getPoint());
				mapView.setRegion(battlefieldView.getRegion());				
			}
		});
	}
	
	public void setGame(Game game) {
		this.game = game;
		battlefieldView.setGame(game);
		mapView.setGame(game);
		mapView.setRegion(battlefieldView.getRegion());
	}
	
	private Game game;
	private BattlefieldView battlefieldView;
	private MapView mapView;
}
