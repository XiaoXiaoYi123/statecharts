package org.yakindu.scr.floatmodulo;


public class FloatModuloStatemachine implements IFloatModuloStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private double r;
		
		public double getR() {
			return r;
		}
		
		public void setR(double value) {
			this.r = value;
		}
		
		private long i;
		
		public long getI() {
			return i;
		}
		
		public void setI(long value) {
			this.i = value;
		}
		
	}
	
	protected SCInterfaceImpl sCInterface;
	
	protected class SCIAImpl implements SCIA {
	
		private double r;
		
		public double getR() {
			return r;
		}
		
		public void setR(double value) {
			this.r = value;
		}
		
		private long i;
		
		public long getI() {
			return i;
		}
		
		public void setI(long value) {
			this.i = value;
		}
		
	}
	
	protected SCIAImpl sCIA;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StateA,
		main_region__final_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	public FloatModuloStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCIA = new SCIAImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
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
			case main_region_StateA:
				main_region_StateA_react(true);
				break;
			case main_region__final_:
				main_region__final__react(true);
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
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return (stateVector[0] == State.main_region__final_);
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
		case main_region_StateA:
			return stateVector[0] == State.main_region_StateA;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public SCIA getSCIA() {
		return sCIA;
	}
	
	public double getR() {
		return sCInterface.getR();
	}
	
	public void setR(double value) {
		sCInterface.setR(value);
	}
	
	public long getI() {
		return sCInterface.getI();
	}
	
	public void setI(long value) {
		sCInterface.setI(value);
	}
	
	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_StateA() {
		sCInterface.setR(sCInterface.getR() % sCInterface.r);
		
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCInterface.setR((sCInterface.r % sCInterface.r));
		
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCInterface.setI((sCInterface.i % sCInterface.i));
		
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCInterface.setI(sCInterface.getI() % sCInterface.i);
		
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCInterface.setR((sCInterface.r % sCInterface.i));
		
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCInterface.setR(sCInterface.getR() % sCInterface.i);
		
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCInterface.setR((sCInterface.i % sCInterface.r));
		
		sCInterface.setR(3.4);
		
		sCInterface.setI(2);
		
		sCInterface.setR((sCInterface.i % sCInterface.i));
		
		sCIA.setR(sCIA.getR() % (sCIA.r));
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
		
		sCIA.setR((sCIA.r % sCIA.r));
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
		
		sCIA.setI((sCIA.i % sCIA.i));
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
		
		sCIA.setI(sCIA.getI() % (sCIA.i));
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
		
		sCIA.setR((sCIA.r % sCIA.i));
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
		
		sCIA.setR(sCIA.getR() % (sCIA.i));
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
		
		sCIA.setR((sCIA.i % sCIA.r));
		
		sCIA.setR(3.4);
		
		sCIA.setI(2);
		
		sCIA.setR((sCIA.i % sCIA.i));
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		entryAction_main_region_StateA();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_FloatModulo_main_region__entry_Default();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StateA:
			exitSequence_main_region_StateA();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_FloatModulo_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				exitSequence_main_region_StateA();
				enterSequence_main_region__final__default();
			}
		}
		return did_transition;
	}
	
	private boolean main_region__final__react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
}
