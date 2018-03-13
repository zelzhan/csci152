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

//    @Override
//    public boolean remove(T value) {
//        OnOffTreeNode<T> node = root;
//
//        if (active(root, value)) {
//            while (node != null) {
//                if (node.getValue().equals(value)) {
//                    node.setActive(false);
//                    size--;
//                    return true;
//                } else {
//                    if (node.getValue().compareTo(value) > 0) {
//                        node = node.getLeft();
//                    } else if (node.getValue().compareTo(value) < 0) {
//                        node = node.getRight();
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean active(OnOffTreeNode<T> node, T value){
//        boolean result;
//        if(node==null){
//            return false;
//        }
//        if(node.getValue().compareTo(value)>0){
//            result = active(node.getLeft(), value);
//        } else if(node.getValue().compareTo(value)<0){
//            result = active(node.getRight(), value);
//        }else{
//            return node.isActive();
//        }
//        return result;
//    }

//    public boolean remove(T value) {
//        if (!contains(value)) return false;
//        size--;
//        OnOffTreeNode<T> link = root;
//        OnOffTreeNode<T> prevLink = link;
//        while(!link.getValue().equals(value)){
//            if(link.getValue().compareTo(value) < 0){
//                prevLink = link;
//                link = link.getRight();
//            }
//            if(link.getValue().compareTo(value) > 0){
//                prevLink = link;
//                link = link.getLeft();
//            }
//        }
//
//        //case 1
//        if((link.getRight()==null || link.getRight().isActive() == false) && (link.getLeft().isActive() == false || link.getLeft() == null)){
//            if(prevLink.getValue().compareTo(value) < 0) prevLink.getRight().setActive(false);
//            else prevLink.getLeft().setActive(false);
//            return true;
//        }
//
//        //case 2
//        if(link.getLeft() == null || link.getLeft().isActive() == false){
//            if(prevLink.getValue().compareTo(value) < 0) prevLink.setRight(link.getRight());
//            else prevLink.setLeft(link.getRight());
//            return true;
//        }
//
//        if(link.getRight() == null || link.getRight().isActive() == false){
//            if(prevLink.getValue().compareTo(value) < 0) prevLink.setRight(link.getLeft());
//            else prevLink.setLeft(link.getLeft());
//            return true;
//        }
//
//        //case 3
//        OnOffTreeNode<T> temp = link.getRight();
//        OnOffTreeNode<T> temp2 = link;
//
//        //root case
//        if(link == prevLink){
//            while(temp.getLeft() != null || temp.getLeft().isActive() != false){
//                temp2 = temp;
//                temp = temp.getLeft();
//            }
//            temp2.setActive(false);
//            temp.setLeft(root.getLeft());
//            temp.setRight(root.getRight());
//            root = temp;
//            return true;
//        };
//
//        //general case
//        if(temp.getLeft() == null || temp.getLeft().isActive() == false){
//            temp.setLeft(link.getLeft());
//            if(prevLink.getValue().compareTo(temp.getValue()) < 0) prevLink.setRight(temp);
//            else prevLink.setLeft(temp);
//            return true;
//        }
//        while(temp.getLeft() != null || temp.getLeft().isActive() == false){
//            temp2 = temp;
//            temp = temp.getLeft();
//        }
//        temp2.getLeft().setActive(false);
//        temp.setLeft(link.getLeft());
//        temp.setRight(link.getRight());
//        if(prevLink.getValue().compareTo(temp.getValue()) < 0) prevLink.setRight(temp);
//        else prevLink.setLeft(temp);
//
//        return true;
//
//    }

    @Override
    public boolean remove(T value) {
        if (!contains(value)) return false;
        size--;
        OnOffTreeNode<T> link = root;
        OnOffTreeNode<T> prevLink = link;
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
        OnOffTreeNode<T> temp = link.getRight();
        OnOffTreeNode<T> temp2 = link;

        //root case
        if(link == prevLink){
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
        temp2.setLeft(null);
        temp.setLeft(link.getLeft());
        temp.setRight(link.getRight());
        if(prevLink.getValue().compareTo(temp.getValue()) < 0) prevLink.setRight(temp);
        else prevLink.setLeft(temp);

        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0) throw new Exception("Exception");
        T value = root.getValue();
        remove(root.getLeft().getValue());
        return value;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {
    }

    @Override
    public String toString(){
        return "{" + toStringHelper(root)+ " }";
    }

    private String toStringHelper(OnOffTreeNode<T> node){
        if (node == null) return "";
        return  toStringHelper(node.getLeft()) + toStringHelper(node.getRight()) + " " +
                node.getValue();

    }

    private OnOffTreeNode addHelper(OnOffTreeNode<T> node, T value){
        if(node.getValue().compareTo(value) < 0){
            if(!node.isActive() || node.getRight() == null) return node;
            node = addHelper(node.getRight(), value);
        } else if(node.getValue().compareTo(value) > 0){
            if(!node.isActive() || node.getLeft() == null) return node;
            node = addHelper(node.getLeft(), value);
        }
        return node;
    }

    private boolean containsHelper(OnOffTreeNode<T> node, T value){
        if(node.getValue().compareTo(value) == 0) return true;
        if(node.getValue().compareTo(value) < 0 && node.getRight() != null){
            return containsHelper(node.getRight(), value);
        } else if(node.getValue().compareTo(value) > 0 && node.getLeft() != null) {
            return containsHelper(node.getLeft(), value);
        }
        return false;
    }
}
