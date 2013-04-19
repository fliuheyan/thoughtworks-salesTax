package com.thoughtworks.tax.factory;

import java.math.BigDecimal;

import com.thoughtworks.tax.Product;
import com.thoughtworks.tax.DomesticTaxProduct;

public class DomesticTaxProductFactory extends TaxProductFactory {

	@Override
	public Product createProduct(String name) {
		return new DomesticTaxProduct(name);
	}

	@Override
	public Product createProduct(String name, BigDecimal price) {
		return new DomesticTaxProduct(name, price);
	}

	@Override
	public Product createProduct(String name, BigDecimal price, BigDecimal rate) {
		return new DomesticTaxProduct(name, price, rate);
	}

}
