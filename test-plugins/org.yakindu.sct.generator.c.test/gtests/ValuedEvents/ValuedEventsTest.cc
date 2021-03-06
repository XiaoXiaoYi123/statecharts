
#include "gtest/gtest.h"
#include "ValuedEvents.h"

#include "sc_timer_service.h"

static ValuedEvents statechart;


class ValuedEventsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void valuedEventsTest();
	void setTimer(ValuedEvents* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ValuedEvents* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ValuedEventsTest * tc;


void ValuedEventsTest::SetUp()
{
	valuedEvents_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &valuedEvents_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ValuedEventsTest::valuedEventsTest()
{
	valuedEvents_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&statechart), "sct") == 0);
	valuedEventsIface_raise_integerEvent(&statechart, 23);
	valuedEventsIface_raise_booleanEvent(&statechart, false);
	valuedEventsIface_raise_realEvent(&statechart, 20);
	valuedEventsIface_raise_stringEvent(&statechart, (sc_string)"tool");
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_integer_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_string_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_boolean_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_real_region_D));
	EXPECT_TRUE(valuedEventsIface_get_myInt(&statechart)== 23);
	EXPECT_TRUE(valuedEventsIface_get_myBool(&statechart)== false);
	EXPECT_TRUE(valuedEventsIface_get_myReal(&statechart)== 20);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&statechart), "tool") == 0);
}

void ValuedEventsTest::setTimer(ValuedEvents* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ValuedEventsTest::unsetTimer(ValuedEvents* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ValuedEventsTest, valuedEventsTest) {
	valuedEventsTest();
}


