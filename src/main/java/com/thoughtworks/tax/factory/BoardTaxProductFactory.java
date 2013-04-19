package com.thoughtworks.tax.factory;

import java.math.BigDecimal;

import com.thoughtworks.tax.BoardTaxProduct;
import com.thoughtworks.tax.Product;

public class BoardTaxProductFactory extends TaxProductFactory{

	@Override
	public Product createProduct(String name) {
		return new BoardTaxProduct(name);
	}

	@Override
	public Product createProduct(String name, BigDecimal price) {
		return new BoardTaxProduct(name,price);
	}

	@Override
	public Product createProduct(String name, BigDecimal price, BigDecimal rate) {
		return new BoardTaxProduct(name,price,rate);
	}

	
}
