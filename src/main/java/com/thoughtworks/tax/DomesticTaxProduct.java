package com.thoughtworks.tax;

import java.math.BigDecimal;

public class DomesticTaxProduct extends TaxProduct {
	private String name;
	private BigDecimal price;
	private BigDecimal rate;

	public DomesticTaxProduct(String name) {
		this.name = name;
		this.rate = DEFAULT_RATE;
		this.price = new BigDecimal("0.00");
	}

	public DomesticTaxProduct(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
		this.rate = DEFAULT_RATE;
	}

	public DomesticTaxProduct(String name, BigDecimal price, BigDecimal rate) {
		this.name = name;
		this.price = price;
		this.rate = rate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public boolean getIsBoard() {
		return false;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTaxCost() {
		return ScaleHelper.applyRoundingFactor(price.multiply(rate));
	}

	public BigDecimal getTotalCost() {
		return getTaxCost().add(price);
	}

}
