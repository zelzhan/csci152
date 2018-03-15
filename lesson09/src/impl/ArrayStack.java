package impl;
import adt.Stack;

public class ArrayStack<X> implements Stack<X> {

    private X[] values;
    private int size;

    public ArrayStack() {
        size = 0;
        values = (X[]) new Object[10];
    }


    @Override
    public void push(X value) {
        if (size == values.length) {
            X[] tempValues = (X[]) new Object[values.length * 2];
            for (int i = 0; i < size; i++) {
                tempValues[i] = values[i];
            }
            values = tempValues;
        }
        values[size] = value;
        size++;
    }


    @Override
    public X pop() throws Exception {
        if (size == 0) throw new Exception("stack is empty");
        X result = values[size - 1];
        size--;
        return result;
    }


    @Override
    public int getSize() {
        return size;
    }


    @Override
    public void clear() {
        X [] tempValues = (X[]) new Object [10];
        values = tempValues;
        size=0;

    }


    public String toString() {
        String string = "";
        for (int i=0;i<size;i++) string = string + values[i]+" ";
        return "Bottom["+string +"]top";
    }
}
