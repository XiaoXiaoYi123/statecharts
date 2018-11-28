/* Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "StateIsActive.h"

#include "sc_timer_service.h"

static StateIsActive statechart;



//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;
			
class StateIsActiveTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		stateIsActive_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			0,
			(sc_run_cycle_fp) &stateIsActive_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(StateIsActiveTest, stateIsActive) {
	
	stateIsActive_enter(&statechart);
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R1_R1A));
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R2_R2A));
	stateIsActiveIface_raise_event1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R1_R1B));
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R2_R2B));
}


