package com.prep.problem.binary_tree;

public class DistanceBetweenNodes {
    LowestCommonAncestor lca = new LowestCommonAncestor();

    public int findDistance(TreeNode A, int B, int C) {
        TreeNode common = lca.find(A, B, C);

        return distanceFromNode(common, B) + distanceFromNode(common, C);
    }

    public int distanceFromNode(TreeNode A, int value) {
        return 0;
    }
}
