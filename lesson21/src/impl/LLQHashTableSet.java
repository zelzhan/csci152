/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package impl;

import adt.HashTableSet;

public class LLQHashTableSet<T extends Comparable> implements HashTableSet<T> {
    private LinkedListQueue<T>[] hashtable;
    private int size, buckets;

    public LLQHashTableSet(int buckets){
        hashtable = new LinkedListQueue[buckets];
        this.buckets = buckets;
    }


    @Override
    public void add(T value) {
        if(contains(value)) return;
        size++;
        int index = Math.abs(value.hashCode())%buckets;
        if(hashtable[index] == null) hashtable[index] = new LinkedListQueue<T>();
        hashtable[index].enqueue(value);
    }

    @Override
    public boolean contains(T value) {
        int index = Math.abs(value.hashCode())%buckets;
        if(hashtable[index] == null) return false;
        for(int i = 0; i < hashtable[index].getSize(); i++){
            try{
                T temp = hashtable[index].dequeue();
                hashtable[index].enqueue(temp);
                if(temp == value) return true;
            } catch (Exception ex){
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        int index = Math.abs(value.hashCode())%buckets;
        boolean bool = false;
        for(int i = 0; i < hashtable[index].getSize(); i++){
            try{
                T temp = hashtable[index].dequeue();
                if(temp == value){
                    size--;
                    return true;
                }
                hashtable[index].enqueue(temp);
            } catch (Exception ex){
            }
        }
        return false;
    }


    @Override
    public T removeAny() throws Exception {
        if(size == 0) throw new Exception("Exceeeeeeption");
        for(int i = 0; i < buckets; i++){
            if(hashtable[i].getSize() != 0){
                size--;
                return hashtable[i].dequeue();
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
        hashtable = new LinkedListQueue[buckets];
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

    @Override
    public int getNumberOfBuckets() {
        return buckets;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index > buckets || index < 0) throw new Exception("Out of range");
        if(hashtable[index] != null) return hashtable[index].getSize();
        return 0;
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
            if(hashtable[j] != null) sum2+=Math.pow(Math.abs(hashtable[j].getSize() - mean), 2);
            else sum2+=Math.pow(mean, 2);
        }
        return Math.sqrt(sum2/buckets);
    }



    @Override
    public String bucketsToString() {
        return toString();
    }
}
