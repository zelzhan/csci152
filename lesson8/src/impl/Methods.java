package impl;
import adt.IntStack;
import adt.IntQueue;

public class Methods {

    /**
     * The evenCount method, which returns the number of even integers stored in the stack stk
     * @param stk
     * @return amount of even numbers in stack
     */
    public static int evenCount(IntStack stk){
        int counter = 0, temp;
        IntStack stack = new ArrayIntStack();
        //for loop doesn't work!
        while (stk.getSize() != 0) {
            try{
                temp = stk.pop();
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

    /**
     * The copyQueue method, which creates and returns a copy of the queue orig, where orig is “preserved”.
     * @param orig
     * @return copied queue
     */
    public static IntQueue copyQueue(IntQueue orig){
        int temp, size = orig.getSize();
          IntQueue copy = new ArrayIntQueue();
          for(int i = 0; i < size; i++ ){
              try{
                  temp = orig.dequeue();
                  orig.enqueue(temp);
                  copy.enqueue(temp);
              } catch(Exception ex){
                  break;
              }
          }
          return copy;
    }

    /**
     * The reverseQueue method, which reverses the order of the elements stored in the queue toRev.
     * @param toRev queue which has to be reversed
     */
    public static void reverseQueue(IntQueue toRev) {
        int size = toRev.getSize();
        IntStack stk= new ArrayIntStack();
        while(size != 0){
            try{
                stk.push(toRev.dequeue());
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

    /**
     * The merge method, where s1 and s2 are stacks whose elements are in order (smallest at the bottom).
     * @param s1
     * @param s2
     * @return Merged Stack
     */
    public static IntStack merge(IntStack s1, IntStack s2){
        int temp1 = 0, temp2 = 0, size1, size2;
        int[] arr;
        IntStack mergedStack = new ArrayIntStack();
        IntStack tempStack = new ArrayIntStack();
        while(true){
            if(s1.getSize() == 0 && s2.getSize() == 0) break;
            try{
                temp2 = s2.pop();
            } catch (Exception e) {
            }
            try{
                temp1 = s1.pop();
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
