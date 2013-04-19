package com.thoughtworks.tax;

import java.math.BigDecimal;

public class ScaleHelper {
	private static final BigDecimal ROUND_OFF_FACTOR = new BigDecimal("0.05");

	public static BigDecimal applyRoundingFactor(BigDecimal value) {
		BigDecimal result = new BigDecimal(Math.ceil(value.doubleValue()
				/ ROUND_OFF_FACTOR.doubleValue())).multiply(ROUND_OFF_FACTOR);
		result = result.setScale(2);
		return result;
	}
}
