package impl;
import impl.Node;
import impl.LinkedListStack;

public class Test {
    public static void main(String[] args){
        LinkedListStack<Double> linkedStack = new LinkedListStack();
//
//        try{
//            linkedStack.pop();
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }

//        for(int i = 0; i < 12; i ++) linkedStack.push((double) i);
//        System.out.println(linkedStack);
//
//        try{
//            System.out.println(linkedStack.pop());
//            System.out.println(linkedStack.pop());
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(linkedStack.getSize());
//        System.out.println(linkedStack);
//        linkedStack.clear();

        for (double j = 0; j < 22; j++) linkedStack.push(j);
        System.out.println(linkedStack);
        System.out.println(linkedStack.getSize());
//        linkedStack.push(2.0);
        System.out.println(linkedStack);
        SomeClass some = new SomeClass();
        linkedStack.push(21.0);
        System.out.println(linkedStack);
        System.out.println(some.isIncreasing(linkedStack));
        System.out.println(linkedStack);

    }
}
