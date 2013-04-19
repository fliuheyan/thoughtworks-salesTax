package com.thoughtworks.tax.factory;

import java.math.BigDecimal;

import com.thoughtworks.tax.Product;

public abstract class AbstractFactory {
	public abstract Product createProduct(String name);

	public abstract Product createProduct(String name, BigDecimal price);

	public abstract Product createProduct(String name, BigDecimal price, BigDecimal rate);

}
