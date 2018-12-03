#include <string>
#include "gtest/gtest.h"
#include "SyncFork.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

SyncFork* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class SyncForkTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new SyncFork();
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


TEST_F(SyncForkTest, syncForkTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_A));
	
	statechart->getDefaultSCI()->raise_f();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B));
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B_r1_C1));
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B_r2_D1));
	
	statechart->getDefaultSCI()->raise_f();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B));
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B_r1_C2));
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B_r2_D2));
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_A));
	
	statechart->getDefaultSCI()->raise_f();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B));
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B_r1_C1));
	
	EXPECT_TRUE(statechart->isStateActive(SyncFork::main_region_B_r2_D1));
	
	
}

	}

