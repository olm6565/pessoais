package net.intelie.challenges;

import org.junit.Assert;
import org.junit.Test;

import net.intelie.challenges.impl.EventIteratorImpl;

import java.util.ArrayList;
import java.util.List;


public class EventIteratorTest {
	
	@Test
	public void testIteratorCurrent(){
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(new Event("Evento 1" , 123L));
		listEvent.add(new Event("Evento 2" , 133L));
		listEvent.add(new Event("Evento 3" , 143L));
		
		EventIteratorImpl iterator = new EventIteratorImpl(listEvent.iterator());
		iterator.moveNext();
		Event event = iterator.current();
		
		Assert.assertEquals(event.type(), "Evento 1");
		Assert.assertEquals(event.timestamp(),123L);		
	}
	
	@Test
	public void testIteratorMoveNext(){
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(new Event("Evento 1" , 123L));
		listEvent.add(new Event("Evento 2" , 133L));
		listEvent.add(new Event("Evento 3" , 143L));
		
		EventIteratorImpl iterator = new EventIteratorImpl(listEvent.iterator());
		Boolean iteratorOk = iterator.moveNext();
		Event event = iterator.current();
		
		Assert.assertEquals(iteratorOk,true);
		Assert.assertEquals(event.type(), "Evento 1");
		Assert.assertEquals(event.timestamp(),123L);		
	}
	
	@Test
	public void testIteratorRemove(){
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(new Event("Evento 1" , 123L));
		listEvent.add(new Event("Evento 2" , 133L));
		listEvent.add(new Event("Evento 3" , 143L));
		
		EventIteratorImpl iterator = new EventIteratorImpl(listEvent.iterator());
		iterator.moveNext();
		iterator.remove();
		Event event = iterator.current();		
		Assert.assertNull(event);			
	}
}
