package com.prep.problem.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MaxMinSlidingWindow {
    Deque<Integer> max_deque = new ArrayDeque<>();
    Deque<Integer> min_deque = new ArrayDeque<>();
    Integer max;
    Integer min;

    void push_max(Integer num) {
        if (max_deque.isEmpty()) {
            max_deque.add(num);
        } else {

            while (!max_deque.isEmpty() && max_deque.peekLast() < num) {
                max_deque.pollLast();
            }

            max_deque.add(num);
        }

    }

    void push_min(Integer num) {
        if (min_deque.isEmpty()) {
            min_deque.add(num);
        } else {

            while (!min_deque.isEmpty() && min_deque.peekLast() > num) {
                min_deque.pollLast();
            }

            min_deque.add(num);
        }

    }

    void pop_max(Integer num) {
        if ( !max_deque.isEmpty() && max_deque.peek() == num ) {
            max_deque.pollFirst();
        }

    }

    void pop_min(Integer num) {
        if ( !min_deque.isEmpty() && min_deque.peek() == num ) {
            min_deque.pollFirst();
        }

    }

    public int solve(List<Integer> A, int B) {
        int max, min;
        long result = 0;
        int firstMax = 0, firstMin = 0;

        for (int i = 0; i < A.size(); i++) {
            push_max(A.get(i));
            push_min(A.get(i));

            if ( i - B >= 0 ) {
                pop_max(A.get(i - B));
                pop_min(A.get(i - B));
            }

            if ( i >= (B-1)) {
                max = max_deque.peek();
                min = min_deque.peek();
                result = (((result + min) % 1000000007) + max) % 1000000007;
            }
        }

        return (int) result;
    }
}
