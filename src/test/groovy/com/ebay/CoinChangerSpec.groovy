package com.ebay

import spock.lang.Specification
import spock.lang.Unroll

class CoinChangerSpec extends Specification {

    CoinChanger coinChanger

    void setup() {
        coinChanger = new GroovyCoinChanger()
    }

    @Unroll
    void 'change for amount #amount is equal to #change'() {
        expect:
        coinChanger.getChange(amount) == change

        where:
        amount | change
        -1     | []
        0      | []
        1      | [1]
        2      | [1, 1]
        3      | [1, 1, 1]
        5      | [5]
        11     | [10, 1]
        34     | [25, 5, 1, 1, 1, 1]
        84     | [50, 25, 5, 1, 1, 1, 1]
    }

    void 'returns change for max int'() {
        expect:
        !coinChanger.getChange(1000000).isEmpty()
    }

}
