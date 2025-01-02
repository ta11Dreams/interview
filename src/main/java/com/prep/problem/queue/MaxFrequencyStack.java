package com.prep.problem.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MaxFrequencyStack {

    /**
     * freq_stack is map that stores the freq -> stack of all elements with that freq, in order latest first
     * freq_map stores the freq of the element and is used to find the stack in the above map to place is right stack
     * the highest is stored as we build the freq_map, and keep reducing it when we poll it and is then used to find the next one
     */
    HashMap<Integer, Stack<Integer> > freq_stack;//freq --> all elements with that freq contained in stack
    HashMap<Integer, Integer> freq_map; // element --> its freq

    int highest_freq = 0;

    public void push(int n) {
        if (!freq_map.containsKey(n)) {
            freq_map.put(n, 1);
        } else {
            freq_map.put(n, freq_map.get(n) + 1);
        }

        int freq = freq_map.get(n);

        if (!freq_stack.containsKey(freq)) {
            freq_stack.put(freq, new Stack<>());
        }

        freq_stack.get(freq).push(n);
        if (freq > highest_freq) {
            highest_freq = freq;
        }
    }

    public int pop() {
        if (highest_freq == 0) return -1;
        int n = freq_stack.get(highest_freq).pop();
        if (freq_stack.get(highest_freq).isEmpty()) {
            highest_freq--;
        }
        freq_map.put(n, freq_map.get(n) - 1);
        return n;
    }

    public ArrayList<Integer> solve(List<List<Integer>> A) {
        freq_stack = new HashMap<>();
        freq_map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i).get(0) == 1)
            {
                //push
                push(A.get(i).get(1));
                ans.add(-1);
            }
            else
            {
                //pop
                int v = pop();
                if(v == -1) continue;
                ans.add(v);
            }
        }
        return ans;
    }
}
