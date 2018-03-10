/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import adt.Set;
import impl.BSTSet;
import impl.LLQueueSet;

public class TestStudent {
    public static void main(String[] args){
        Set<Student> set = new BSTSet<>();

        set.add(new Student("Daulet", 12345));
        set.add(new Student("kau2et", 123425));
        set.add(new Student("baul4et", 123454));
        set.add(new Student("naule5t", 123455));
        set.add(new Student("maul6et", 123457));

        System.out.println(set);

        set.add(new Student("baul4et", 123454));
        set.add(new Student("baul4et", 123454));
        System.out.println(set);
        set.add(new Student("baul42et", 1263454));
        set.add(new Student("baul34et", 12325454));
        set.add(new Student("bagul4et", 1273454));
        System.out.println(set);

        set.clear();

        System.out.println(set);

        set.add(new Student("baul34et", 12325454));
        set.add(new Student("bagul4et", 1273454));

        System.out.println(set);
    }
}
