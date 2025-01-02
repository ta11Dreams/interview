package com.prep.problem.queue;

import java.util.*;

//https://www.scaler.com/academy/mentee-dashboard/class/27043/assignment/problems/50
public class MaxInSlidingWindow {

    public ArrayList<Integer> slidingMaximum2(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for ( int i = 0; i < A.size(); i++ ) {
            if ( (i - B) >= 0 ) {
                if (deque.peek() == (int)A.get(i - B)) {
                    deque.poll();
                }
            }

            while (!deque.isEmpty() && (int)deque.peekLast() < A.get(i)) {
                deque.pollLast();
            }

            deque.add(A.get(i));

            if ( i >= (B - 1)) {
                result.add( deque.peek());
            }
        }

        return result;
    }


    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        deque.add(A.get(0));

        for ( int i = 1; i < B; i++ ) {
            Integer current = A.get(i);
            Integer first = deque.peek();

            if ( current > first ) {
                deque.clear();
            }
            deque.add(current);

        }

        result.add(deque.peek());

        for ( int i = B; i < A.size(); i++ ) {
            int remove_index = i - B;
            Integer remove_element = A.get(remove_index);
            Integer current = A.get(i);

            if ( remove_element == (int)deque.peek() ) {
                deque.poll();
            }

            // if (deque.isEmpty()) deque.add(current);

            if (!deque.isEmpty() && current > deque.peekFirst() ) {
                deque.clear();

            } else if (!deque.isEmpty() && current > deque.peekLast()) {
                while ( current < deque.peekLast() ) {
                    deque.pollLast();
                }

            }

            deque.add(current);

            result.add(deque.peek());
        }

        return result;

    }
}
