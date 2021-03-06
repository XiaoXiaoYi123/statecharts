
#include "gtest/gtest.h"
#include "StatechartEntryAndExitActions.h"

#include "sc_timer_service.h"

static StatechartEntryAndExitActions statechart;


class StatechartEntryExitActions : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void entryActionsAreExecutedOnEnteringStatechart();
	void exitActionsAreExecutedOnEnteringStatechart();
	void setTimer(StatechartEntryAndExitActions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(StatechartEntryAndExitActions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static StatechartEntryExitActions * tc;


void StatechartEntryExitActions::SetUp()
{
	statechartEntryAndExitActions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &statechartEntryAndExitActions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void StatechartEntryExitActions::entryActionsAreExecutedOnEnteringStatechart()
{
	EXPECT_TRUE(statechartEntryAndExitActionsIface_get_x(&statechart)== 0);
	EXPECT_TRUE(statechartEntryAndExitActionsIface_get_y(&statechart)== 0);
	statechartEntryAndExitActionsIface_set_b(&statechart,true);
	statechartEntryAndExitActions_enter(&statechart);
	EXPECT_TRUE(statechartEntryAndExitActionsIface_get_x(&statechart)== 5);
	EXPECT_TRUE(statechartEntryAndExitActionsIface_get_y(&statechart)== 3);
}
void StatechartEntryExitActions::exitActionsAreExecutedOnEnteringStatechart()
{
	statechartEntryAndExitActions_enter(&statechart);
	statechartEntryAndExitActions_exit(&statechart);
	EXPECT_TRUE(statechartEntryAndExitActionsIface_get_x(&statechart)== 6);
	EXPECT_TRUE(statechartEntryAndExitActionsIface_get_y(&statechart)== 2);
}

void StatechartEntryExitActions::setTimer(StatechartEntryAndExitActions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void StatechartEntryExitActions::unsetTimer(StatechartEntryAndExitActions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(StatechartEntryExitActions, entryActionsAreExecutedOnEnteringStatechart) {
	entryActionsAreExecutedOnEnteringStatechart();
}
TEST_F(StatechartEntryExitActions, exitActionsAreExecutedOnEnteringStatechart) {
	exitActionsAreExecutedOnEnteringStatechart();
}


