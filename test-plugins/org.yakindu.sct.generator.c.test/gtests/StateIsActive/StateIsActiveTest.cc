
#include "gtest/gtest.h"
#include "StateIsActive.h"

#include "sc_timer_service.h"

static StateIsActive statechart;


class StateIsActiveTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void stateIsActive();
	void setTimer(StateIsActive* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(StateIsActive* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static StateIsActiveTest * tc;


void StateIsActiveTest::SetUp()
{
	stateIsActive_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &stateIsActive_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void StateIsActiveTest::stateIsActive()
{
	stateIsActive_enter(&statechart);
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R1_R1A));
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R2_R2A));
	stateIsActiveIface_raise_event1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R1_R1B));
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R2_R2B));
}

void StateIsActiveTest::setTimer(StateIsActive* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void StateIsActiveTest::unsetTimer(StateIsActive* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(StateIsActiveTest, stateIsActive) {
	stateIsActive();
}


