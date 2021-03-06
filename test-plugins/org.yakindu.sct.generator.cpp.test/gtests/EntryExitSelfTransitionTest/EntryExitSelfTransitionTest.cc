#include <string>
#include "gtest/gtest.h"
#include "EntryExitSelfTransition.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

void init();
EntryExitSelfTransition* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class EntryExitSelfTransitionTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new EntryExitSelfTransition();
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

void init(){
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entries()== 1);
	
	EXPECT_TRUE(statechart->isStateActive(EntryExitSelfTransition::main_region_A__region0_B));
	
	statechart->getDefaultSCI()->set_entries(0);
	
	
}

TEST_F(EntryExitSelfTransitionTest, SelfTransitionToChildState) {
	
	init();
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entries()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exits()== 1);
	
	EXPECT_TRUE(statechart->isStateActive(EntryExitSelfTransition::main_region_A__region0_C));
	
	statechart->exit();
	
	
}
TEST_F(EntryExitSelfTransitionTest, SelfTransitionFromChildState) {
	
	init();
	
	statechart->getDefaultSCI()->raise_e1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entries()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exits()== 0);
	
	EXPECT_TRUE(statechart->isStateActive(EntryExitSelfTransition::main_region_A__region0_C));
	
	statechart->getDefaultSCI()->raise_e1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(EntryExitSelfTransition::main_region_A__region0_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entries()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exits()== 1);
	
	statechart->exit();
	
	
}

}

