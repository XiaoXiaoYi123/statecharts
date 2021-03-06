
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.eventdriventriggeredbyevent.EventDrivenTriggeredByEventStatemachine;
import org.yakindu.scr.eventdriventriggeredbyevent.EventDrivenTriggeredByEventStatemachine.State;	
import org.yakindu.scr.VirtualTimer;

/**
 * Unit TestCase for EventDrivenTriggeredByEvent
 */
@SuppressWarnings("all")
public class EventDrivenTriggeredByEvent {
	
	private EventDrivenTriggeredByEventStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void eventDrivenTriggeredByEvent_setUp() {
		statemachine = new EventDrivenTriggeredByEventStatemachine();
		timer = new VirtualTimer(200);
		statemachine.setTimer(timer);
		
		statemachine.init();
		
	}

	@After
	public void eventDrivenTriggeredByEvent_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void internalEventTriggersRunCycle() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.eventDrivenTriggeredByEvent_main_region_A));
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.eventDrivenTriggeredByEvent_main_region_B));
		assertTrue(statemachine.getX() == 0l);
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.eventDrivenTriggeredByEvent_main_region_A));
		assertTrue(statemachine.getX() == 0l);
		statemachine.exit();
	}
	
	@Test
	public void proceedTimeDoesNotTriggerRunCycle() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.eventDrivenTriggeredByEvent_main_region_A));
		timer.timeLeap(120000);
		assertTrue(statemachine.getX() == 0l);
		statemachine.exit();
	}
}
