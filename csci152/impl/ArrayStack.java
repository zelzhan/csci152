/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 *
 * @author Karina
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] values;
    private int size;
   
    public ArrayStack() {
        size = 0;
        values =(T[]) new Object[10];

    }

    @Override
    public void push(T value) {
        if (size == values.length) {
            T[] tempValues =(T[]) new Object[values.length * 2];
            for (int i = 0; i < size; i++) {
                tempValues[i] = values[i];
            }
            values = tempValues;
        }
        values[size] = value;
        size++;
    }

    @Override
    public T pop() throws Exception {
         if (size == 0) {
            throw new Exception("stack is empty");
        }
        T result = values[size - 1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        T [] tempValues =(T[]) new Object[10];
        values = tempValues;
        size=0;

    }

    public String toString() {
        String output = "";
        for (int i=0;i<size;i++){
            output = output + values[i]+" "; 
        }
        return "Bottom["+output +"]top";
    }
}
