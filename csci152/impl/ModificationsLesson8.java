/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Stack;

/**
 *
 * @author Karina
 */
public class ModificationsLesson8 {
    public static Stack copyStack(Stack stk){
        ArrayStack<Integer> origStk = new ArrayStack();
        ArrayStack<Integer> tempStk = new ArrayStack();
        
        try{
            while(stk.getSize()!=0)
        tempStk.push(stk.pop());
            while(tempStk.getSize()!=0)
                origStk.push(tempStk.pop());
            
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return origStk;
    }
    public static int evenCount(Stack stk){
        Stack<Integer> origStk = new ArrayStack();
        int counter =0;
        
        try {
            while (stk.getSize()!=0){
                intxx last=stk.pop();
                if (last%2==0){
                    counter++;
                }
                origStk.push(last);
            }
            while(origStk.getSize()!=0)
                stk.push(origStk.pop());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
                
        
       return counter; 
    }
    public static void reverseQueue(Queue toRev){
        ArrayStack<Integer> stk = new ArrayStack();
       try{ 
        while(toRev.getSize()!=0)
            stk.push(toRev.dequeue());
        
        while (stk.getSize()!=0)
            toRev.enqueue(stk.pop());
        
       }catch (Exception e){
           System.out.println(e.getMessage());
                  
       }
       
    }
    public static void insert(Stack st, int pos, int val){
          Stack<Integer> temp = new ArrayStack();
          try{ 
            while (st.getSize()!=pos)
                temp.push(st.pop());
            st.push(val);
            while(temp.getSize()!=0)
                st.push(temp.pop());
                
          }catch (Exception exc){
              System.out.println(exc.getMessage());
          }
          
       }
}
