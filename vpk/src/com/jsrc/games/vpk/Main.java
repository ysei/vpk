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

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.jsrc.games.vpk.comm.Transceiver;
import com.jsrc.games.vpk.gui.IntegratedView;
import com.jsrc.games.vpk.server.Game;

/**
 * The Main class that runs the game.
 */
public class Main {

	/**
	 * Initializes and runs the game.
	 * @param args The arguments.
	 */
	public static void main(String[] args) {
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					createAndShowGUI();
				}			
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates and shows the GUI.
	 * TODO Better comment.
	 */
	protected static void createAndShowGUI() {
		JFrame frame = new JFrame("VPK");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		IntegratedView gamePanel = new IntegratedView();
		
		frame.setContentPane(gamePanel);
		frame.pack();
		frame.setVisible(true);

		Transceiver rxtx = new Transceiver();
		Game game = GameBuilder.build();
		game.setComm(rxtx);
		com.jsrc.games.vpk.client.Game gameClient = new com.jsrc.games.vpk.client.Game();
		gameClient.setComm(rxtx);
		gamePanel.setGame(gameClient);
		
		Timer timer = new Timer(50, new GameAnimator(game, gameClient, gamePanel));
		timer.start();
	}
}
