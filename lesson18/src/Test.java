/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import adt.Set;
import impl.LLQHashTableSet;
public class Test {
    public static void main(String [] args){
        Set<Integer> set = new LLQHashTableSet<>(10);
        try{
            set.removeAny();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for(int i = 1; i<= 20; i++) set.add(i);
        System.out.println(set);
        System.out.println(set.getSize());
        for(int j = 2; j<=20; j+=2) set.remove(j);
        System.out.println(set);
        System.out.println(set.getSize());
        System.out.println(set.remove(10));
        System.out.println(set.remove(100));
        System.out.println(set.getSize());
        for(int i = 1; i<= 30; i++) set.add(i);
        System.out.println(set);
        System.out.println(set.getSize());
        for(int j = 0; j < 10; j++){
            try{
                System.out.println(set.removeAny());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(set);
        System.out.println(set.getSize());
        set.clear();
        System.out.println(set);
        System.out.println(set.getSize());
        for(int k = 51; k <= 79; k+=2) set.add(k);
        System.out.println(set);
        System.out.println(set.getSize());


    }
}
