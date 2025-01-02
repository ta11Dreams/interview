package com.prep.problem.binary_tree;

import java.util.*;

public class BuildTreeFromInorderPostOrder {
    public TreeNode buildTree(List<Integer> A, List<Integer> B) {

        Queue<TreeNode> ql = new LinkedList<>();
        Queue<TreeNode> qr = new LinkedList<>();
        Stack<Integer> root_stack = new Stack<>();

        Queue<TreeNode> temp = ql;

        Integer root_value = B.get(B.size() - 1);
        TreeNode root = new TreeNode(root_value);

        for (Integer i: B) {
            root_stack.push(i);
        }

        for (Integer i: A) {
            if (Objects.equals(i, root_stack.peek())) {
                temp = qr;
                root_stack.pop();
                //continue;
            } else {
                temp.add( new TreeNode(i));
            }

        }

        System.out.printf("%s %s %n", ql, qr);
        build_tree( root, ql, qr, root_stack);

        return root;
    }

    void build_tree( TreeNode root, Queue<TreeNode> ql, Queue<TreeNode> qr, Stack<Integer> root_stack ) {
        if (root == null ) return;

        if (!qr.isEmpty()) {
            Integer root_value = root_stack.pop();
            TreeNode _root = new TreeNode( root_value );
            root.right = _root;
            Queue<TreeNode> _qr = new LinkedList<>();
            Queue<TreeNode> _ql = new LinkedList<>();
            Queue<TreeNode> temp = _ql;

            while (!qr.isEmpty()) {

                if ( qr.peek().val == root_value ) {
                    temp = _qr;
                    continue;
                }

                temp.add( qr.poll() );
            }

            build_tree(_root, _ql, _qr, root_stack);
        }

        if (!ql.isEmpty()) {
            Integer root_value = root_stack.pop();
            TreeNode _root = new TreeNode( root_value );
            root.left = _root;
            Queue<TreeNode> _qr = new LinkedList<>();
            Queue<TreeNode> _ql = new LinkedList<>();
            Queue<TreeNode> temp = _ql;

            while (!ql.isEmpty()) {

                if ( ql.peek().val == root_value ) {
                    temp = _qr;
                    continue;
                }

                temp.add( ql.poll() );
            }

            build_tree(_root, _ql, _qr, root_stack);
        }


    }
}

