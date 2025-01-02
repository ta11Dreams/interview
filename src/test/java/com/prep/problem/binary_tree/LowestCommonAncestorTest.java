package com.prep.problem.binary_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {

    LowestCommonAncestor obj = new LowestCommonAncestor();

    @Test
    public void findTest1() {
        TreeDeserializer deserializer = new TreeDeserializer();
        String treeString = "5 2 8 1 3 6 11 -1 -1 -1 4 -1 -1 -1 -1 -1 -1";
        TreeNode A = deserializer.levelOrderDeserialisation(treeString);

        TreeNode B = obj.find(A, 1, 4);

        assertEquals(2, B.val);
    }

    @Test
    public void findTest2() {
        TreeDeserializer deserializer = new TreeDeserializer();
        String treeString = "5 2 8 1 3 6 11 -1 -1 -1 4 -1 -1 -1 -1 -1 -1";
        TreeNode A = deserializer.levelOrderDeserialisation(treeString);

        TreeNode B = obj.find(A, 6, 4);

        assertEquals(5, B.val);
    }


    @Test
    public void findTest3() {
        TreeDeserializer deserializer = new TreeDeserializer();
        String treeString = "5 2 8 1 3 6 11 -1 -1 -1 4 -1 -1 -1 -1 -1 -1";
        TreeNode A = deserializer.levelOrderDeserialisation(treeString);

        TreeNode B = obj.find(A, 2, 4);

        assertEquals(5, B.val);
    }
}