package com.thoughtworks.tax.service;

import java.math.BigDecimal;
import java.util.List;

import com.thoughtworks.tax.Bill;
import com.thoughtworks.tax.Product;

public class BillTaxCalculateServiceImpl implements BillTaxCalculateService {

	public BigDecimal calculateBillTax(Bill<Product> bill) {
		List<Product> list = bill.getProductList();
		BigDecimal bd = new BigDecimal(0);
		for (Product product : list) {
			bd = bd.add(product.getTaxCost());
		}
		return bd;
	}

	public BigDecimal calculateBillCost(Bill<Product> bill) {
		List<Product> list = bill.getProductList();
		BigDecimal bd = new BigDecimal(0);
		for (Product product : list) {
			bd = bd.add(product.getTotalCost());
		}
		return bd;
	}

}
