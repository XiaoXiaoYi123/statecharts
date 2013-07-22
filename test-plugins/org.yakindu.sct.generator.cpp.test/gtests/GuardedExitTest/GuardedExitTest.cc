/**
* Copyright (c) 2013 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include <string>
#include "gtest/gtest.h"
#include "GuardedExit.h"

TEST(StatemachineTest, ExitTaken) {
	GuardedExit* statechart = new GuardedExit();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(GuardedExit::GuardedExit_main_region_A));
	EXPECT_TRUE(!statechart->getSCInterface()->get_guard());
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(GuardedExit::GuardedExit_main_region_B));
	EXPECT_TRUE(!statechart->getSCInterface()->get_done());
	delete statechart;
}
TEST(StatemachineTest, ExitNotTaken) {
	GuardedExit* statechart = new GuardedExit();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(GuardedExit::GuardedExit_main_region_A));
	statechart->getSCInterface()->set_guard(true);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(GuardedExit::GuardedExit_main_region_B));
	EXPECT_TRUE(statechart->getSCInterface()->get_done());
	delete statechart;
}
