package impl;/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
import adt.Set;
import sun.reflect.generics.tree.Tree;

public class BST2Set<T extends Comparable> implements Set<T> {
    private OnOffTreeNode<T> root;
    private int size;

    public BST2Set(){
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if(root == null){
            root = new OnOffTreeNode<>(value);
            root.setActive(true);
            size++;
            return;
        }
        if(contains(value)) return;
        size++;
        OnOffTreeNode link = addHelper(root, value);
        if(value.compareTo(link.getValue()) < 0){
            if(link.getLeft() != null){
                link.getLeft().setActive(true);
                return;
            }
            link.setLeft(new OnOffTreeNode(value));
            link.getLeft().setActive(true);
        } else {
            if(link.getRight() != null){
                link.getRight().setActive(true);
                return;
            }
            link.setRight(new OnOffTreeNode(value));
            link.getRight().setActive(true);
        }
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    @Override
    public boolean remove(T value) {
        OnOffTreeNode<T> node = root;
        if (activeOrNot(root, value)) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    node.setActive(false);
                    size--;
                    return true;
                } else {
                    if (node.getValue().compareTo(value) > 0) {
                        node = node.getLeft();
                    } else if (node.getValue().compareTo(value) < 0) {
                        node = node.getRight();
                    }
                }
            }
        }
        return false;
    }



    private boolean activeOrNot(OnOffTreeNode<T> node, T value){
        boolean result;
        if(node==null){
            return false;
        }
        if(node.getValue().compareTo(value)>0){
            result = activeOrNot(node.getLeft(), value);
        } else if(node.getValue().compareTo(value)<0){
            result = activeOrNot(node.getRight(), value);
        }else{
            return node.isActive();
        }
        return result;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0) throw new Exception("Exception");
        OnOffTreeNode<T> node = removeAnyHelper(root);
        size--;
        return node.getValue();
    }

    private OnOffTreeNode removeAnyHelper(OnOffTreeNode node){
        if ((node.getRight() == null || node.getRight().isActive() == false)
                && (node.getLeft() == null || node.getLeft().isActive() == false)){
            node.setActive(false);
            return node;
        }
        if(node.getLeft() == null || node.getLeft().isActive() == false){
           node = removeAnyHelper(node.getRight());
        }
        if(node.getRight() == null || node.getRight().isActive() == false)
            node = removeAnyHelper(node.getLeft());
        return node;
    }

    public T getRoot(){
        return root.getValue();
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

    private String toStringHelper(OnOffTreeNode<T> node) {
        if (node == null) {
            return "";
        }else if(!node.isActive()){
            return toStringHelper(node.getLeft()) + toStringHelper(node.getRight());
        }else{
            return toStringHelper(node.getLeft()) + " " + node + " " + toStringHelper(node.getRight());
        }
    }

    private OnOffTreeNode addHelper(OnOffTreeNode<T> node, T value){
        if(node.getValue().compareTo(value) < 0){
            if(node.getRight() == null) {
                return node;
            } else if(node.getRight().isActive() == false){
                return node;            }
            node = addHelper(node.getRight(), value);
        } else if(node.getValue().compareTo(value) > 0){
            if(node.getLeft() == null){
                return node;
            } else if (node.getLeft().isActive() == false){
                return node;
            }
            node = addHelper(node.getLeft(), value);
        }
        return node;
    }

    private boolean containsHelper(OnOffTreeNode<T> node, T value){
        if(node.getValue().compareTo(value) == 0 && node.isActive() == true) return true;
        if(node.getValue().compareTo(value) < 0 && node.getRight() != null){
            return containsHelper(node.getRight(), value);
        } else if(node.getValue().compareTo(value) > 0 && node.getLeft() != null) {
            return containsHelper(node.getLeft(), value);
        }
        return false;
    }
}
