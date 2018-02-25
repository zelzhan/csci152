import adt.Deque;
import impl.LinkedListDeque;
public class Merge {

    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
	    int temp1, temp2;
	    Deque<Integer> deque = new LinkedListDeque<Integer>();
	    while(true){
	        try{
                temp1 = d1.popFromBack();
                temp2 = d2.popFromBack();
                if(temp1 < temp2) {
                    deque.pushToFront(temp1);
                    d2.pushToBack(temp2);
                }
                else {
                    deque.pushToFront(temp2);
                    d1.pushToBack(temp1);
                }
                if(d1.getSize() == 0){
                    while(d2.getSize() != 0) deque.pushToFront(d2.popFromBack());
                    break;
                } else if (d2.getSize() == 0){
                    while(d1.getSize() != 0) deque.pushToFront(d1.popFromBack());
                    break;
                } else if(d1.getSize() == 0 && d2.getSize() == 0 ) break;
            } catch (Exception ex){
	            break;
            }
        }
        return deque;
    }


    public static Deque<Integer> mergeSort(Deque<Integer> deq) {
        if(deq.getSize() == 1) {
            return deq;
        }
        Deque<Integer> dq1 = new LinkedListDeque<Integer>();
        Deque<Integer> dq2 = new LinkedListDeque<Integer>();
        while(deq.getSize() != 0 ){
            try{
                dq1.pushToFront(deq.popFromBack());
                dq2.pushToFront(deq.popFromBack());
            } catch (Exception ex){
                break;
            }
        }
        dq1 = mergeSort(dq1);
        dq2 = mergeSort(dq2);
        return merge(dq1, dq2);
    }


}
