/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
import adt.HashTableSet;
import adt.HashTableStats;
import adt.Set;
import impl.BSTHashTableSet;
import impl.LLQHashTableSet;

import java.util.Random;

public class Test {
    public static void main(String[] args){
        Random rand = new Random();
//        HashTableSet<Integer> set1 = new LLQHashTableSet<>(5000 );
        HashTableSet<Integer> set1 = new BSTHashTableSet<>(5000);
        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
//            System.out.println(i);
            set1.add(rand.nextInt());
        }
        time2 = System.currentTimeMillis();
        duration = time2 - time1;
        System.out.println("Time taken in ms: " + duration);
        System.out.println("Load factor: " + set1.getLoadFactor());
        System.out.println("Standard deviation : " + set1.getBucketSizeStandardDev());

    }
}
