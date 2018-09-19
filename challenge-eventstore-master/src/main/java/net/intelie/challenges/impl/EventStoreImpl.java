package net.intelie.challenges.impl;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import net.intelie.challenges.Event;
import net.intelie.challenges.EventIterator;
import net.intelie.challenges.EventStore;

public class EventStoreImpl implements EventStore {
	
	public List<Event> listEvent;

	public EventStoreImpl(List<Event> listEventConstructor) {
		super();
		listEvent = listEventConstructor;	
	}

	@Override
	public void insert(Event event) {
		listEvent.add(event);		
	}

	@Override
	public void removeAll(String type) {
		listEvent.removeIf(p -> p.type().equals(type));		
	}

	@Override
	public EventIteratorImpl query(String type, long startTime, long endTime) {
		
		 Iterator<Event> iteratorEvent = listEvent.stream()
         .filter(r->r.type().equals(type) && (r.timestamp() >= startTime && r.timestamp() <= endTime))
         .collect(Collectors.toList()).iterator();
		
		return new EventIteratorImpl(iteratorEvent);
	}
}
