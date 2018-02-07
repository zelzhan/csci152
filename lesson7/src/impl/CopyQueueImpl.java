package impl;
import adt.ArrayInQueue;

/**
 *
 * @author Lenovo
 */
public class CopyQueueImpl implements ArrayInQueue {
    private int[] values;
    private int size, front, back;

    public CopyQueueImpl(){
        values = new int[5];
        size = 0;
        front = -1;
        back = -1;
    }
    @Override
    public void enqueue(int value){
        int back_f = ((back +1)<values.length) ? back +1 : 0;

        if(back_f == front){
            int[] newAr = new int[size+5];
            for (int i=0; i<values.length; i++){
                newAr[i] = values[front];
                front = (front+1<values.length) ? front+1 : 0;
            }
            front=0;
            back = values.length;
            values = newAr;
            values[back] = value;
            size++;

        } else{
            if(front<0) front++;
            values[back_f] = value;
            back = back_f;
            size++;
        }

    }

    @Override
    public int dequeue() throws Exception {
        if(size == 0) throw new Exception("queque is empty");
        int result = values[front];
        size--;
        if(front == back) this.clear();
        front = (front+1)< values.length ? front+1 : 0;

        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = new int[5];
        size = 0;
        front = -1;
        back = -1;
    }

    @Override
    public String toString(){
        String result ="";
        int f = front;
        for(int i =0; i<size; i++) {
            result += String.valueOf(values[f])+" ";
            f = (f+1<values.length) ? f+1 : 0;
        }

        return "front[" + result + "]back";
    }

}