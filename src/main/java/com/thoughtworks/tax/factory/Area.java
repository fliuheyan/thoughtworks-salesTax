package com.thoughtworks.tax.factory;

public enum Area {
	imported(true), domestic(false);
	private boolean isImported;

	Area(boolean isImported) {
		this.setImported(isImported);
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
}
