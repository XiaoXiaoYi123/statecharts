/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java;

/**
 * 
 * Basic event class.
 * 
 * @param <T>
 */
public class Event<T extends Enum<T>> {

	private T id;

	private int offset;

	/**
	 * Creates an event with the given id and an offset. The offset represents
	 * the start index of the events position in the {@link EventVector} of the
	 * statemachine.
	 * 
	 * @param id
	 * @param offset
	 */
	public Event(T id, int offset) {
		this.id = id;
		this.offset = offset;
	}

	/**
	 * Returns the event identifier.
	 * 
	 * @return
	 */
	public T getId() {
		return id;
	}

	/**
	 * Returns the position of the event in the statemachines
	 * {@link EventVector}
	 * 
	 * @return {@code int}
	 */
	public int getIndex() {
		return offset + id.ordinal();
	}
}
