package com.prep.problem.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDeserializer {
    public TreeNode levelOrderDeserialisation (String serializedString) {

        String[] nodeValues = serializedString.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int value = Integer.parseInt(nodeValues[count]);

            if ( value != -1 ) {
                node.left = new TreeNode(value);
                queue.add(node.left);
            }
            count++;

            value = Integer.parseInt(nodeValues[count]);

            if (value != -1) {
                node.right = new TreeNode(value);
                queue.add(node.right);
            }

            count++;
        }

        return root;
    }
}
