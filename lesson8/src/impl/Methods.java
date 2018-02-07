package impl;
import adt.IntStack;
import adt.IntQueue;

public class Methods {
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
            System.out.println("temp1: " +  temp1);
            System.out.println("temp2: " + temp2);
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
