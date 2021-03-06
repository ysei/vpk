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


import com.jsrc.games.vpk.geo.Map;
import com.jsrc.games.vpk.gui.IntegratedView;
import com.jsrc.games.vpk.msg.Context;
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

		Context context = new Context();
		context.createChannel("tm1");
		context.createChannel("tc1");
		context.createChannel("tm2");
		context.createChannel("tc2");
		
		Game game = GameBuilder.build();
		game.addTm(context.getSender("tm1"));
		game.addTc(context.getReceiver("tc1"));
		game.addTm(context.getSender("tm2"));
		game.addTc(context.getReceiver("tc2"));
		
		com.jsrc.games.vpk.client.Game gameClient1 = new com.jsrc.games.vpk.client.Game();
		gameClient1.setMap(new Map());
		gameClient1.setTm(context.getReceiver("tm1"));
		gameClient1.setTc(context.getSender("tc1"));
		gamePanel.setGame(gameClient1);
		
		com.jsrc.games.vpk.client.Game gameClient2 = new com.jsrc.games.vpk.client.Game();
		gameClient2.setTm(context.getReceiver("tm2"));
		gameClient2.setTc(context.getSender("tc2"));
		//ai.setGame(gameClient2);
		
		Timer timer = new Timer(50, new GameAnimator(gameClient1, gameClient2, gamePanel));
		timer.start();
		game.start();
	}
}
