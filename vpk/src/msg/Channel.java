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
package msg;

import java.util.ArrayDeque;
import java.util.Queue;

public class Channel implements Sender, Receiver {
	
	public Channel() {
		queue = new ArrayDeque<Object>();
	}

	@Override
	public Object receive() {
		return queue.poll();
	}

	@Override
	public void send(Object message) {
		queue.add(message);		
	}

	Queue<Object> queue;
}
