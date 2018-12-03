#include <string>
#include "gtest/gtest.h"
#include "StatechartActive.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

StatechartActive* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class StatechartActiveTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new StatechartActive();
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


TEST_F(StatechartActiveTest, inactiveBeforeEnter) {
	
	EXPECT_TRUE(!statechart->isActive());
	
	
}
TEST_F(StatechartActiveTest, activeAfterEnter) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isActive());
	
	
}
TEST_F(StatechartActiveTest, inactiveAfterExit) {
	
	statechart->enter();
	
	statechart->exit();
	
	EXPECT_TRUE(!statechart->isActive());
	
	
}
TEST_F(StatechartActiveTest, activeAfterReenter) {
	
	statechart->enter();
	
	statechart->exit();
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isActive());
	
	
}

	}

