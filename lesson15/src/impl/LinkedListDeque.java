package impl;
import adt.Deque;

public class LinkedListDeque<T> implements Deque<T> {
    private DoublyLinkedNode<T> front, back, temp;
    private int size;
    private T result;

    public LinkedListDeque() {
        front = null;
        back = null;
        size = 0;
    }
    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<T>(value);
        if(this.size == 0){
            front = back = node;
        } else {
            node.setPrevious(front);
            front.setNext(node);
            front = node;
        }
        size++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<T>(value);
        if(this.size == 0){
            front = node;
            back = node;
        } else {
            node.setNext(back);
            back.setPrevious(node);
            back = node;
        }
        size++;

    }

    @Override
    public T popFromFront() throws Exception {
        if(size == 0) throw new Exception("Exceeeeeeption");
        else if (size == 1){
            result = front.getValue();
            front = null;
            back = null;
            size--;
            return result;
        }
        result = front.getValue();
        front = front.getPrevious();
        front.setNext(null);
        size--;
        return result;
    }

    @Override
    public T popFromBack() throws Exception {
        if(size == 0) throw new Exception("Exceeeeeeption");
        else if (size == 1){
            result = front.getValue();
            front = null;
            back = null;
            size--;
            return result;
        }
        result = back.getValue();
        back = back.getNext();
        back.setPrevious(null);
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        front = null;
        back = null;
    }

    @Override
    public String toString() {
        DoublyLinkedNode cur = back;
        String string = "";
        while(cur != null){
            string += cur.getValue() + " ";
            cur = cur.getNext();
        }
        return "back| " + string + "|front";
    }
}