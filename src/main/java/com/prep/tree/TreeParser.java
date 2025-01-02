package com.prep.tree;

import lombok.Data;

import java.util.List;

public class TreeParser {

    public <T> TreeNode<T> parse(List<T> serializedList) {
        if (serializedList == null || serializedList.isEmpty()) {
            return null;
        }
        T value = serializedList.get(0);
        TreeNode<T> root = new TreeNode<>();

        return root;
    }
}

//record TreeNode<T> (TreeNode<T> left, TreeNode<T> right, T value) {}

@Data
class TreeNode<T> {

}
