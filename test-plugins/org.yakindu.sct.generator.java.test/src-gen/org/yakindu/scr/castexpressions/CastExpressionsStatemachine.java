package org.yakindu.scr.castexpressions;


public class CastExpressionsStatemachine implements ICastExpressionsStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private double realValue;
		
		public double getRealValue() {
			return realValue;
		}
		
		public void setRealValue(double value) {
			this.realValue = value;
		}
		
		private long intValue;
		
		public long getIntValue() {
			return intValue;
		}
		
		public void setIntValue(long value) {
			this.intValue = value;
		}
		
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_A,
		main_region_B,
		main_region_C,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	public CastExpressionsStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setRealValue((((double) 5)));
		
		sCInterface.setIntValue((((long) 5.5)));
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		enterSequence_main_region_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_A:
				main_region_A_react(true);
				break;
			case main_region_B:
				main_region_B_react(true);
				break;
			case main_region_C:
				main_region_C_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_A:
			return stateVector[0] == State.main_region_A;
		case main_region_B:
			return stateVector[0] == State.main_region_B;
		case main_region_C:
			return stateVector[0] == State.main_region_C;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public double getRealValue() {
		return sCInterface.getRealValue();
	}
	
	public void setRealValue(double value) {
		sCInterface.setRealValue(value);
	}
	
	public long getIntValue() {
		return sCInterface.getIntValue();
	}
	
	public void setIntValue(long value) {
		sCInterface.setIntValue(value);
	}
	
	/* Entry action for state 'B'. */
	private void entryAction_main_region_B() {
		sCInterface.setRealValue((3 * ((long) 5.5)));
	}
	
	/* Entry action for state 'C'. */
	private void entryAction_main_region_C() {
		sCInterface.setRealValue(((long) (((sCInterface.realValue * sCInterface.intValue) * 10.1))));
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		entryAction_main_region_B();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_main_region_C_default() {
		entryAction_main_region_C();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_CastExpressions_main_region__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C */
	private void exitSequence_main_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_A:
			exitSequence_main_region_A();
			break;
		case main_region_B:
			exitSequence_main_region_B();
			break;
		case main_region_C:
			exitSequence_main_region_C();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_CastExpressions_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				exitSequence_main_region_A();
				enterSequence_main_region_B_default();
			}
		}
		return did_transition;
	}
	
	private boolean main_region_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if ((((double) ((sCInterface.getRealValue() * 0.1)))>((long) 1.4) && ((long) ((sCInterface.getRealValue() * sCInterface.getIntValue())))<((double) 100))) {
					exitSequence_main_region_B();
					enterSequence_main_region_C_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_C_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
}
