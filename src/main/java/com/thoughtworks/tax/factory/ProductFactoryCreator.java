package com.thoughtworks.tax.factory;

import java.math.BigDecimal;

public interface ProductFactoryCreator {
	public AbstractFactory createFactory(String name, BigDecimal price,
			Area area, TaxRequire taxRequire);
}
