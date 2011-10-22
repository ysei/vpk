/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
package com.jsrc.games.vpk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.jsrc.games.vpk.server.Game;

public class GameAnimator implements ActionListener {

	public GameAnimator(Game game, com.jsrc.games.vpk.client.Game gameClient, JPanel panel) {
		this.game = game;
		this.gameClient = gameClient;
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game.step();
		gameClient.step();
		panel.repaint();
	}
	
	Game game;
	com.jsrc.games.vpk.client.Game gameClient;
	JPanel panel;
}
