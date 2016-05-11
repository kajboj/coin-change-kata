package com.ebay;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newLinkedList;
import static java.util.Arrays.asList;
import static java.util.Map.Entry;
import static org.junit.Assert.assertEquals;

public class CoinChangerTest {

    Map<Integer, List<Integer>> values = new ImmutableMap.Builder<Integer, List<Integer>>()
            .put(-1, newLinkedList())
            .put(0, newLinkedList())
            .put(1, asList(1))
            .put(2, asList(1, 1))
            .put(3, asList(1, 1, 1))
            .put(5, asList(5))
            .put(11, asList(10, 1))
            .put(34, asList(25, 5, 1, 1, 1, 1))
            .put(84, asList(50, 25, 5, 1, 1, 1, 1))
            .build();

    @Test
    public void returnsChangeForAmountJava8() {
        checkChange(new Java8CoinChanger());
    }

    @Test
    public void returnsChangeForAmountJava7() {
        checkChange(new Java7CoinChanger());
    }

    private void checkChange(CoinChanger coinChanger) {
        for (Entry<Integer, List<Integer>> value : values.entrySet()) {
            assertEquals(value.getValue(), coinChanger.getChange(value.getKey()));
        }
    }
}
