package com.thoughtworks.tax;

import java.math.BigDecimal;

public class BoardTaxProduct extends TaxProduct {
	private final BigDecimal extract_rate = new BigDecimal("0.05");
	private final BigDecimal default_rate = new BigDecimal("0.10");
	private BigDecimal rate;
	private BigDecimal price;
	private String name;

	public BoardTaxProduct(String name) {
		this.setName(name);
		this.rate = extract_rate.add(default_rate);
		this.price = new BigDecimal("0.00");
	}

	public BoardTaxProduct(String name, BigDecimal price) {
		this.setName(name);
		this.price = price;
		this.rate = extract_rate.add(default_rate);
	}

	public BoardTaxProduct(String name, BigDecimal price, BigDecimal rate) {
		this.setName(name);
		this.price = price;
		this.rate = extract_rate.add(rate);
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
