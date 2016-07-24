package com.ebay;

import java.util.LinkedList;
import java.util.List;

public class ChangeCalculator {

	private int insertedAmount;

	public ChangeCalculator() {
		this.insertedAmount = 0;
	}

	public List<Integer> getChange(int amount) {
		if (insertedAmount < amount) {
			return null;
		} else if (amount < 0) {
			return new LinkedList<Integer>();
		} else {
			int changeAmount = insertedAmount - amount;
			return new InfiniteCoinChanger().getChange(changeAmount);
		}
	}

	public void insert(int coin) {
		insertedAmount += coin;
	}
}
