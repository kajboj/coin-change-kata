package com.ebay;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EndToEndTest {
	@Test
	public void changeCalculatorReturnsCorrectChange() {
		CoinChanger coinChanger = new InfiniteCoinChanger();
		ChangeCalculator calculator = new ChangeCalculator(coinChanger);

		calculator.insert(Coins.QUARTER);     // 25
		calculator.insert(Coins.HALF_DOLLAR); // 75
		calculator.insert(Coins.DIME);        // 85
		assertEquals(asList(Coins.NICKEL, Coins.CENT), calculator.getChange(79));
	}
}