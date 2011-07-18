/*
* generated by Xtext
*/
package org.eclipselabs.mscript.language.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipselabs.mscript.language.services.MscriptGrammarAccess;

public class MscriptParser extends AbstractContentAssistParser {
	
	@Inject
	private MscriptGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipselabs.mscript.language.ui.contentassist.antlr.internal.InternalMscriptParser createParser() {
		org.eclipselabs.mscript.language.ui.contentassist.antlr.internal.InternalMscriptParser result = new org.eclipselabs.mscript.language.ui.contentassist.antlr.internal.InternalMscriptParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getDefinitionAccess().getAlternatives(), "rule__Definition__Alternatives");
					put(grammarAccess.getDataTypeDefinitionAccess().getAlternatives(), "rule__DataTypeDefinition__Alternatives");
					put(grammarAccess.getFunctionDefinitionAccess().getAlternatives_11(), "rule__FunctionDefinition__Alternatives_11");
					put(grammarAccess.getDataTypeSpecifierAccess().getAlternatives(), "rule__DataTypeSpecifier__Alternatives");
					put(grammarAccess.getDataTypeSpecifierAccess().getDefinedTypeAlternatives_0_0(), "rule__DataTypeSpecifier__DefinedTypeAlternatives_0_0");
					put(grammarAccess.getPrimitiveTypeAccess().getAlternatives(), "rule__PrimitiveType__Alternatives");
					put(grammarAccess.getNumericTypeAccess().getAlternatives(), "rule__NumericType__Alternatives");
					put(grammarAccess.getArrayTypeAccess().getAlternatives(), "rule__ArrayType__Alternatives");
					put(grammarAccess.getArrayTypeAccess().getAlternatives_1_0_0(), "rule__ArrayType__Alternatives_1_0_0");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getAlternatives_0(), "rule__LetExpressionVariableDeclaration__Alternatives_0");
					put(grammarAccess.getRelationalExpressionAccess().getAlternatives_1(), "rule__RelationalExpression__Alternatives_1");
					put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
					put(grammarAccess.getMemberFeatureCallAccess().getAlternatives_1(), "rule__MemberFeatureCall__Alternatives_1");
					put(grammarAccess.getArraySubscriptAccess().getAlternatives(), "rule__ArraySubscript__Alternatives");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
					put(grammarAccess.getNumericLiteralAccess().getAlternatives(), "rule__NumericLiteral__Alternatives");
					put(grammarAccess.getFeatureCallAccess().getAlternatives(), "rule__FeatureCall__Alternatives");
					put(grammarAccess.getArrayConstructionOperatorAccess().getAlternatives_2(), "rule__ArrayConstructionOperator__Alternatives_2");
					put(grammarAccess.getUnitNumeratorAccess().getAlternatives(), "rule__UnitNumerator__Alternatives");
					put(grammarAccess.getUnitDenominatorAccess().getAlternatives(), "rule__UnitDenominator__Alternatives");
					put(grammarAccess.getValidIntegerAccess().getAlternatives(), "rule__ValidInteger__Alternatives");
					put(grammarAccess.getAssertionStatusKindAccess().getAlternatives(), "rule__AssertionStatusKind__Alternatives");
					put(grammarAccess.getEqualityOperatorAccess().getAlternatives(), "rule__EqualityOperator__Alternatives");
					put(grammarAccess.getRelationalOperatorAccess().getAlternatives(), "rule__RelationalOperator__Alternatives");
					put(grammarAccess.getAdditiveOperatorAccess().getAlternatives(), "rule__AdditiveOperator__Alternatives");
					put(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives(), "rule__MultiplicativeOperator__Alternatives");
					put(grammarAccess.getPowerOperatorAccess().getAlternatives(), "rule__PowerOperator__Alternatives");
					put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
					put(grammarAccess.getBooleanKindAccess().getAlternatives(), "rule__BooleanKind__Alternatives");
					put(grammarAccess.getEnumerationDefinitionAccess().getGroup(), "rule__EnumerationDefinition__Group__0");
					put(grammarAccess.getEnumerationDefinitionAccess().getGroup_3(), "rule__EnumerationDefinition__Group_3__0");
					put(grammarAccess.getEnumerationDefinitionAccess().getGroup_3_1(), "rule__EnumerationDefinition__Group_3_1__0");
					put(grammarAccess.getTypeAliasDefinitionAccess().getGroup(), "rule__TypeAliasDefinition__Group__0");
					put(grammarAccess.getRecordDefinitionAccess().getGroup(), "rule__RecordDefinition__Group__0");
					put(grammarAccess.getRecordFieldDeclarationAccess().getGroup(), "rule__RecordFieldDeclaration__Group__0");
					put(grammarAccess.getFunctionDefinitionAccess().getGroup(), "rule__FunctionDefinition__Group__0");
					put(grammarAccess.getFunctionDefinitionAccess().getGroup_3(), "rule__FunctionDefinition__Group_3__0");
					put(grammarAccess.getFunctionDefinitionAccess().getGroup_3_2(), "rule__FunctionDefinition__Group_3_2__0");
					put(grammarAccess.getFunctionDefinitionAccess().getGroup_5(), "rule__FunctionDefinition__Group_5__0");
					put(grammarAccess.getFunctionDefinitionAccess().getGroup_5_1(), "rule__FunctionDefinition__Group_5_1__0");
					put(grammarAccess.getFunctionDefinitionAccess().getGroup_9(), "rule__FunctionDefinition__Group_9__0");
					put(grammarAccess.getAssertionAccess().getGroup(), "rule__Assertion__Group__0");
					put(grammarAccess.getStateVariableDeclarationAccess().getGroup(), "rule__StateVariableDeclaration__Group__0");
					put(grammarAccess.getFunctionObjectDeclarationAccess().getGroup(), "rule__FunctionObjectDeclaration__Group__0");
					put(grammarAccess.getFunctionObjectDeclarationAccess().getGroup_4(), "rule__FunctionObjectDeclaration__Group_4__0");
					put(grammarAccess.getFunctionObjectDeclarationAccess().getGroup_4_2(), "rule__FunctionObjectDeclaration__Group_4_2__0");
					put(grammarAccess.getEquationAccess().getGroup(), "rule__Equation__Group__0");
					put(grammarAccess.getRealTypeAccess().getGroup(), "rule__RealType__Group__0");
					put(grammarAccess.getRealTypeAccess().getGroup_2(), "rule__RealType__Group_2__0");
					put(grammarAccess.getIntegerTypeAccess().getGroup(), "rule__IntegerType__Group__0");
					put(grammarAccess.getIntegerTypeAccess().getGroup_2(), "rule__IntegerType__Group_2__0");
					put(grammarAccess.getComplexTypeAccess().getGroup(), "rule__ComplexType__Group__0");
					put(grammarAccess.getComplexTypeAccess().getGroup_2(), "rule__ComplexType__Group_2__0");
					put(grammarAccess.getGaussianTypeAccess().getGroup(), "rule__GaussianType__Group__0");
					put(grammarAccess.getGaussianTypeAccess().getGroup_2(), "rule__GaussianType__Group_2__0");
					put(grammarAccess.getBooleanTypeAccess().getGroup(), "rule__BooleanType__Group__0");
					put(grammarAccess.getStringTypeAccess().getGroup(), "rule__StringType__Group__0");
					put(grammarAccess.getArrayTypeAccess().getGroup_1(), "rule__ArrayType__Group_1__0");
					put(grammarAccess.getArrayTypeAccess().getGroup_1_0(), "rule__ArrayType__Group_1_0__0");
					put(grammarAccess.getArrayTypeAccess().getGroup_1_3(), "rule__ArrayType__Group_1_3__0");
					put(grammarAccess.getTensorTypeAccess().getGroup(), "rule__TensorType__Group__0");
					put(grammarAccess.getTensorTypeAccess().getGroup_3(), "rule__TensorType__Group_3__0");
					put(grammarAccess.getArrayDimensionAccess().getGroup(), "rule__ArrayDimension__Group__0");
					put(grammarAccess.getLetExpressionAccess().getGroup(), "rule__LetExpression__Group__0");
					put(grammarAccess.getLetExpressionAccess().getGroup_2(), "rule__LetExpression__Group_2__0");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getGroup(), "rule__LetExpressionVariableDeclaration__Group__0");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getGroup_0_1(), "rule__LetExpressionVariableDeclaration__Group_0_1__0");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getGroup_0_1_2(), "rule__LetExpressionVariableDeclaration__Group_0_1_2__0");
					put(grammarAccess.getIfExpressionAccess().getGroup(), "rule__IfExpression__Group__0");
					put(grammarAccess.getSwitchExpressionAccess().getGroup(), "rule__SwitchExpression__Group__0");
					put(grammarAccess.getSwitchCaseAccess().getGroup(), "rule__SwitchCase__Group__0");
					put(grammarAccess.getRangeExpressionAccess().getGroup(), "rule__RangeExpression__Group__0");
					put(grammarAccess.getRangeExpressionAccess().getGroup_1(), "rule__RangeExpression__Group_1__0");
					put(grammarAccess.getRangeExpressionAccess().getGroup_1_3(), "rule__RangeExpression__Group_1_3__0");
					put(grammarAccess.getImpliesExpressionAccess().getGroup(), "rule__ImpliesExpression__Group__0");
					put(grammarAccess.getImpliesExpressionAccess().getGroup_1(), "rule__ImpliesExpression__Group_1__0");
					put(grammarAccess.getLogicalOrExpressionAccess().getGroup(), "rule__LogicalOrExpression__Group__0");
					put(grammarAccess.getLogicalOrExpressionAccess().getGroup_1(), "rule__LogicalOrExpression__Group_1__0");
					put(grammarAccess.getLogicalOrExpressionAccess().getGroup_1_1(), "rule__LogicalOrExpression__Group_1_1__0");
					put(grammarAccess.getLogicalAndExpressionAccess().getGroup(), "rule__LogicalAndExpression__Group__0");
					put(grammarAccess.getLogicalAndExpressionAccess().getGroup_1(), "rule__LogicalAndExpression__Group_1__0");
					put(grammarAccess.getLogicalAndExpressionAccess().getGroup_1_1(), "rule__LogicalAndExpression__Group_1_1__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup_1(), "rule__EqualityExpression__Group_1__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1_0(), "rule__RelationalExpression__Group_1_0__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1_1(), "rule__RelationalExpression__Group_1_1__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
					put(grammarAccess.getAdditiveExpressionPartAccess().getGroup(), "rule__AdditiveExpressionPart__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
					put(grammarAccess.getMultiplicativeExpressionPartAccess().getGroup(), "rule__MultiplicativeExpressionPart__Group__0");
					put(grammarAccess.getPowerExpressionAccess().getGroup(), "rule__PowerExpression__Group__0");
					put(grammarAccess.getPowerExpressionAccess().getGroup_1(), "rule__PowerExpression__Group_1__0");
					put(grammarAccess.getUnaryExpressionAccess().getGroup_1(), "rule__UnaryExpression__Group_1__0");
					put(grammarAccess.getPostfixExpressionAccess().getGroup(), "rule__PostfixExpression__Group__0");
					put(grammarAccess.getPostfixExpressionAccess().getGroup_1(), "rule__PostfixExpression__Group_1__0");
					put(grammarAccess.getArrayElementAccessAccess().getGroup(), "rule__ArrayElementAccess__Group__0");
					put(grammarAccess.getArrayElementAccessAccess().getGroup_1(), "rule__ArrayElementAccess__Group_1__0");
					put(grammarAccess.getArrayElementAccessAccess().getGroup_1_3(), "rule__ArrayElementAccess__Group_1_3__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup(), "rule__MemberFeatureCall__Group__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_0(), "rule__MemberFeatureCall__Group_1_0__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_1(), "rule__MemberFeatureCall__Group_1_1__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_1_4(), "rule__MemberFeatureCall__Group_1_1_4__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_1_4_1(), "rule__MemberFeatureCall__Group_1_1_4_1__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_2(), "rule__MemberFeatureCall__Group_1_2__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_2_5(), "rule__MemberFeatureCall__Group_1_2_5__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_2_6(), "rule__MemberFeatureCall__Group_1_2_6__0");
					put(grammarAccess.getMemberFeatureCallAccess().getGroup_1_2_7(), "rule__MemberFeatureCall__Group_1_2_7__0");
					put(grammarAccess.getIterationAccumulatorAccess().getGroup(), "rule__IterationAccumulator__Group__0");
					put(grammarAccess.getRealLiteralAccess().getGroup(), "rule__RealLiteral__Group__0");
					put(grammarAccess.getRealLiteralAccess().getGroup_2(), "rule__RealLiteral__Group_2__0");
					put(grammarAccess.getIntegerLiteralAccess().getGroup(), "rule__IntegerLiteral__Group__0");
					put(grammarAccess.getIntegerLiteralAccess().getGroup_2(), "rule__IntegerLiteral__Group_2__0");
					put(grammarAccess.getFeatureCallAccess().getGroup_0(), "rule__FeatureCall__Group_0__0");
					put(grammarAccess.getFeatureCallAccess().getGroup_0_2(), "rule__FeatureCall__Group_0_2__0");
					put(grammarAccess.getFeatureCallAccess().getGroup_1(), "rule__FeatureCall__Group_1__0");
					put(grammarAccess.getFeatureCallAccess().getGroup_1_0(), "rule__FeatureCall__Group_1_0__0");
					put(grammarAccess.getFeatureCallAccess().getGroup_1_0_3(), "rule__FeatureCall__Group_1_0_3__0");
					put(grammarAccess.getFeatureCallAccess().getGroup_1_0_3_1(), "rule__FeatureCall__Group_1_0_3_1__0");
					put(grammarAccess.getArrayConstructionOperatorAccess().getGroup(), "rule__ArrayConstructionOperator__Group__0");
					put(grammarAccess.getArrayConstructionOperatorAccess().getGroup_2_0(), "rule__ArrayConstructionOperator__Group_2_0__0");
					put(grammarAccess.getArrayConstructionOperatorAccess().getGroup_2_1(), "rule__ArrayConstructionOperator__Group_2_1__0");
					put(grammarAccess.getArrayConstructionOperatorAccess().getGroup_2_1_2(), "rule__ArrayConstructionOperator__Group_2_1_2__0");
					put(grammarAccess.getArrayConstructionIterationClauseAccess().getGroup(), "rule__ArrayConstructionIterationClause__Group__0");
					put(grammarAccess.getArrayConcatenationOperatorAccess().getGroup(), "rule__ArrayConcatenationOperator__Group__0");
					put(grammarAccess.getArrayConcatenationOperatorAccess().getGroup_2(), "rule__ArrayConcatenationOperator__Group_2__0");
					put(grammarAccess.getExpressionListAccess().getGroup(), "rule__ExpressionList__Group__0");
					put(grammarAccess.getExpressionListAccess().getGroup_1(), "rule__ExpressionList__Group_1__0");
					put(grammarAccess.getUnitConstructionOperatorAccess().getGroup(), "rule__UnitConstructionOperator__Group__0");
					put(grammarAccess.getParenthesizedExpressionAccess().getGroup(), "rule__ParenthesizedExpression__Group__0");
					put(grammarAccess.getParenthesizedExpressionAccess().getGroup_2(), "rule__ParenthesizedExpression__Group_2__0");
					put(grammarAccess.getBeginExpressionAccess().getGroup(), "rule__BeginExpression__Group__0");
					put(grammarAccess.getEndExpressionAccess().getGroup(), "rule__EndExpression__Group__0");
					put(grammarAccess.getUnitAccess().getGroup(), "rule__Unit__Group__0");
					put(grammarAccess.getUnitAccess().getGroup_1(), "rule__Unit__Group_1__0");
					put(grammarAccess.getUnitAccess().getGroup_1_1(), "rule__Unit__Group_1_1__0");
					put(grammarAccess.getUnitNumeratorAccess().getGroup_0(), "rule__UnitNumerator__Group_0__0");
					put(grammarAccess.getUnitNumeratorAccess().getGroup_1(), "rule__UnitNumerator__Group_1__0");
					put(grammarAccess.getUnitNumeratorAccess().getGroup_1_1(), "rule__UnitNumerator__Group_1_1__0");
					put(grammarAccess.getUnitDenominatorAccess().getGroup_1(), "rule__UnitDenominator__Group_1__0");
					put(grammarAccess.getUnitDenominatorAccess().getGroup_1_2(), "rule__UnitDenominator__Group_1_2__0");
					put(grammarAccess.getUnitFactorAccess().getGroup(), "rule__UnitFactor__Group__0");
					put(grammarAccess.getUnitFactorAccess().getGroup_1(), "rule__UnitFactor__Group_1__0");
					put(grammarAccess.getUnitExponentAccess().getGroup(), "rule__UnitExponent__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getModuleAccess().getDefinitionsAssignment(), "rule__Module__DefinitionsAssignment");
					put(grammarAccess.getEnumerationDefinitionAccess().getNameAssignment_1(), "rule__EnumerationDefinition__NameAssignment_1");
					put(grammarAccess.getEnumerationDefinitionAccess().getLiteralDeclarationsAssignment_3_0(), "rule__EnumerationDefinition__LiteralDeclarationsAssignment_3_0");
					put(grammarAccess.getEnumerationDefinitionAccess().getLiteralDeclarationsAssignment_3_1_1(), "rule__EnumerationDefinition__LiteralDeclarationsAssignment_3_1_1");
					put(grammarAccess.getEnumerationLiteralDeclarationAccess().getNameAssignment(), "rule__EnumerationLiteralDeclaration__NameAssignment");
					put(grammarAccess.getTypeAliasDefinitionAccess().getNameAssignment_1(), "rule__TypeAliasDefinition__NameAssignment_1");
					put(grammarAccess.getTypeAliasDefinitionAccess().getTypeAssignment_3(), "rule__TypeAliasDefinition__TypeAssignment_3");
					put(grammarAccess.getRecordDefinitionAccess().getNameAssignment_1(), "rule__RecordDefinition__NameAssignment_1");
					put(grammarAccess.getRecordDefinitionAccess().getFieldDeclarationsAssignment_3(), "rule__RecordDefinition__FieldDeclarationsAssignment_3");
					put(grammarAccess.getRecordFieldDeclarationAccess().getNameAssignment_0(), "rule__RecordFieldDeclaration__NameAssignment_0");
					put(grammarAccess.getRecordFieldDeclarationAccess().getTypeAssignment_2(), "rule__RecordFieldDeclaration__TypeAssignment_2");
					put(grammarAccess.getFunctionDefinitionAccess().getStatefulAssignment_0(), "rule__FunctionDefinition__StatefulAssignment_0");
					put(grammarAccess.getFunctionDefinitionAccess().getNameAssignment_2(), "rule__FunctionDefinition__NameAssignment_2");
					put(grammarAccess.getFunctionDefinitionAccess().getTemplateParameterDeclarationsAssignment_3_1(), "rule__FunctionDefinition__TemplateParameterDeclarationsAssignment_3_1");
					put(grammarAccess.getFunctionDefinitionAccess().getTemplateParameterDeclarationsAssignment_3_2_1(), "rule__FunctionDefinition__TemplateParameterDeclarationsAssignment_3_2_1");
					put(grammarAccess.getFunctionDefinitionAccess().getInputParameterDeclarationsAssignment_5_0(), "rule__FunctionDefinition__InputParameterDeclarationsAssignment_5_0");
					put(grammarAccess.getFunctionDefinitionAccess().getInputParameterDeclarationsAssignment_5_1_1(), "rule__FunctionDefinition__InputParameterDeclarationsAssignment_5_1_1");
					put(grammarAccess.getFunctionDefinitionAccess().getOutputParameterDeclarationsAssignment_8(), "rule__FunctionDefinition__OutputParameterDeclarationsAssignment_8");
					put(grammarAccess.getFunctionDefinitionAccess().getOutputParameterDeclarationsAssignment_9_1(), "rule__FunctionDefinition__OutputParameterDeclarationsAssignment_9_1");
					put(grammarAccess.getFunctionDefinitionAccess().getAssertionsAssignment_11_0(), "rule__FunctionDefinition__AssertionsAssignment_11_0");
					put(grammarAccess.getFunctionDefinitionAccess().getFunctionObjectDeclarationsAssignment_11_1(), "rule__FunctionDefinition__FunctionObjectDeclarationsAssignment_11_1");
					put(grammarAccess.getFunctionDefinitionAccess().getStateVariableDeclarationsAssignment_11_2(), "rule__FunctionDefinition__StateVariableDeclarationsAssignment_11_2");
					put(grammarAccess.getFunctionDefinitionAccess().getEquationsAssignment_11_3(), "rule__FunctionDefinition__EquationsAssignment_11_3");
					put(grammarAccess.getParameterDeclarationAccess().getNameAssignment(), "rule__ParameterDeclaration__NameAssignment");
					put(grammarAccess.getAssertionAccess().getStaticAssignment_0(), "rule__Assertion__StaticAssignment_0");
					put(grammarAccess.getAssertionAccess().getConditionAssignment_2(), "rule__Assertion__ConditionAssignment_2");
					put(grammarAccess.getAssertionAccess().getStatusKindAssignment_4(), "rule__Assertion__StatusKindAssignment_4");
					put(grammarAccess.getAssertionAccess().getMessageAssignment_5(), "rule__Assertion__MessageAssignment_5");
					put(grammarAccess.getStateVariableDeclarationAccess().getNameAssignment_1(), "rule__StateVariableDeclaration__NameAssignment_1");
					put(grammarAccess.getFunctionObjectDeclarationAccess().getNameAssignment_1(), "rule__FunctionObjectDeclaration__NameAssignment_1");
					put(grammarAccess.getFunctionObjectDeclarationAccess().getFunctionNameAssignment_3(), "rule__FunctionObjectDeclaration__FunctionNameAssignment_3");
					put(grammarAccess.getFunctionObjectDeclarationAccess().getTemplateArgumentsAssignment_4_1(), "rule__FunctionObjectDeclaration__TemplateArgumentsAssignment_4_1");
					put(grammarAccess.getFunctionObjectDeclarationAccess().getTemplateArgumentsAssignment_4_2_1(), "rule__FunctionObjectDeclaration__TemplateArgumentsAssignment_4_2_1");
					put(grammarAccess.getEquationAccess().getLeftHandSideAssignment_0(), "rule__Equation__LeftHandSideAssignment_0");
					put(grammarAccess.getEquationAccess().getRightHandSideAssignment_2(), "rule__Equation__RightHandSideAssignment_2");
					put(grammarAccess.getDataTypeSpecifierAccess().getDefinedTypeAssignment_0(), "rule__DataTypeSpecifier__DefinedTypeAssignment_0");
					put(grammarAccess.getDataTypeSpecifierAccess().getTypeAssignment_1(), "rule__DataTypeSpecifier__TypeAssignment_1");
					put(grammarAccess.getRealTypeAccess().getUnitAssignment_2_1(), "rule__RealType__UnitAssignment_2_1");
					put(grammarAccess.getIntegerTypeAccess().getUnitAssignment_2_1(), "rule__IntegerType__UnitAssignment_2_1");
					put(grammarAccess.getComplexTypeAccess().getUnitAssignment_2_1(), "rule__ComplexType__UnitAssignment_2_1");
					put(grammarAccess.getGaussianTypeAccess().getUnitAssignment_2_1(), "rule__GaussianType__UnitAssignment_2_1");
					put(grammarAccess.getArrayTypeAccess().getDefinedElementTypeAssignment_1_0_0_0(), "rule__ArrayType__DefinedElementTypeAssignment_1_0_0_0");
					put(grammarAccess.getArrayTypeAccess().getElementTypeAssignment_1_0_0_1(), "rule__ArrayType__ElementTypeAssignment_1_0_0_1");
					put(grammarAccess.getArrayTypeAccess().getDimensionsAssignment_1_2(), "rule__ArrayType__DimensionsAssignment_1_2");
					put(grammarAccess.getArrayTypeAccess().getDimensionsAssignment_1_3_1(), "rule__ArrayType__DimensionsAssignment_1_3_1");
					put(grammarAccess.getTensorTypeAccess().getDefinedElementTypeAssignment_0(), "rule__TensorType__DefinedElementTypeAssignment_0");
					put(grammarAccess.getTensorTypeAccess().getDimensionsAssignment_2(), "rule__TensorType__DimensionsAssignment_2");
					put(grammarAccess.getTensorTypeAccess().getDimensionsAssignment_3_1(), "rule__TensorType__DimensionsAssignment_3_1");
					put(grammarAccess.getArrayDimensionAccess().getSizeAssignment_1(), "rule__ArrayDimension__SizeAssignment_1");
					put(grammarAccess.getLetExpressionAccess().getVariableDeclarationsAssignment_1(), "rule__LetExpression__VariableDeclarationsAssignment_1");
					put(grammarAccess.getLetExpressionAccess().getVariableDeclarationsAssignment_2_1(), "rule__LetExpression__VariableDeclarationsAssignment_2_1");
					put(grammarAccess.getLetExpressionAccess().getTargetExpressionAssignment_4(), "rule__LetExpression__TargetExpressionAssignment_4");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getPartsAssignment_0_0(), "rule__LetExpressionVariableDeclaration__PartsAssignment_0_0");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getPartsAssignment_0_1_1(), "rule__LetExpressionVariableDeclaration__PartsAssignment_0_1_1");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getPartsAssignment_0_1_2_1(), "rule__LetExpressionVariableDeclaration__PartsAssignment_0_1_2_1");
					put(grammarAccess.getLetExpressionVariableDeclarationAccess().getAssignedExpressionAssignment_2(), "rule__LetExpressionVariableDeclaration__AssignedExpressionAssignment_2");
					put(grammarAccess.getLetExpressionVariableDeclarationPartAccess().getNameAssignment(), "rule__LetExpressionVariableDeclarationPart__NameAssignment");
					put(grammarAccess.getIfExpressionAccess().getStaticAssignment_0(), "rule__IfExpression__StaticAssignment_0");
					put(grammarAccess.getIfExpressionAccess().getConditionAssignment_2(), "rule__IfExpression__ConditionAssignment_2");
					put(grammarAccess.getIfExpressionAccess().getThenExpressionAssignment_4(), "rule__IfExpression__ThenExpressionAssignment_4");
					put(grammarAccess.getIfExpressionAccess().getElseExpressionAssignment_6(), "rule__IfExpression__ElseExpressionAssignment_6");
					put(grammarAccess.getSwitchExpressionAccess().getStaticAssignment_0(), "rule__SwitchExpression__StaticAssignment_0");
					put(grammarAccess.getSwitchExpressionAccess().getControlExpressionAssignment_2(), "rule__SwitchExpression__ControlExpressionAssignment_2");
					put(grammarAccess.getSwitchExpressionAccess().getCasesAssignment_3(), "rule__SwitchExpression__CasesAssignment_3");
					put(grammarAccess.getSwitchExpressionAccess().getDefaultExpressionAssignment_6(), "rule__SwitchExpression__DefaultExpressionAssignment_6");
					put(grammarAccess.getSwitchCaseAccess().getCaseExpressionAssignment_1(), "rule__SwitchCase__CaseExpressionAssignment_1");
					put(grammarAccess.getSwitchCaseAccess().getResultExpressionAssignment_3(), "rule__SwitchCase__ResultExpressionAssignment_3");
					put(grammarAccess.getRangeExpressionAccess().getOperandsAssignment_1_2(), "rule__RangeExpression__OperandsAssignment_1_2");
					put(grammarAccess.getRangeExpressionAccess().getOperandsAssignment_1_3_1(), "rule__RangeExpression__OperandsAssignment_1_3_1");
					put(grammarAccess.getImpliesExpressionAccess().getRightOperandAssignment_1_2(), "rule__ImpliesExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getLogicalOrExpressionAccess().getOperandsAssignment_1_1_1(), "rule__LogicalOrExpression__OperandsAssignment_1_1_1");
					put(grammarAccess.getLogicalAndExpressionAccess().getOperandsAssignment_1_1_1(), "rule__LogicalAndExpression__OperandsAssignment_1_1_1");
					put(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_1(), "rule__EqualityExpression__OperatorAssignment_1_1");
					put(grammarAccess.getEqualityExpressionAccess().getRightOperandAssignment_1_2(), "rule__EqualityExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_0_1(), "rule__RelationalExpression__OperatorAssignment_1_0_1");
					put(grammarAccess.getRelationalExpressionAccess().getRightOperandAssignment_1_0_2(), "rule__RelationalExpression__RightOperandAssignment_1_0_2");
					put(grammarAccess.getRelationalExpressionAccess().getTypeAssignment_1_1_2(), "rule__RelationalExpression__TypeAssignment_1_1_2");
					put(grammarAccess.getAdditiveExpressionAccess().getRightPartsAssignment_1_1(), "rule__AdditiveExpression__RightPartsAssignment_1_1");
					put(grammarAccess.getAdditiveExpressionPartAccess().getOperatorAssignment_0(), "rule__AdditiveExpressionPart__OperatorAssignment_0");
					put(grammarAccess.getAdditiveExpressionPartAccess().getOperandAssignment_1(), "rule__AdditiveExpressionPart__OperandAssignment_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getRightPartsAssignment_1_1(), "rule__MultiplicativeExpression__RightPartsAssignment_1_1");
					put(grammarAccess.getMultiplicativeExpressionPartAccess().getOperatorAssignment_0(), "rule__MultiplicativeExpressionPart__OperatorAssignment_0");
					put(grammarAccess.getMultiplicativeExpressionPartAccess().getOperandAssignment_1(), "rule__MultiplicativeExpressionPart__OperandAssignment_1");
					put(grammarAccess.getPowerExpressionAccess().getOperatorAssignment_1_1(), "rule__PowerExpression__OperatorAssignment_1_1");
					put(grammarAccess.getPowerExpressionAccess().getExponentAssignment_1_2(), "rule__PowerExpression__ExponentAssignment_1_2");
					put(grammarAccess.getUnaryExpressionAccess().getOperatorAssignment_1_1(), "rule__UnaryExpression__OperatorAssignment_1_1");
					put(grammarAccess.getUnaryExpressionAccess().getOperandAssignment_1_2(), "rule__UnaryExpression__OperandAssignment_1_2");
					put(grammarAccess.getPostfixExpressionAccess().getOperatorAssignment_1_1(), "rule__PostfixExpression__OperatorAssignment_1_1");
					put(grammarAccess.getArrayElementAccessAccess().getSubscriptsAssignment_1_2(), "rule__ArrayElementAccess__SubscriptsAssignment_1_2");
					put(grammarAccess.getArrayElementAccessAccess().getSubscriptsAssignment_1_3_1(), "rule__ArrayElementAccess__SubscriptsAssignment_1_3_1");
					put(grammarAccess.getMemberFeatureCallAccess().getMemberVariableAssignment_1_0_2(), "rule__MemberFeatureCall__MemberVariableAssignment_1_0_2");
					put(grammarAccess.getMemberFeatureCallAccess().getFeatureAssignment_1_1_2(), "rule__MemberFeatureCall__FeatureAssignment_1_1_2");
					put(grammarAccess.getMemberFeatureCallAccess().getArgumentsAssignment_1_1_4_0(), "rule__MemberFeatureCall__ArgumentsAssignment_1_1_4_0");
					put(grammarAccess.getMemberFeatureCallAccess().getArgumentsAssignment_1_1_4_1_1(), "rule__MemberFeatureCall__ArgumentsAssignment_1_1_4_1_1");
					put(grammarAccess.getMemberFeatureCallAccess().getIdentifierAssignment_1_2_2(), "rule__MemberFeatureCall__IdentifierAssignment_1_2_2");
					put(grammarAccess.getMemberFeatureCallAccess().getVariablesAssignment_1_2_4(), "rule__MemberFeatureCall__VariablesAssignment_1_2_4");
					put(grammarAccess.getMemberFeatureCallAccess().getVariablesAssignment_1_2_5_1(), "rule__MemberFeatureCall__VariablesAssignment_1_2_5_1");
					put(grammarAccess.getMemberFeatureCallAccess().getAccumulatorAssignment_1_2_6_1(), "rule__MemberFeatureCall__AccumulatorAssignment_1_2_6_1");
					put(grammarAccess.getMemberFeatureCallAccess().getBreakConditionAssignment_1_2_7_1(), "rule__MemberFeatureCall__BreakConditionAssignment_1_2_7_1");
					put(grammarAccess.getMemberFeatureCallAccess().getExpressionAssignment_1_2_9(), "rule__MemberFeatureCall__ExpressionAssignment_1_2_9");
					put(grammarAccess.getIterationVariableAccess().getNameAssignment(), "rule__IterationVariable__NameAssignment");
					put(grammarAccess.getIterationAccumulatorAccess().getNameAssignment_0(), "rule__IterationAccumulator__NameAssignment_0");
					put(grammarAccess.getIterationAccumulatorAccess().getInitializerAssignment_2(), "rule__IterationAccumulator__InitializerAssignment_2");
					put(grammarAccess.getArraySubscriptAccess().getSliceAssignment_0(), "rule__ArraySubscript__SliceAssignment_0");
					put(grammarAccess.getArraySubscriptAccess().getExpressionAssignment_1(), "rule__ArraySubscript__ExpressionAssignment_1");
					put(grammarAccess.getRealLiteralAccess().getValueAssignment_0(), "rule__RealLiteral__ValueAssignment_0");
					put(grammarAccess.getRealLiteralAccess().getModifierAssignment_1(), "rule__RealLiteral__ModifierAssignment_1");
					put(grammarAccess.getRealLiteralAccess().getUnitAssignment_2_1(), "rule__RealLiteral__UnitAssignment_2_1");
					put(grammarAccess.getIntegerLiteralAccess().getValueAssignment_0(), "rule__IntegerLiteral__ValueAssignment_0");
					put(grammarAccess.getIntegerLiteralAccess().getModifierAssignment_1(), "rule__IntegerLiteral__ModifierAssignment_1");
					put(grammarAccess.getIntegerLiteralAccess().getUnitAssignment_2_1(), "rule__IntegerLiteral__UnitAssignment_2_1");
					put(grammarAccess.getBooleanLiteralAccess().getValueAssignment(), "rule__BooleanLiteral__ValueAssignment");
					put(grammarAccess.getStringLiteralAccess().getValueAssignment(), "rule__StringLiteral__ValueAssignment");
					put(grammarAccess.getFeatureCallAccess().getFeatureAssignment_0_1(), "rule__FeatureCall__FeatureAssignment_0_1");
					put(grammarAccess.getFeatureCallAccess().getStepExpressionAssignment_0_2_1(), "rule__FeatureCall__StepExpressionAssignment_0_2_1");
					put(grammarAccess.getFeatureCallAccess().getFeatureAssignment_1_0_1(), "rule__FeatureCall__FeatureAssignment_1_0_1");
					put(grammarAccess.getFeatureCallAccess().getArgumentsAssignment_1_0_3_0(), "rule__FeatureCall__ArgumentsAssignment_1_0_3_0");
					put(grammarAccess.getFeatureCallAccess().getArgumentsAssignment_1_0_3_1_1(), "rule__FeatureCall__ArgumentsAssignment_1_0_3_1_1");
					put(grammarAccess.getArrayConstructionOperatorAccess().getExpressionsAssignment_1(), "rule__ArrayConstructionOperator__ExpressionsAssignment_1");
					put(grammarAccess.getArrayConstructionOperatorAccess().getExpressionsAssignment_2_0_1(), "rule__ArrayConstructionOperator__ExpressionsAssignment_2_0_1");
					put(grammarAccess.getArrayConstructionOperatorAccess().getIterationClausesAssignment_2_1_1(), "rule__ArrayConstructionOperator__IterationClausesAssignment_2_1_1");
					put(grammarAccess.getArrayConstructionOperatorAccess().getIterationClausesAssignment_2_1_2_1(), "rule__ArrayConstructionOperator__IterationClausesAssignment_2_1_2_1");
					put(grammarAccess.getArrayConstructionIterationClauseAccess().getVariableNameAssignment_0(), "rule__ArrayConstructionIterationClause__VariableNameAssignment_0");
					put(grammarAccess.getArrayConstructionIterationClauseAccess().getCollectionExpressionAssignment_2(), "rule__ArrayConstructionIterationClause__CollectionExpressionAssignment_2");
					put(grammarAccess.getArrayConcatenationOperatorAccess().getRowsAssignment_1(), "rule__ArrayConcatenationOperator__RowsAssignment_1");
					put(grammarAccess.getArrayConcatenationOperatorAccess().getRowsAssignment_2_1(), "rule__ArrayConcatenationOperator__RowsAssignment_2_1");
					put(grammarAccess.getExpressionListAccess().getExpressionsAssignment_0(), "rule__ExpressionList__ExpressionsAssignment_0");
					put(grammarAccess.getExpressionListAccess().getExpressionsAssignment_1_1(), "rule__ExpressionList__ExpressionsAssignment_1_1");
					put(grammarAccess.getUnitConstructionOperatorAccess().getUnitAssignment_2(), "rule__UnitConstructionOperator__UnitAssignment_2");
					put(grammarAccess.getParenthesizedExpressionAccess().getExpressionsAssignment_1(), "rule__ParenthesizedExpression__ExpressionsAssignment_1");
					put(grammarAccess.getParenthesizedExpressionAccess().getExpressionsAssignment_2_1(), "rule__ParenthesizedExpression__ExpressionsAssignment_2_1");
					put(grammarAccess.getUnitAccess().getNumeratorAssignment_1_0(), "rule__Unit__NumeratorAssignment_1_0");
					put(grammarAccess.getUnitAccess().getDenominatorAssignment_1_1_1(), "rule__Unit__DenominatorAssignment_1_1_1");
					put(grammarAccess.getUnitNumeratorAccess().getFactorsAssignment_1_0(), "rule__UnitNumerator__FactorsAssignment_1_0");
					put(grammarAccess.getUnitNumeratorAccess().getFactorsAssignment_1_1_1(), "rule__UnitNumerator__FactorsAssignment_1_1_1");
					put(grammarAccess.getUnitDenominatorAccess().getFactorsAssignment_0(), "rule__UnitDenominator__FactorsAssignment_0");
					put(grammarAccess.getUnitDenominatorAccess().getFactorsAssignment_1_1(), "rule__UnitDenominator__FactorsAssignment_1_1");
					put(grammarAccess.getUnitDenominatorAccess().getFactorsAssignment_1_2_1(), "rule__UnitDenominator__FactorsAssignment_1_2_1");
					put(grammarAccess.getUnitFactorAccess().getSymbolAssignment_0(), "rule__UnitFactor__SymbolAssignment_0");
					put(grammarAccess.getUnitFactorAccess().getExponentAssignment_1_1(), "rule__UnitFactor__ExponentAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipselabs.mscript.language.ui.contentassist.antlr.internal.InternalMscriptParser typedParser = (org.eclipselabs.mscript.language.ui.contentassist.antlr.internal.InternalMscriptParser) parser;
			typedParser.entryRuleModule();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public MscriptGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MscriptGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
