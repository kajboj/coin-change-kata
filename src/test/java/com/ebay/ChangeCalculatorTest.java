package com.ebay;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Test;

public class ChangeCalculatorTest {
	private ChangeCalculator calculator;
	private CoinChanger coinChangerMock;

	public ChangeCalculatorTest() {
		coinChangerMock = mock(CoinChanger.class);
		calculator = new ChangeCalculator(coinChangerMock);
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
		when(coinChangerMock.getChange(1)).thenReturn(asList(Coins.CENT));
		calculator.insert(Coins.NICKEL);
		assertEquals(asList(Coins.CENT), calculator.getChange(4));
		verify(coinChangerMock).getChange(1);
	}

	@Test
	public void returnsCorrectChangeWhenSomeCoinsInsertedAndChangeForZero() {
		when(coinChangerMock.getChange(5)).thenReturn(asList(Coins.NICKEL));
		calculator.insert(Coins.NICKEL);
		assertEquals(asList(Coins.NICKEL), calculator.getChange(0));
		verify(coinChangerMock).getChange(5);
	}
}