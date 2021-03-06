
#include "gtest/gtest.h"
#include "LogicalOr.h"

#include "sc_timer_service.h"

static LogicalOr statechart;


class LogicalOrTests : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void operandEvaluationOrder();
	void setTimer(LogicalOr* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(LogicalOr* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static LogicalOrTests * tc;


void LogicalOrTests::SetUp()
{
	logicalOr_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &logicalOr_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void LogicalOrTests::operandEvaluationOrder()
{
	logicalOr_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(logicalOrIface_get_x(&statechart)== 4 && logicalOrIface_get_b(&statechart)) << "logical or expression was executed in wrong order..." ;
}

void LogicalOrTests::setTimer(LogicalOr* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void LogicalOrTests::unsetTimer(LogicalOr* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(LogicalOrTests, operandEvaluationOrder) {
	operandEvaluationOrder();
}


