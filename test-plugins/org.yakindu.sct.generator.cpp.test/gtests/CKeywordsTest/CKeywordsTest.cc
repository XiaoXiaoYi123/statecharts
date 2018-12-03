#include <string>
#include "gtest/gtest.h"
#include "CKeywords.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

CKeywords* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class CKeywordsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new CKeywords();
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


TEST_F(CKeywordsTest, CKeywordsTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_char));
	
	statechart->getDefaultSCI()->raise_auto();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_loop));
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_loop_switch_case));
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_loop_switch_case_enum_asm));
	
	
}

	}

