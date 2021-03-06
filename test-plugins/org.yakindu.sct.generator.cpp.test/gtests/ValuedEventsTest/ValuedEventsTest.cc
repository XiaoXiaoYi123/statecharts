#include <string>
#include "gtest/gtest.h"
#include "ValuedEvents.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

ValuedEvents* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ValuedEventsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ValuedEvents();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(ValuedEventsTest, valuedEventsTest) {
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "sct") == 0);
	
	statechart->getDefaultSCI()->raise_integerEvent( 23);
	
	statechart->getDefaultSCI()->raise_booleanEvent( false);
	
	statechart->getDefaultSCI()->raise_realEvent( 20);
	
	statechart->getDefaultSCI()->raise_stringEvent((sc_string) "tool");
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ValuedEvents::integer_region_D));
	
	EXPECT_TRUE(statechart->isStateActive(ValuedEvents::string_region_D));
	
	EXPECT_TRUE(statechart->isStateActive(ValuedEvents::boolean_region_D));
	
	EXPECT_TRUE(statechart->isStateActive(ValuedEvents::real_region_D));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 23);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 20);
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "tool") == 0);
	
	
}

}

