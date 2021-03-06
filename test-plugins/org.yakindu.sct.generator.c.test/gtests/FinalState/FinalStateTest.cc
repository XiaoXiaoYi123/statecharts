
#include "gtest/gtest.h"
#include "FinalState.h"

#include "sc_timer_service.h"

static FinalState statechart;


class FinalStateTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void StatechartNameTest();
	void setTimer(FinalState* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(FinalState* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static FinalStateTest * tc;


void FinalStateTest::SetUp()
{
	finalState_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &finalState_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void FinalStateTest::StatechartNameTest()
{
	finalState_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(finalState_isFinal(&statechart));
}

void FinalStateTest::setTimer(FinalState* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void FinalStateTest::unsetTimer(FinalState* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(FinalStateTest, StatechartNameTest) {
	StatechartNameTest();
}


