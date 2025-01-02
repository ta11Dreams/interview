package com.prep.problem.queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaxInSlidingWindowTest {

    MaxInSlidingWindow obj = new MaxInSlidingWindow();

    @Test
    public void testSolve() {
        ArrayList<Integer> list = new ArrayList<>(List.of(10,9,8,7,6,5,4,3,2,1));

        ArrayList<Integer> op = obj.slidingMaximum2(list, 1);

        assertEquals(List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), op);
    }

    @Test
    public void testSolve1() {
        ArrayList<Integer> list = new ArrayList<>(List.of(10,9,8,7,6,5,4,3,2,1));

        ArrayList<Integer> op = obj.slidingMaximum2(list, 2);

        assertEquals(List.of(10, 9, 8, 7, 6, 5, 4, 3, 2), op);
    }
    @Test
    public void testSolve2() {
        ArrayList<Integer> list = new ArrayList<>(List.of(648,614,490,138,657,544,745,582,738,229,775,665,876,448,4,81,807,578,712,951,867,328,308,440,542,178,637,446,882,760,354,523,935,277,158,698,536,165,892,327,574,516,36,705,900,482,558,937,207,368));

        ArrayList<Integer> op = obj.slidingMaximum2(list, 9);

        assertEquals(List.of(745,745,775,775,876,876,876,876,876,876,876,951,951,951,951,951,951,951,951,951,882,882,882,882,935,935,935,935,935,935,935,935,935,892,892,892,900,900,900,937,937,937), op);
    }
}