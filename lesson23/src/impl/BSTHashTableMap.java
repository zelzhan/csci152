package impl;

import adt.HashTableMap;

public class BSTHashTableMap<K extends Comparable, V> implements HashTableMap<K, V> {
    private TreeNode<KeyValuePair<K, V>>[] hashtable;
    private int size, buckets;

    public BSTHashTableMap(int buckets){
        hashtable = new TreeNode[buckets];
        this.buckets = buckets;
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index > buckets || index < 0) throw new Exception("Out of range");
        if(hashtable[index] != null){
            return getBucketSizeHelper(hashtable[index], 1);
        }
        return 0;
    }

    private int getBucketSizeHelper(TreeNode<KeyValuePair<K, V>> node, int size){
        if(node.getLeft() != null){
            return getBucketSizeHelper(node.getLeft(), size+1);
        }
        if(node.getRight() != null){
            return getBucketSizeHelper(node.getRight(), size+1);
        }
        if(node == null) return size;
        return size;
    }

    @Override
    public double getLoadFactor() {
        return size/buckets;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double mean, sum2 = 0;
        mean = size/buckets;
        for(int j = 0; j<buckets; j++){
            try{
                if(hashtable[j] != null) sum2+=Math.pow(Math.abs(getBucketSize(j) - mean), 2);
                else sum2+=Math.pow(mean, 2);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return Math.sqrt(sum2/buckets);
    }

    @Override
    public String bucketsToString() {
        String string = "";
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] == null) continue;
            string += hashtable[i].toString() + '\n';
        }
        return string;
    }

    @Override
    public void define(K key, V value) {
        int index = Math.abs(key.hashCode())%buckets;
        if(hashtable[index] == null){
            hashtable[index] = new TreeNode<>(new KeyValuePair<>(key, value));
            size++;
            return;
        }
        TreeNode<KeyValuePair<K, V>> temp = defineHelper(hashtable[index], key);
        if (temp != null){
            temp.getValue().setValue(value);
            return;
        }
        insert(hashtable[index], new TreeNode<>(new KeyValuePair<>(key, value)));

    }

    private TreeNode<KeyValuePair<K, V>> defineHelper(TreeNode<KeyValuePair<K, V>> node, K key){
        if(node.getValue().getKey().compareTo(key) < 0 && node.getRight() != null){
            return defineHelper(node.getRight(), key);
        } else if(node.getValue().getKey().compareTo(key) > 0 && node.getLeft() != null){
            return defineHelper(node.getLeft(), key);
        } else if(node.getValue().getKey().equals(key)){
            return node;
        }
        return null;
    }

    private void insert(TreeNode<KeyValuePair<K, V>> root, TreeNode<KeyValuePair<K, V>> node){
        if(node.getValue().getKey().compareTo(root.getValue().getKey()) < 0 ){
            if(root.getLeft() == null){
                root.setLeft(node);
                return;
            }
            insert(root.getLeft(), node);
        } else if(node.getValue().getKey().compareTo(root.getValue().getKey())>0){
            if(root.getRight() == null){
                root.setRight(node);
                return;
            }
            insert(root.getRight(), node);
        }
    }

    @Override
    public V getValue(K key) {
        int index = Math.abs(key.hashCode())%buckets;
        TreeNode<KeyValuePair<K, V>> temp = defineHelper(hashtable[index], key);
        if(temp == null) return null;
        return temp.getValue().getValue();
    }

    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode())%buckets;
        if (find(key, index) == null) return null;
        if(hashtable[index] == null) return null;
        size--;
        try{
            if(getBucketSize(index) == 1){
               V temp = hashtable[index].getValue().getValue();
               hashtable[index] = null;
               return temp;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        TreeNode<KeyValuePair<K, V>> link = hashtable[index];
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
        if(link.getLeft() == null && link != hashtable[index]){
            if(prevLink.getValue().getKey().compareTo(key) < 0) prevLink.setRight(link.getRight());
            else prevLink.setLeft(link.getRight());
            return link.getValue().getValue();
        }

        if(link.getRight() == null && link != hashtable[index]){
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
                prevLink = hashtable[index];
                link.getRight().setLeft(hashtable[index].getLeft());
                hashtable[index] = link.getRight();
                System.out.println("1");
                return prevLink.getValue().getValue();
            }
            while(temp.getLeft() != null){
                temp2 = temp;
                temp = temp.getLeft();
            }
            temp2.setLeft(null);
            prevLink = hashtable[index];
            temp.setLeft(hashtable[index].getLeft());
            temp.setRight(hashtable[index].getRight());
            hashtable[index] = temp;
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
        if (size == 0) throw new Exception("Map is empty");
        for(int i = hashtable.length-1; i>-1; i--){
            if(hashtable[i] != null){
                TreeNode<KeyValuePair<K, V>> link = new TreeNode<>(new KeyValuePair<>(hashtable[i].getValue().getKey(),
                        hashtable[i].getValue().getValue()));
                size--;
                remove(hashtable[i].getValue().getKey());
                return link.getValue();
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public void clear() {
        hashtable = new TreeNode[buckets];
        this.buckets = buckets;
    }

    @Override
    public String toString(){
        String string = "";
        for(int i = 0; i < hashtable.length; i++){
            string += toStringHelper(hashtable[i]);
        }
        return "{" + string + " }";
    }

    private String toStringHelper(TreeNode<KeyValuePair<K, V>> node){
        if (node == null) return "";
        return  toStringHelper(node.getLeft()) + toStringHelper(node.getRight()) + " " +
                node.getValue();
    }

    private KeyValuePair<K, V> find(K value, int index) {
        return containsHelper(hashtable[index], value);
    }

    private KeyValuePair<K, V> containsHelper(TreeNode<KeyValuePair<K, V>> node, K value){
        if(node.getValue().getKey().compareTo(value) == 0) return node.getValue();
        if(node.getValue().getKey().compareTo(value) < 0 && node.getRight() != null) return containsHelper(node.getRight(), value);
        else if(node.getValue().getKey().compareTo(value) > 0 && node.getLeft() != null) return containsHelper(node.getLeft(), value);
        return null;
    }
}
