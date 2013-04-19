package com.thoughtworks.tax;

import java.util.ArrayList;
import java.util.List;

public class Bill<T> {

	private List<T> productList;

	public Bill() {
		setProductList(new ArrayList<T>());
	}

	public List<T> getProductList() {
		return productList;
	}

	public void setProductList(List<T> productList) {
		this.productList = productList;
	}

	public void clean() {
		productList.clear();
	}

	public void add(T product) {
		productList.add(product);
	}
}
