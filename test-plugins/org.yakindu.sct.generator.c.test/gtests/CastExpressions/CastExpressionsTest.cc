
#include "gtest/gtest.h"
#include "CastExpressions.h"

#include "sc_timer_service.h"

static CastExpressions statechart;


class CastExpressionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void CastExpressionTest();
	void setTimer(CastExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(CastExpressions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static CastExpressionsTest * tc;


void CastExpressionsTest::SetUp()
{
	castExpressions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &castExpressions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void CastExpressionsTest::CastExpressionTest()
{
	castExpressions_enter(&statechart);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 5);
	EXPECT_TRUE(castExpressionsIface_get_intValue(&statechart)== 5);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 15);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(castExpressions_isStateActive(&statechart, CastExpressions_main_region_C));
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 757);
}

void CastExpressionsTest::setTimer(CastExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void CastExpressionsTest::unsetTimer(CastExpressions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(CastExpressionsTest, CastExpressionTest) {
	CastExpressionTest();
}


