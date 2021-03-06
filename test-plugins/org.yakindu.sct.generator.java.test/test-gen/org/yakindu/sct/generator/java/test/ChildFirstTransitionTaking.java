
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.childfirsttransitiontaking.ChildFirstTransitionTakingStatemachine;
import org.yakindu.scr.childfirsttransitiontaking.ChildFirstTransitionTakingStatemachine.State;	
import org.yakindu.scr.VirtualTimer;

/**
 * Unit TestCase for ChildFirstTransitionTaking
 */
@SuppressWarnings("all")
public class ChildFirstTransitionTaking {
	
	private ChildFirstTransitionTakingStatemachine statemachine;	
	
	
	@Before
	public void childFirstTransitionTaking_setUp() {
		statemachine = new ChildFirstTransitionTakingStatemachine();
		
		statemachine.init();
		
	}

	@After
	public void childFirstTransitionTaking_tearDown() {
		statemachine = null;
		
	}
	
	@Test
	public void testParentTransitionFromSimpleState() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AA));
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_B));
		statemachine.exit();
	}
	
	@Test
	public void testParentTransitionFromOrthogonalChildState() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AA));
		statemachine.getSCInterface().raiseGo();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AB_r1_ABA));
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AB_r2_ABB));
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_B));
		statemachine.exit();
	}
	
	@Test
	public void testParentLocalReactionOnTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AA));
		statemachine.getSCInterface().raiseGo();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AB_r1_ABA));
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AB_r2_ABB));
		statemachine.getSCInterface().raiseGo();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r1_A_r1_AA));
		statemachine.exit();
	}
	
	@Test
	public void testLocalReactionsOnTransitionsParentScope() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r2_C_r_CA_r_CAA));
		assertTrue(statemachine.getCLocalReaction() == 0l);
		assertTrue(statemachine.getCaLocalReaction() == 0l);
		statemachine.getSCInterface().raiseGo();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r2_C_r_CA_r_CAB));
		assertTrue(statemachine.getCLocalReaction() == 1l);
		assertTrue(statemachine.getCaLocalReaction() == 1l);
		statemachine.getSCInterface().raiseGo();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r2_C_r_CA_r_CAA));
		assertTrue(statemachine.getCLocalReaction() == 2l);
		assertTrue(statemachine.getCaLocalReaction() == 2l);
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r2_C_r_CB));
		assertTrue(statemachine.getCLocalReaction() == 3l);
		assertTrue(statemachine.getCaLocalReaction() == 2l);
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.childFirstTransitionTaking_r2_C_r_CA));
		assertTrue(statemachine.getCLocalReaction() == 4l);
		assertTrue(statemachine.getCaLocalReaction() == 2l);
	}
}
