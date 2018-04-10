package impl;

import adt.SortedQueue;
import adt.Stack;

public class LinkedListSortedQueue<T extends  Comparable> implements SortedQueue<T>{
    private Node<T> front;
    private int size;
    private T result;

    public LinkedListSortedQueue(){
        front = null;
        size = 0;
    }
    @Override
    public void insert(T value) {
        Node<T> node = new Node(value);
        Node<T> tempLink = front, tempLink2 = null;
        if(size == 0) {
            front = node;
        } else {
            if(value.compareTo(front.getValue()) <= 0){
                node.setLink(front);
                front = node;
            } else {
                while(tempLink != null){
                    if(value.compareTo(tempLink.getValue()) <= 0){
                        node.setLink(tempLink);
                        tempLink2.setLink(node);
                        break;
                    }
                    tempLink2 = tempLink;
                    tempLink = tempLink.getLink();
                    if (tempLink == null) tempLink2.setLink(node);
                }
            }
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0) throw new Exception("Queue is empty!");
        result = front.getValue();
        front = front.getLink();
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        size = 0;

    }

    @Override
    public String toString(){
        Stack<T> stk = new LinkedListStack<T>();
        String string = "";
        Node<T> cur = front;
        while(cur!=null){
            stk.push(cur.getValue());
            cur = cur.getLink();
        }
        while(stk.getSize() != 0) {
            try {
                string += " " + stk.pop();
            } catch (Exception ex){
            }
        }
        return "back|" + string + " |front";
    }
}
