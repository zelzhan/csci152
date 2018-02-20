package impl;
import impl.Node;
import impl.LinkedListQueue;
import adt.Queue;

public class Test {
    public static void main(String[] args){
        Queue que = new LinkedListQueue();
        for(int i =0; i < 20; i++) que.enqueue(i);
        System.out.println(que);
        try{
        que.dequeue();
        } catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println(que);
}
}
