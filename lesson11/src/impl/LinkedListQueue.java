package impl;
import adt.Queue;

public class LinkedListQueue<T> implements Queue<T> {
    public Node<T> front, back, temp;
    public int size;
    public T result;

    public LinkedListQueue () {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        temp = new Node<T> (value);
        if(front == null) {
            front = temp;
            back = temp;
        }
        back.setLink(temp);
        back = temp;

        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) throw new Exception("Exception");
        result = front.getValue();
        front = front.getLink();
        if(front == back) back = null;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public String toString(){
        String string = "";
        Node<T> cur = front;
        while(cur!=null){
            string += cur+" ";
            cur = cur.getLink();
        }
        return "front[ " + string + "]back";
    }
}
