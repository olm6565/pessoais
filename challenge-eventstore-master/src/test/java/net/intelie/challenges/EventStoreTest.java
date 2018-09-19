package net.intelie.challenges;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.intelie.challenges.impl.EventIteratorImpl;
import net.intelie.challenges.impl.EventStoreImpl;

public class EventStoreTest {
	
	@Test
	public void testInsert() {
		
		List<Event> list = new ArrayList<Event>();
		EventStoreImpl eventStore = new EventStoreImpl(list);
		eventStore.insert(new Event("Evento 1" , 123L));
		
		Assert.assertEquals(1,eventStore.listEvent.size());		
	}
	
	@Test
	public void testRemoveAll() {
		
		List<Event> list = new ArrayList<Event>();
		EventStoreImpl eventStore = new EventStoreImpl(list);
		eventStore.insert(new Event("Evento 1" , 123L));
		eventStore.insert(new Event("Evento 2" , 133L));
		eventStore.insert(new Event("Evento 2" , 143L));
		
		Assert.assertEquals(3,eventStore.listEvent.size());		
		
		eventStore.removeAll("Evento 1");		
		
		Assert.assertEquals(2,eventStore.listEvent.size());		
	}
	
	@Test
	public void testQuery() {
		
		List<Event> list = new ArrayList<Event>();
		EventStoreImpl eventStore = new EventStoreImpl(list);
		eventStore.insert(new Event("Evento 1" , 123L));
		eventStore.insert(new Event("Evento 1" , 133L));
		eventStore.insert(new Event("Evento 2" , 143L));
		
		Assert.assertEquals(3,eventStore.listEvent.size());		
		
		EventIteratorImpl iterator = eventStore.query("Evento 1",123L,133L);		
		
		iterator.moveNext();
		Assert.assertEquals("Evento 1" , iterator.current().type());
		Assert.assertEquals(123L , iterator.current().timestamp());
		
		iterator.moveNext();
		Assert.assertEquals("Evento 1" , iterator.current().type());
		Assert.assertEquals(133L , iterator.current().timestamp());
		
		Assert.assertEquals(iterator.moveNext(),false);		
	}

}
