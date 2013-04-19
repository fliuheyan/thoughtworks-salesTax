package com.thoughtworks.tax.factory;

import java.math.BigDecimal;

import com.thoughtworks.tax.BoardFreeTaxProduct;
import com.thoughtworks.tax.Product;

public class BoardFreeTaxProductFactory extends FreeTaxProductFactory {

	@Override
	public Product createProduct(String name) {
		return new BoardFreeTaxProduct(name);
	}

	@Override
	public Product createProduct(String name, BigDecimal price) {
		// TODO Auto-generated method stub
		return new BoardFreeTaxProduct(name, price);
	}

	@Override
	public Product createProduct(String name, BigDecimal price, BigDecimal rate) {
		// TODO Auto-generated method stub
		return new BoardFreeTaxProduct(name, price, rate);
	}

}
