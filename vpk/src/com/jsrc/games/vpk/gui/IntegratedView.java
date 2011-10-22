/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk.gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.jsrc.games.vpk.client.Game;

@SuppressWarnings("serial")
public class IntegratedView extends JPanel {

	public IntegratedView() {
		super();

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		battlefieldView = new BattlefieldView();
		battlefieldView.setPreferredSize(new Dimension(600, 600));

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		
		MapView mapView = new MapView();
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
	}
	
	public void setGame(Game game) {
		battlefieldView.setGame(game);
	}
	
	private BattlefieldView battlefieldView;
}
