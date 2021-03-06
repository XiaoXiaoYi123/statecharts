#include <string>
#include "gtest/gtest.h"
#include "ShallowHistory.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

ShallowHistory* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ShallowHistoryTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ShallowHistory();
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


TEST_F(ShallowHistoryTest, shallowHistoryTest) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_event1();
	
	runner->proceed_cycles(1);
	
	statechart->getDefaultSCI()->raise_event3();
	
	runner->proceed_cycles(1);
	
	statechart->getDefaultSCI()->raise_event5();
	
	runner->proceed_cycles(1);
	
	statechart->getDefaultSCI()->raise_event7();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->isStateActive(ShallowHistory::mainRegion_State1));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State7__region0_State9));
	
	statechart->getDefaultSCI()->raise_event6();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State7__region0_State9));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State6));
	
	statechart->getDefaultSCI()->raise_event5();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State7__region0_State8));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State7__region0_State9));
	
	statechart->getDefaultSCI()->raise_event2();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State7__region0_State9));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistory::mainRegion_State1));
	
	statechart->getDefaultSCI()->raise_event1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State6));
	
	EXPECT_TRUE(!statechart->isStateActive(ShallowHistory::mainRegion_State1));
	
	statechart->getDefaultSCI()->raise_event5();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State6));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistory::mainRegion_State2__region0_State4__region0_State7__region0_State9));
	
	
}

}

