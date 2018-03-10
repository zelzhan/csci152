/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package impl;
import adt.Set;

public class BSTSet<T extends Comparable> implements Set<T> {
    private TreeNode<T> root;
    private int size;

    public BSTSet(){
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if(root == null){
            root = new TreeNode<>(value);
            size++;
            return;
        }
        if(contains(value)) return;
        size++;
        TreeNode link = addHelper(root, value);
        if(value.compareTo(link.getValue()) < 0){
            link.setLeft(new TreeNode(value));
        } else {
            link.setRight(new TreeNode(value));
        }
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    @Override
    public boolean remove(T value) {
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String toString(){
        return "{" + toStringHelper(root)+ " }";
    }

    private String toStringHelper(TreeNode<T> node){
        if (node == null) return "";
        return  toStringHelper(node.getLeft()) + toStringHelper(node.getRight()) + " " +
                node.getValue();

    }

    private TreeNode addHelper(TreeNode<T> node, T value){
        if(node.getValue().compareTo(value) < 0){
            if(node.getRight() == null) return node;
            node = addHelper(node.getRight(), value);
        } else if(node.getValue().compareTo(value) > 0){
            if(node.getLeft() == null) return node;
            node = addHelper(node.getLeft(), value);
        }
        return node;
    }

    private boolean containsHelper(TreeNode<T> node, T value){
        if(node.getValue().compareTo(value) == 0) return true;
        if(node.getValue().compareTo(value) < 0 && node.getRight() != null){
            return containsHelper(node.getRight(), value);
        } else if(node.getValue().compareTo(value) > 0 && node.getLeft() != null) {
            return containsHelper(node.getLeft(), value);
        }
        return false;
    }


    /**
     *                      5               9
     *                       \
     *                       7.5
     *                       / \
     *                      7   10
     *                     / \
     *                   6.5 7.25
     */

}
