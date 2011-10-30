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
package com.jsrc.games.vpk.msg;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class allows to create communication channels.
 */
public class Context {

	/**
	 * Constructor.
	 */
	public Context() {
		channels = new TreeMap<String, Channel>();
	}
	
	/**
	 * Creates a new channel identified by the name.
	 * @param name The name of the new channel.
	 */
	public void createChannel(String name) {
		channels.put(name, new Channel());
	}
	
	/**
	 * Returns the sender end-point of the channel with the given name.
	 * @param name The name of the channel.
	 * @return The sender end-point of the channel with the given name.
	 */
	public Sender getSender(String name) {
		return channels.get(name);
	}
	
	/**
	 * Returns the receiver end-point of the channel with the given name.
	 * @param name The name of the channel.
	 * @return The receiver end-point of the channel with the given name.
	 */
	public Receiver getReceiver(String name) {
		return channels.get(name);
	}
	
	/** The channels in this context. */
	private Map<String, Channel> channels;
}
