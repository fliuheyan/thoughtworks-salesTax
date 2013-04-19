package com.thoughtworks.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Product {
	
	final static RoundingMode ROUNDMODE = RoundingMode.HALF_UP;
	final static BigDecimal EXTRACT_RATE = new BigDecimal("0.05");
	final static BigDecimal DEFAULT_RATE = new BigDecimal("0.10");
	
	public abstract String getName();
	
	public abstract BigDecimal getPrice();

	public abstract BigDecimal getRate();
	
	public abstract boolean getIsBoard();
	
	public abstract BigDecimal getTaxCost();
	
	public abstract BigDecimal getTotalCost();
}
