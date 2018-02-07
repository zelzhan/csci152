/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntQueue;

/**
 *
 * @author Karina
 */
public class ArrayIntQueue implements IntQueue{
    
    private int [] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayIntQueue(){
        values = new int [5];
        size =0;
        back=0;
        front=0;
    }

    @Override
    public void enqueue(int value) {
        
        if (front==(back+1)%values.length){
            int[] tempValues=new int[values.length*2];
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
    public int dequeue() throws Exception {
        if(front==back){
            throw new Exception("Queue is empty"); 
        }
       int result =values[front];
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
            int [] tempValues = new int [5];
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
