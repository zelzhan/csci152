package impl;
import adt.Stack;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top, temp;
    private int size;
    private T result;

    public LinkedListStack () {
        top = null;
        size = 0;
    }

    @Override
    public void push(T value) {
        temp = new Node<T>(value);
        temp.setLink(top);
        top = temp;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if(this.size == 0) throw new Exception("Exception");
        this.result = top.getValue();
        this.top = top.getLink();
        size--;
        return this.result;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public String toString(){
        String string = "";
        Node cur = top;
        while(cur!=null){
            string += cur+" ";
            cur = cur.getLink();
        }
        return "top[ " + string + "]bottom";
    }

}
