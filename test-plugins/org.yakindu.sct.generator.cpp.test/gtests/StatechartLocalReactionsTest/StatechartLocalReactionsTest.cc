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
#include "StatechartLocalReactions.h"

TEST(StatemachineTest, statechartLocalReactionsTest) {
	StatechartLocalReactions* statechart = new StatechartLocalReactions();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(StatechartLocalReactions::StatechartLocalReactions_main_region_S1));
	EXPECT_TRUE(statechart->isActive(StatechartLocalReactions::StatechartLocalReactions_region2_a));
	while (statechart->getSCInterface()->get_myInt()< 10) {
		EXPECT_TRUE(statechart->isActive(StatechartLocalReactions::StatechartLocalReactions_region2_a));
		if (statechart->getSCInterface()->get_myInt()%2== 0) {
					EXPECT_TRUE(statechart->isActive(StatechartLocalReactions::StatechartLocalReactions_main_region_S1));
				  }
				else {
					EXPECT_TRUE(statechart->isActive(StatechartLocalReactions::StatechartLocalReactions_main_region_S2));;
				}
		statechart->runCycle();
	}
	delete statechart;
}
