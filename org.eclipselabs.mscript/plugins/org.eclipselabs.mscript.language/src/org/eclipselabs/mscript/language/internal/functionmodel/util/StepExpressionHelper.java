/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.internal.functionmodel.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.IntegerLiteral;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.util.TypeSystemSwitch;

/**
 * @author Andreas Unger
 *
 */
public class StepExpressionHelper {

	public StepExpressionResult getStepExpression(VariableAccess variableAccess) throws CoreException {
		if (variableAccess.getStepExpression() != null) {
			return evaluateStepExpression(variableAccess.getStepExpression());
		}
		return new StepExpressionResult(0, false);
	}

	private StepExpressionResult evaluateStepExpression(Expression expression) throws CoreException {
		Evaluator evaluator = new Evaluator();
		int result = evaluator.doSwitch(expression);
		IStatus status = evaluator.getStatus();
		if (status.isOK()) {
			return new StepExpressionResult(result, evaluator.isAbsolute());
		}
		throw new CoreException(status);
	}
	
	private static class Evaluator extends AstSwitch<Integer> {
	
		private MultiStatus status;
		
		private boolean absolute = true;
		
		/**
		 * 
		 */
		public Evaluator() {
			status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "Step expression evaluation failed", null);
		}
		
		/**
		 * @return the status
		 */
		public IStatus getStatus() {
			return status;
		}
		
		public boolean isAbsolute() {
			return absolute;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public Integer caseAdditiveExpression(AdditiveExpression addSubtractExpression) {
			Integer result = doSwitch(addSubtractExpression.getLeftOperand());
			for (AdditiveExpressionPart part : addSubtractExpression.getRightParts()) {
				result = addSubtract(result, doSwitch(part.getOperand()), part.getOperator());
			}
			return result;
		}
		
		protected Integer addSubtract(Integer operand1, Integer operand2, AdditiveOperator operator) {
			switch (operator) {
			case ADD:
				return operand1 + operand2;
			case SUBTRACT:
				return operand1 - operand2;
			}
			throw new IllegalArgumentException();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public Integer caseUnaryExpression(UnaryExpression unaryExpression) {
			Integer result;
			Integer operandValue = doSwitch(unaryExpression.getOperand());
			switch (unaryExpression.getOperator()) {
			case NEGATE:
				result = -operandValue;
				break;
			case LOGICAL_NOT:
				result = 0;
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid unary operation", unaryExpression));
				break;
			default:
				throw new IllegalArgumentException();
			}
			return result;
		}
	
		@Override
		public Integer caseVariableAccess(VariableAccess variableAccess) {
			if (variableAccess.getFeature().getName().equals("n")) {
				if (absolute) {
					absolute = false;
					return 0;
				} else {
					status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Duplicate 'n'", variableAccess));
				}
			} else {
				status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid symbol", variableAccess));
			}
			return 0;
		}
		
		private TypeSystemSwitch<Integer> typeSystemSwitch = new TypeSystemSwitch<Integer>() {
		
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
			 */
			@Override
			public Integer caseIntegerLiteral(IntegerLiteral integerLiteral) {
				Unit unit = integerLiteral.getUnit();
				if (unit.isWildcard() || !unit.getNumerator().getFactors().isEmpty() || unit.getDenominator() != null) {
					status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Integer literal must not specify unit", unit));
					return 0;
				}
				return (int) integerLiteral.getValue();
			}
		
		};
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public Integer caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			return doSwitch(parenthesizedExpression.getExpressions().get(0));
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Integer defaultCase(EObject object) {
			Integer result = typeSystemSwitch.doSwitch(object);
			if (result != null) {
				return result;
			}
			status.add(new SyntaxStatus(IStatus.ERROR, LanguagePlugin.PLUGIN_ID, 0, "Invalid expression part", object));
			return 0;
		}
	
	}

}
