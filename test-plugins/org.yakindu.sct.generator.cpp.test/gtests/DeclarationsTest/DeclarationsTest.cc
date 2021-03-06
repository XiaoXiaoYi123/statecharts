#include <string>
#include "gtest/gtest.h"
#include "Declarations.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

Declarations* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class DeclarationsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new Declarations();
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


TEST_F(DeclarationsTest, declarationsTest) {
	
	statechart->enter();
	
	
}

}

