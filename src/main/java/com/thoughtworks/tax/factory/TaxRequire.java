package com.thoughtworks.tax.factory;

public enum TaxRequire {
	charge(true), free(false);
	private boolean isTaxRequire;

	TaxRequire(boolean isTaxRequire) {
		this.setTaxRequire(isTaxRequire);
	}

	public boolean isTaxRequire() {
		return isTaxRequire;
	}

	public void setTaxRequire(boolean isTaxRequire) {
		this.isTaxRequire = isTaxRequire;
	}
}
