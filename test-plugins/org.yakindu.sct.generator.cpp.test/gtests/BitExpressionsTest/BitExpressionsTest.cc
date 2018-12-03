#include <string>
#include "gtest/gtest.h"
#include "BitExpressions.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

BitExpressions* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class BitExpressionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new BitExpressions();
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


TEST_F(BitExpressionsTest, BitExpressions) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(BitExpressions::main_region_StateA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBit1()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBit2()== 7l);
	
	statechart->getDefaultSCI()->raise_e1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(BitExpressions::main_region_StateB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_leftBitshift()== 10l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_rightBitshift()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_complementBitshift()== - 6l );
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseAnd()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseOr()== 7l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseXor()== 2l);
	
	
}

	}

