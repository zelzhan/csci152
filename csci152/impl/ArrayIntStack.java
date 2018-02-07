/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntStack;

/**
 *
 * @author Karina
 */
public class ArrayIntStack implements IntStack {

    private int[] values;
    private int size;
   
    public ArrayIntStack() {
        size = 0;
        values = new int[10];

    }

    @Override
    public void push(int value) {
        if (size == values.length) {
            int[] tempValues = new int[values.length * 2];
            for (int i = 0; i < size; i++) {
                tempValues[i] = values[i];
            }
            values = tempValues;
        }
        values[size] = value;
        size++;
    }

    @Override
    public int pop() throws Exception {
         if (size == 0) {
            throw new Exception("stack is empty");
        }
        int result = values[size - 1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        int [] tempValues = new int [10];
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
