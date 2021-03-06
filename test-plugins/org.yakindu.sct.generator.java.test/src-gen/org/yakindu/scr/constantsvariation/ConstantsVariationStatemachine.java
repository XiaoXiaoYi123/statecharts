package org.yakindu.scr.constantsvariation;


public class ConstantsVariationStatemachine implements IConstantsVariationStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		public boolean getB2() {
			return b2;
		}
		
		public String getStr2() {
			return str2;
		}
		
		public double getR2() {
			return r2;
		}
		
		public long getI2() {
			return i2;
		}
		
	}
	
	protected SCInterfaceImpl sCInterface;
	
	protected class SCINamedImpl implements SCINamed {
	
		public boolean getB() {
			return b;
		}
		
		public String getStr() {
			return str;
		}
		
		public double getR() {
			return r;
		}
		
		public long getI() {
			return i;
		}
		
	}
	
	protected SCINamedImpl sCINamed;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StateA,
		main_region__final_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	protected boolean getB() {
		return b;
	}
	
	protected String getStr() {
		return str;
	}
	
	protected double getR() {
		return r;
	}
	
	protected long getI() {
		return i;
	}
	
	public ConstantsVariationStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCINamed = new SCINamedImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
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
	
	public SCINamed getSCINamed() {
		return sCINamed;
	}
	
	public boolean getB2() {
		return sCInterface.getB2();
	}
	
	public String getStr2() {
		return sCInterface.getStr2();
	}
	
	public double getR2() {
		return sCInterface.getR2();
	}
	
	public long getI2() {
		return sCInterface.getI2();
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
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
		react_ConstantsVariation_main_region__entry_Default();
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
	private void react_ConstantsVariation_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if ((((((((((((getB()==true && (getStr()== null?"String" ==null :getStr().equals("String"))) && getR()==5) && getI()==5) && sCInterface.getB2()==true) && (sCInterface.getStr2()== null?"String" ==null :sCInterface.getStr2().equals("String"))) && sCInterface.getR2()==5) && sCInterface.getI2()==5) && sCINamed.getB()==true) && (sCINamed.getStr()== null?"String" ==null :sCINamed.getStr().equals("String"))) && sCINamed.getR()==5) && sCINamed.getI()==5)) {
					exitSequence_main_region_StateA();
					enterSequence_main_region__final__default();
				} else {
					did_transition = false;
				}
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
