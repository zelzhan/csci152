package impl;
import impl.Methods;
import adt.Stack;
import adt.Queue;

public class Test {
    public static void main(String[] args){
        Methods method = new Methods();
        Stack stack = new ArrayStack();
        Stack stack2 = new ArrayStack();
        Stack merged = new ArrayStack();
        Queue queue = new ArrayQueue();
        Queue copy = new ArrayQueue();

        //This is tester for evenCount method
        for (int i = 0; i < 10; i++) stack.push(i);
        System.out.println(stack);
        System.out.println(method.evenCount(stack));
        System.out.println(stack);


        //Tester for copyQueue method
        for (int j = 0; j < 10; j++){
            queue.enqueue(j);
        }
        System.out.println("Original:" + queue);
        copy = method.copyQueue(queue);
        System.out.println("Copy:" + copy);
        System.out.println("Original: " + queue);

        //tester for reverseQueue method
        method.reverseQueue(queue);
        System.out.println("Reversed Queue:" + queue);


        //tester for merge method
        for(int k = 0; k < 20; k+=2) stack2.push(k);
        System.out.println("Stack 1: " + stack);
        System.out.println("Stack 2: " + stack2);
        merged = method.merge(stack, stack2);
        System.out.println("Merged Stack: " + merged);

    }





}

