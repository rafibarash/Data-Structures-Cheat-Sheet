package DataStructures.Tree;

import java.util.*;

public class BinaryTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {

    private BinaryNodeInterface<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    public BinaryTree(T data, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        privateSetTree(data, leftTree, rightTree);
    }

    @Override
    public void setTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    }

    private void privateSetTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        root = new BinaryNode<T>(rootData);
        if (leftTree != null && !leftTree.isEmpty()) {
            BinaryNodeInterface<T> leftNode = ((BinaryTree<T>) leftTree).getRoot();
            root.setLeftChild(leftNode);
        }
        if (rightTree != null && !rightTree.isEmpty()) {
            BinaryNodeInterface<T> rightNode = ((BinaryTree<T>) rightTree).getRoot();
            if (rightTree == leftTree) {
                root.setRightChild(rightNode.copy());
            } else {
                root.setRightChild(rightNode);
            }

        }
        if (leftTree != null && leftTree != this) {
            leftTree.clear();
        }
        if (rightTree != null && rightTree != this) {
            rightTree.clear();
        }
    }

    @Override
    public T getRootData() {
        T rootData = null;
        if (root != null) {
            rootData = root.getData();
        }
        return rootData;
    }

    public BinaryNodeInterface<T> getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return root.getHeight();
    }

    @Override
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public void preorder() {
        root.preorder();
    }

    @Override
    public void inorder() {
        root.inorder();
    }

    @Override
    public void postorder() {
        root.postorder();
    }

    @Override
    public void levelorder() {
        root.levelorder();
    }
}
