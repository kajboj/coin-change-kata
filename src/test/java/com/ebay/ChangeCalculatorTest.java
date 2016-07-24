package com.ebay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collections;

import org.junit.Test;
import static java.util.Arrays.asList;

public class ChangeCalculatorTest {
	private ChangeCalculator calculator;

	public ChangeCalculatorTest() {
		calculator = new ChangeCalculator();
	}

	@Test
	public void returnsNoChangeWhenNoCoinsInsertedAndChangeForZeroAmount() {
		assertEquals(Collections.emptyList(), calculator.getChange(0));
	}

	@Test
	public void returnsNoChangeWhenNoCoinsInsertedAndChangeForNegativeAmount() {
		assertEquals(Collections.emptyList(), calculator.getChange(-1));
	}

	@Test
	public void returnsNullWhenNoCoinsInsertedAndChangeForNonZeroAmount() {
		assertNull(calculator.getChange(1));
	}

	@Test
	public void returnsNullWhenCoinsInsertedAndChangeForAmountGreaterThanInserted() {
		calculator.insert(Coins.CENT);
		assertNull(calculator.getChange(2));
	}

	@Test
	public void returnsCorrectChangeWhenEnoughCoinsInserted() {
		calculator.insert(Coins.QUARTER);     // 25
		calculator.insert(Coins.HALF_DOLLAR); // 75
		calculator.insert(Coins.DIME);        // 85
		assertEquals(asList(Coins.NICKEL, Coins.CENT), calculator.getChange(79));
	}

	@Test
	public void returnsCorrectChangeWhenSomeCoinsInsertedAndChangeForZero() {
		calculator.insert(Coins.NICKEL);
		assertEquals(asList(Coins.NICKEL), calculator.getChange(0));
	}
}
