package com.prep.problem.binary_tree;

import java.util.ArrayList;

public class RecoverBinaryTree {
    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> recoverTree(TreeNode A) {
        bounds(A.left, A.val, Integer.MIN_VALUE);
        bounds(A.right, Integer.MAX_VALUE, A.val);

        if (result.size() == 1) {
           //int value = find(A, result.get(0));
           //result.add(value);
        }
        result.sort((a, b) -> (a > b ? 1 : -1));

        return result;
    }

    int find(TreeNode A, int value) {
        if ( A == null ) return -1;

        if ( value > A.val) return find(A.right, value);
        else return find(A.left, value);

    }

    void bounds(TreeNode A, int upper, int lower) {
        if (A == null) return;

        if ( A.val > upper || A.val < lower) {
            result.add(A.val);
            bounds(A.left, upper, lower);
            bounds(A.right, upper, lower);
        } else {
            bounds(A.left, A.val, lower);
            bounds(A.right, upper, A.val);
        }
    }
    void upperBound(TreeNode A, int upper, int lower) {
        if (A == null) return;

        upperBound(A.left, A.val, Integer.MIN_VALUE);
        if ( A.val > upper || A.val < lower) {
            result.add(upper);
            result.add(A.val);
        }
        lowerBound(A.right, upper, A.val);
    }

    void lowerBound(TreeNode A, int lower, int upper) {
        if (A == null) return;

        lowerBound(A.left, lower, Integer.MAX_VALUE);
        if ( A.val < lower || A.val > upper ) {
            result.add(A.val);
            result.add(lower);
        }
        upperBound(A.right, A.val, lower);
    }
}
