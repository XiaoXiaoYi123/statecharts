
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.valuedevents.ValuedEventsStatemachine;
import org.yakindu.scr.valuedevents.ValuedEventsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ValuedEvents
 */
@SuppressWarnings("all")
public class ValuedEvents {
	
	private ValuedEventsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void valuedEvents_setUp() {
		statemachine = new ValuedEventsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void valuedEvents_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void valuedEventsTest() {
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.getMyString().equals("sct"));
		statemachine.getSCInterface().raiseIntegerEvent(23l);
		statemachine.getSCInterface().raiseBooleanEvent(false);
		statemachine.getSCInterface().raiseRealEvent(20l);
		statemachine.getSCInterface().raiseStringEvent("tool");
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.integer_region_D));
		assertTrue(statemachine.isStateActive(State.string_region_D));
		assertTrue(statemachine.isStateActive(State.boolean_region_D));
		assertTrue(statemachine.isStateActive(State.real_region_D));
		assertTrue(statemachine.getMyInt() == 23l);
		assertTrue(statemachine.getMyBool() == false);
		assertTrue(statemachine.getMyReal() == 20l);
		assertTrue(statemachine.getMyString().equals("tool"));
	}
}
