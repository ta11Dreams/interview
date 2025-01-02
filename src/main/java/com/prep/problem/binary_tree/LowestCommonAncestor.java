package com.prep.problem.binary_tree;

import java.util.Stack;

public class LowestCommonAncestor {
    Stack<TreeNode> stack = new Stack<>();

    public TreeNode find(TreeNode A, int B, int C) {
        int temp = Math.min(B, C);
        C = Math.max(B, C);
        B = temp;

        constructPath(A, B, stack);

        while ( !stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (contains(node, C)) return  node;
        }

        return null;
    }

    void constructPath (TreeNode A, int value, Stack<TreeNode> stack) {
        if ( A == null ) return;

        if ( A.val > value) {
            stack.add(A);
            constructPath(A.left, value, stack);
        } else if (A.val < value) {
            stack.add(A);
            constructPath(A.right, value, stack);
        } else {
            // do nothing
        }
    }

    boolean contains(TreeNode A, int value) {
        if (A == null) return false;

        if ( A.val == value ) return true;

        if ( A.val < value) return contains(A.right, value);
        else return contains(A.left, value);

    }
}
