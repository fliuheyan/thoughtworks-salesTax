package com.thoughtworks.tax.service;

import java.math.BigDecimal;

import com.thoughtworks.tax.Bill;
import com.thoughtworks.tax.Product;

public interface BillTaxCalculateService {
	public BigDecimal calculateBillTax(Bill<Product> bill);

	public BigDecimal calculateBillCost(Bill<Product> bill);
}
