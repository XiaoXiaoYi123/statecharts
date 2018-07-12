/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */

package org.yakindu.sct.ui.editor.editor.themes;

import org.eclipse.swt.graphics.Color;

public abstract class AbstractTheme implements IStatechartsTheme {

	@Override
	public boolean getDrawStateShadows() {
		return false;
	}

	@Override
	public boolean getDrawRegionShadows() {
		return false;
	}

	@Override
	public boolean getTransitionExpressionOpaque() {
		return false;
	}

	@Override
	public boolean getDrawRelativeStateOutline() {
		return false;
	}

	@Override
	public double getRelativeStateOutlineFactor() {
		return 0;
	}

	@Override
	public boolean getDrawStateBgGradient() {
		return false;
	}

	@Override
	public boolean getDrawRegionBgGradient() {
		return false;
	}

	@Override
	public int getStateBlurShadowWidth() {
		return 0;
	}

	@Override
	public int getRegionBlurShadowWidth() {
		return 0;
	}

	@Override
	public Color getCanvasBgColor() {
		return null;
	}

	@Override
	public Color getStateBgColor() {
		return null;
	}

	@Override
	public Color getRegionBgColor() {
		return null;
	}

	@Override
	public Color getRegionOutlineColor() {
		return null;
	}

	@Override
	public final Color getStateOutlineColor() {
		return getStateOutlineColor(null);
	}

	@Override
	public final Color getStateOutlineColor(Color stateColor) {
		if (getDrawRelativeStateOutline()) {
			Color bgColor = stateColor != null ? stateColor : getStateBgColor();
			double offset = getRelativeStateOutlineFactor();
			return ColorHelper.modifyColorShade(bgColor, offset);
		} else {
			return getInternalStateOutlineColor();
		}
	}

	protected abstract Color getInternalStateOutlineColor();

	@Override
	public int getTransitionBendpointRadius() {
		return 0;
	}

}