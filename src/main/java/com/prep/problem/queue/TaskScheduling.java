package com.prep.problem.queue;

import java.util.*;

public class TaskScheduling {

    public int run(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count = 0 ;
        int curr = B.getFirst();
        int bi = 0;

        Queue<Integer> queue = new LinkedList<>(A);

        int num;
        while (!queue.isEmpty()) {
            num = queue.poll();

            if ( curr == num ) {
                bi++;
                if (bi < B.size())
                    curr = B.get(bi);
            } else {
                    queue.add(num);
            }
            count++;
        }

        return count;
    }
}
