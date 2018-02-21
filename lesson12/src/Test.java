import adt.SortedQueue;
import impl.LinkedListSortedQueue;
import impl.LinkedListStack;

public class Test {
    public static void main(String[] args){
        SortedQueue<Integer> sortq = new LinkedListSortedQueue();
        for (int i = 90; i >= 10; i-=10) sortq.insert(i);
        try{
            sortq.dequeue();
            sortq.dequeue();
            sortq.dequeue();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for (int j = 100; j <= 900; j+=100) sortq.insert(j);
        try{
            sortq.dequeue();
            sortq.dequeue();
            sortq.dequeue();
            sortq.dequeue();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for (int k = 5; k <= 915; k+=5) sortq.insert(k);
        for (;sortq.getSize() != 0;){
            try{
                sortq.dequeue();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        sortq.insert(3);
        sortq.insert(5);
        sortq.insert(2);
        sortq.clear();
        sortq.insert(3);
        sortq.insert(10);
        sortq.insert(2);
        sortq.insert(2);
        System.out.println(sortq);
        System.out.println(sortq.getSize());
    }
}
