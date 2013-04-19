package com.thoughtworks.tax.factory;

import java.math.BigDecimal;

public class ProductFactoryCreatorImpl implements ProductFactoryCreator{

	public AbstractFactory createFactory(String name, BigDecimal price,
			Area area, TaxRequire taxRequire) {
		if(area.isImported()){
			
		}
		return null;
	}
}
