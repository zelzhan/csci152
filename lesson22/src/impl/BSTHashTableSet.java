/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package impl;

import adt.HashTableSet;

public class BSTHashTableSet<T extends  Comparable> implements HashTableSet<T> {
    private BSTSet<T>[] hashtable;
    private int size, buckets;

    public BSTHashTableSet(int buckets){
        hashtable = new BSTSet[buckets];
        this.buckets = buckets;
    }


    @Override
    public int getNumberOfBuckets() {
        return buckets;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index > buckets || index < 0) throw new Exception("Out of range");
        return hashtable[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return size/buckets;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double sum1 = 0, mean, sum2 = 0;
        for(int i = 0; i<buckets; i++) if(hashtable[i] != null) sum1+=hashtable[i].getSize();
        mean = sum1/buckets;
        for(int j = 0; j<buckets; j++){
            if (hashtable[j] != null) sum2+=Math.pow(Math.abs(hashtable[j].getSize() - mean), 2);
        }

        return Math.sqrt(sum2/buckets);
    }

    @Override
    public String bucketsToString() {
        return toString();
    }

    @Override
    public void add(T value) {
        if(contains(value)) return;
        size++;
        int index = Math.abs(value.hashCode())%buckets;
        if(hashtable[index] == null) hashtable[index] = new BSTSet<>();
        hashtable[index].add(value);
    }

    @Override
    public boolean contains(T value) {
        int index = Math.abs(value.hashCode())%buckets;
        if(hashtable[index] == null) return false;
        return hashtable[index].contains(value);
    }

    @Override
    public boolean remove(T value) {
        int index = Math.abs(value.hashCode())%buckets;
        return hashtable[index].remove(value);
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0) throw new Exception("Exceeeeeeption");
        for(int i = 0; i < buckets; i++){
            if(hashtable[i].getSize() != 0){
                size--;
                return hashtable[i].removeAny();
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
        hashtable = new BSTSet[buckets];
        size = 0;
    }

    @Override
    public String toString(){
        String string = "";
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] == null) continue;
            string += hashtable[i].toString() + '\n';
        }
        return string;
    }

}
