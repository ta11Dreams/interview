package com.prep.problem.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class UniqueLetter {
    public String solve(String A) {

        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < A.length(); i++ ) {
            Character ch = A.charAt(i);
            queue.add(ch);
            Integer freq = map.get(ch);

            if (freq == null) map.put(ch, 1);
            else map.put(ch, ++freq);

            Character head_ch = queue.peek();
            Integer head_freq = map.get(head_ch);

            while (!queue.isEmpty()) {
                head_ch = queue.peek();
                head_freq = map.get(head_ch);

                if (head_freq == 1) break;
                else queue.poll();
            }

            if (head_freq != 1) sb.append('#');
            else sb.append(head_ch);

        }

        return sb.toString();
    }
}
