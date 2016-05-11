package com.ebay

import groovy.transform.TailRecursive

import static com.ebay.Coins.*
import static java.util.Arrays.asList
import static org.apache.commons.collections.ListUtils.union

class GroovyCoinChanger implements CoinChanger {

    private List coins = [HALF_DOLLAR, QUARTER, DIME, NICKEL, CENT]

    @TailRecursive
    List getChange(int amount, List change = []) {
        def coin = findNextCoin(amount)
        coin.isPresent() ? getChange(amount - coin.get(), union(change, asList(coin.get()))) : change
    }

    private Optional findNextCoin(int amount) {
        Optional.ofNullable(coins.find { it <= amount })
    }

}
