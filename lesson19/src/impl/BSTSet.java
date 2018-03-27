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
        if (!contains(value)) return false;
        size--;
        TreeNode<T> link = root;
        TreeNode<T> prevLink = link;
        while(!link.getValue().equals(value)){
            if(link.getValue().compareTo(value) < 0){
                prevLink = link;
                link = link.getRight();
            }
            if(link.getValue().compareTo(value) > 0){
                prevLink = link;
                link = link.getLeft();
            }
        }
        //case 1
        if(link.getRight()==null && link.getLeft() == null){
            if(prevLink.getValue().compareTo(value) < 0) prevLink.setRight(null);
            else prevLink.setLeft(null);
            return true;
        }

        //case 2
        if(link.getLeft() == null){
            if(prevLink.getValue().compareTo(value) < 0) prevLink.setRight(link.getRight());
            else prevLink.setLeft(link.getRight());
            return true;
        }

        if(link.getRight() == null){
            if(prevLink.getValue().compareTo(value) < 0) prevLink.setRight(link.getLeft());
            else prevLink.setLeft(link.getLeft());
            return true;
        }

        //case 3
        TreeNode<T> temp = link.getRight();
        TreeNode<T> temp2 = link;

        //root case
        if(link == prevLink){
            if(link.getRight().getLeft() == null){
                link.getRight().setLeft(root.getLeft());
                root = link.getRight();
                return true;
            }
            while(temp.getLeft() != null){
                temp2 = temp;
                temp = temp.getLeft();
            }
            temp2.setLeft(null);
            temp.setLeft(root.getLeft());
            temp.setRight(root.getRight());
            root = temp;
            return true;
        };

        //general case
        if(temp.getLeft() == null){
            temp.setLeft(link.getLeft());
            if(prevLink.getValue().compareTo(temp.getValue()) < 0) prevLink.setRight(temp);
            else prevLink.setLeft(temp);
            return true;
        }
        while(temp.getLeft() != null){
            temp2 = temp;
            temp = temp.getLeft();
        }
        temp2.setLeft(temp.getRight());
        temp.setLeft(link.getLeft());
        temp.setRight(link.getRight());
        if(prevLink.getValue().compareTo(temp.getValue()) < 0) prevLink.setRight(temp);
        else prevLink.setLeft(temp);

        return true;
    }

    @Override
    public T removeAny() throws Exception {
//        if(size == 0) throw new Exception("Exception");
//        TreeNode<T> node = root;
//        while(node != null && size != 1) node = node.getLeft();

        if(size == 0) throw new Exception("Exception");
        T value = root.getValue();
        remove(root.getLeft().getValue());
        return value;
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
