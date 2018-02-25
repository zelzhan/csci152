import adt.Deque;
import impl.LinkedListDeque;

public class Test {
    public static void main(String[] args){
//        LinkedListDeque<Integer> deque = new LinkedListDeque();
//        try{
//            deque.popFromBack();
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(deque);
//
//
//        try{
//            deque.popFromBack();
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(deque);
//
//        for(int i = 0; i<5; i++) deque.pushToFront(i);
//        System.out.println(deque);
//
//        for(int i = 0; i<5; i++){
//            try{
//                deque.popFromFront();
//                System.out.println(deque);
//            } catch (Exception ex){
//                System.out.println(ex.getMessage());
//            }
//        }
//        System.out.println(deque);
//
//        for(int i = 0; i<12; i+=2) {
//            deque.pushToFront(i);
//            System.out.println(deque);
//        }
//        System.out.println(deque);
//        System.out.println("Size: " + deque.getSize());
//
//        for(int i = 0; i<12; i+=2) {
//            deque.pushToBack(i);
//            System.out.println(deque);
//        }
//        System.out.println(deque);
//        System.out.println("Size: " + deque.getSize());
//
//        for(int i = 0; i<7; i++){
//            try{
//                deque.popFromBack();
//                System.out.println(deque);
//            } catch (Exception ex){
//                System.out.println(ex.getMessage());
//            }
//        }
//        System.out.println(deque);
//        System.out.println("Size: " + deque.getSize());
//
//        for(int i = 0; i<16; i+=2) {
//            deque.pushToBack(i);
//            System.out.println(deque);
//        }
//        System.out.println(deque);
//        System.out.println("Size: " + deque.getSize());
//
//        for(int i = 0; i<8; i++){
//            try{
//                deque.popFromFront();
//                System.out.println(deque);
//            } catch (Exception ex){
//                System.out.println(ex.getMessage());
//            }
//        }
//        System.out.println(deque);
//        System.out.println("Size: " + deque.getSize());
//
//        for(int j = 0; j < 10; j++){
//            deque.pushToFront(j);
//            deque.pushToBack(j);
//            System.out.println(deque);
//            System.out.println("Size: " + deque.getSize());
//        }
//
//        for(int j = 0; j < 8; j++){
//            try{
//                deque.popFromFront();
//                deque.popFromBack();
//                System.out.println(deque);
//                System.out.println("Size: " + deque.getSize());
//            } catch (Exception ex){
//                System.out.println(ex.getMessage());
//            }
//        }
//
//        deque.clear();
//        System.out.println(deque);
//        System.out.println("Size: " + deque.getSize());

        /**
         * Tester for second task
         */

        Deque<Integer> deq1 = new LinkedListDeque<Integer>();
        Deque<Integer> deq2 = new LinkedListDeque<Integer>();
        Deque<Integer> end = new LinkedListDeque<Integer>();
        for(int k = 0; k < 10; k++) deq1.pushToFront(k);
        deq1.pushToFront(5);
        for(int j = 0; j < 20; j+=2) deq1.pushToFront(j);
        deq1.pushToFront(2);
        deq1.pushToFront(1);
        deq1.pushToFront(10);
        Merge merge = new Merge();
        System.out.println(deq1);
        System.out.println(deq2);
//        end = merge.merge(deq1, deq2);
        end = merge.mergeSort(deq1);
        System.out.println(end);
    }
}
