#include <string>
#include "gtest/gtest.h"
#include "ExitSequence.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

ExitSequence* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ExitSequenceTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ExitSequence();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			true,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(ExitSequenceTest, exitStatechartFromLeafSlimState) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AA));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	statechart->exit();
	
	EXPECT_TRUE(!statechart->isStateActive(ExitSequence::main_region_A));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitLeafSlimStateByTransition) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AB));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitLeafSlimStateByTransitionFromParent) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_f();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AA));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitStatechartFromLeafSlimOrthogonalState) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AB));
	
	statechart->exit();
	
	EXPECT_TRUE(!statechart->isStateActive(ExitSequence::main_region_A));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitLeafSlimOrthogonaleStateByTransition) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AC));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitLeafSlimOrthogonalStateByTransitionFromParent) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AB));
	
	statechart->getDefaultSCI()->raise_f();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AA));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitStatechartFromLeafSlimDeepState) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AC));
	
	statechart->exit();
	
	EXPECT_TRUE(!statechart->isStateActive(ExitSequence::main_region_A));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 8l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 7l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 6l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitLeafSlimDeepStateByTransition) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AD));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 7l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 6l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitLeafSlimDeepStateByTransitionFromParent) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AC));
	
	statechart->getDefaultSCI()->raise_f();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AA));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 8l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 7l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 6l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 0l));
	
	
}
TEST_F(ExitSequenceTest, exitStatechartFromFatState) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AD));
	
	statechart->exit();
	
	EXPECT_TRUE(!statechart->isStateActive(ExitSequence::main_region_A));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 12l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 7l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 6l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 11l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 8l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 9l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 10l));
	
	
}
TEST_F(ExitSequenceTest, exitFatStateByTransition) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AD));
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AA));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 0l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 7l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 6l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 11l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 8l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 9l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 10l));
	
	
}
TEST_F(ExitSequenceTest, exitFatStateByTransitionFromParent) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AD));
	
	statechart->getDefaultSCI()->raise_f();
	
	EXPECT_TRUE(statechart->isStateActive(ExitSequence::main_region_A_r_AA));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_a_exit()== 12l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aa_exit()== 1l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ab_exit()== 4l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aba_exit()== 2l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_abb_exit()== 3l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ac_exit()== 7l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_aca_exit()== 6l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_acaa_exit()== 5l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ad_exit()== 11l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_ada_exit()== 8l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adb_exit()== 9l));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_adc_exit()== 10l));
	
	
}

	}

