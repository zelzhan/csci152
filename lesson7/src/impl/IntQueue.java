package impl;
import adt.ArrayInQueue;
public class IntQueue implements ArrayInQueue {
    private int[] values;
    private int size, front, back, upperbound;

    public IntQueue() {
        this.upperbound = 5;
        this.values = new int[upperbound];
        this.size = 0;
        this.front = 0;
        this.back = 0;
    }

    @Override
    public void enqueue(int value) {
        this.values[back] = value;
        this.size++;
        this.back++;
        if (this.size+1 == this.upperbound){
            int[] copyOfValues = new int[this.upperbound];
            for(int i = 0; i<this.upperbound; i++){
                copyOfValues[i] = this.values[i];
            }
            this.upperbound *= 2;
            this.values = new int[this.upperbound];
            for(int i = 0; i<this.upperbound/2; i++){
                this.values[i] = copyOfValues[i];
            }
        }
        if(this.back == this.upperbound){
            this.back -= this.upperbound;
        }
    }

    @Override
    public int dequeue() throws Exception {
        if(size == 0) {
            throw new Exception("The queue is empty!");
        }
        int result = values[front];
        this.front++;
        if(this.front == this.upperbound-1) this.front = 0;
        this.size--;
        return result;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.values = new int[upperbound];
    }

    @Override
    public String toString() {
//        String string = " ";
//
//        int front = this.front, back = this.back;
//        for (; ; back--){
//            if(size == 0 || front == back-1) break;
//            if(back == 0){
//                string += this.values[upperbound-1] + " ";
//                back = this.upperbound;
//                back--;
//            }
//            if(back - 1 == 0){
//                string += this.values[back-1] + " ";
//                back = this.upperbound;
//                string += this.values[back-1] + " ";
//                back--;
//            } else {
//                string += this.values[back-1] + " ";
//            }
//        }
//        string += this.values[front] + " ";
//        return "back[" + string + "]front";
//    }
        String result =" ";
        int front = this.front;
        for(int i =0; i<this.size; i++) {
            result += this.values[front] +" ";
            if (front+1<upperbound){
                front = front+1;
            } else {
                front = 0;
            }
        }

        return "front[" + result + "]back";
    }
}
