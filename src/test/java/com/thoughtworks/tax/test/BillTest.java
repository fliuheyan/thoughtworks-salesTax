package com.thoughtworks.tax.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.tax.Bill;
import com.thoughtworks.tax.BoardFreeTaxProduct;
import com.thoughtworks.tax.Product;
import com.thoughtworks.tax.factory.AbstractFactory;
import com.thoughtworks.tax.factory.BoardFreeTaxProductFactory;
import com.thoughtworks.tax.factory.BoardTaxProductFactory;
import com.thoughtworks.tax.factory.DomesticFreeTaxProductFactory;
import com.thoughtworks.tax.factory.DomesticTaxProductFactory;
import com.thoughtworks.tax.service.BillTaxCalculateService;
import com.thoughtworks.tax.service.BillTaxCalculateServiceImpl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SuppressWarnings("unused")
public class BillTest {
	private static final BigDecimal ROUND_OFF_FACTOR = new BigDecimal("0.05");
	private AbstractFactory boardFreeTaxFactory;
	private AbstractFactory domesticFreeTaxFactory;
	private AbstractFactory boardTaxFactory;
	private AbstractFactory domesticTaxFactory;
	private BillTaxCalculateService bcs;
	private Bill<Product> bill;

	@Before
	public void init() {
		boardFreeTaxFactory = new BoardFreeTaxProductFactory();
		domesticFreeTaxFactory = new DomesticFreeTaxProductFactory();
		boardTaxFactory = new BoardTaxProductFactory();
		domesticTaxFactory = new DomesticTaxProductFactory();
		bcs = new BillTaxCalculateServiceImpl();
		bill = new Bill<Product>();
	}

	@Test
	public void testBook_Music_Chocolate() {
		Product book = domesticFreeTaxFactory.createProduct("book",
				new BigDecimal("12.49"));
		Product musicCD = domesticTaxFactory.createProduct("music CD",
				new BigDecimal("14.99"));
		Product chocolate = domesticFreeTaxFactory.createProduct(
				"chocolate bar", new BigDecimal("0.85"));
		bill.add(book);
		bill.add(musicCD);
		bill.add(chocolate);
		assertThat(book.getTaxCost().toString(), is("0.00"));
		assertThat(musicCD.getTaxCost().toString(), is("1.50"));
		assertThat(chocolate.getTaxCost().toString(), is("0.00"));
		assertThat(bcs.calculateBillTax(bill).doubleValue(), is(1.50d));
		assertThat(bcs.calculateBillCost(bill).doubleValue(), is(29.83d));
	}

	@Test
	public void testImportedChocolate_ImportedPerFume() {
		Product importedChocolate = boardFreeTaxFactory.createProduct(
				"chocolate", new BigDecimal("10.00"));
		Product imporetedPerfume = boardTaxFactory.createProduct("perfum",
				new BigDecimal("47.50"));
		bill.add(imporetedPerfume);
		bill.add(importedChocolate);
		assertThat(importedChocolate.getTotalCost().doubleValue(), is(10.5d));
		assertThat(imporetedPerfume.getTotalCost().doubleValue(), is(54.65d));
		assertThat(bcs.calculateBillTax(bill).doubleValue(), is(7.65d));
		assertThat(bcs.calculateBillCost(bill).doubleValue(), is(65.15d));
	}

	@Test
	public void testImportedPerfume_perfume_pill_chocolate() {
		Product importedPerfume = boardTaxFactory.createProduct(
				"imported perfume", new BigDecimal("27.99"));
		Product perfume = domesticTaxFactory.createProduct("perfume",
				new BigDecimal("18.99"));
		Product pill = domesticFreeTaxFactory.createProduct("pills",
				new BigDecimal("9.75"));
		Product importedChocolate = boardFreeTaxFactory.createProduct(
				"imported chocolate", new BigDecimal("11.25"));
		bill.add(importedPerfume);
		bill.add(perfume);
		bill.add(pill);
		bill.add(importedChocolate);
		assertThat(bcs.calculateBillTax(bill).doubleValue(), is(6.70d));
		assertThat(bcs.calculateBillCost(bill).doubleValue(), is(74.68d));
	}

	@Test
	public void testImportedPerfume_perfume_pill_ImportedChocolate() {
		BigDecimal bd = new BigDecimal("0.01").setScale(2,
				BigDecimal.ROUND_HALF_EVEN);
		System.out.println(bd.toString());
	}

}
