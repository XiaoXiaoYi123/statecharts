package org.yakindu.sct.generator.c.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/HistoryWithoutInitialStep/HistoryWithoutInitialStepTest.cc",
	program = "gtests/HistoryWithoutInitialStep/HistoryWithoutInitialStep",
	model = "testmodels/SCTUnit/HistoryWithoutInitialStep.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_timer_service.c",
		"libraryTarget/sc_timer_service.h"
	},
	additionalFilesToCompile = {
		"HistoryWithoutInitialStep.c",
		"sc_timer_service.c"
	}
)
@RunWith(GTestRunner.class)
public class HistoryWithoutInitialStepTest {

	protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
