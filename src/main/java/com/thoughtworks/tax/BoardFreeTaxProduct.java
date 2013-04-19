package com.thoughtworks.tax;

import java.math.BigDecimal;

public class BoardFreeTaxProduct extends FreeTaxProduct {
	private String name;
	private BigDecimal price;
	private BigDecimal rate;

	public BoardFreeTaxProduct() {
		this.rate = EXTRACT_RATE;
		this.price = new BigDecimal("0.00");
	}

	public BoardFreeTaxProduct(String name) {
		this.name = name;
		this.price = new BigDecimal("0.00");
	}

	public BoardFreeTaxProduct(String name, BigDecimal price) {
		this();
		this.price = price;
	}

	public BoardFreeTaxProduct(String name, BigDecimal price, BigDecimal rate) {
		this(name, price);
		this.rate = rate.add(EXTRACT_RATE);
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public boolean getIsBoard() {
		return false;
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
