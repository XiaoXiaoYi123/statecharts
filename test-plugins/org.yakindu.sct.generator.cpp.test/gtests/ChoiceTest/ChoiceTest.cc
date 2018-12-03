#include <string>
#include "gtest/gtest.h"
#include "Choice.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

void initForEventE(sc_boolean valueForC);
void initForEventF(sc_boolean valueForC);
void initForEventG(sc_boolean valueForC);
void initForEventH(sc_boolean valueForC);
Choice* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ChoiceTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new Choice();
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

void initForEventE(sc_boolean valueForC){
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(valueForC);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	
}
void initForEventF(sc_boolean valueForC){
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(valueForC);
	
	statechart->getDefaultSCI()->raise_f();
	
	runner->proceed_cycles(1);
	
	
}
void initForEventG(sc_boolean valueForC){
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(valueForC);
	
	statechart->getDefaultSCI()->raise_g();
	
	runner->proceed_cycles(1);
	
	
}
void initForEventH(sc_boolean valueForC){
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(valueForC);
	
	statechart->getDefaultSCI()->raise_h();
	
	runner->proceed_cycles(1);
	
	
}

TEST_F(ChoiceTest, elseChoiceUsingNonDefaultTransition) {
	
	initForEventE(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	
}
TEST_F(ChoiceTest, elseChoiceUsingDefaultTransition) {
	
	initForEventE(false);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
	
}
TEST_F(ChoiceTest, defaultChoiceUsingNonDefaultTransition) {
	
	initForEventG(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	
}
TEST_F(ChoiceTest, defaultChoiceUsingDefaultTransition) {
	
	initForEventG(false);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
	
}
TEST_F(ChoiceTest, uncheckedChoiceUsingNonDefaultTransition) {
	
	initForEventF(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	
}
TEST_F(ChoiceTest, uncheckedChoiceUsingDefaultTransition) {
	
	initForEventF(false);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
	
}
TEST_F(ChoiceTest, alwaysTrueTransitionInChoice) {
	
	initForEventH(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	
}

	}

