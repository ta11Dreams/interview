package com.prep.problem.binary_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeDeserializerTest {

    TreeDeserializer obj = new TreeDeserializer();

    @Test
    public void levelOrderDeserialisation() {
        String serialized = "1 2 3 -1 -1 -1 -1";

        TreeNode root = obj.levelOrderDeserialisation(serialized);

        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertNull(root.left.left);

    }
}