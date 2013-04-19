package com.thoughtworks.tax;

import java.math.BigDecimal;

public class DomesticFreeTaxProduct extends FreeTaxProduct {
	private String name;
	private BigDecimal price;
	private BigDecimal rate;

	public DomesticFreeTaxProduct(String name) {
		this.rate = DEFAULT_RATE;
		this.name = name;
	}

	public DomesticFreeTaxProduct(String name, BigDecimal price) {
		this(name);
		this.price = price;
	}

	public DomesticFreeTaxProduct(String name, BigDecimal price, BigDecimal rate) {
		this(name, price);
		this.rate = rate;
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
		// return price.multiply(rate).setScale(2);
		return new BigDecimal("0.00");
	}

	public BigDecimal getTotalCost() {
		// return getTaxCost().add(price);
		return price;
	}
}
