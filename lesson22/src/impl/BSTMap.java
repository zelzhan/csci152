
package impl;

import adt.Map;

public class BSTMap<K extends Comparable, V> implements Map<K, V> {

    private TreeNode<KeyValuePair<K,V>> root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void define(K key, V value) {
        if(root == null){
            root = new TreeNode(new KeyValuePair<K, V>(key, value));
            size++;
        }
        KeyValuePair<K, V> temp = find(key);
        if(temp != null) {
            temp.setValue(value);
            return;
        }
        TreeNode<KeyValuePair<K, V>> link = defineHelper(root, key);
        if(key.compareTo(link.getValue().getKey()) < 0) link.setLeft(new TreeNode(new KeyValuePair<K, V>(key, value)));
        else link.setRight(new TreeNode(new KeyValuePair<K, V>(key, value)));
        size++;
    }

    private TreeNode<KeyValuePair<K, V>> defineHelper(TreeNode<KeyValuePair<K, V>> node, K value){
        if(node.getValue().getKey().compareTo(value) < 0){
            if(node.getRight() == null) return node;
            node = defineHelper(node.getRight(), value);
        } else if(node.getValue().getKey().compareTo(value) > 0){
            if(node.getLeft() == null) return node;
            node = defineHelper(node.getLeft(), value);
        }
        return node;
    }


    private KeyValuePair<K, V> find(K value) {
        return containsHelper(root, value);
    }

    private KeyValuePair<K, V> containsHelper(TreeNode<KeyValuePair<K, V>> node, K value){
        if(node.getValue().getKey().compareTo(value) == 0) return node.getValue();
        if(node.getValue().getKey().compareTo(value) < 0 && node.getRight() != null) return containsHelper(node.getRight(), value);
        else if(node.getValue().getKey().compareTo(value) > 0 && node.getLeft() != null) return containsHelper(node.getLeft(), value);
        return null;
    }

    @Override
    public V getValue(K key) {
        return find(key).getValue();
    }

    @Override
    public V remove(K key) {
        if (find(key) == null) return null;
        size--;
        TreeNode<KeyValuePair<K, V>> link = root;
        TreeNode<KeyValuePair<K, V>> prevLink = link;
        while(!link.getValue().getKey().equals(key)){
            if(link.getValue().getKey().compareTo(key) < 0){
                prevLink = link;
                link = link.getRight();
            }
            if(link.getValue().getKey().compareTo(key) > 0){
                prevLink = link;
                link = link.getLeft();
            }
        }

        //case 1
        if(link.getRight()==null && link.getLeft() == null){
            if(prevLink.getValue().getKey().compareTo(key) < 0) prevLink.setRight(null);
            else prevLink.setLeft(null);
            return link.getValue().getValue();
        }

        //case 2
        if(link.getLeft() == null && link != root){
            if(prevLink.getValue().getKey().compareTo(key) < 0) prevLink.setRight(link.getRight());
            else prevLink.setLeft(link.getRight());
            return link.getValue().getValue();
        }

        if(link.getRight() == null && link != root){
            if(prevLink.getValue().getKey().compareTo(key) < 0) prevLink.setRight(link.getLeft());
            else prevLink.setLeft(link.getLeft());
            return link.getValue().getValue();
        }

        //case 3
        TreeNode<KeyValuePair<K, V>> temp = link.getRight();
        TreeNode<KeyValuePair<K, V>> temp2 = link;

        //root case
        if(link == prevLink){
            if(link.getRight().getLeft() == null){
                prevLink = root;
                link.getRight().setLeft(root.getLeft());
                root = link.getRight();
                System.out.println("1");
                return prevLink.getValue().getValue();
            }
            while(temp.getLeft() != null){
                temp2 = temp;
                temp = temp.getLeft();
            }
            temp2.setLeft(null);
            prevLink = root;
            temp.setLeft(root.getLeft());
            temp.setRight(root.getRight());
            root = temp;
            System.out.println("2");
            return prevLink.getValue().getValue();
        };

        //general case
        if(temp.getLeft() == null){
            temp.setLeft(link.getLeft());
            if(prevLink.getValue().getKey().compareTo(temp.getValue()) < 0) prevLink.setRight(temp);
            else prevLink.setLeft(temp);
            return link.getValue().getValue();
        }
        while(temp.getLeft() != null){
            temp2 = temp;
            temp = temp.getLeft();
        }
        temp2.setLeft(temp.getRight());
        temp.setLeft(link.getLeft());
        temp.setRight(link.getRight());
        if(prevLink.getValue().getKey().compareTo(temp.getValue()) < 0) prevLink.setRight(temp);
        else prevLink.setLeft(temp);
        return link.getValue().getValue();
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(size == 0) throw new Exception("Exception");
        KeyValuePair<K, V> value = root.getValue();
        remove(root.getValue().getKey());
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

    private String toStringHelper(TreeNode<KeyValuePair<K, V>> node){
        if (node == null) return "";
        return  toStringHelper(node.getLeft()) + toStringHelper(node.getRight()) + " " +
                node.getValue();

    }
}