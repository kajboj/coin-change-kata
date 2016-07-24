package com.ebay;

import java.util.LinkedList;
import java.util.List;

public class ChangeCalculator {

	private int insertedAmount;
	private CoinChanger coinChanger;

	public ChangeCalculator(CoinChanger coinChanger) {
		this.coinChanger = coinChanger;
		this.insertedAmount = 0;
	}

	public List<Integer> getChange(int amount) {
		if (insertedAmount < amount) {
			return null;
		} else if (amount < 0) {
			return new LinkedList<Integer>();
		} else {
			int changeAmount = insertedAmount - amount;
			return coinChanger.getChange(changeAmount);
		}
	}

	public void insert(int coin) {
		insertedAmount += coin;
	}
}
