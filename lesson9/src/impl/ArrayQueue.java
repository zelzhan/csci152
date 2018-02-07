/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;
import adt.Queue;

/**
 * @author Elzhan
 */
public class ArrayQueue<X> implements Queue<X>{

    private X [] values;
    private int size;
    private int front;
    private int back;

    public ArrayQueue(){
        values = (X[]) new  Object [5];
        size =0;
        back=0;
        front=0;
    }


    @Override
    public void enqueue(X value) {

        if (front==(back+1)%values.length){
            X[] tempValues= (X[]) new Object[values.length*2];
            for(int i=0,start=front; i <size;i++,start=(start+1)%values.length){
                tempValues[i]=values[start];
            }
            values = tempValues;
            front = 0;
            back=size;
        }
        values[back]=value;
        back=(back+1)%values.length;
        size++;
    }


    @Override
    public X dequeue() throws Exception {
        if(front==back) throw new Exception("Queue is empty");
        X result =values[front];
        front= (front+1)%values.length ;
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        X [] tempValues = (X[]) new Object[5];
        values= tempValues;
        size=0;
        front=0;
        back=0;

    }

    public String toString(){
        String string="";
        for (int i=0,start=front;i<size;i++,start=(start+1)%values.length) string = string + values[start]+" ";
        return "bottom["+string+"]top";
    }
}
