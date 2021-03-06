/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import impl.BSTHashTableSet;
import adt.HashTableSet;
import impl.LLQHashTableSet;

public class BSTSetTest {
    public static void main(String[] args){
        HashTableSet<Student> set1= new BSTHashTableSet<>(10);
        for(int i = 100; i<300;i++ ) set1.add(new Student("Bob", i));
        System.out.println(set1);
        System.out.println("Load Factor" + set1.getLoadFactor());
        System.out.println("Standard deviation" + set1.getBucketSizeStandardDev());
    }
}
