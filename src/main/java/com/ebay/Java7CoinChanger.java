package com.ebay;

import java.util.List;

import static com.ebay.Coins.*;
import static com.google.common.collect.Lists.newLinkedList;
import static java.util.Arrays.asList;

public class Java7CoinChanger implements CoinChanger {

    private List<Integer> coins = asList(HALF_DOLLAR, QUARTER, DIME, NICKEL, CENT);

    public List<Integer> getChange(int amount) {
        List<Integer> change = newLinkedList();

        for (Integer coin : coins) {
            while (amount >= coin) {
                change.add(coin);
                amount = amount - coin;
            }
        }

        return change;
    }
}
