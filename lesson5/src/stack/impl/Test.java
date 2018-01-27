package stack.impl;

public class Test {
    public static void main(String[] args){
        StackImpl stack = new StackImpl();
        try {
            stack.pop();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i < 12; i++){
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.getSize());
        stack.clear();
        System.out.println(stack);
        System.out.println(stack.getSize());
        for (int j = 0; j < 22; j++){
            stack.push(j);
        }
        System.out.println(stack);
        System.out.println(stack.getSize());
    }
}
