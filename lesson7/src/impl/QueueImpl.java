package impl;

public class QueueImpl {
    public static void main(String[] args){
        IntQueue Queue = new IntQueue();
        try {
            Queue.dequeue();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i <7; i++){
            Queue.enqueue(i);
        }
        System.out.println(Queue);
        System.out.println(Queue.getSize());
        try {
            Queue.dequeue();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(Queue);
        System.out.println(Queue.getSize());
        for (int i = 0; i < 22; i++){
            Queue.enqueue(i);
        }
        System.out.println(Queue);
        System.out.println(Queue.getSize());
    }
}
