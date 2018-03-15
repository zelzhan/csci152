package impl;

import adt.Queue;
import adt.Stack;
import impl.ArrayStack;


public class Methods {
    public static int evenCount(Stack stk){
        int counter = 0, temp;
        Stack<Integer> stack = new ArrayStack();
        //for loop doesn't work!
        while (stk.getSize() != 0) {
            try{
                temp = (Integer) stk.pop();
                if(temp%2 == 0) counter++;
                stack.push(temp);
            } catch(Exception ex){
                break;
            }
        }
        while(stack.getSize() != 0){
            try{
                stk.push(stack.pop());
            } catch (Exception ex) {
                break;
            }
        }
        return counter;
    }

    public static Queue copyQueue(Queue orig){
        int temp, size = orig.getSize();
          Queue<Integer> copy = new ArrayQueue();
          for(int i = 0; i < size; i++ ){
              try{
                  temp = (Integer) orig.dequeue();
                  orig.enqueue(temp);
                  copy.enqueue(temp);
              } catch(Exception ex){
                  break;
              }
          }
          return copy;
    }

    public static void reverseQueue(Queue toRev) {
        int size = toRev.getSize();
        Stack<Integer> stk= new ArrayStack();
        while(size != 0){
            try{
                stk.push((Integer) toRev.dequeue());
            } catch (Exception ex) {
                break;
            }
        }
        size = stk.getSize();
        while(size != 0){
            try {
                toRev.enqueue(stk.pop());
            } catch (Exception ex){
                break;
            }
        }
    }

    public static Stack merge(Stack s1, Stack s2){
        int temp1 = 0, temp2 = 0, size1, size2;
        int[] arr;
        Stack<Integer> mergedStack = new ArrayStack();
        Stack<Integer> tempStack = new ArrayStack();
        while(true){
            if(s1.getSize() == 0 && s2.getSize() == 0) break;
            try{
                temp2 = (Integer) s2.pop();
            } catch (Exception e) {
            }
            try{
                temp1 = (Integer) s1.pop();
            } catch (Exception ex){
            }
            if(temp1 > temp2) {
                tempStack.push(temp1);
                s2.push(temp2);
            } else if ( temp2 > temp1) {
                tempStack.push(temp2);
                s1.push(temp1);
            } else {
                tempStack.push(temp1);
                tempStack.push(temp2);
            }
        }
        while(tempStack.getSize() != 0){
            try{
                mergedStack.push(tempStack.pop());
            } catch (Exception x) {
                break;
            }

        }
        return mergedStack;


    }
}
