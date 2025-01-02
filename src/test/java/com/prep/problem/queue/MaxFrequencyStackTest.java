package com.prep.problem.queue;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MaxFrequencyStackTest {

    MaxFrequencyStack obj = new MaxFrequencyStack();

    @Test
    public void testSolve() {
        List<Integer> result = obj.solve(List.of(List.of(1,5),List.of(1,5),List.of(1,5),List.of(1,3),List.of(1,2),List.of(1,1),List.of(2,0),List.of(2,0),List.of(2,0),List.of(2,0)));

        assertEquals(List.of(-1, -1, -1, -1, -1,-1,5, 5, 1, 2), result);
    }
}