package com.prep.problem.binary_tree;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public class BuildTreeFromInorderPostOrderTest {

    BuildTreeFromInorderPostOrder obj = new BuildTreeFromInorderPostOrder();

    @Test
    public void testBuildTree() {
        obj.buildTree(List.of(2, 1, 3), List.of(2, 3, 1));
    }
}