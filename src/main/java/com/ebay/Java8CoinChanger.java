package com.ebay;

import java.util.List;
import java.util.Optional;

import static com.ebay.Coins.*;
import static com.google.common.collect.Lists.newLinkedList;
import static java.util.Arrays.asList;
import static org.apache.commons.collections.ListUtils.union;

public class Java8CoinChanger implements CoinChanger {

    private List<Integer> coins = asList(HALF_DOLLAR, QUARTER, DIME, NICKEL, CENT);

    public List<Integer> getChange(int amount) {
        return getChange(amount, newLinkedList());
    }

    @SuppressWarnings("unchecked")
    private List<Integer> getChange(int amount, List change) {
        return findNextCoin(amount)
                .map(coin -> getChange(amount - coin, union(change, asList(coin))))
                .orElse(change);
    }

    private Optional<Integer> findNextCoin(int amount) {
        return coins
                .stream()
                .filter(coin -> coin <= amount)
                .findFirst();
    }
}
