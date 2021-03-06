
#include "gtest/gtest.h"
#include "ExitOnSelfTransition.h"

#include "sc_timer_service.h"

static ExitOnSelfTransition statechart;


class ExitOnSelfTransitionTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void exitOnSelfTransitionTest();
	void setTimer(ExitOnSelfTransition* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ExitOnSelfTransition* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ExitOnSelfTransitionTest * tc;


void ExitOnSelfTransitionTest::SetUp()
{
	exitOnSelfTransition_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &exitOnSelfTransition_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ExitOnSelfTransitionTest::exitOnSelfTransitionTest()
{
	exitOnSelfTransition_enter(&statechart);
	EXPECT_TRUE(exitOnSelfTransition_isStateActive(&statechart, ExitOnSelfTransition_main_region_A));
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&statechart)== 1);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&statechart)== 0);
	exitOnSelfTransitionIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&statechart)== 2);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&statechart)== 1);
	exitOnSelfTransitionIface_raise_f(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&statechart)== 2);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&statechart)== 2);
}

void ExitOnSelfTransitionTest::setTimer(ExitOnSelfTransition* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ExitOnSelfTransitionTest::unsetTimer(ExitOnSelfTransition* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ExitOnSelfTransitionTest, ExitOnSelfTransitionTest) {
	exitOnSelfTransitionTest();
}


