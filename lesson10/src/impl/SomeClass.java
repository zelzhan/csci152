package impl;
import adt.Stack;

public class SomeClass {
    public static boolean isIncreasing(Stack<Double> st){
        Double temp1 = 0.0, temp2 = 0.0;
        int size = st.getSize();
        Stack stack = new LinkedListStack();
        boolean value = true;
        while(st.getSize() != 0) {
            try {
                temp1 = st.pop();
                stack.push(temp1);
                temp2 = st.pop();
                if(temp1 < temp2) {
                      value = false;
                }
                st.push(temp2);
            } catch (Exception ex) {
                break;
            }
        }
        for(;size>0; size--){
            try{
                st.push((Double) stack.pop());
            } catch (Exception x) {
                break;
            }
        }
        return value;



    }

}
