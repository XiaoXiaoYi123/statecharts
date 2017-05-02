/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include "gtest/gtest.h"
#include "ConditionalExpressions.h"

ConditionalExpressions handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		conditionalExpressions_init(&handle);
	}
};


TEST_F(StatemachineTest, ConditionalExpressionTest) {					
	conditionalExpressions_enter(&handle);
	EXPECT_TRUE(conditionalExpressions_isStateActive(&handle, ConditionalExpressions_main_region_A));
	EXPECT_TRUE(conditionalExpressionsIface_get_condition(&handle)== 1l);
	conditionalExpressionsIface_raise_e(&handle);
	conditionalExpressions_runCycle(&handle);
	EXPECT_TRUE(conditionalExpressions_isStateActive(&handle, ConditionalExpressions_main_region_B));
	EXPECT_TRUE(conditionalExpressionsIface_get_condition(&handle)== 2l);
}


