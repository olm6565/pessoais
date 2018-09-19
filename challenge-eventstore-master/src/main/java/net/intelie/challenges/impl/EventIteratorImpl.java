package net.intelie.challenges.impl;

import java.util.Iterator;

import net.intelie.challenges.Event;
import net.intelie.challenges.EventIterator;

public class EventIteratorImpl implements EventIterator {
	
	Iterator<Event> iteratorEvent;
	Event event = null;
	
	public EventIteratorImpl(Iterator<Event> iterator) {
		super();
		iteratorEvent = iterator;
	}

	@Override
	public void close() throws Exception {
		
	}

	@Override
	public boolean moveNext() {
		if (iteratorEvent.hasNext()) {
			event = iteratorEvent.next();
			return true;
		}
		return false;
	}

	@Override
	public Event current() {
		return event;
	}

	@Override
	public void remove() {
		if (event != null) {
			iteratorEvent.remove();		
			event = null;
		}
	}

}
