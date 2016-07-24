package com.ebay;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.ImmutableList;

@RunWith(Parameterized.class)
public class InfiniteCoinChangerTest {
	private int amount;
	private List<Integer> expectedChange;
	private CoinChanger coinChanger;
    
    public InfiniteCoinChangerTest(int amount, List<Integer> expectedChange) {
    	this.amount = amount;
    	this.expectedChange = expectedChange;
    	this.coinChanger = new InfiniteCoinChanger();
    }

    @Parameters
    public static Collection<Object[]> setParameters() {
        Collection<Object[]> params = new ArrayList<>();
        params.add(new Object[] {-1, ImmutableList.<Integer>of()});
        params.add(new Object[] {0, ImmutableList.<Integer>of()});
        params.add(new Object[] {1, asList(1)});
		params.add(new Object[] {2, asList(1, 1)});
		params.add(new Object[] {3, asList(1, 1, 1)});
		params.add(new Object[] {5, asList(5)});
		params.add(new Object[] {11, asList(10, 1)});
		params.add(new Object[] {34, asList(25, 5, 1, 1, 1, 1)});
		params.add(new Object[] {84, asList(50, 25, 5, 1, 1, 1, 1)});

        return params;
    }
    
    @Test
    public void returnsChangeForAmount() {
    	assertEquals(expectedChange, coinChanger.getChange(amount));
    }
}
