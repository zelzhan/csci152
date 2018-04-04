/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
import adt.HashTableSet;
import adt.HashTableStats;
import impl.LLQHashTableSet;
public class Test {
    public static void main(String[] args){
        HashTableSet<Student> set = new LLQHashTableSet(100);
        for(int i = 100; i<300;i++ ) set.add(new Student("Bob", i));
        System.out.println(set);
        System.out.println("Load Factor" + set.getLoadFactor());
        System.out.println("Standard deviation" + set.getBucketSizeStandardDev());
//        HashTableSet<Student> set1= new LLQHashTableSet(10);
////        for(int i = 0; i<10;i++) set1.add(new Student("Bob", i));
//        System.out.println(set1);
    }
}
