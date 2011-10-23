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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.jsrc.games.vpk.server.Game;

public class GameAnimator implements ActionListener {

	public GameAnimator(Game game, 
			com.jsrc.games.vpk.client.Game gameClient1, 
			com.jsrc.games.vpk.client.Game gameClient2, 
			JPanel panel) {
		this.game = game;
		this.gameClient1 = gameClient1;
		this.gameClient2 = gameClient2;
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game.step();
		gameClient1.step();
		gameClient2.step();
		panel.repaint();
	}
	
	Game game;
	com.jsrc.games.vpk.client.Game gameClient1;
	com.jsrc.games.vpk.client.Game gameClient2;
	JPanel panel;
}
