package com.prep.problem.binary_tree;

import java.util.Stack;

//https://www.scaler.com/academy/mentee-dashboard/class/27061/assignment/problems/335
public class KthSmallestNumber {
    int count;
    Stack<Integer> stack = new Stack<>();

    public int kthsmallest(TreeNode A, int B) {
        count = B;
        //myApproachUsingQueue(A);
        //return stack.pop();

        return betterOne(A);
    }

    int betterOne(TreeNode A) {
        if (A == null) return -1;

        int result =  betterOne(A.left);
        // check the count after processing left node
        if (count == 0)
            return result;
        // decrement count if still found
        count--;
        result = A.val;

        // if found now return the result
        if (count == 0)
            return result;

        // otherwise the result lies in the right node
        return betterOne(A.right);
    }

    void myApproachUsingQueue(TreeNode A) {
        if (A == null) return;

        myApproachUsingQueue(A.left);

        if (stack.size() == count) return;

        stack.add(A.val);

        if (stack.size() == count) return;

        myApproachUsingQueue(A.right);

    }
}
