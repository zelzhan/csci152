package impl;

public class QueueImpl {
    public static void main(String[] args){
        CopyQueueImpl Queue = new CopyQueueImpl();

        //Creates a new queue and tries to dequeue from the empty queue
        try {
            Queue.dequeue();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        //Enqueues 8 items on the queue using a loop, and then prints its contents and size afterwards
        for (int i = 0; i <8; i++){
            Queue.enqueue(i);
        }
        System.out.println(Queue);
        System.out.println(Queue.getSize());

        //Dequeue 3 items from the queue, and print its contents and resulting size
        try {
            Queue.dequeue();
            Queue.dequeue();
            Queue.dequeue();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(Queue);
        System.out.println(Queue.getSize());

        //Create a for loop that iterates 9 times, where the body enqueues two items, and then dequeues two items.
        //Print the queue’s contents and size after each iteration.
        for (int j = 0; j < 9; j++){
            Queue.enqueue(j);
            Queue.enqueue(j);
            try {
                Queue.dequeue();
                Queue.dequeue();

            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(Queue);
            System.out.println(Queue.getSize());
        }

        //Clear the queue, and print its contents and resulting size
        Queue.clear();
        System.out.println(Queue);
        System.out.println(Queue.getSize());

        //Enqueue 22 more items to the queue using a loop, and again print its contents and resulting size
        for (int i = 0; i < 22; i++){
            Queue.enqueue(i);
        }
        System.out.println(Queue);
        System.out.println(Queue.getSize());


  }
}
