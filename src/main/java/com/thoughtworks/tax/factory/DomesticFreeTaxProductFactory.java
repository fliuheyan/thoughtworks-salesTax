package com.thoughtworks.tax.factory;

import java.math.BigDecimal;

import com.thoughtworks.tax.DomesticFreeTaxProduct;
import com.thoughtworks.tax.Product;

public class DomesticFreeTaxProductFactory extends FreeTaxProductFactory {

	@Override
	public Product createProduct(String name) {
		return new DomesticFreeTaxProduct(name);
	}

	@Override
	public Product createProduct(String name, BigDecimal price) {
		return new DomesticFreeTaxProduct(name, price);
	}

	@Override
	public Product createProduct(String name, BigDecimal price, BigDecimal rate) {
		// TODO Auto-generated method stub
		return null;
	}

}
