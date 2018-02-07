/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;



/**
 *
 * @author Karina
 */
public class ArrayQueue<T> implements Queue<T>{
    
    private T[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayQueue(){
        values = (T[])new Object[5];
        size =0;
        back=0;
        front=0;
    }

    @Override
    public void enqueue(T value) {
        
        if (front==(back+1)%values.length){
            T[] tempValues=(T[])new Object[values.length*2];
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
    public T dequeue() throws Exception {
        if(front==back){
            throw new Exception("Queue is empty"); 
        }
       T result =values[front];
       values[front] = null;
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
        T [] tempValues =(T[]) new Object [5];
        values= tempValues;
        size=0;
        front=0;
        back=0;
       
    }
    
    public String toString(){
        String output="";
        for (int i=0,start=front;i<size;i++,start=(start+1)%values.length){
            output = output + values[start]+" ";
        }
    
        return "bottom["+output+"]top";
    }
}
