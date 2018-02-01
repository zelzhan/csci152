package impl;
import adt.Stack;

public class StackImpl implements Stack{
    private int[] values;
    private int size, upperBound;


    public StackImpl(){
        this.upperBound = 10;
        this.values = new int[upperBound];
        this.size = 0;
    }

    @Override
    public void push(int value) {
        if (size+1 == upperBound){
            int[] copyOfValues = new int[upperBound];
            for(int i = 0; i<upperBound; i++){
                copyOfValues[i] = this.values[i];
            }
            upperBound *= 2;
            this.values = new int[upperBound];
            for(int i = 0; i<upperBound/2; i++){
                this.values[i] = copyOfValues[i] ;
            }
        }
        this.values[size] = value;
        this.size++;
    }

    @Override
    public int pop() throws Exception {
        if(this.size == 0){
            throw new Exception("The stack is already empty!!");
        }
        int result = values[this.size-1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.values = new int[upperBound];
    }

    @Override
    public String toString() {
        String string = " ";
        for (int i = 0; i < this.size; i++){
            string += this.values[i] + " ";
        }
        return "bottom[" + string + "]top";
    }
}
