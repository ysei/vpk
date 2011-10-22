/////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Jose Sebastian Reguera Candal
/////////////////////////////////////////////////////////////////////////////
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
